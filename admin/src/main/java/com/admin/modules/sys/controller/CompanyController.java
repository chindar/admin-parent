package com.admin.modules.sys.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.admin.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admin.modules.sys.entity.CompanyEntity;
import com.admin.modules.sys.service.CompanyService;
import com.admin.common.utils.PageUtils;
import com.admin.common.utils.R;



/**
 * 公司信息表
 *
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:55:09
 */
@RestController
@RequestMapping("sys/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    /**
     * 获取所有有效的公司(不带分页)
     * @return
     */
    @RequestMapping(value = "getAllCompanyList")
    public R getAllCompanyList(){
        List<CompanyEntity> list = companyService.getAllCompanyList();
        return R.ok().put("list",list);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:company:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = companyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:company:info")
    public R info(@PathVariable("id") Integer id){
        CompanyEntity company = companyService.selectById(id);

        return R.ok().put("company", company);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:company:save")
    public R save(@RequestBody CompanyEntity company){
        companyService.insert(company);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:company:update")
    public R update(@RequestBody CompanyEntity company){
        ValidatorUtils.validateEntity(company);
        companyService.updateAllColumnById(company);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:company:delete")
    public R delete(@RequestBody Integer[] ids){
        companyService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
