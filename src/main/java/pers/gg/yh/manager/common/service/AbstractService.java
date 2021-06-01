package pers.gg.yh.manager.common.service;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import pers.gg.yh.manager.common.entity.BaseMainEntity;
import pers.gg.yh.manager.seq.entity.Seq;
import pers.gg.yh.manager.seq.repository.SeqRepository;

public abstract class AbstractService {
	@Resource
	private SeqRepository seqRepository;
	
    public void setBaseMainEntityField(BaseMainEntity entity, String module) {
        entity.setLatest(true);
        entity.setCreatedOn(LocalDateTime.now());
        entity.setUpdatedOn(LocalDateTime.now());
        entity.setVersion(1);
        entity.setRefNo(findRefNoByModule(module));
    }

    private String findRefNoByModule(String module) {
    	Seq seq = seqRepository.findByModule(module).get();
    	LocalDateTime now = LocalDateTime.now();
    	if (now.getYear() != seq.getUpdatedOn().getYear() && now.getMonthValue() != seq.getUpdatedOn().getMonthValue()) {
    		seq.setSeqNum(1);
    		seq.setUpdatedOn(now);
    	}
    	String yearPrefix = StringUtils.substring(String.valueOf(seq.getUpdatedOn().getYear()) , 2);
    	String monthPrefix = StringUtils.leftPad(String.valueOf(String.valueOf(seq.getUpdatedOn().getMonthValue())), 2, "0");
    	int seqNum = seq.getSeqNum();
    	seq.setSeqNum(seqNum + 1);
    	seqRepository.saveAndFlush(seq);
    	String number = StringUtils.leftPad(String.valueOf(seqNum), 4, "0");
        return seq.getPrefix() + "-" + yearPrefix + monthPrefix + number;
    }
}
