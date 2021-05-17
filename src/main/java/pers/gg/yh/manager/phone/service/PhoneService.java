package pers.gg.yh.manager.phone.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import pers.gg.yh.manager.phone.entity.Phone;
import pers.gg.yh.manager.phone.repository.PhoneRepository;

@Service
public class PhoneService {
	private Logger log = LogManager.getLogger(this.getClass());

	@Resource
	private PhoneRepository phoneRepository;
	
	public Phone findById(String id) {
		return phoneRepository.findById(id).get();
	}
	
	public List<Phone> findAll() {
		return phoneRepository.findAll();
	}
	
	public Phone insertOne(Phone phone) {
		log.info("----- start insert phone -----");
		phone.setCreatedOn(LocalDateTime.now());
		phone.setUpdatedOn(LocalDateTime.now());
		phone.setLatest(true);
		phone.setVersion(1);
		Phone saveData = phoneRepository.saveAndFlush(phone);
		return saveData;
	}
}
