package com.admin.modules.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.common.utils.R;
import com.admin.modules.sys.dao.DispatchDao;
import com.admin.modules.sys.entity.DispatchEntity;
import com.admin.modules.sys.entity.vo.DispatchVo;
import com.admin.modules.sys.service.DispatchService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Log4j2
@SuppressWarnings("ALL")
@Service("dispatchService")
public class DispatchServiceImpl extends ServiceImpl<DispatchDao, DispatchEntity> implements DispatchService {

    @Autowired
    private DispatchDao dispatchDao;

    private static List<Object> templetList = CollUtil.newArrayList();
    static {
        // 公司 ERP账号 总单量 合计单量 费用合计 小件 大件 三同 售后取件 接货首单量 接货续单量 其他单量 差评 投诉 罚款合计 其他扣款 工资 备注
        templetList.add("公司");
        templetList.add("ERP账号");
        templetList.add("总单量");
        templetList.add("合计单量");
        templetList.add("费用合计");
        templetList.add("小件");
        templetList.add("大件");
        templetList.add("三同");
        templetList.add("售后取件");
        templetList.add("接货首单量");
        templetList.add("接货续单量");
        templetList.add("其他单量");
        templetList.add("差评");
        templetList.add("投诉");
        templetList.add("罚款合计");
        templetList.add("其他扣款");
        templetList.add("工资");
        templetList.add("备注");
    }

    @Override
    public R queryPage(Map<String, Object> params) {
        Page<DispatchVo> page = new Query<DispatchVo>(params).getPage();
        DispatchVo dispatchVo = BeanUtil.mapToBean(params, DispatchVo.class, true);
        List<DispatchVo> dispatchVoList = dispatchDao.queryPage(page, dispatchVo);
        page.setRecords(dispatchVoList);

        PageUtils pageUtils = new PageUtils(page);
        return R.ok().put("page", pageUtils);
    }

    @Override
    public void exportDispatch(HttpServletResponse res) {
        OutputStream bos = null;
        try {
            List<DispatchVo> dispatchList = dispatchDao.selectAll();

            // 第一步，创建一个webbook，对应一个Excel文件
            XSSFWorkbook wb = new XSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            XSSFSheet sheet = wb.createSheet("运营数据");

            // 设置所有单元格大小 -- 宽度
            sheet.setDefaultColumnWidth(14);
            // 设置所有单元格大小 -- 高度
            sheet.setDefaultRowHeightInPoints(14);

            /**
             * 数据表内容
             */
            // 添加表头标题
            XSSFRow row = sheet.createRow(0);
            //设置行高
            row.setHeight((short) 600);
            XSSFCell cell = null;
            // 设置表头名称
            for (int i = 0; i < templetList.size(); i++) {
                cell = row.createCell(i);
                cell.setCellValue(Convert.toStr(templetList.get(i)));
            }


            // 遍历配送员信息list
            for (int i = 0; i < dispatchList.size(); i++) {
                DispatchVo vo = dispatchList.get(i);
                // 确定内容开始行
                row = sheet.createRow(row.getRowNum() + 1);
                //设置行高
                row.setHeight((short) 600);

                // 公司
                String companyName = vo.getCompanyName();
                if (StrUtil.isNotBlank(companyName)) {
                    cell = row.createCell(0);
                    cell.setCellValue(companyName);
                }
                // ERP账号
                String name = vo.getErpNumber();
                if (StrUtil.isNotBlank(name)) {
                    cell = row.createCell(1);
                    cell.setCellValue(name);
                }
                // 总单量
                Integer allOrderCount = vo.getAllOrderCount();
                if (ObjectUtil.isNotNull(allOrderCount)) {
                    cell = row.createCell(2);
                    cell.setCellValue(allOrderCount);
                }
                // 合计单量
                Integer totalOrderCount = vo.getTotalOrderCount();
                if (ObjectUtil.isNotNull(totalOrderCount)) {
                    cell = row.createCell(3);
                    cell.setCellValue(totalOrderCount);
                }
                // 费用合计
                BigDecimal totalMoney = vo.getTotalMoney();
                if (ObjectUtil.isNotNull(totalMoney)) {
                    cell = row.createCell(4);
                    cell.setCellValue(Convert.toStr(totalMoney));
                }
                // 小件
                Integer small = vo.getSmall();
                if (ObjectUtil.isNotNull(small)) {
                    cell = row.createCell(5);
                    cell.setCellValue(small);
                }
                // 大件
                Integer large = vo.getLarge();
                if (ObjectUtil.isNotNull(large)) {
                    cell = row.createCell(6);
                    cell.setCellValue(large);
                }
                // 三同
                Integer thrIdentical = vo.getThrIdentical();
                if (ObjectUtil.isNotNull(thrIdentical)) {
                    cell = row.createCell(7);
                    cell.setCellValue(thrIdentical);
                }

                // 售后取件
                Integer afterSaleCount = vo.getAfterSaleCount();
                if (ObjectUtil.isNotNull(afterSaleCount)) {
                    cell = row.createCell(8);
                    cell.setCellValue(afterSaleCount);
                }

                // 接货首单量
                Integer firstCount = vo.getFirstCount();
                if (ObjectUtil.isNotNull(firstCount)) {
                    cell = row.createCell(9);
                    cell.setCellValue(firstCount);
                }

                // 接货续单量
                Integer againCount = vo.getAgainCount();
                if (ObjectUtil.isNotNull(againCount)) {
                    cell = row.createCell(10);
                    cell.setCellValue(againCount);
                }

                // 其他单量
                Integer otherCount = vo.getOtherCount();
                if (ObjectUtil.isNotNull(otherCount)) {
                    cell = row.createCell(11);
                    cell.setCellValue(otherCount);
                }

                // 差评
                Integer badCount = vo.getBadCount();
                if (ObjectUtil.isNotNull(badCount)) {
                    cell = row.createCell(12);
                    cell.setCellValue(badCount);
                }

                // 投诉
                Integer complaintCount = vo.getComplaintCount();
                if (ObjectUtil.isNotNull(complaintCount)) {
                    cell = row.createCell(13);
                    cell.setCellValue(complaintCount);
                }

                // 罚款合计
                BigDecimal fineMoney = vo.getFineMoney();
                if (ObjectUtil.isNotNull(fineMoney)) {
                    cell = row.createCell(14);
                    cell.setCellValue(Convert.toStr(fineMoney));
                }

                // 其他扣款
                BigDecimal deductMoney = vo.getDeductMoney();
                if (ObjectUtil.isNotNull(deductMoney)) {
                    cell = row.createCell(15);
                    cell.setCellValue(Convert.toStr(deductMoney));
                }

                // 工资
                BigDecimal salary = vo.getSalary();
                if (ObjectUtil.isNotNull(salary)) {
                    cell = row.createCell(16);
                    cell.setCellValue(Convert.toStr(salary));
                }

                // 备注
                String remark = vo.getRemark();
                if (StrUtil.isNotBlank(remark)) {
                    cell = row.createCell(17);
                    cell.setCellValue(remark);
                }
            }

            String filename = "运营数据.xlsx";
            res.setHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("gb2312"), "iso8859-1"));
            res.addHeader("Pargam", "no-cache");
            res.addHeader("Cache-Control", "no-cache");
            res.setContentType("application/vnd.ms-excel;charset=UTF8");
            bos = new BufferedOutputStream(res.getOutputStream());
            wb.write(bos);

        } catch (IOException e) {
            log.info("运营数据导出失败!", e);
        } finally {
            IoUtil.close(bos);
        }
    }
}
