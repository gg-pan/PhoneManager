package pers.gg.yh.manager.seq.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pers.gg.yh.manager.seq.entity.Seq;

@Repository
public interface SeqRepository extends JpaRepository<Seq, String> {
	Optional<Seq> findByModule(String module);
}
