package com.admin.modules.sys.entity;

import com.admin.common.validator.group.AddGroup;
import com.admin.common.validator.group.UpdateGroup;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
	@NotBlank(message="合同名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	/**
	 * 业务名称
	 */
	@NotBlank(message="业务名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String businessName;
	/**
	 * 
	 */
	private Integer cityId;
	/**
	 * 开始时间
	 */
	@NotBlank(message="开始时间不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String startDate;
	/**
	 * 结束时间
	 */
	@NotBlank(message="结束时间不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String endDate;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 合同文件id
	 */
	@NotNull(message="合同文件不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String fileId;
	/**
	 * 
	 */
	private String fileName;
	/**
	 * 公司id
	 */
	@NotNull(message="公司不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Integer companyId;
	/**
	 * 省份
	 */
	@NotBlank(message="省份不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String provinceName;
	/**
	 * 城市
	 */
	@NotBlank(message="城市不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String cityName;
	/**
	 * 1:删除0:正常
	 */
	private Integer isDelete;

//	/**
//	 *合同状态 0待生效、1生效、2结束
//	 */
//	private Integer pactStatus;
//
//	public Integer getPactStatus() {
//		return pactStatus;
//	}
//
//	public void setPactStatus(Integer pactStatus) {
//		this.pactStatus = pactStatus;
//	}

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
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取：开始时间
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：结束时间
	 */
	public String getEndDate() {
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
