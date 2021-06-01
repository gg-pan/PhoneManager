package pers.gg.yh.manager.phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pers.gg.yh.manager.phone.entity.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, String> {
	Phone findByRefNoAndLatest(String refNo, boolean latest);
}
