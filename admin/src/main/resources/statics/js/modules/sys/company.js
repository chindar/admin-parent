
$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/company/list',
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
                label: '公司名称',
                name: 'name',
                index: 'name',
                width: 80
            },
            {
                label: '地址',
                name: 'address',
                index: 'address',
                width:120
            },
            {
                label: '所在省',
                name: 'provinceName',
                index: 'province_name',
                width: 80
            },
            {
                label: '所在城市',
                name: 'cityName',
                index: 'city_name',
                width: 80
            },
            {
                label: '法人',
                name: 'legalPersonName',
                index: 'legal_person_name',
                width: 80
            },

            {
                label: '邮箱',
                name: 'email',
                index: 'email',
                width: 80
            },
            {
                label: '邮编',
                name: 'zipCode',
                index: 'zip_code',
                width: 80
            },
            {
                label: '联系人姓名',
                name: 'contactName',
                index: 'contact_name',
                width: 80
            },
            {
                label: '联系人电话',
                name: 'phone',
                index: 'phone',
                width: 80
            },
            {
                label: '营业执照',
                name: 'businessFileid',
                index: 'business_fileid',
                width: 80,
                formatter: function (value, options, row) {
                    return '<img src="' + row.businessFileUrl + '">';
                }
            },
            {
                label: '法人身份证',
                name: 'cardFileid',
                index: 'card_fileid',
                width: 80,
                formatter: function(value, options, row){
                    return '<img src="'+row.cardFileUrl+'">';
                }
            },
            {
                label:'操作',
                name:'id',
                valign: 'middle',
                width:180,
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
            //$("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        },
        onCellSelect: function (rowid,iCol,cellcontent,e) {
            var strs= new Array(); //定义一数组
            strs=cellcontent.split("\"");
            // console.log(strs[1]);
            imgShow("#outerdiv", "#innerdiv", "#bigimg", strs[1].replace(/amp;/g,""));
        },

    });
    //格式化操作列
    function cmgStateFormat(cellValue) {
        return "<button class='btn btn-primary' onclick=\"editCompany("+ cellValue + ")\">编辑</button>"+
            "&nbsp;&nbsp;&nbsp;<button class='btn btn-primary' onclick=\"deleteCompany("+ cellValue + ")\">删除</button>";
    };

    $.ajax({
        type: "POST",
        url: baseURL + "sys/city/list",
        contentType: "application/json",
        // data: JSON.stringify(ids),
        success: function (r) {
            if (r.code == 0) {
                // alert('操作成功', function (index) {
                //     $("#jqGrid").trigger("reloadGrid");
                // });
                vm.citylist = r.page.list
            } else {
                alert(r.msg);
            }
        }
    });

    new AjaxUpload('#upload', {
        action: baseURL + "sys/company/upload",
        name: 'file',
        autoSubmit:true,
        responseType:"json",
        data:{dbname:"businessFile"},
        onSubmit:function(file, extension){
            if (!(extension && /^(jpg|png)$/.test(extension.toLowerCase()))){
                alert('只支持jpg、png格式的图片！');
                return false;
            }
        },
        onComplete : function(file, r){
            if(r.code == 0){
                vm.company.businessFileid = r.data.fileId
                $("#aaa").attr("src",r.data.fileUrl)
                // vm.company.businessFileUrl = r.data.fileUrl
            }else{
                alert(r.msg);
            }
            console.log(vm.company);
        }
    });
    new AjaxUpload('#upload2', {
        action: baseURL + "sys/company/upload",
        name: 'file',
        autoSubmit:true,
        responseType:"json",
        data:{dbname:"cardFile"},
        onSubmit:function(file, extension){
            if (!(extension && /^(jpg|png)$/.test(extension.toLowerCase()))){
                alert('只支持jpg、png格式的图片！');
                return false;
            }
        },
        onComplete : function(file, r){
            if(r.code == 0){
                vm.companyInfo.cardFileid = r.data.fileId
                $("#bbb").attr("src",r.data.fileUrl)
                // vm.company.cardFileUrl = r.data.fileUrl
            }else{
                alert(r.msg);
            }
        }
    });
    $(".pic_class").click(function(event){
        event.stopPropagation();
        var _this = $(this);//将当前的pimg元素作为_this传入函数
        imgShow("#outerdiv", "#innerdiv", "#bigimg", _this.attr("src"));
    });
    function imgShow(outerdiv, innerdiv, bigimg, src){
        // var src = _this.attr("src");//获取当前点击的pimg元素中的src属性
        $(bigimg).attr("src", src);//设置#bigimg元素的src属性

        /*获取当前点击图片的真实大小，并显示弹出层及大图*/
        $("<img/>").attr("src", src).load(function(){
            var windowW = $(window).width();//获取当前窗口宽度
            var windowH = $(window).height();//获取当前窗口高度
            var realWidth = this.width;//获取图片真实宽度
            var realHeight = this.height;//获取图片真实高度
            var imgWidth, imgHeight;
            var scale = 0.8;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放

            if(realHeight>windowH*scale) {//判断图片高度
                imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放
                imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度
                if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度
                    imgWidth = windowW*scale;//再对宽度进行缩放
                }
            } else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度
                imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放
                imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度
            } else {//如果图片真实高度和宽度都符合要求，高宽不变
                imgWidth = realWidth;
                imgHeight = realHeight;
            }
            $(bigimg).css("width",imgWidth);//以最终的宽度对图片缩放

            var w = (windowW-imgWidth)/2;//计算图片与窗口左边距
            var h = (windowH-imgHeight)/2;//计算图片与窗口上边距
            $(innerdiv).css({"top":h, "left":w});//设置#innerdiv的top和left属性
            $(outerdiv).fadeIn("fast");//淡入显示#outerdiv及.pimg
        });

        $(outerdiv).click(function(){//再次点击淡出消失弹出层
            $(this).fadeOut("fast");
        });
    };
    // $("#city").citySelect();
});
//编辑
function editCompany(id) {
    vm.showList = false;
    vm.title = "修改";
    vm.getInfo(id);
};
//删除
function deleteCompany(id) {
    confirm('确定要删除选中的记录？', function () {
        var data = {id: id};
        $.ajax({
            type: "POST",
            url: baseURL + "sys/company/delete",
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
};
var vm = new Vue({

    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        company: {

        },
        q:{
            name: null
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.company = {
                cityId: '',
                provinceName: '',
                cityName: ''
                // businessFileUrl : 'http://localhost:8080/renren-admin/sys/company/getFile?fileId=1545211156491&dbname=businessFile'
            };
            $("#aaa").attr("src", "/admin/statics/default.png")
            $("#bbb").attr("src", "/admin/statics/default.png")
            $("#city").citySelect({prov:"",city:""});
        }
        ,
        saveOrUpdate: function (event) {
            var url = vm
                .company.id ==
            null ? "sys/company/save" : "sys/company/update";
            console.log(vm.company)
            // $.ajax({
            //     type: "POST",
            //     url: baseURL + url,
            //     contentType: "application/json",
            //     data: JSON.stringify(vm.company),
            //     success: function (r) {
            //         if (r.code === 0) {
            //             alert('操作成功', function (index) {
            //                 vm.reload();
            //             });
            //         } else {
            //             alert(r.msg);
            //         }
            //     }
            // });
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
                    url: baseURL + "sys/company/delete",
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
            $.get(baseURL + "sys/company/info/" + id, function (r) {
                $("#city").citySelect({prov:r.company.provinceName,city:r.company.cityName,required:true});
                vm.company = r.company;
            });
        }
        ,
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData:{'name': vm.q.name},
                page: page
            }).trigger("reloadGrid");
        },
    }
});