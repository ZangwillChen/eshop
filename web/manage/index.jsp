 <%@ page language="java" contentType="text/html; charset=UTF-8"
              pageEncoding="UTF-8"%>
<% String context = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/Buttons/2.0.0/css/buttons.css">
    <title>后台界面</title>
</head>
<style type="text/css">
    body{
        background-color: #eee;
    }
    .container{
        padding-top: 100px;
        width: 660px;
        margin: auto;
    }
    .container a{
        margin:10px;
    }
    .flex-box{
        display: flex;
        justify-content: space-around;

    }
</style>
<body>
<div class="container">
    <div class="flex-box">
        <a class="button button-primary button-rounded" href="<%=context %>/manage/addgood.jsp">添加商品</a>

        <a class="button button-primary button-rounded"  href="<%=context %>/manage/listgood!goodslist">商品列表</a>
    </div>

    <div class="flex-box">
        <a class="button button-primary button-rounded " href="<%=context %>/manage/manager">查看订单</a>
        <a class="button button-primary button-rounded"  href="<%=context %>/from/logoutaction!execute"> 返回前台</a>
    </div>
</div>


</body>
</html>