<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/11/13
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<link href="${APP_PATH}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.7.2.min.js"></script>

<html>

<head>
    <title>Title</title>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">

            <h1>SSM-CRUD</h1>
        </div>

    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button type="button" class="btn btn-primary">添加</button>
            <button type="button" class="btn btn-danger">删除</button>
        </div>
    </div>

   <div class="row">
       <div class="col-md-12">
           <table class="table table-hover">
               <tr>
                   <th>id</th>
                   <th>empName</th>
                   <th>gender</th>
                   <th>email</th>

                   <th>deptName</th>
                   <th>操作</th>
               </tr>
               <tr>
                   <c:forEach items="${pageInfo.list}" var="emp">
               <tr>
               <th>${emp.empId}</th>
               <th>${emp.empName}</th>
               <th>${emp.gender=="M"?"男":"女"}</th>
               <th>${emp.email}</th>

               <th>${emp.department.deptName}</th>
               <th>
                   <div class="btn btn-primary btn-sm">
                       <span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span>编辑</div>
                   <div class="btn btn-danger btn-sm"  >
                       <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>  删除</div>
               </th>
           </tr>

                   </c:forEach>
               </tr>
           </table>
       </div>

   </div>
    <div class="row">
        <div class="col-md-6">
      当前第${pageInfo.pageNum}页,   共${pageInfo.pages}页,    一共有${pageInfo.total}条记录
        </div>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${APP_PATH}/emps?pn=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="${APP_PATH}/emps?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo</span>
                            </a>
                        </li>
                    </c:if>



                    <c:forEach items="${pageInfo.navigatepageNums}" var="pagenum">
                      <c:if test="${pagenum == pageInfo.pageNum}">
                          <li class="active" ><a href="#">${pagenum}</a></li>
                      </c:if>
                       <c:if test="${pagenum != pageInfo.pageNum}">
                           <li ><a href="${APP_PATH}/emps?pn=${pageInfo.pageNum+1}">${pagenum}</a></li>

                       </c:if>


                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>


                    <li><a href="${APP_PATH}/emps?pn=${pageInfo.pages}">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>

</body>
</html>
