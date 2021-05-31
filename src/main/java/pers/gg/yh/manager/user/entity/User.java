package pers.gg.yh.manager.user.entity;


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
@Table(name = "tb_user")
public class User extends BaseMainEntity implements Serializable {
	private static final long serialVersionUID = -2246095337567355463L;
	
	private String name;
	private String email;
	private String phoneNum;
	private String password;
}
