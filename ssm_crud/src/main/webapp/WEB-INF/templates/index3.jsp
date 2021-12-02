<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/11/14
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<script type="text/javascript" src="${APP_PATH}/static/script/jquery.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<link href="${APP_PATH}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet"/>


<html>


<head>
    <title>Title</title>


</head>
<body>
<%--员工修改模态框--%>

<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >员工修改</h4>
            </div>
            <div class="modal-body">


                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="empName_update_static"></p>
                            <span  class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="text" name="email" class="form-control" id="email_update_input" placeholder="请输入你的email">
                            <span  class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_update_input" value="M" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_update_input" value="F"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <%--                            部门提交部门id即可--%>
                            <select class="form-control" name="dId" id="dept_add_select">

                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_update_btn">修改</button>
            </div>
        </div>
    </div>
</div>

<%--员工添加模态框--%>
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
            </div>
            <div class="modal-body">


                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <input type="text"  name="empName" class="form-control" id="empName_add_input" placeholder="empName">
                            <span id="helpBlock2" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="text" name="email" class="form-control" id="email_add_input" placeholder="请输入你的email">
                            <span id="helpBlock3" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_add_input" value="F"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
<%--                            部门提交部门id即可--%>
                            <select class="form-control" name="dId" id="dept_add_select">

                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-12">

            <h1>SSM-CRUD</h1>
        </div>

    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button type="button" class="btn btn-primary "  id="emp_add_model_btn">添加</button>
            <button type="button" class="btn btn-danger" id="emp_delete_all_btn">删除</button>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table"/>
                <thead>

                <tr>
                    <th>
                        <input type="checkbox" id="check_all">
                    </th>
                    <th>id</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>dId</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>


                </tbody>
            </table>
        </div>

    </div>
    <div class="row">
        <div class="col-md-6" id="page_info_area"/>

        </div>
        <div class="col-md-6"  id="page_nav_area">

        </div>
    </div>
</div>
<script type="text/javascript">
    var totalRecord,currentPage;
    $(function (){
       topage(1);
    });

    function topage(pn) {
        $.ajax({
                url:"${APP_PATH}/emps",
                data:"pn="+pn,
                type:"get",
                success:function (result) {
                    // console.log(result) ;
                    build_emps_table(result);

                    build_page_info(result);

                    build_page_nav(result);
                }
            }
        );
    }


    function build_emps_table(result){
        $("#emps_table tbody").empty();
        //取出list集合
        var emps = result.map.pageinfo.list;
        //遍历

        $.each(emps,function(index,item){
             // alert(item.empName);
            var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
            var empIdTd = $("<td></td>").append(item.empId);
            var empNameT = $("<td></td>").append(item.empName);
            var genderTd = $("<td></td>").append(item.gender=='M'?"男":"女");
            var emailTd = $("<td></td>").append(item.email);
            var dIdTd = $("<td></td>").append(item.dId);
            var deptNameTd = $("<td></td>").append(item.department.deptName);

            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn").append("<span></span>")
                .addClass("glyphicon glyphicon-pencil").append("编辑");
            //为编辑按钮添加一个自定义的属性，来表示当前员工id
            editBtn.attr("edit-id",item.empId);
            var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append("<span></span>")
                .addClass("glyphicon glyphicon-trash").append("删除");
            delBtn.attr("del-id",item.empId)
             $("<td></td>").append(editBtn).append("").append(delBtn);
             $("<tr></tr>")
                 .append(checkBoxTd).append(empIdTd).append(empNameT)
                .append(genderTd).append(emailTd)
                .append(dIdTd).append(deptNameTd)
                 .append(editBtn).append(delBtn)
                .appendTo("#emps_table tbody");
            //         <button type="button" class="btn btn-primary">添加</button>
            //          <button type="button" class="btn btn-danger">删除</button>

        })
    }
    function build_page_info(result){
        $("#page_info_area").empty();
$("#page_info_area").
append(" 当前第"+result.map.pageinfo.pageNum +"页,共"+result.map.pageinfo.pages +"页,一共有"+ result.map.pageinfo.total+"条记录");
totalRecord = result.map.pageinfo.total;
currentPage = result.map.pageinfo.pageNum;
    }
    function build_page_nav(result){
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");

        var fistpageli =  $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));

        var prepageli =  $("<li></li>").append($("<a></a>").append("&laquo;"));
       if(result.map.pageinfo.hasPreviousPage == false){
        fistpageli.addClass("disabled");
         prepageli.addClass("disabled");
        }else{
           fistpageli.click(function () {
               topage(1);
           })
           prepageli.click(function () {
               topage(result.map.pageinfo.pageNum-1);
           })
       }


        var nextpageli =  $("<li></li>").append($("<a></a>").append("&raquo;"));

        var lastpageli =  $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        if(result.map.pageinfo.hasNextPage == false){
            nextpageli.addClass("disabled");
            lastpageli.addClass("disabled");
        }else{
            nextpageli.click(function (){
                topage(result.map.pageinfo.pageNum+1);
            })
            lastpageli.click(function (){
                topage(result.map.pageinfo.pages);
            })
        }


        ul.append(fistpageli).append(prepageli);
        $.each(result.map.pageinfo.navigatepageNums,function (index,item) {

            var numli =  $("<li></li>").append($("<a></a>").append(item));
            if(result.map.pageinfo.pageNum == item){
                numli.addClass("Active");
            }
            numli.click(function () {
                topage(item)
            })
            ul.append(numli);
        });
        ul.append(nextpageli).append(lastpageli);
        //
        var navEle =$("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");

    }
    function reset_form(ele){
        $(ele).reset();
        $(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
    }
    //点击新增按钮弹出模态框
    $("#emp_add_model_btn").click(function (){
        $("#empAddModal form")[0].reset();
        // $("#empAddModal").modal({});
        //发送ajax请求获取部门名称,显示在下拉列表中
        // $("#empName_add_input").val().empty()
        // $("#email_add_input").val().empty()
        // $("#dept_add_select").empty()
        getDepts("#empAddModal select");
        $("#empAddModal").modal({
                backdrop:"static"
        }

        )

    })
    function getDepts(ele){
        //清空之前下拉列表的值
        $(ele).empty();
        $.ajax({
            url:"${APP_PATH}/depts",
            type: "GET",
            success:function (result){
                 console.log(result)
                //显示部门信息
                // $("#dept_add_select").append("")
                $.each(result.map.depts,function(){
                    var optionEle = $("<option></option>").append(this.deptName).attr("value",this.deptId);
                    optionEle.appendTo(ele);
                })
            }
        })
    }


    function show_validate_msg(ele,status,msg){
        $(ele).parent().removeClass("has-error has-success");
        $(ele).next("span").text("");
        if("success"==status){
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);
        }else if("error"==status){
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg);
        }


    }







    function validate_add_form(){
        //校验

        var empname = $("#empName_add_input").val();
        var reqname =  /(^[a-z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5}$)/;
        if(!reqname.test(empname)){
            // alert("用户名必须为2-5位中文或者6-16位英文和数字的组合");
            show_validate_msg("#empName_add_input","error","用户名必须为2-5位中文或者6-16位英文和数字的组合")
            return false;
        }else{
            show_validate_msg("#empName_add_input","success","")

        }


        var email = $("#email_add_input").val();
        var reqemail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;

        if(!reqemail.test(email)){
            show_validate_msg("#email_add_input","error","email不规范请重新输入")
            // alert("email不规范请重新输入")
            return false;
        }else{
            show_validate_msg("#email_add_input","success","")


        }
         return true;
    }
    $("#empAddModal").on("change","#empName_add_input",function () {
            // var value = this.value();
            var value1 = $("#empName_add_input").val();
            $.ajax({
                url:"${APP_PATH}/checkuser",
                data:"empName="+value1,
                type:"POST",
                success:function (result) {
                     // console.log(result)
                    if(result.num == 200){
                        show_validate_msg("#empName_add_input","success","用户名可用");
                        $("#emp_save_btn").attr("ajax-va","success");
                    }
                    else {
                        show_validate_msg("#empName_add_input", "error", "result.map.va_msg");
                        $("#emp_save_btn").attr("ajax-va","error");

                    }
                }
            })

    })
    <%--$("#empName_add_input").change(function () {--%>
    <%--    var value = this.value();--%>

    <%--    $.ajax({--%>
    <%--        url:"${APP_PATH}/checkuser",--%>
    <%--        data:"empName="+value,--%>
    <%--        type:"post",--%>
    <%--        success:function (result) {--%>
    <%--             // console.log(result)--%>
    <%--            if(result.num == 200){--%>
    <%--                show_validate_msg("#empName_add_input","success","用户名可用");--%>
    <%--                $("#emp_save_btn").attr("ajax-va","success");--%>
    <%--            }else {--%>
    <%--                show_validate_msg("#empName_add_input", "error", "用户名不可用");--%>
    <%--                $("#emp_save_btn").attr("ajax-va","error");--%>

    <%--            }--%>
    <%--        }--%>
    <%--    })--%>

    <%--})--%>


    $("#emp_save_btn").click(function(){
        //校验
        if(!validate_add_form()){
            return false;
        }

        if($(this).attr("ajax-va")=="error"){
            return false;
        }

        $.ajax({
            url:"${APP_PATH}/emp",
            type:"post",
            data:$("#empAddModal form").serialize(),
            success:function (result) {
                if(result.num == 200){
                    $("#empAddModal").modal('hide')
                    topage(totalRecord);
                }else{
                    // console.log(result);
                    //有那个字段就校验那个字段
                    if(undefined != result.map.errorFields.email ){
                        show_validate_msg("#email_add_input","error",result.map.errorFields.email);
                    }
                    if(undefined != result.map.errorFields.empName){
                        show_validate_msg("#empName_add_input","success",result.map.errorFields.empName);

                    }
                    // alert(result.map.errorFields.email);
                    // alert(result.map.errorFields.empName);
                }

                // alert("11")
                // console.log(result)
                // alert(result.str);
                //关闭模态框

                //来到最后一页，显示刚才保存的信息
                //发送ajax请求

            }
        })





    })
    $(document).on("click",".delete_btn",function () {
        var empName =  $(this).parent("tr").find("td:eq(2)").text();
        var empId = $(this).attr("del-id");

       if(confirm("确认删除【"+ empName+"】吗?")){
           //确认发送ajax
           $.ajax({
               url:"${APP_PATH}/emp/"+empId,
               type:"delete",
               success:function (result) {
                   topage(currentPage);
               }
           })
       }


    })



//按钮之前就绑定了CLICK,所以绑定不上
    $(document).on("click",".edit_btn",function () {
        // 查询员工信息,显示员工信息

    //    查出部门信息,并显示部门列表
        getDepts("#empUpdateModal select")
         getEmp($(this).attr("edit-id"));
        $("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"));
        $("#empUpdateModal").modal({
                backdrop:"static"
            })

    })
function getEmp(id){
        $.ajax({
            url:"${APP_PATH}/emp/"+id,
            type:"get",
            success:function (result) {
                 // console.log(result.map.emp)
                // var emps = result.map.emp;
                $("#empName_update_static").text(result.map.emp.empName);
                $("#email_update_input").val(result.map.emp.email);
                $("#empUpdateModal input[name=gender]").val([result.map.emp.gender]);
                $("#empUpdateModal select").val([result.map.emp.dId]);
            }
        })
}
$("#emp_update_btn").click(function () {
    var email = $("#email_update_input").val();
    var reqemail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;

    if(!reqemail.test(email)){
        show_validate_msg("#email_update_input","error","email不规范请重新输入")
        // alert("email不规范请重新输入")
        return false;
    }else{
        show_validate_msg("#email_update_input","success","")


    }
    //我们要能支持直接发送put之类的请求还要封装请求体中的值
    //1.配置上httpPutFormContentFilter
    //2.它的作用，将请求体中的数据包装成一个map

   $.ajax({
    url:"${APP_PATH}/emp/"+$(this).attr("edit-id"),
    type:"put",
    data:$("#empUpdateModal form").serialize(),
    success:function (result) {
        // alert("123")
//关闭模态框
        $("#empUpdateModal").modal("hide");

        topage(currentPage)

    }

})

})
    $("#check_all").click(function () {
        //attr获取
        // alert($(this).prop("ckecked"));
        $(".check_item").prop("checked",$(this).prop("checked"));
    });
      $(document).on("click",".check_item",function () {
          // alert($('.check_item:checked').length);
          // alert($(".check_item").length);
          // alert($(".check_item:checked").length==$(".check_item").length);
      var flag = $(".check_item:checked").length==$(".check_item").length;
       $("#check_all").prop("checked",flag);
});
    $("#emp_delete_all_btn").click(function () {
        var empName = "";
        var  del_idstr = "";
        $.each($(".check_item:checked"),function () {
           empName += $(this).parents("tr").find("td:eq(2)").text()+",";
            del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
        });
         empName = empName.substring(0,empName.length-1);

        del_idstr = del_idstr.substring(0,del_idstr.length-1);
        if(confirm("你确认删除【"+empName +"】吗")){
            $.ajax({
                url:"${APP_PATH}/emp/"+del_idstr,
                type:"DELETE",
                success:function (result) {
                    // alert(result.str);
                    topage(currentPage);

                }
            })
        }
    })
    <%--$("#emp_delete_all_btn").click(function(){--%>
    <%--    //--%>
    <%--    var empNames = "";--%>
    <%--    var del_idstr = "";--%>
    <%--    $.each($(".check_item:checked"),function(){--%>
    <%--        //this--%>
    <%--        empNames += $(this).parents("tr").find("td:eq(2)").text()+",";--%>
    <%--        //组装员工id字符串--%>
    <%--        del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";--%>
    <%--    });--%>
    <%--    //去除empNames多余的,--%>
    <%--    empNames = empNames.substring(0, empNames.length-1);--%>
    <%--    //去除删除的id多余的---%>
    <%--    del_idstr = del_idstr.substring(0, del_idstr.length-1);--%>
    <%--    if(confirm("确认删除【"+empNames+"】吗？")){--%>
    <%--        //发送ajax请求删除--%>
    <%--        $.ajax({--%>
    <%--            url:"${APP_PATH}/emp/"+del_idstr,--%>
    <%--            type:"DELETE",--%>
    <%--            success:function(result){--%>
    <%--                // alert(result.msg);--%>
    <%--                //回到当前页面--%>
    <%--                topage(currentPage);--%>
    <%--            }--%>
    <%--        });--%>
    <%--    }--%>
    <%--});--%>
</script>
</body>
</html>
