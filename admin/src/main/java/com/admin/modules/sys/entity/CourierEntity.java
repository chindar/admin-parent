package com.admin.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 快递员信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-15 12:06:08
 */
@Data
@TableName("tb_courier")
public class CourierEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * pk
	 */
	@TableId
	private Integer id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 身份证
	 */
	private String cardId;
	/**
	 * 手机
	 */
	private String phone;
	/**
	 * 银行卡号
	 */
	private String bankCardId;
	/**
	 * 开户行名称
	 */
	private String depositBank;
	/**
	 * 联行号
	 */
	private String joinBankNumber;
	/**
	 * 入职时间
	 */
	private Date entryDate;
	/**
	 * 离职时间
	 */
	private Date leaveDate;
	/**
	 * 1:离职 0:在职
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String remark;
	/** 公司id */
	private Integer companyId;
	/**
	 * ERP账号id
	 */
	private Integer erpId;
	/**
	 * 片区id
	 */
	private Integer areaId;
	/**
	 * 站点id
	 */
	private Integer siteId;
	/**
	 * 合同id
	 */
	private Integer pactId;
	/**
	 * 城市id
	 */
	private Integer cityId;
	/** 创建时间 */
	private Date createTime;
	/**
	 * -1:删除0:正常
	 */
	private Integer isDelete;

}
