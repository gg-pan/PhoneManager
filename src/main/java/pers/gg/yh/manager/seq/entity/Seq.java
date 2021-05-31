package pers.gg.yh.manager.seq.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_seq")
public class Seq implements Serializable {

	private static final long serialVersionUID = 59935417372140552L;
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "id_sequence")
    @GenericGenerator(name = "id_sequence", strategy = "pers.gg.yh.manager.common.generator.IdGenerator")
    private String id;
	
	private String module;
	private String prefix;
	private int seqNum;
	private LocalDateTime updatedOn;
}
