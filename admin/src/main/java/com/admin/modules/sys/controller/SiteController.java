package com.admin.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.R;
import com.admin.common.validator.ValidatorUtils;
import com.admin.modules.sys.entity.SiteEntity;
import com.admin.modules.sys.service.SiteService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 站点表
 *
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:19:10
 */
@RestController
@RequestMapping("sys/site")
public class SiteController {
    @Autowired
    private SiteService siteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:site:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = siteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:site:info")
    public R info(@PathVariable("id") Integer id){
        SiteEntity site = siteService.selectById(id);

        return R.ok().put("site", site);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:site:save")
    public R save(@RequestBody SiteEntity site){
        siteService.insert(site);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:site:update")
    public R update(@RequestBody SiteEntity site){
        ValidatorUtils.validateEntity(site);
        siteService.updateAllColumnById(site);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:site:delete")
    public R delete(@RequestBody Integer[] ids){
        siteService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
