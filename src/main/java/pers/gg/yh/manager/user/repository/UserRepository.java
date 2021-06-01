package pers.gg.yh.manager.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pers.gg.yh.manager.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findByPhoneNum(String phoneNum);
}
