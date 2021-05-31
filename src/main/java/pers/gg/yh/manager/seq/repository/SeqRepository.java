package pers.gg.yh.manager.seq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pers.gg.yh.manager.seq.entity.Seq;

@Repository
public interface SeqRepository extends JpaRepository<Seq, String> {
	public Seq findByModule(String module);
}
