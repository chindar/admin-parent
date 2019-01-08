/*
 * 文件名：DispatchVo.java
 * 版权：Copyright Neusoft Corporation Rights Reserved.
 * 描述：运营数据Vo
 * 修改人：Wang Chinda
 * 修改时间：2019/1/6
 * 修改内容：新增
 */
package com.admin.modules.sys.entity.vo;

import com.admin.modules.sys.entity.DispatchEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 运营数据Vo
 *
 * @author Wang Chinda
 * @date 2019/1/6
 * @see
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class DispatchVo extends DispatchEntity implements Serializable {

    private static final long serialVersionUID = -7607605004887049942L;

    private Integer companyId;
    private String companyName;
    /** 片区名称 */
    private Integer areaId;
    private String areaName;
    /** 城市名称 */
    private Integer cityId;
    private String cityName;
    /** 站点名称 */
    private Integer siteId;
    private String siteName;
    /** ERP账号 */
    private String erpNumber;
    /** 配送员姓名 */
    private String courierName;
    /** 身份证 */
    private String cardId;
    /** 状态 */
    private Integer status;
    /** 合同id */
    private Integer pactId;
    



}
