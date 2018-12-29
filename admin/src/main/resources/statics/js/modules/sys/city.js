$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/city/list',
        datatype: "json",
        colModel: [
                    // {
                    //     label: 'id',
                    //     name: 'id',
                    //     index: 'id',
                    //     width: 50,
                    //     key: true
                    // },
                    {
                        label: '城市',
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
    $.ajax({
        type: "POST",
        url: baseURL + "sys/company/getAllCompanyList",
        contentType: "application/json",
        success: function (r) {
            if (r.code == 0) {
                vm.companylist = r.list
            } else {
                alert(r.msg);
            }
        }
    });
    //格式化操作列
    function cmgStateFormat(cellValue) {
        return "<button class='btn btn-info	 ' onclick=\"editArea("+ cellValue + ")\">编辑</button>"+
            "&nbsp;&nbsp;&nbsp;<button class='btn btn-info	 ' onclick=\"deleteArea("+ cellValue + ")\">删除</button>";
    }
});

//编辑
function editArea(id) {
    vm.title = "修改";
    vm.showList = false;
    vm.getInfo(id);
}
//删除
function deleteArea(id) {
    confirm('确定要删除选中的记录？', function () {
        var data = {id: id}
        $.ajax({
            type: "POST",
            url: baseURL + "sys/city/delete",
            dataType: "json",
            data:{id: id},
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
var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        city: {
        },
        q:{
            name:null,
            companyId:"",
            areaId:""
        },
        companylist:[],
        arealist:[]
    },
methods: {
    query: function () {
        vm.reload();
    }
,
    add: function () {
        vm.showList = false;
        vm.title = "新增";
        vm.city = {companyId:"",areaId:""};
        vm.arealist = [];
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
    .city.id ==
        null ? "sys/city/save" : "sys/city/update";
        $.ajax({
            type: "POST",
            url: baseURL + url,
            contentType: "application/json",
            data: JSON.stringify(vm.city),
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
                url: baseURL + "sys/city/delete",
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
        $.get(baseURL + "sys/city/info/" +id, function (s) {
            $.ajax({
                type: "POST",
                url: baseURL + "sys/area/getAllAreaList",
                dataType: "json",
                data:{companyId: s.city.companyId},
                success: function (r) {
                    if (r.code == 0) {
                        vm.arealist = r.list
                        vm.city = s.city;
                    } else {
                        alert(r.msg);
                    }
                }
            });
        });
    }
,
    reload: function (event) {
        vm.showList = true;
        var page = $("#jqGrid").jqGrid('getGridParam', 'page');
        $("#jqGrid").jqGrid('setGridParam', {
            postData:{'name': vm.q.name,'companyId':vm.q.companyId,'areaId':vm.q.areaId},
            page: page
        }).trigger("reloadGrid");
    },
    //改变城市
    changeCompany: function (event) {
        //搜索条件
        if (event == 1) {
            if (vm.q.companyId) {
                vm.getAllAreaList(vm.q.companyId)
            } else {
                vm.q.areaId = ""
                vm.arealist = []
            }
        }
        //编辑
        if (event == 2) {
            if (vm.city.companyId) {
                vm.getAllAreaList(vm.city.companyId)
                vm.city.areaId = ""
            } else {
                vm.arealist = []
            }
        }
    },
    getAllAreaList: function (event) {
        $.ajax({
            type: "POST",
            url: baseURL + "sys/area/getAllAreaList",
            dataType: "json",
            data:{companyId: event},
            success: function (r) {
                if (r.code == 0) {
                    vm.arealist = r.list
                } else {
                    alert(r.msg);
                }
            }
        });
    }
}
});