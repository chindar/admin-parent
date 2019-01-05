/*
 * 文件名：ErpVo.java
 * 版权：Copyright Neusoft Corporation Rights Reserved.
 * 描述：
 * 修改人：Wang Chinda
 * 修改时间：2019/1/5
 * 修改内容：新增
 */
package com.admin.modules.sys.entity.vo;

import com.admin.modules.sys.entity.ErpEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wang Chinda
 * @date 2019/1/5
 * @see
 * @since 1.0
 */
@Data
@NoArgsConstructor
public class ErpVo extends ErpEntity {

    private String companyName;
}
