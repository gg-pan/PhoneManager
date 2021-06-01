package pers.gg.yh.manager.item.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import pers.gg.yh.manager.common.entity.BaseMainEntity;
import pers.gg.yh.manager.phone.entity.Phone;

@Entity
@Data
@Table(name = "tb_item")
public class Item extends BaseMainEntity implements Serializable {

	private static final long serialVersionUID = 5728546481916714164L;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phone_id", nullable = false)
	private Phone phone;				//手机

	private LocalDateTime inTime;		//进货时间
	private LocalDateTime outTime;		//售货时间
	private BigDecimal inPrice;			//进货价
	private BigDecimal outPrice;		//售货价
	
	private String vendorName;			//供应商
	private String vendorPhone;
	private String vendorIdCard;
	private String vendorAddress;
	
	private String customerName;		//顾客
	private String customerPhone;
	private String customerIdCard;
	private String customerAddress;
	
	private boolean mortgage;			//是否抵押
	private String mortgageName;		//抵押人
	private String mortgagePhone;
	private String mortgageIdCard;
	private String mortgageAddress;
	
	private LocalDateTime mortgagedOn;	//抵押日期
	private int mortgagedTime;			//抵押时长(日)
	private BigDecimal mortgagePrice;	//押金
	
	private String remark;				//备注
}
