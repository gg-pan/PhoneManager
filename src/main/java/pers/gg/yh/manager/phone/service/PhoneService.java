package pers.gg.yh.manager.phone.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import pers.gg.yh.manager.common.service.AbstractService;
import pers.gg.yh.manager.phone.entity.Phone;
import pers.gg.yh.manager.phone.repository.PhoneRepository;

@Service
public class PhoneService extends AbstractService {
	private Logger log = LogManager.getLogger(this.getClass());
	
	private static final String MODULE = "phone";

	@Resource
	private PhoneRepository phoneRepository;
	
	public Phone findByRefNo(String refNo) {
		return phoneRepository.findByRefNoAndLatest(refNo, true);
	}
	
	public List<Phone> findAll() {
		return phoneRepository.findAll();
	}
	
	public Phone insertOne(Phone phone) {
		log.info("----- start insert phone -----");
		setBaseMainEntityField(phone, MODULE);
		Phone saveData = phoneRepository.saveAndFlush(phone);
		log.info("----- end insert phone -----");
		return saveData;
	}
}
