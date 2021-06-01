package pers.gg.yh.manager.item.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.gg.yh.manager.common.service.AbstractService;
import pers.gg.yh.manager.item.entity.Item;
import pers.gg.yh.manager.item.repository.ItemRepository;

@Service
public class ItemService extends AbstractService {
	@Resource
	ItemRepository itemRepository;
	
	public Item findByRefNo(String refNo) {
		return itemRepository.findByRefNoAndLatest(refNo, true).get();
	}
	
	public List<Item> findAll() {
		return itemRepository.findAll();
	}
}
