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
import pers.gg.yh.manager.common.entity.BaseMainEntity;

@Entity
@Data
@Table(name = "tb_phone")
public class Phone extends BaseMainEntity implements Serializable {
	private static final long serialVersionUID = -8477461446339156247L;

	private String brand;	//品牌
    private String model;	//型号
    
}
