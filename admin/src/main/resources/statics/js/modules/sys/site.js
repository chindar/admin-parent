$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/site/list',
        datatype: "json",
        colModel: [
                   // {
                   //      label: 'id',
                   //      name: 'id',
                   //      index: 'id',
                   //      width: 50,
                   //      key: true
                   //  },
                    {
                        label: '站点',
                        name: 'name',
                        index: 'name',
                        width: 80
                    }, 
                    {
                        label: '公司',
                        name: 'companyName',
                        index: 'company_name',
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
                        label:'操作',
                        name:'id',
                        index:'id',
                        align:'center',
                        width:50,
                        // edittype:"button",
                        formatter:cmgStateFormat
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
    //格式化操作列
    function cmgStateFormat(cellValue) {
        return "<button class='btn btn-info	 ' onclick=\"editArea("+ cellValue + ")\">编辑</button>"+
            "&nbsp;&nbsp;&nbsp;<button class='btn btn-info	 ' onclick=\"deleteArea("+ cellValue + ")\">删除</button>";
    }
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
site: {
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
        vm.site = {};
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
    .site.id ==
        null ? "sys/site/save" : "sys/site/update";
        $.ajax({
            type: "POST",
            url: baseURL + url,
            contentType: "application/json",
            data: JSON.stringify(vm.site),
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
                url: baseURL + "sys/site/delete",
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
        $.get(baseURL + "sys/site/info/" +id, function (r) {
            vm.site = r.site;
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