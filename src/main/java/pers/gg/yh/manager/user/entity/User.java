package pers.gg.yh.manager.user.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

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
