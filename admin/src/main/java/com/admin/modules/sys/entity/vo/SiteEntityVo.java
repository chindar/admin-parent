package com.admin.modules.sys.entity.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
@TableName("tb_site")
public class SiteEntityVo implements Serializable{

        private static final long serialVersionUID = 1L;

        /**
         *
         */
        @TableId
        private Integer id;
        /**
         *
         */
        private String name;
        /**
         *
         */
        private Integer companyId;
        /**
         *
         */
        private Integer areaId;
        /**
         *
         */
        private Integer cityId;
        /**
         * 1:删除0:正常
         */
        private Integer isDelete;

        /**
         * 设置：
         */
        public void setId(Integer id) {
            this.id = id;
        }
        /**
         * 获取：
         */
        public Integer getId() {
            return id;
        }
        /**
         * 设置：
         */
        public void setName(String name) {
            this.name = name;
        }
        /**
         * 获取：
         */
        public String getName() {
            return name;
        }
        /**
         * 设置：
         */
        public void setCompanyId(Integer companyId) {
            this.companyId = companyId;
        }
        /**
         * 获取：
         */
        public Integer getCompanyId() {
            return companyId;
        }
        /**
         * 设置：
         */
        public void setAreaId(Integer areaId) {
            this.areaId = areaId;
        }
        /**
         * 获取：
         */
        public Integer getAreaId() {
            return areaId;
        }
        /**
         * 设置：
         */
        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }
        /**
         * 获取：
         */
        public Integer getCityId() {
            return cityId;
        }
        /**
         * 设置：1:删除0:正常
         */
        public void setIsDelete(Integer isDelete) {
            this.isDelete = isDelete;
        }
        /**
         * 获取：1:删除0:正常
         */
        public Integer getIsDelete() {
            return isDelete;
        }
}
