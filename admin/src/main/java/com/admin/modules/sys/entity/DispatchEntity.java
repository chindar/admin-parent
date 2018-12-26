package com.admin.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 配送信息表
 * 
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:55:09
 */
@TableName("tb_dispatch")
public class DispatchEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 月份
	 */
	private String month;
	/**
	 * 公司id
	 */
	private Integer companyId;
	/**
	 * ERP账号id
	 */
	private Integer erpId;
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
	private Integer isDelete;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：月份
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * 获取：月份
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * 设置：公司id
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	/**
	 * 获取：公司id
	 */
	public Integer getCompanyId() {
		return companyId;
	}
	/**
	 * 设置：ERP账号id
	 */
	public void setErpId(Integer erpId) {
		this.erpId = erpId;
	}
	/**
	 * 获取：ERP账号id
	 */
	public Integer getErpId() {
		return erpId;
	}
	/**
	 * 设置：总单量
	 */
	public void setAllOrderCount(Integer allOrderCount) {
		this.allOrderCount = allOrderCount;
	}
	/**
	 * 获取：总单量
	 */
	public Integer getAllOrderCount() {
		return allOrderCount;
	}
	/**
	 * 设置：合计单量
	 */
	public void setTotalOrderCount(Integer totalOrderCount) {
		this.totalOrderCount = totalOrderCount;
	}
	/**
	 * 获取：合计单量
	 */
	public Integer getTotalOrderCount() {
		return totalOrderCount;
	}
	/**
	 * 设置：费用合计
	 */
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	/**
	 * 获取：费用合计
	 */
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	/**
	 * 设置：小件
	 */
	public void setSmall(Integer small) {
		this.small = small;
	}
	/**
	 * 获取：小件
	 */
	public Integer getSmall() {
		return small;
	}
	/**
	 * 设置：大件
	 */
	public void setLarge(Integer large) {
		this.large = large;
	}
	/**
	 * 获取：大件
	 */
	public Integer getLarge() {
		return large;
	}
	/**
	 * 设置：三同
	 */
	public void setThrIdentical(Integer thrIdentical) {
		this.thrIdentical = thrIdentical;
	}
	/**
	 * 获取：三同
	 */
	public Integer getThrIdentical() {
		return thrIdentical;
	}
	/**
	 * 设置：售后取件
	 */
	public void setAfterSaleCount(Integer afterSaleCount) {
		this.afterSaleCount = afterSaleCount;
	}
	/**
	 * 获取：售后取件
	 */
	public Integer getAfterSaleCount() {
		return afterSaleCount;
	}
	/**
	 * 设置：接货首单量
	 */
	public void setFirstCount(Integer firstCount) {
		this.firstCount = firstCount;
	}
	/**
	 * 获取：接货首单量
	 */
	public Integer getFirstCount() {
		return firstCount;
	}
	/**
	 * 设置：接货续单量
	 */
	public void setAgainCount(Integer againCount) {
		this.againCount = againCount;
	}
	/**
	 * 获取：接货续单量
	 */
	public Integer getAgainCount() {
		return againCount;
	}
	/**
	 * 设置：其他单量
	 */
	public void setOtherCount(Integer otherCount) {
		this.otherCount = otherCount;
	}
	/**
	 * 获取：其他单量
	 */
	public Integer getOtherCount() {
		return otherCount;
	}
	/**
	 * 设置：差评数
	 */
	public void setBadCount(Integer badCount) {
		this.badCount = badCount;
	}
	/**
	 * 获取：差评数
	 */
	public Integer getBadCount() {
		return badCount;
	}
	/**
	 * 设置：投诉数
	 */
	public void setComplaintCount(Integer complaintCount) {
		this.complaintCount = complaintCount;
	}
	/**
	 * 获取：投诉数
	 */
	public Integer getComplaintCount() {
		return complaintCount;
	}
	/**
	 * 设置：罚款合计
	 */
	public void setFineMoney(BigDecimal fineMoney) {
		this.fineMoney = fineMoney;
	}
	/**
	 * 获取：罚款合计
	 */
	public BigDecimal getFineMoney() {
		return fineMoney;
	}
	/**
	 * 设置：其他扣款
	 */
	public void setDeductMoney(BigDecimal deductMoney) {
		this.deductMoney = deductMoney;
	}
	/**
	 * 获取：其他扣款
	 */
	public BigDecimal getDeductMoney() {
		return deductMoney;
	}
	/**
	 * 设置：工资
	 */
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	/**
	 * 获取：工资
	 */
	public BigDecimal getSalary() {
		return salary;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：1:删除0:正常
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：1:删除0:正常
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
}
