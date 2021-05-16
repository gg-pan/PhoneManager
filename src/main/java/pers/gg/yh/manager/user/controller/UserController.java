package pers.gg.yh.manager.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pers.gg.yh.manager.user.entity.User;
import pers.gg.yh.manager.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@ResponseBody
	@GetMapping("/findById")
    public User findById(@RequestParam String id) {
        return userService.findById(id);
    }
	
	@ResponseBody
	@GetMapping("/list")
    public List<User> all() {
        return userService.findAll();
    }
	
	@ResponseBody
	@PostMapping("/insert")
	public User saveUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
}
