$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/pact/list',
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
                        label: '合同名称',
                        name: 'name',
                        index: 'name',
                        width: 80
                    }, 
                                                                {
                        label: '业务名称',
                        name: 'businessName',
                        index: 'business_name',
                        width: 80
                    }, 
                                                                {
                        label: '',
                        name: 'cityId',
                        index: 'city_id',
                        width: 80
                    }, 
                                                                {
                        label: '开始时间',
                        name: 'startDate',
                        index: 'start_date',
                        width: 80
                    }, 
                                                                {
                        label: '结束时间',
                        name: 'endDate',
                        index: 'end_date',
                        width: 80
                    }, 
                                                                {
                        label: '',
                        name: 'createTime',
                        index: 'create_time',
                        width: 80
                    }, 
                                                                {
                        label: '合同文件id',
                        name: 'fileId',
                        index: 'file_id',
                        width: 80
                    }, 
                                                                {
                        label: '',
                        name: 'fileName',
                        index: 'file_name',
                        width: 80
                    }, 
                                                                {
                        label: '公司id',
                        name: 'companyId',
                        index: 'company_id',
                        width: 80
                    }, 
                                                                {
                        label: '省份',
                        name: 'provinceName',
                        index: 'province_name',
                        width: 80
                    }, 
                                                                {
                        label: '城市',
                        name: 'cityName',
                        index: 'city_name',
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
pact: {
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
        vm.pact = {};
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
    .pact.id ==
        null ? "sys/pact/save" : "sys/pact/update";
        $.ajax({
            type: "POST",
            url: baseURL + url,
            contentType: "application/json",
            data: JSON.stringify(vm.pact),
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
                url: baseURL + "sys/pact/delete",
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
        $.get(baseURL + "sys/pact/info/" +id, function (r) {
            vm.pact = r.pact;
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