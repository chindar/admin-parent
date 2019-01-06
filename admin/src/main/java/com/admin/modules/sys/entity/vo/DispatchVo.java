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
import lombok.NoArgsConstructor;

/**
 * 运营数据Vo
 *
 * @author Wang Chinda
 * @date 2019/1/6
 * @see
 * @since 1.0
 */
@Data
@NoArgsConstructor
public class DispatchVo extends DispatchEntity {

    /** 片区名称 */
    private String areaName;
    /** 城市名称 */
    private String cityName;
    /** 站点名称 */
    private String siteName;
    /** ERP账号 */
    private String erpNumber;
    /** 配送员姓名 */
    private String courierName;
    /** 身份证 */
    private String cardId;
    



}
