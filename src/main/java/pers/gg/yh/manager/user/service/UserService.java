package pers.gg.yh.manager.user.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import pers.gg.yh.manager.user.entity.User;
import pers.gg.yh.manager.user.repository.UserRepository;

@Service
public class UserService {

	@Resource
	private UserRepository userRepository;
	
	public User login(User loginUser) {
		User user = findUserByPhoneNum(loginUser.getPhoneNum());
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
		user.setCreatedOn(LocalDateTime.now());
		user.setUpdatedOn(LocalDateTime.now());
		user.setLatest(true);
		user.setVersion(1);
		User saveData = userRepository.saveAndFlush(user);
		return saveData;
	}
	
	public User findUserByPhoneNum(String phoneNum) {
		return userRepository.findUserByPhoneNum(phoneNum);
	}
}
