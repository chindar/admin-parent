package com.admin.modules.sys.controller;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.R;
import com.admin.common.validator.ValidatorUtils;
import com.admin.common.validator.group.UpdateGroup;
import com.admin.modules.sys.entity.PactEntity;
import com.admin.modules.sys.entity.vo.PactEntityVo;
import com.admin.modules.sys.service.PactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;



/**
 * 合同信息表
 *
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:55:09
 */
@RestController
@RequestMapping("sys/pact")
public class PactController {
    @Autowired
    private PactService pactService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        String QUERY_FILE_PATH = request.getScheme() + "://" +
                request.getServerName() + ":" + request.getServerPort() +
                request.getContextPath() + "/";
        PageUtils page = pactService.queryPage(params, QUERY_FILE_PATH);

        return R.ok().put("page", page);
    }

    /**
     * 获取所有有效的合同信息(不带分页)
     * @return
     */
    @GetMapping("/listAll/{companyId}")
    public R listAll(@PathVariable("companyId") Integer companyId) {
        return pactService.listAll(companyId);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
//        PactEntity pact = pactService.selectById(id);
        PactEntityVo pact = pactService.getPactInfoById(id);
        return R.ok().put("pact", pact);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PactEntity pact){
        ValidatorUtils.validateEntity(pact,UpdateGroup.class);
        pactService.insert(pact);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PactEntity pact){
        ValidatorUtils.validateEntity(pact);
        pactService.updateAllColumnById(pact);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestParam(value = "id",defaultValue = "") Integer id){
//        pactService.deleteBatchIds(Arrays.asList(ids));
        try{
            pactService.deletePactById(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error(e.getMessage());
        }
        return R.ok();
    }
}
