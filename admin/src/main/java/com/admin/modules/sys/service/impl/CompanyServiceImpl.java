package com.admin.modules.sys.service.impl;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.modules.sys.dao.CompanyDao;
import com.admin.modules.sys.entity.CompanyEntity;
import com.admin.modules.sys.service.CompanyService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("companyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyDao, CompanyEntity> implements CompanyService {

    @Autowired
    private CompanyDao dao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CompanyEntity> page = this.selectPage(
                new Query<CompanyEntity>(params).getPage(),
                new EntityWrapper<CompanyEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 获取所有有效的公司
     * @return
     */
    @Override
    public List<CompanyEntity> getAllCompanyList() {
        return dao.getAllCompanyList();
    }


    @Override
    public PageUtils getCompanyList(Map<String, Object> params,String path) {
        CompanyEntity entity = new CompanyEntity();
        Page page = new Query<CompanyEntity>(params).getPage();
        List<CompanyEntity> list = dao.getCompanyList(page,entity);
//        if (list.size() > 0){
//            for (CompanyEntity info: list) {
//                if (Tools.notEmpty(info.getBusinessFileid())){
//                    info.setBusinessFileUrl(MessageFormat.format("{0}sys/company/getFile?fileId={1}&dbname={2}", path, info.getBusinessFileid(),"businessFile"));
//                }
//                if (Tools.notEmpty(info.getBusinessFileid())){
//                    info.setCardFileUrl(MessageFormat.format("{0}sys/company/getFile?fileId={1}&dbname={2}", path, info.getCardFileid(),"cardFile"));
//                }
//            }
//        }
        page.setRecords(list);
        return new PageUtils(page);
    }
}
