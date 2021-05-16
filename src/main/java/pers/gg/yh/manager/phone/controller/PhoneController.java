package pers.gg.yh.manager.phone.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pers.gg.yh.manager.phone.entity.Phone;
import pers.gg.yh.manager.phone.service.PhoneService;

@RestController
@RequestMapping("/phone")
public class PhoneController {
	@Resource
	private PhoneService phoneService;
	
	@ResponseBody
	@GetMapping("/findById")
    public Phone findById(@RequestParam String id) {
        return phoneService.findById(id);
    }
	
	@ResponseBody
	@GetMapping("/list")
    public List<Phone> all() {
        return phoneService.findAll();
    }
	
	@ResponseBody
	@PostMapping("/insert")
	public Phone savePhone(@RequestBody Phone phone) {
		return phoneService.insertOne(phone);
	}
}
