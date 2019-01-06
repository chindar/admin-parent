$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/dispatch/list',
        datatype: "json",
        colModel: [
            {
                label: '月份',
                name: 'month',
                index: 'month',
                width: 80
            },
            {
                label: '片区',
                name: 'areaName',
                index: 'area_name',
                width: 80
            },
            {
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
                label: 'ERP账号',
                name: 'erpId',
                index: 'erp_id',
                width: 80
            },
            {
                label: '姓名',
                name: 'courierName',
                index: 'courier_name',
                width: 80
            },
            {
                label: '身份证',
                name: 'cardId',
                index: 'card_id',
                width: 80
            },
            {
                label: '总单量',
                name: 'allOrderCount',
                index: 'all_order_count',
                width: 80
            },
            {
                label: '合计单量',
                name: 'totalOrderCount',
                index: 'total_order_count',
                width: 80
            },
            {
                label: '费用合计',
                name: 'totalMoney',
                index: 'total_money',
                width: 80
            },
            {
                label: '罚款合计',
                name: 'fineMoney',
                index: 'fine_money',
                width: 80
            },
            {
                label: '其他扣款',
                name: 'deductMoney',
                index: 'deduct_money',
                width: 80
            },
            {
                label: '工资',
                name: 'salary',
                index: 'salary',
                width: 80
            },
            {
                label: '备注',
                name: 'remark',
                index: 'remark',
                width: 80
            }
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
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
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        q: {},
        dispatch: {},
        companyList: [],
        areaList: [],
        cityList: [],
        siteList: []
    },
    methods: {
        query: function () {
            vm.reload();
        }
        ,
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.dispatch = {};
        }
        ,
        update: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        }
        ,
        saveOrUpdate: function (event) {
            var url = vm.dispatch.id == null ? "sys/dispatch/save" : "sys/dispatch/update";
            if (this.validator()) {
                return;
            }
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.dispatch),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            vm.initSearch();
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        }
        ,
        del: function (event) {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/dispatch/delete",
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
        }
        ,
        getInfo: function (id) {
            $.get(baseURL + "sys/dispatch/info/" + id, function (r) {
                vm.dispatch = r.dispatch;
            });
        }
        ,
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {
                    'courierName': vm.q.name,
                    'month': vm.q.month,
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
         * 初始化查询条件
         * @author Wang Chinda
         **********************************************************************/
        initSearch: function () {
            this.q.name = '';
            this.q.month = '';
            this.q.cardId = '';
            this.q.companyId = '';
            this.q.status = '';
            this.q.cityId = '';
            this.q.areaId = '';
            this.q.siteId = '';
        },

        /**********************************************************************
         * 初始化查询条件下拉列表
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
            if (isBlank(vm.courier.leaveDate)) {
                alert("离职时间不能为空");
                return true;
            }
        }
    },

    created: function () {
        this.initSearch();
        this.initCondition();
    }
});