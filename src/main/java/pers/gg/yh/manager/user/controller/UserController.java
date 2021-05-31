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

import pers.gg.yh.manager.common.controller.AbstractController;
import pers.gg.yh.manager.common.response.Result;
import pers.gg.yh.manager.common.util.JWTUtil;
import pers.gg.yh.manager.user.entity.User;
import pers.gg.yh.manager.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController {
	@Resource
	private UserService userService;
	
	@ResponseBody
	@PostMapping("/login")
	public Result<String> login(@RequestBody User loginUser) {
        try {
            User user = userService.login(loginUser);
            Map<String, String> payload = new HashMap<>(2);
            payload.put("phoneNum", user.getPhoneNum());
            payload.put("password", user.getPassword());
            String token = JWTUtil.getToken(payload);

            return successResponse("Login successful", token);
        } catch (Exception exception) {
            return new Result<String>(500, exception.getMessage());
        }
	}
	
	@ResponseBody
	@GetMapping("/list")
    public Result<List<User>> all() {
        return successResponse(userService.findAll());
    }
	
	@ResponseBody
	@PostMapping("/insert")
	public Result<User> saveUser(@RequestBody User user) {
		return successResponse(userService.insertUser(user));
	}
}
