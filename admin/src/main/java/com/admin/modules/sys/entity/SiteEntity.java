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
 * 站点表
 * 
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:19:10
 */
@TableName("tb_site")
public class SiteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	@NotBlank(message="站点名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	/**
	 * 
	 */
	@NotNull(message="公司不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Integer companyId;
	/**
	 * 
	 */
	@NotNull(message="片区不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Integer areaId;
	/**
	 * 
	 */
	@NotNull(message="城市不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Integer cityId;
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
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	/**
	 * 获取：
	 */
	public Integer getCompanyId() {
		return companyId;
	}
	/**
	 * 设置：
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取：
	 */
	public Integer getAreaId() {
		return areaId;
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
