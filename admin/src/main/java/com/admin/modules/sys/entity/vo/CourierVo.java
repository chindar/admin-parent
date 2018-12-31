/*
 * file name: CourierVo.java
 * copyright:
 * desc: 快递员数据传递对象
 * author: Wang Chinda
 * date: 2018-12-16 8:34
 * modify history: add
 */
package com.admin.modules.sys.entity.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 快递员数据传递对象
 *
 * @author Wang Chinda
 * @date 2018-12-16 8:34
 * @see
 * @since 1.0
 */
@Data
public class CourierVo implements Serializable {
    private static final long serialVersionUID = -7299850319822134930L;
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
    /** 离职倒计时 */
    private Long jobOverTime;
    /**
     * 1:离职 0:在职
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
    /** 公司 */
    private Integer companyId;
    private String companyName;
    /**
     * ERP账号
     */
    private Integer erpId;
    private String erpNumber;
    /**
     * 片区
     */
    private Integer areaId;
    private String areaName;
    /**
     * 站点
     */
    private Integer siteId;
    private String siteName;
    /**
     * 合同
     */
    private Integer pactId;
    private String pactName;
    /**
     * 城市
     */
    private Integer cityId;
    private String cityName;
    /** 创建时间 */
    private Date createTime;
    /**
     * -1:删除0:正常
     */
    private Integer isDelete;
}
