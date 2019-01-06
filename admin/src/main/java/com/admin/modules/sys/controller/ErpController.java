package com.admin.modules.sys.controller;

import com.admin.common.utils.R;
import com.admin.modules.sys.entity.ErpEntity;
import com.admin.modules.sys.service.ErpService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
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
    public R info(@PathVariable("id") Integer id){
        ErpEntity erp = erpService.selectById(id);

        return R.ok().put("erp", erp);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ErpEntity erp){
        return erpService.save(erp);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ErpEntity erp){
        return erpService.update(erp);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer id){
        erpService.deleteById(id);

        return R.ok();
    }

    /**
     * 导出excel
     * @param res
     */
    @GetMapping("/leadOut")
    public void leadOut(HttpServletResponse res) {
        erpService.leadOut(res);
    }

    /**
     * 导入配送员信息
     * @return
     */
    @PostMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file) {
        return erpService.upload(file);
    }

}
