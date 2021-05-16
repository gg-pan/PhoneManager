package pers.gg.yh.manager.user.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.gg.yh.manager.user.entity.User;
import pers.gg.yh.manager.user.repository.UserRepository;

@Service
public class UserService {

	@Resource
	private UserRepository userRepository;
	
	public User findById(String id) {
		return userRepository.findById(id).get();
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
}
