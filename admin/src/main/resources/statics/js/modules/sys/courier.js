$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/courier/list',
        datatype: "json",
        colModel: [
            // 姓名 身份证 手机 公司 片区 城市 站点 合同 创建时间 ERP账号 离职倒记时 状态 操作
            {
                label: '姓名',
                name: 'name',
                index: 'name',
                width: 100
            },
            {
                label: '身份证',
                name: 'cardId',
                index: 'card_id',
                width: 100
            },
            {
                label: '手机',
                name: 'phone',
                index: 'phone',
                width: 100
            },
            {
                label: '公司',
                name: 'companyName',
                index: 'company_name',
                width: 100
            },
            {
                label: '片区',
                name: 'areaName',
                index: 'area_name',
                width: 80
            }, {
                label: '城市',
                name: 'cityName',
                index: 'city_name',
                width: 80
            },
            {
                label: '站点',
                name: 'siteName',
                index: 'site_name',
                width: 80
            },
            {
                label: '合同',
                name: 'pactName',
                index: 'pact_name',
                width: 80
            },
            {
                label: '创建时间',
                name: 'createTime',
                index: 'create_time',
                width: 80
            },
            {
                label: 'ERP账号',
                name: 'erpNumber',
                index: 'erp_number',
                width: 80
            },
            {
                label: '离职倒记时',
                name: 'jobOverTime',
                index: 'job_over_time',
                width: 80
            },
            {
                label: '状态',
                name: 'status',
                index: 'status',
                width: 80,
                formatter: function (value, options, row) {
                    return value == 0 ?
                        '<span class="label label-success">在职</span>' :
                        value == 1 ?
                            '<span class="label label-danger">离职</span>' :
                            '<span class="label"></span>';
                }
            },
            {
                label: '操作',
                name: 'option',
                index: 'option',
                width: 150,
                formatter: cmgStateFormat
            },
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: false,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        },
        //格式化操作列
    });

    function cmgStateFormat(cellValue) {
        return "<button class='btn btn-info	 ' onclick=\"editArea(" + cellValue + ")\">编辑</button>" +
            "<button class='btn btn-info	 ' onclick=\"editArea(" + cellValue + ")\">详情</button>" +
            "&nbsp;&nbsp;&nbsp;<button class='btn btn-info	 ' onclick=\"del(" + cellValue + ")\">删除</button>";
    }

    // new AjaxUpload('#upload', {
    //     action: baseURL + "sys/courier/import",
    //     name: 'file',
    //     autoSubmit: true,
    //     responseType: "json",
    //     onSubmit: function (file, extension) {
    //
    //         if (vm.pactId == '') {
    //             alert("录入之前请先选择某一个合同, 之后再操作!");
    //             return false;
    //         }
    //         if (!(extension && /^(xlsx)$/.test(extension.toLowerCase()))) {
    //             alert('只支持xlsx格式的文件！');
    //             return false;
    //         }
    //     },
    //     onComplete: function (file, r) {
    //         if (r.code == 0) {
    //             vm.batchId = r.batchId;
    //         } else {
    //             alert(r.msg);
    //         }
    //     },
    // });
});


var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        showStatus: false,
        q: {
            name: null,
            erpNumber: null,
            cardId: null,
            companyId: null,
            status: -1,
            pactId: null,
            cityId: null,
            areaId: null,
            siteId: null
        },
        courier: {},
        pactId: '',
        companyList: [],
        pactList: [],
        cityList: [],
        areaList: [],
        siteList: [],
        erpList: [],
        batchId: null
    },
    watch: {
        batchId: function (newBatchId, oldBatchId) {
            if (newBatchId != null) {
                this.editBatch(newBatchId);
            }
        },
        /**********************************************************************
         * 监听keyword是否切换
         * @author Wang Chinda
         **********************************************************************/
        keyword: function (newKey, oldKey) {
            if (newKey != oldKey) {
                vm.q.name = null;
            }
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.showStatus = false;
            vm.title = "新增配送员";
            vm.courier = {
                erpId: '',
                companyId: '',
                status: '',
                pactId: '',
                cityId: '',
                areaId: '',
                siteId: ''
            };
            vm.searchErpList();

        },
        update: function (id) {
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },
        saveOrUpdate: function (event) {
            var url = vm.courier.id == null ? "sys/courier/save" : "sys/courier/update";
            if (this.validator()) {
                return;
            }
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.courier),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },

        del: function (cell) {

            console.log(cell);
            debugger;
            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/courier/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getInfo: function (id) {
            $.get(baseURL + "sys/courier/info/" + id, function (r) {
                vm.courier = r.courier;
            });
        },

        /**********************************************************************
         * 导出配送员信息
         * @author Wang Chinda
         **********************************************************************/
        exportCourier: function () {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }
            window.open("/admin/sys/courier/exportCourier?ids=" + ids);
        },

        /**********************************************************************
         * 获取合同信息
         * @author Wang Chinda
         **********************************************************************/
        getPact: function () {
            $.ajax({
                type: "GET",
                url: baseURL + "sys/pactinfo/all",
                contentType: "application/json",
                success: function (r) {
                    if (r.code == 0) {
                        vm.pactList = r.pactList;
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },

        editBatch: function (batchId) {
            var data = {};
            data["batchId"] = batchId;
            data["pactId"] = vm.pactId;
            $.ajax({
                type: "POST",
                url: baseURL + "sys/courier/editPact",
                data: data,
                success: function (r) {
                    if (r.code == 0) {
                        alert('导入成功', function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },

        /**********************************************************************
         * 下载配送员信息导入模板
         * @author Wang Chinda
         **********************************************************************/
        download: function () {
            location.href = encodeURI("/admin/statics/录入快递员模板.xlsx");
        },

        /**********************************************************************
         * 初始化查询条件
         * @author Wang Chinda
         **********************************************************************/
        initSearch: function () {
            this.q.name = null;
            this.q.erpNumber = null;
            this.q.cardId = null;
            this.q.companyId = '';
            this.q.status = '';
            this.q.pactId = '';
            this.q.cityId = '';
            this.q.areaId = '';
            this.q.siteId = '';
        },

        /**********************************************************************
         * 初始化查询条件下拉列表信息
         * @author Wang Chinda
         **********************************************************************/
        initCondition: function () {
            // 查询公司信息
            this.searchCompany();
            // 查询合同信息
            this.searchPact();
            // 查询城市信息
            this.searchCity();
            // 查询区域信息
            this.searchArea();
            // 查询站点信息
            this.searchSite();
        },

        /**********************************************************************
         * 查询公司信息
         * @author Wang Chinda
         **********************************************************************/
        searchCompany: function () {
            $.get(baseURL + "sys/company/getAllCompanyList", function (r) {
                vm.companyList = r.list;
            });
        },

        /**********************************************************************
         * 查询合同信息
         * @author Wang Chinda
         **********************************************************************/
        searchPact: function () {
            $.get(baseURL + "sys/pact/listAll", function (r) {
                vm.pactList = r.list;
            });
        },

        /**********************************************************************
         * 查询城市信息
         * @author Wang Chinda
         **********************************************************************/
        searchCity: function () {
            $.get(baseURL + "sys/city/listAll", function (r) {
                vm.cityList = r.list;
            });
        },

        /**********************************************************************
         * 查询区域信息
         * @author Wang Chinda
         **********************************************************************/
        searchArea: function () {
            $.get(baseURL + "sys/area/listAll", function (r) {
                vm.areaList = r.list;
            });
        },

        /**********************************************************************
         * 查询站点信息
         * @author Wang Chinda
         **********************************************************************/
        searchSite: function () {
            $.get(baseURL + "sys/site/listAll", function (r) {
                vm.siteList = r.list;
            });
        },

        /**********************************************************************
         * 查询Erp账户
         * @author Wang Chinda
         **********************************************************************/
        searchErpList: function () {
            $.get(baseURL + "sys/erp/listByCourier", function (r) {
                vm.erpList = r.list;
            });
        },

        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {
                    'name': vm.q.name,
                    'erpNumber': vm.q.erpNumber,
                    'cardId': vm.q.cardId,
                    'companyId': vm.q.companyId,
                    'status': vm.q.status,
                    'pactId': vm.q.pactId,
                    'cityId': vm.q.cityId,
                    'areaId': vm.q.areaId,
                    'siteId': vm.q.siteId
                },
                page: page
            }).trigger("reloadGrid");
        },

        /**********************************************************************
         * 表单校验
         * @author Wang Chinda
         **********************************************************************/
        validator: function () {
            if (isBlank(vm.courier.name)) {
                alert("配送员姓名不能为空");
                return true;
            }
            if (isBlank(vm.courier.cardId)) {
                alert("身份证号不能为空");
                return true;
            }
            if (isBlank(vm.courier.phone)) {
                alert("手机号不能为空");
                return true;
            }
            if (isBlank(vm.courier.bankCardId)) {
                alert("银行卡号不能为空");
                return true;
            }
            if (isBlank(vm.courier.entryDate)) {
                alert("入职时间不能为空");
                return true;
            }
            if (isBlank(vm.courier.entryDate)) {
                alert("入职时间不能为空");
                return true;
            }
        }
    },

    created: function () {
        this.initSearch();
        this.initCondition();
    }
});