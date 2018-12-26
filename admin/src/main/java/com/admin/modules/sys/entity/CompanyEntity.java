package com.admin.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 公司信息表
 * 
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:55:09
 */
@TableName("tb_company")
public class CompanyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 公司名
	 */
	private String name;
	/**
	 * 法人
	 */
	private String legalPersonName;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 邮编
	 */
	private String zipCode;
	/**
	 * 联系人
	 */
	private String contactName;
	/**
	 * 联系人电话
	 */
	private String phone;
	/**
	 * 营业执照
	 */
	private String businessFileid;
	/**
	 * 法人身份证
	 */
	private String cardFileid;
	/**
	 * 省份
	 */
	private String provinceName;
	/**
	 * 城市
	 */
	private String cityName;
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
	 * 设置：公司名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：公司名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：法人
	 */
	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}
	/**
	 * 获取：法人
	 */
	public String getLegalPersonName() {
		return legalPersonName;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：邮编
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * 获取：邮编
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * 设置：联系人
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * 获取：联系人
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * 设置：联系人电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系人电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：营业执照
	 */
	public void setBusinessFileid(String businessFileid) {
		this.businessFileid = businessFileid;
	}
	/**
	 * 获取：营业执照
	 */
	public String getBusinessFileid() {
		return businessFileid;
	}
	/**
	 * 设置：法人身份证
	 */
	public void setCardFileid(String cardFileid) {
		this.cardFileid = cardFileid;
	}
	/**
	 * 获取：法人身份证
	 */
	public String getCardFileid() {
		return cardFileid;
	}
	/**
	 * 设置：省份
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	/**
	 * 获取：省份
	 */
	public String getProvinceName() {
		return provinceName;
	}
	/**
	 * 设置：城市
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * 获取：城市
	 */
	public String getCityName() {
		return cityName;
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
