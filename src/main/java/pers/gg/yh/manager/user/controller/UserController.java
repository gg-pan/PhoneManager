package pers.gg.yh.manager.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pers.gg.yh.manager.common.util.JWTUtil;
import pers.gg.yh.manager.user.entity.User;
import pers.gg.yh.manager.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@ResponseBody
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody User loginUser) {
		Map<String, Object> map = new HashMap<>(4);
        try {
            User user = userService.login(loginUser);
            
            Map<String, String> payload = new HashMap<>(2);
            payload.put("phoneNum", user.getPhoneNum());
            payload.put("password", user.getPassword());

            String token = JWTUtil.getToken(payload);
            
            map.put("code", HttpStatus.OK.value());
            map.put("msg", "login successful");
            map.put("token", token);
            map.put("payload", payload);
        } catch (Exception exception) {
            map.put("code", 500);
            map.put("msg", exception.getMessage());
        }
        return map;
	}
	
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
