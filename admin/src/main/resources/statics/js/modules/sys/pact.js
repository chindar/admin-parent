var url= "/admin/statics/js/city.min.js"
var city_json;
$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/pact/list',
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
                        label: '合同名称',
                        name: 'name',
                        index: 'name',
                        align:'center',
                        width: 80
                    },
                    {
                        label: '公司',
                        name: 'companyName',
                        index: 'company_name',
                        align:'center',
                        width: 80
                    },
                    {
                        label: '业务名称',
                        name: 'businessName',
                        index: 'business_name',
                        align:'center',
                        width: 80
                    },
                    {
                        label: '省份',
                        name: 'provinceName',
                        index: 'province_name',
                        align:'center',
                        width: 80
                    },
                    {
                        label: '城市',
                        name: 'cityName',
                        index: 'city_name',
                        align:'center',
                        width: 80
                    },
                    {
                        label: '起始日期',
                        name: 'startDate',
                        index: 'start_date',
                        align:'center',
                        width: 80
                    }, 
                    {
                        label: '终止日期',
                        name: 'endDate',
                        index: 'end_date',
                        align:'center',
                        width: 80
                    }, 
                    {
                        label: '创建时间',
                        name: 'createTime',
                        index: 'create_time',
                        align:'center',
                        width: 80
                    },
                    {
                        label: '状态',
                        name: 'pactStatus',
                        index: 'pact_status',
                        align:'center',
                        width: 40,
                        formatter: function(value, options, row){
                            return value === 0 ?
                                '<span class="label label-warning">待生效</span>' :
                                   value === 1 ?
                                '<span class="label label-success">生效</span>':
                                '<span class="label label-danger">结束</span>';
                        }
                    },
                    {
                        label: '合同到期预警',
                        name: 'overDays',
                        index: 'over_days',
                        align:'center',
                        width: 50,
                        formatter: function(value, options, row){
                            return value <= 0 ?
                                '<span style="color: tomato;">结束</span>':
                                value <= 30?
                                '<span style="color: red;">'+value+'天</span>':
                                '<span>'+value+'天</span>';
                        }
                    },
                    {
                        label:'操作',
                        name:'id',
                        index:'id',
                        align:'center',
                        width:120,
                        // edittype:"button",
                        formatter: function(value, options, row){
                            return "<a  onclick=\"editPact("+ value + ")\">编辑</a>"+
                                '&nbsp;&nbsp;&nbsp;<a class="caozuo" href="'+row.fileUrl+'">合同</a>'+
                                "&nbsp;&nbsp;&nbsp;<a onclick=\"deletePact("+ value + ")\">删除</a>";
                        }
                    }
                    // {
                    //     label: '1:删除0:正常',
                    //     name: 'isDelete',
                    //     index: 'is_delete',
                    //     width: 80
                    // }
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
    new AjaxUpload('#upload', {
        action: baseURL + "sys/pactinfo/upload",
        name: 'file',
        autoSubmit:true,
        responseType:"json",
        onSubmit:function(file, extension){
            // if(vm.config.type == null){
            //     alert("云存储配置未配置");
            //     return false;
            // }
            if (!(extension && /^(pdf|jpg|png)$/.test(extension.toLowerCase()))){
                alert('只支持pdf、jpg、png格式的合同文件！');
                return false;
            }
        },
        onComplete : function(file, r){
            if(r.code == 0){
                // alert(r.url);
                vm.pact.fileId = r.data.fileId
                vm.pact.fileName = r.data.fileName
                $(".filename_class").text(r.data.fileName)
                // vm.reload();
            }else{
                alert(r.msg);
            }
        }
    });
});
//编辑
function editPact(id) {
    vm.showList = false;
    vm.title = "修改";
    vm.getInfo(id);
}
//删除
function deletePact(id) {
    confirm('确定要删除选中的记录？', function () {
        $.ajax({
            type: "POST",
            url: baseURL + "sys/pact/delete",
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
        pact: {
        },
        companylist:[],
        q:{
            name:null,
            businessName:null,
            pactStatus:"",
            companyId:"",
            timeType:1,
            startDate:null,
            endDate:null
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
        vm.pact = {
            companyId: '',
            provinceName: '',
            cityName: ''
        };
        $(".filename_class").text("");
        $.getJSON(url,function(json){
            city_json=json;
            vm.init();
        });
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
            // vm.pact = r.pact;
            $.getJSON(url,function(json){
                city_json=json;
                vm.init(r.pact);
            });
        });
    }
,
    reload: function (event) {
        vm.showList = true;
        var page = $("#jqGrid").jqGrid('getGridParam', 'page');
        $("#jqGrid").jqGrid('setGridParam', {
            postData:{'businessName': vm.q.businessName,'timeType':vm.q.timeType,'pactStatus':vm.q.pactStatus,'name':vm.q.name,'companyId':vm.q.companyId,'startDate':vm.q.startDate,'endDate':vm.q.endDate},
            page: page
        }).trigger("reloadGrid");
    },
    init:function(data){
        // 遍历赋值省份下拉列表
        temp_html="<option value=''>请选择省份</option>"
        $.each(city_json.citylist,function(i,prov){
            temp_html+="<option value='"+prov.p+"'>"+prov.p+"</option>";
        });
        //省份
        $(".prov").html(temp_html);
        //城市
        temp_html2="<option value=''>请选择城市</option>"
        $(".city").html(temp_html2);
        // 选择省份时发生事件
        $(".prov").bind("change",function(){
            vm.changePri();
        });
        if (typeof(data) != "undefined"){
            setTimeout(function(){
                vm.changePri($(".prov").get(0).selectedIndex,data)
            },1);
        }
    },
    changePri:function (id,data) {
        var prov_id=$(".prov").get(0).selectedIndex;
        if (typeof(id) != "undefined"){
            prov_id = id
        }
        temp_html="<option value=''>请选择城市</option>"
        if(prov_id==0||typeof(city_json.citylist[prov_id].c)=="undefined"){
            let optionflag = city_json.citylist.find((e, i) => {
                return e.p === data.provinceName
            })
            $.each(optionflag.c,function(i,city){
                if (i==0){
                    temp_html += "<option value='" + city.n + "' selected>" + city.n + "</option>";
                }else {
                    temp_html += "<option value='" + city.n + "'>" + city.n + "</option>";
                }
            });
        }else{
            prov_id--;
            // 遍历赋值市级下拉列表
            $.each(city_json.citylist[prov_id].c,function(i,city){
                if (i==0){
                    temp_html += "<option value='" + city.n + "' selected>" + city.n + "</option>";
                }else {
                    temp_html += "<option value='" + city.n + "'>" + city.n + "</option>";
                }
            });
        }
        $(".city").html(temp_html).css({"display":"","visibility":""});
        console.info(data)
        if (typeof(data) != "undefined"){
            setTimeout(function(){
                vm.pact = data
                $(".filename_class").text(data.fileName)
            },1);
        }else {
            vm.pact.cityName = ""
        }
    },
}
});