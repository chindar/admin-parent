package com.admin.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
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
	@NotBlank(message="配送员姓名不能为空")
	private String name;
	/**
	 * 身份证
	 */
	@NotBlank(message="身份证号不能为空")
	private String cardId;
	/**
	 * 手机
	 */
	@NotBlank(message="手机号不能为空")
	private String phone;
	/**
	 * 银行卡号
	 */
	@NotBlank(message="银行卡号不能为空")
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
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
	private Date entryDate;
	/**
	 * 离职时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
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
	 * 1:删除0:正常
	 */
	@TableLogic
	private Integer isDelete;

}
