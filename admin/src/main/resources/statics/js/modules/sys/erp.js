$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/erp/list',
        datatype: "json",
        colModel: [

            {
                label: 'ERP账号',
                name: 'erpNumber',
                index: 'erp_number',
                width: 80
            },
            {
                label: '公司',
                name: 'companyName',
                index: 'company_name',
                width: 80
            },
            {
                label: '创建时间',
                name: 'createTime',
                index: 'create_time',
                width: 80
            },
            {
                label: '状态',
                name: 'status',
                index: 'status',
                width: 80,
                formatter: function (value, options, row) {
                    return value === 0 ? '<span class="label label-success">启用</span>' :
                        '<span class="label label-danger">停用</span>'
                }
            },
            {
                label: '操作',
                name: 'id',
                index: 'id',
                width: 80,
                formatter: function (value, options, row) {
                    return "<a onclick=\"vm.edit(" + value + ")\">编辑</a>" +
                        "&nbsp;&nbsp;&nbsp;<a onclick=\"vm.del(" + value + ")\">删除</a>";
                }
            }
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
        }
    });

    new AjaxUpload('#upload', {
        action: baseURL + "sys/erp/upload",
        name: 'file',
        autoSubmit: true,
        responseType: "json",
        onSubmit: function (file, extension) {
            if (!(extension && /^(xls|xlsx)$/.test(extension.toLowerCase()))) {
                alert('只支持xls, xlsx格式的文件！');
                return false;
            }
        },
        onComplete: function (file, r) {
            if (r.code == 0) {
                vm.reload();
            } else {
                alert(r.msg);
            }
        },
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        showStatus: false,
        title: null,
        q: {
            erpNumber: '',
            status: '',
            companyId: ''
        },
        erp: {},
        companyList: []
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.showStatus = false;
            vm.title = "新增ERP账号";
            vm.erp = {
                erpNumber: '',
                status: '',
                companyId: ''
            };
        },
        edit: function (id) {
            vm.showList = false;
            vm.showStatus = true;
            vm.title = "修改ERP账号";

            vm.getInfo(id)
        },
        saveOrUpdate: function (event) {
            var url = vm.erp.id == null ? "sys/erp/save" : "sys/erp/update";
            if (this.validator()) {
                return;
            }
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.erp),
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
        },

        del: function (id) {
            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/erp/delete",
                    contentType: "application/json",
                    data: JSON.stringify(id),
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
            $.get(baseURL + "sys/erp/info/" + id, function (r) {
                vm.erp = r.erp;
            });
        },

        /**********************************************************************
         * 导出配送员信息
         * @author Wang Chinda
         **********************************************************************/
        leadOut: function () {
            window.open(baseURL + "sys/erp/leadOut");
        },

        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {
                    'erpNumber': vm.q.erpNumber,
                    'companyId': vm.q.companyId,
                    'status': vm.q.status
                },
                page: page
            }).trigger("reloadGrid");
        },

        /**********************************************************************
         * 下载配送员信息导入模板
         * @author Wang Chinda
         **********************************************************************/
        download: function () {
            location.href = encodeURI(baseURL + "statics/ERP账号模板.xlsx");
        },

        /**********************************************************************
         * 表单校验
         * @author Wang Chinda
         **********************************************************************/
        validator: function () {
            if (isBlank(vm.erp.erpNumber)) {
                alert("ERP账号不能为空");
                return true;
            }
            if (isBlank(vm.erp.companyId)) {
                alert("公司不允许不选择");
                return true;
            }
        },

        /**********************************************************************
         * 初始化查询条件
         * @author Wang Chinda
         **********************************************************************/
        initSearch: function () {
            this.q.erpNumber = '';
            this.q.status = '';
            this.q.companyId = '';
        },

        /**********************************************************************
         * 初始化查询条件下拉列表信息
         * @author Wang Chinda
         **********************************************************************/
        initCondition: function () {
            // 查询公司信息
            this.searchCompany();
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
    },

    created: function () {
        this.initSearch();
        this.initCondition();
    }
});