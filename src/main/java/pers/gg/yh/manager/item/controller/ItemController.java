package pers.gg.yh.manager.item.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pers.gg.yh.manager.common.controller.AbstractController;
import pers.gg.yh.manager.common.response.Result;
import pers.gg.yh.manager.item.entity.Item;
import pers.gg.yh.manager.item.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController extends AbstractController {
	@Resource
	ItemService itemService;
	
	@ResponseBody
	@GetMapping("/findByRefNo")
    public Result<Item> findByRefNo(@RequestParam String refNo) {
        return successResponse(itemService.findByRefNo(refNo));
    }
	
	@ResponseBody
	@GetMapping("/list")
    public Result<List<Item>> all() {
        return successResponse(itemService.findAll());
    }
}
