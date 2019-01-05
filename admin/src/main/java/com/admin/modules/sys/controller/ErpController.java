package com.admin.modules.sys.controller;

import com.admin.common.utils.R;
import com.admin.common.validator.ValidatorUtils;
import com.admin.modules.sys.entity.ErpEntity;
import com.admin.modules.sys.service.ErpService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * erp账号表
 *
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:19:10
 */
@RestController
@RequestMapping("sys/erp")
public class ErpController {
    @Autowired
    private ErpService erpService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:erp:list")
    public R list(@RequestParam Map<String, Object> params){

        return erpService.queryPageErpList(params);
    }

    /**
     * 查询未绑定员工的ERP账号
     * @return
     */
    @GetMapping("/listByCourier")
    public R list() {
        return erpService.getErpList();
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:erp:info")
    public R info(@PathVariable("id") Integer id){
        ErpEntity erp = erpService.selectById(id);

        return R.ok().put("erp", erp);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:erp:save")
    public R save(@RequestBody ErpEntity erp){
        erpService.insert(erp);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:erp:update")
    public R update(@RequestBody ErpEntity erp){
        ValidatorUtils.validateEntity(erp);
        erpService.updateAllColumnById(erp);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:erp:delete")
    public R delete(@RequestBody Integer[] ids){
        erpService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
