package com.admin.modules.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.common.utils.R;
import com.admin.common.validator.ValidatorUtils;
import com.admin.modules.sys.dao.CityInfoDao;
import com.admin.modules.sys.dao.CourierDao;
import com.admin.modules.sys.entity.CourierEntity;
import com.admin.modules.sys.entity.vo.CourierVo;
import com.admin.modules.sys.service.CourierService;
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

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Log4j2
@SuppressWarnings("ALL")
@Service("courierService")
public class CourierServiceImpl extends ServiceImpl<CourierDao, CourierEntity> implements CourierService {

    @Autowired
    private CityInfoDao cityInfoDao;
    @Autowired
    private CourierDao courierDao;


    private static List<Object> templetList = CollUtil.newArrayList();

    static {
        // 公司、姓名、身份证、手机号、银行卡、开户行、银联号、入职时间、离职时间、合同、ERP账号、站点、备注
        templetList.add("公司");
        templetList.add("姓名");
        templetList.add("身份证");
        templetList.add("手机号");
        templetList.add("银行卡");
        templetList.add("开户行");
        templetList.add("银联号");
        templetList.add("入职时间");
        templetList.add("离职时间");
        templetList.add("合同");
        templetList.add("ERP账号");
        templetList.add("站点");
        templetList.add("备注");
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CourierEntity> page = this.selectPage(
                new Query<CourierEntity>(params).getPage(),
                new EntityWrapper<CourierEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 查询配送员列表
     *
     * @param params
     * @return
     */
    @Override
    public R queryCourierList(Map<String, Object> params) {
        Page<CourierVo> page = new Query<CourierVo>(params).getPage();

        CourierVo courierVo = BeanUtil.mapToBean(params, CourierVo.class, true);

        List<CourierVo> courierVoList = courierDao.queryCourierList(page, courierVo);
        List<String> nameList = CollUtil.newArrayList();
        for (CourierVo c : courierVoList) {
            Date leaveDate = c.getLeaveDate();
            if (ObjectUtil.isNotNull(leaveDate)) {
                long jobOverTime = DateUtil.betweenDay(DateUtil.date(), leaveDate, false);
                c.setJobOverTime(jobOverTime);
            } else {
                nameList.add(c.getName());
            }
        }
        page.setRecords(courierVoList);

        PageUtils pageUtils = new PageUtils(page);
        if (CollUtil.isEmpty(nameList)) {
            return R.ok().put("page", pageUtils);
        }
        return R.ok(StrUtil.format("{}离职时间为空, 运算离职倒计时失败!", Convert.toStr(nameList))).put("page", pageUtils);
    }

    public PageUtils selectMyPage(Map<String, Object> params) {
        Page<CourierVo> page = new Query<CourierVo>(params).getPage();
        CourierVo courierVo = BeanUtil.mapToBean(params, CourierVo.class, true);
        page.setRecords(courierDao.selectMyPage(page, courierVo));
        return new PageUtils(page);
    }

//    /**
//     * 上传文件
//     *
//     * @param multipartFile
//     * @return
//     */
//    @Override
//    public R importCourier(MultipartFile multipartFile) {
//        final String batchId = RandomUtil.simpleUUID();
//        try {
//            InputStream is = multipartFile.getInputStream();
//            String filename = multipartFile.getOriginalFilename();
//            ExcelReader reader = ExcelUtil.getReader(is, 0);
//            // TODO: 2018/12/15 判断是否为规定模板
//            List<List<Object>> readFirstList = reader.read(0, 0);
//            List<Object> columnList = readFirstList.get(0);
//            if (isTemplet(columnList, templetList)) {
//                // TODO: 2018/12/15 读取文件
//                List<List<Object>> contentList = reader.read(1);
//                // TODO: 2018/12/15 解析数据
//                List<CourierEntity> courierList = CollUtil.newArrayList();
//                contentList.forEach(lineList -> {
//                    CourierEntity courierEntity = new CourierEntity();
//                    // 片区 城市 站点 erp账号 姓名 身份证号码 电话 银行卡号 开户行 联行号 入职时间 离职时间 状态 备注
//                    courierEntity.setArea(Convert.toStr(lineList.get(0)));
//                    // 根据城市名称获取城市id
//                    Integer cityId = cityInfoDao.getIdByCityName(lineList.get(1));
//                    courierEntity.setCityId(cityId);
//                    courierEntity.setSite(Convert.toStr(lineList.get(2)));
//                    courierEntity.setErpId(Convert.toStr(lineList.get(3)));
//                    courierEntity.setName(Convert.toStr(lineList.get(4)));
//                    courierEntity.setCardId(Convert.toStr(lineList.get(5)));
//                    courierEntity.setPhone(Convert.toStr(lineList.get(6)));
//                    courierEntity.setBankCardId(Convert.toStr(lineList.get(7)));
//                    courierEntity.setDepositBank(Convert.toStr(lineList.get(8)));
//                    courierEntity.setJoinBankNumber(Convert.toStr(lineList.get(9)));
//                    courierEntity.setEntryDate(DateUtil.parse(Convert.toStr(lineList.get(10))));
//                    courierEntity.setLeaveDate(DateUtil.parse(Convert.toStr(lineList.get(11))));
//                    String statusStr = Convert.toStr(lineList.get(12));
//                    int status = StrUtil.equals(statusStr, "在职") ? 1 : 0;
//                    courierEntity.setStatus(status);
//                    courierEntity.setComment(Convert.toStr(lineList.get(13)));
//                    courierEntity.setIsDelete(0);
//                    String username = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getUsername();
//                    courierEntity.setCreater(username);
//                    courierEntity.setCreateDate(DateUtil.date());
//                    courierEntity.setBatchId(batchId);
//                    courierList.add(courierEntity);
//                });
//                // TODO: 2018/12/15 存入数据库
//                if (CollUtil.isNotEmpty(courierList)) {
//                    this.insertBatch(courierList);
//                }
//            }
//        } catch (IOException e) {
//            return R.error("导入失败, 解析Excel异常!");
//        } catch (DateException e) {
//            return R.error("导入失败, 时间解析异常!");
//        } catch (Exception e) {
//            return R.error();
//        }
//        return R.ok().put("batchId", batchId);
//    }

//    /**
//     * 批量更新配送员信息
//     *
//     * @param batchId
//     * @param pactId
//     * @return
//     */
//    @Override
//    public R editBatch(String batchId, String pactId) {
//        courierDao.updateByBatch(batchId, pactId);
//        return R.ok();
//    }

    /**
     * 导出配送员信息
     *
     * @param ids
     * @param res
     */
    @Override
    public void exportCourier(HttpServletResponse res) {

        OutputStream bos = null;
        try {
            List<CourierVo> courierList = courierDao.selectAll();

            // 第一步，创建一个webbook，对应一个Excel文件
            XSSFWorkbook wb = new XSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            XSSFSheet sheet = wb.createSheet("配送员信息");

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
            cell = row.createCell(13);
            cell.setCellValue("状态");

            // 遍历配送员信息list
            for (int i = 0; i < courierList.size(); i++) {
                CourierVo vo = courierList.get(i);
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
                // 姓名
                String name = vo.getName();
                if (StrUtil.isNotBlank(name)) {
                    cell = row.createCell(1);
                    cell.setCellValue(name);
                }
                // 身份证
                String cardId = vo.getCardId();
                if (StrUtil.isNotBlank(cardId)) {
                    cell = row.createCell(2);
                    cell.setCellValue(cardId);
                }
                // 手机号
                String phone = vo.getPhone();
                if (StrUtil.isNotBlank(phone)) {
                    cell = row.createCell(3);
                    cell.setCellValue(phone);
                }
                // 银行卡
                String bankCardId = vo.getBankCardId();
                if (StrUtil.isNotBlank(bankCardId)) {
                    cell = row.createCell(4);
                    cell.setCellValue(bankCardId);
                }
                // 开户行
                String depositBank = vo.getDepositBank();
                if (StrUtil.isNotBlank(depositBank)) {
                    cell = row.createCell(5);
                    cell.setCellValue(depositBank);
                }
                // 银联号
                String joinBankNumber = vo.getJoinBankNumber();
                if (StrUtil.isNotBlank(joinBankNumber)) {
                    cell = row.createCell(6);
                    cell.setCellValue(joinBankNumber);
                }
                // 入职时间
                Date entryDate = vo.getEntryDate();
                if (ObjectUtil.isNotNull(entryDate)) {
                    cell = row.createCell(7);
                    cell.setCellValue(entryDate);
                }

                // 离职时间
                Date leaveDate = vo.getLeaveDate();
                if (ObjectUtil.isNotNull(leaveDate)) {
                    cell = row.createCell(8);
                    cell.setCellValue(leaveDate);
                }

                // 合同
                String pactName = vo.getPactName();
                if (StrUtil.isNotBlank(pactName)) {
                    cell = row.createCell(9);
                    cell.setCellValue(pactName);
                }

                // ERP账号
                String erpNumber = vo.getErpNumber();
                if (StrUtil.isNotBlank(erpNumber)) {
                    cell = row.createCell(10);
                    cell.setCellValue(erpNumber);
                }

                // 站点
                String siteName = vo.getSiteName();
                if (StrUtil.isNotBlank(siteName)) {
                    cell = row.createCell(11);
                    cell.setCellValue(siteName);
                }

                // 备注
                String remark = vo.getRemark();
                if (StrUtil.isNotBlank(remark)) {
                    cell = row.createCell(12);
                    cell.setCellValue(remark);
                }

                // 状态
                Integer statusI = vo.getStatus();
                if (ObjectUtil.isNotNull(statusI)) {
                    int status = statusI.intValue();
                    cell = row.createCell(13);
                    cell.setCellValue(status == 1 ? "离职" : status == 0 ? "在职" : "");
                }
            }

            String filename = "配送员信息.xlsx";
            res.setHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("gb2312"), "iso8859-1"));
            res.addHeader("Pargam", "no-cache");
            res.addHeader("Cache-Control", "no-cache");
            res.setContentType("application/vnd.ms-excel;charset=UTF8");
            bos = new BufferedOutputStream(res.getOutputStream());
            wb.write(bos);

        } catch (IOException e) {
            log.info("配送员信息导出失败!", e);
        } finally {
            IoUtil.close(bos);
        }
    }

    /**
     * 保存配送员信息
     *
     * @param courier
     * @return
     */
    @Override
    public R save(CourierEntity courier) {
        if (isExist(courier)) {
            return R.error("该员工已在公司中入职!");
        }
        //校验类型
        ValidatorUtils.validateEntity(courier);
        this.insert(courier);
        return R.ok();
    }

    /**
     * 更新配送员信息
     *
     * @param courier
     * @return
     */
    @Override
    public R update(CourierEntity courier) {
        if (isExist(courier)) {
            return R.error("该员工已在公司中入职!");
        }
        ValidatorUtils.validateEntity(courier);
        this.updateAllColumnById(courier);//全部更新
        return R.ok();
    }

    /**
     * 判断配送员信息在公司中是否存在
     *
     * @param courier
     * @return
     */
    private boolean isExist(CourierEntity courier) {
        Integer companyId = courier.getCompanyId();
        String cardId = courier.getCardId();
        return this.selectCount(new EntityWrapper<CourierEntity>()
                .eq("company_id", companyId)
                .eq("card_id", cardId)) > 0 ? true : false;
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
