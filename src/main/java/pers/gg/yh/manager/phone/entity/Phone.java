package pers.gg.yh.manager.phone.entity;

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
@Table(name = "tb_phone")
public class Phone implements Serializable {
	private static final long serialVersionUID = -8477461446339156247L;

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "id_sequence")
	@GenericGenerator(name = "id_sequence", strategy = "pers.gg.yh.manager.common.generator.IdGenerator")
    private String id;
	
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	private int version;
	private String refNo;
	private boolean latest;

	private String brand;	//品牌
    private String model;	//型号
    
}
