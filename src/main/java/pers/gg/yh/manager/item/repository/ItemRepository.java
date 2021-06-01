package pers.gg.yh.manager.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pers.gg.yh.manager.item.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
	Item findByRefNoAndLatest(String refNo, boolean latest);
}
