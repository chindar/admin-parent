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
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        erp: {}
    },
    methods: {
        query: function () {
            vm.reload();
        }
        ,
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.erp = {};
        }
        ,
        update: function (event) {
            var id =
                getSelectedRow();
            if (id == null
            ) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        }
        ,
        saveOrUpdate: function (event) {
            var url = vm
                .erp.id ==
            null ? "sys/erp/save" : "sys/erp/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.erp),
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
                    url: baseURL + "sys/erp/delete",
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
            $.get(baseURL + "sys/erp/info/" + id, function (r) {
                vm.erp = r.erp;
            });
        }
        ,
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                page: page
            }).trigger("reloadGrid");
        }
    }
});