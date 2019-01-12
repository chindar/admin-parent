package com.admin.modules.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.common.utils.R;
import com.admin.common.validator.ValidatorUtils;
import com.admin.modules.sys.dao.CompanyDao;
import com.admin.modules.sys.dao.ErpDao;
import com.admin.modules.sys.entity.ErpEntity;
import com.admin.modules.sys.entity.vo.ErpVo;
import com.admin.modules.sys.service.ErpService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Log4j2
@Service("erpService")
@SuppressWarnings("ALL")
public class ErpServiceImpl extends ServiceImpl<ErpDao, ErpEntity> implements ErpService {

    @Autowired
    private ErpDao erpDao;
    @Autowired
    private CompanyDao companyDao;

    private static List<Object> templetList = CollUtil.newArrayList();
    static {
        // ERP账号、公司名称
        templetList.add("ERP账号");
        templetList.add("公司名称");
    }

    /**
     * 保存ERP账户
     *
     * @param erp
     * @return
     */
    @Override
    public R save(ErpEntity erp) {
        // 查询该公司未删除的ERP账号中该ERP账号是否存在
        boolean isExist = existErp(erp);
        if (isExist) {
            return R.error("该账号已存在!");
        }
        ValidatorUtils.validateEntity(erp);
        this.insert(erp);
        return R.ok();
    }

    /**
     * 编辑ERP账户
     *
     * @param erp
     * @return
     */
    @Override
    public R update(ErpEntity erp) {

        ValidatorUtils.validateEntity(erp);
        //全部更新
        this.updateAllColumnById(erp);
        return R.ok();
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ErpEntity> page = this.selectPage(
                new Query<ErpEntity>(params).getPage(),
                new EntityWrapper<ErpEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 查询未绑定在职员工的ERP账号
     *
     * @return
     * @param companyId
     * @param erpId
     */
    @Override
    public R getErpList(String companyId, String erpId) {
        List<ErpEntity> erpList = erpDao.getErpList(companyId);
        if (StrUtil.isNotBlank(erpId)) {
            ErpEntity erpEntity = erpDao.selectById(erpId);
            erpList.add(erpEntity);
        }
        return R.ok().put("list", erpList);
    }

    /**
     * 查询ERP账号列表
     *
     * @param params
     * @return
     */
    @Override
    public R queryPageErpList(Map<String, Object> params) {
        Page<ErpVo> page = new Query<ErpVo>(params).getPage();

        ErpVo erpVo = BeanUtil.mapToBean(params, ErpVo.class, true);
        List<ErpVo> erpVoList = erpDao.queryPageErpList(page, erpVo);
        page.setRecords(erpVoList);
        PageUtils pageUtils = new PageUtils(page);

        return R.ok().put("page", pageUtils);
    }

    /**
     * 导出excel
     *
     * @param res
     */
    @Override
    public void leadOut(HttpServletResponse res) {

        OutputStream bos = null;
        try {
            List<ErpVo> erpList = erpDao.selectAll();

            // 第一步，创建一个webbook，对应一个Excel文件
            XSSFWorkbook wb = new XSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            XSSFSheet sheet = wb.createSheet("ERP账号");

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
            cell = row.createCell(2);
            cell.setCellValue("状态");

            // 遍历ERP数据list
            for (int i = 0; i < erpList.size(); i++) {
                ErpVo vo = erpList.get(i);
                // 确定内容开始行
                row = sheet.createRow(row.getRowNum() + 1);
                //设置行高
                row.setHeight((short) 600);
                // ERP账号
                String erpNumber = vo.getErpNumber();
                if (StrUtil.isNotBlank(erpNumber)) {
                    cell = row.createCell(0);
                    cell.setCellValue(erpNumber);
                }
                // 公司名称
                String companyName = vo.getCompanyName();
                if (StrUtil.isNotBlank(companyName)) {
                    cell = row.createCell(1);
                    cell.setCellValue(companyName);
                }
                // 状态
                Integer statusI = vo.getStatus();
                if (ObjectUtil.isNotNull(statusI)) {
                    int status = statusI.intValue();
                    cell = row.createCell(2);
                    cell.setCellValue(status == 1 ? "停用" : status == 0 ? "启用" : "");
                }
            }

            String filename = "ERP账号.xlsx";
            res.setHeader("Content-Disposition", "attachment;filename=" + new String(filename
                    .getBytes("gb2312"), CharsetUtil.CHARSET_ISO_8859_1));
            res.addHeader("Pargam", "no-cache");
            res.addHeader("Cache-Control", "no-cache");
            res.setContentType("application/vnd.ms-excel;charset=UTF8");
            bos = new BufferedOutputStream(res.getOutputStream());
            wb.write(bos);

        } catch (IOException e) {
            log.info("ERP账号导出失败!", e);
        } finally {
            IoUtil.close(bos);
        }
    }

    /**
     * 导入配送员信息
     *
     * @param file
     * @return
     */
    @Override
    public R upload(MultipartFile file) {
        try {
            InputStream is = file.getInputStream();
            String filename = file.getOriginalFilename();
            ExcelReader reader = ExcelUtil.getReader(is, 0);
            // TODO: 2018/12/15 判断是否为规定模板
            List<List<Object>> readFirstList = reader.read(0, 0);
            List<Object> columnList = readFirstList.get(0);
            if (isTemplet(columnList, templetList)) {
                // TODO: 2018/12/15 读取文件
                List<List<Object>> contentList = reader.read(1);
                // TODO: 2018/12/15 解析数据
                List<ErpEntity> erpList = CollUtil.newArrayList();
                List<ErpEntity> failList = CollUtil.newArrayList();
                contentList.forEach(lineList -> {
                    ErpEntity erp = new ErpEntity();
                    // ERP账号
                    String erpNumber = Convert.toStr(lineList.get(0));
                    if (StrUtil.isBlank(erpNumber)) {
                        throw new RuntimeException();
                    }
                    erp.setErpNumber(erpNumber);
                    // 公司名称
                    String companyName = Convert.toStr(lineList.get(1));
                    if (StrUtil.isBlank(companyName)) {
                        throw new RuntimeException();
                    }
                    Integer companyId = companyDao.getOneByName(companyName);
                    if (ObjectUtil.isNull(companyId)) {
                        throw new RuntimeException();
                    }
                    erp.setCompanyId(companyId);
                    if (existErp(erp)) {
                        failList.add(erp);
                    }
                    erpList.add(erp);
                });
                if (CollUtil.isNotEmpty(failList)) {
                    return R.error("上传失败: 数据重复!");
                }
                //  存入数据库
                if (CollUtil.isNotEmpty(erpList)) {
                    this.insertBatch(erpList);
                }
            } else {
                return R.error("上传失败: 请选择正确的模板!");
            }
        } catch (RuntimeException e) {
            return R.error("上传失败, 数据出错!");
        } catch (IOException e) {
            return R.error("上传失败, 解析EXCEL失败!");
        } catch (Exception e) {
            return R.error();
        }
        return R.ok();
    }

    /**
     * 查询该公司未删除的ERP账号中该ERP账号是否存在
     *
     * @param erp
     * @return
     */
    private boolean existErp(ErpEntity erp) {
        String erpNumber = erp.getErpNumber();
        Integer companyId = erp.getCompanyId();
        return this.selectCount(new EntityWrapper<ErpEntity>()
                .eq(StrUtil.isNotBlank(erp.getErpNumber()), "erp_number", erpNumber)
                .eq(ObjectUtil.isNotNull(companyId), "company_id", companyId)) > 0 ? true : false;
    }

    /**
     * 是否为Excel模板
     *
     * @param columnList
     * @param templetList
     * @return
     */
    private boolean isTemplet(List<Object> columnList, List<Object> templetList) {
        int templetSize = templetList.size();
        int colSize = columnList.size();
        if (templetSize == colSize) {
            int count = 0;
            for (int i = 0; i < colSize; i++) {
                if (templetList.get(i).equals(columnList.get(i))) {
                    count++;
                }
            }
            if (count == templetSize) {
                return true;
            }
        }
        return false;
    }
}
