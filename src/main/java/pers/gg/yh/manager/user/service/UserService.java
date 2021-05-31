package pers.gg.yh.manager.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import pers.gg.yh.manager.common.service.AbstractService;
import pers.gg.yh.manager.user.entity.User;
import pers.gg.yh.manager.user.repository.UserRepository;

@Service
public class UserService extends AbstractService {
	private Logger log = LogManager.getLogger(this.getClass());

	@Resource
	private UserRepository userRepository;
	
	private static final String MODULE = "user";
	
	public User login(User loginUser) {
		User user = userRepository.findByPhoneNum(loginUser.getPhoneNum());
		if (user == null) {
			throw new RuntimeException("can not find user:" + loginUser.getPhoneNum());
		}
		if (!StringUtils.equals(user.getPassword(), loginUser.getPassword())) {
			throw new RuntimeException("verify password fail");
		}
		return user;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User insertUser(User user) {
		log.info("----- start insert user -----");
		setBaseMainEntityField(user, MODULE);
		User saveData = userRepository.saveAndFlush(user);
		log.info("----- end insert user -----");
		return saveData;
	}
	
}
