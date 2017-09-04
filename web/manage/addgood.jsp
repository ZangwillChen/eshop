 <%@ page language="java" contentType="text/html; charset=UTF-8"
              pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>

<%

    String context = request.getContextPath();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/Buttons/2.0.0/css/buttons.css">
    <title>商品编辑</title>
    <style type="text/css">
        body{
            background-color: #eee;
        }
        .container{
            padding-top: 30px;
            width: 960px;
            margin: auto;
            /*text-align: center;*/
        }
        .submit-container{
            text-align: right;
        }
        .form-group div{
            margin-top: 10px;
        }
    </style>

</head>
<body>
<div class="container">
    <form action="<%=context %>/manage/addgood" method="post" enctype="multipart/form-data">
        　　
        <!--     <table border="1">

                <tr><td>商品名称:<td><input type="text" name="name"></td></tr>

                <tr><td>商品价格:<td><input type="text" name="price"></td></tr>

                <tr><td>商品描述:<td><input type="text" name="description"></td></tr>

                <tr><td>库存:<td><input type="text" name="inventory"></td></tr>

                <tr><td>商品图片:<td><input type="file" name="file"></td></tr>

            </table>

            <input type="submit" value="提交">

            <input type="reset" value="重置">
         -->
        <div class="form-group">

            <div><label>商品名称:</label><input type="text"  class="form-control" name="name"></div>
            <div><label>商品价格:</label><input type="text"  class="form-control" name="price"></div>
            <!-- <div><label>商品描述:</label><input type="text"  class="form-control" name="description"></div> -->
            <div><label>商品描述:</label><textarea type="text" class="form-control" name="description" rows="3"></textarea></div>
            <div class="form-group"><label>商品图片:</label><input type="file" name="file"></div>
            <div><label>库存:</label><input type="text"  class="form-control" name="inventory"></div>

        </div>

        <div class="submit-container"><input type="submit" class="button button-caution button-rounded" value="提交"></div>

        <!-- <input type="reset" value="重置"> -->



    </form>
</div>
</body>
</html>