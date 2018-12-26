$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/dispatch/list',
        datatype: "json",
        colModel: [
                                                {
                        label: 'id',
                        name: 'id',
                        index: 'id',
                        width: 50,
                        key: true
                    },
                                                                {
                        label: '月份',
                        name: 'month',
                        index: 'month',
                        width: 80
                    }, 
                                                                {
                        label: '公司id',
                        name: 'companyId',
                        index: 'company_id',
                        width: 80
                    }, 
                                                                {
                        label: 'ERP账号id',
                        name: 'erpId',
                        index: 'erp_id',
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
                        label: '小件',
                        name: 'small',
                        index: 'small',
                        width: 80
                    }, 
                                                                {
                        label: '大件',
                        name: 'large',
                        index: 'large',
                        width: 80
                    }, 
                                                                {
                        label: '三同',
                        name: 'thrIdentical',
                        index: 'thr_identical',
                        width: 80
                    }, 
                                                                {
                        label: '售后取件',
                        name: 'afterSaleCount',
                        index: 'after_sale_count',
                        width: 80
                    }, 
                                                                {
                        label: '接货首单量',
                        name: 'firstCount',
                        index: 'first_count',
                        width: 80
                    }, 
                                                                {
                        label: '接货续单量',
                        name: 'againCount',
                        index: 'again_count',
                        width: 80
                    }, 
                                                                {
                        label: '其他单量',
                        name: 'otherCount',
                        index: 'other_count',
                        width: 80
                    }, 
                                                                {
                        label: '差评数',
                        name: 'badCount',
                        index: 'bad_count',
                        width: 80
                    }, 
                                                                {
                        label: '投诉数',
                        name: 'complaintCount',
                        index: 'complaint_count',
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
                    }, 
                                                                {
                        label: '',
                        name: 'createTime',
                        index: 'create_time',
                        width: 80
                    }, 
                                                                {
                        label: '1:删除0:正常',
                        name: 'isDelete',
                        index: 'is_delete',
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
dispatch: {
}
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
        var id =
        getSelectedRow();
        if (id== null
    )
        {
            return;
        }
        vm.showList = false;
        vm.title = "修改";

        vm.getInfo(id)
    }
,
    saveOrUpdate: function (event) {
        var url = vm
    .dispatch.id ==
        null ? "sys/dispatch/save" : "sys/dispatch/update";
        $.ajax({
            type: "POST",
            url: baseURL + url,
            contentType: "application/json",
            data: JSON.stringify(vm.dispatch),
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
        $.get(baseURL + "sys/dispatch/info/" +id, function (r) {
            vm.dispatch = r.dispatch;
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