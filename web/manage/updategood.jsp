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
    <title>修改商品</title>
    <style type="text/css">
        body{
            background-color: #eee;
        }
        .container{
            padding-top: 30px;
            width: 960px;
            margin: auto;
            /*text-align: center;*/
            /*border: 1px solid #ccc;*/
        }
        .submit-container{
            text-align: right;
            /*padding-right: 100px;*/
        }
        .form-group div{
            margin-top: 10px;
        }
    </style>

</head>
<body>
<div class="container">
    <form action="<%=context %>/manage/save" method="post" enctype="multipart/form-data">
        　　
        <div class="form-group">

            <div><label>商品名称:</label><input type="text" class="form-control" name="name" value="${updateGood.goodName }"></div>
            <div><label>商品价格:</label><input type="text" class="form-control" name="price" value="${updateGood.goodPrice }"></div>
            <div>

                <label>商品描述:</label><!-- <input type="text" class="form-control" name="description" value="${updateGood.Description }"> -->
                <textarea type="text" class="form-control" name="description" rows="3" ${updateGood.Description}>${updateGood.Description}</textarea>
            </div>
            <div><label>商品图片:</label><input type="file"  name="file"></div>
            <div><label>库存:</label><input type="text"  class="form-control" name="inventory"></div>

        </div>

        <div class="submit-container"><input type="submit" class="button button-caution button-rounded" value="提交"></div>

        <!-- <input type="reset" value="重置"> -->

    </form>
</div>
</body>
</html>