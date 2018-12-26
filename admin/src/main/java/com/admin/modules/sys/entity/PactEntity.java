package com.admin.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 合同信息表
 * 
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:55:09
 */
@TableName("tb_pact")
public class PactEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 合同名称
	 */
	private String name;
	/**
	 * 业务名称
	 */
	private String businessName;
	/**
	 * 
	 */
	private Integer cityId;
	/**
	 * 开始时间
	 */
	private Date startDate;
	/**
	 * 结束时间
	 */
	private Date endDate;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 合同文件id
	 */
	private String fileId;
	/**
	 * 
	 */
	private String fileName;
	/**
	 * 公司id
	 */
	private Integer companyId;
	/**
	 * 省份
	 */
	private String provinceName;
	/**
	 * 城市
	 */
	private String cityName;
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
	 * 设置：合同名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：合同名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：业务名称
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	/**
	 * 获取：业务名称
	 */
	public String getBusinessName() {
		return businessName;
	}
	/**
	 * 设置：
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：
	 */
	public Integer getCityId() {
		return cityId;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEndDate() {
		return endDate;
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
	 * 设置：合同文件id
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	/**
	 * 获取：合同文件id
	 */
	public String getFileId() {
		return fileId;
	}
	/**
	 * 设置：
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：
	 */
	public String getFileName() {
		return fileName;
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
