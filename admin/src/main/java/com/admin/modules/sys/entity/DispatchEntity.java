package com.admin.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 配送信息表
 * 
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:55:09
 */
@Data
@NoArgsConstructor
@TableName("tb_dispatch")
public class DispatchEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * key
	 */
	@TableId
	private Integer id;
	/**
	 * 月份
	 */
	private String month;

	/**
	 * 配送员id
	 */
	private Integer courierId;
	/**
	 * 总单量
	 */
	private Integer allOrderCount;
	/**
	 * 合计单量
	 */
	private Integer totalOrderCount;
	/**
	 * 费用合计
	 */
	private BigDecimal totalMoney;
	/**
	 * 小件
	 */
	private Integer small;
	/**
	 * 大件
	 */
	private Integer large;
	/**
	 * 三同
	 */
	private Integer thrIdentical;
	/**
	 * 售后取件
	 */
	private Integer afterSaleCount;
	/**
	 * 接货首单量
	 */
	private Integer firstCount;
	/**
	 * 接货续单量
	 */
	private Integer againCount;
	/**
	 * 其他单量
	 */
	private Integer otherCount;
	/**
	 * 差评数
	 */
	private Integer badCount;
	/**
	 * 投诉数
	 */
	private Integer complaintCount;
	/**
	 * 罚款合计
	 */
	private BigDecimal fineMoney;
	/**
	 * 其他扣款
	 */
	private BigDecimal deductMoney;
	/**
	 * 工资
	 */
	private BigDecimal salary;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 1:删除0:正常
	 */
	@TableLogic
	private Integer isDelete;


}
