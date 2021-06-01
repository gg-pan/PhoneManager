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

import pers.gg.yh.manager.common.controller.AbstractController;
import pers.gg.yh.manager.common.response.Result;
import pers.gg.yh.manager.phone.entity.Phone;
import pers.gg.yh.manager.phone.service.PhoneService;

@RestController
@RequestMapping("/phone")
public class PhoneController extends AbstractController {
	@Resource
	private PhoneService phoneService;
	
	@ResponseBody
	@GetMapping("/findByRefNo")
    public Result<Phone> findByRefNo(@RequestParam String refNo) {
        return successResponse(phoneService.findByRefNo(refNo));
    }
	
	@ResponseBody
	@GetMapping("/list")
    public Result<List<Phone>> all() {
        return successResponse(phoneService.findAll());
    }
	
	@ResponseBody
	@PostMapping("/insert")
	public Result<Phone> savePhone(@RequestBody Phone phone) {
		return successResponse(phoneService.insertOne(phone));
	}
}
