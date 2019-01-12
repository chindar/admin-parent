package com.admin.modules.sys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.common.utils.R;
import com.admin.common.utils.Tools;
import com.admin.modules.sys.dao.AreaDao;
import com.admin.modules.sys.dao.SiteDao;
import com.admin.modules.sys.entity.SiteEntity;
import com.admin.modules.sys.entity.vo.SiteEntityVo;
import com.admin.modules.sys.service.SiteService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service("siteService")
public class SiteServiceImpl extends ServiceImpl<SiteDao, SiteEntity> implements SiteService {

    @Autowired
    private SiteDao dao;

    @Autowired
    private AreaDao areaDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        SiteEntity entity = new SiteEntity();
        Page page = new Query<SiteEntity>(params).getPage();
        if (params.get("name") != null && Tools.notEmpty(params.get("name").toString()))
            entity.setName(params.get("name").toString());
        if (params.get("companyId") != null && Tools.notEmpty(params.get("companyId").toString()))
            entity.setCompanyId(Integer.parseInt(params.get("companyId").toString()));
        if (params.get("areaId") != null && Tools.notEmpty(params.get("areaId").toString()))
            entity.setAreaId(Integer.parseInt(params.get("areaId").toString()));
        if (params.get("cityId") != null && Tools.notEmpty(params.get("cityId").toString()))
            entity.setCityId(Integer.parseInt(params.get("cityId").toString()));
        List<SiteEntityVo> list = dao.getSiteList(page, entity);
        page.setRecords(list);
        return new PageUtils(page);
    }

    /**
     * 获取所有有效的站点(不带分页)
     *
     * @param cityId
     * @return
     */
    @Override
    public R listAll(String cityId) {
        boolean condition = StrUtil.isNotBlank(cityId) && !StrUtil.equals(cityId, "undefined");
        return R.ok().put("list", this.selectList(new EntityWrapper<SiteEntity>()
                .eq(condition, "city_id", cityId)));
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteSiteById(Integer id) {
        //删除则校验该公司下面有无绑定的待生效、生效中的合同，如果有则提示：删除失败，该公司有待生效/生效中的合同。
        int pactcount = areaDao.getPactByCompanyId(id, "tb_site");
        if (pactcount > 0) {
            throw new RuntimeException("删除失败，该公司有待生效/生效中的合同");
        }
        int count = dao.deleteSiteById(id);
        return count;
    }

}
