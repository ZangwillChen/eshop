 <%@ page language="java" contentType="text/html; charset=UTF-8"
              pageEncoding="UTF-8"%>

<% String context = request.getContextPath(); %>

<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/Buttons/2.0.0/css/buttons.css">
    <title>商品列表</title>
    <style type="text/css">
        .container{
            width: 960px;
            margin: auto;
            text-align: center;
        }
        .flex-box{
            border: 1px solid #ccc;
            margin-top: -1px;
            display: flex;
            flex-direction: row;
            flex-wrap: nowrap;
            justify-content: space-between;
        }
        .image{
            display: inline-block;
            width: 40px;
            height: 30px;
        }
        .price{
            color:red;
            font-weight: bold;
            font-size: 120%;
        }
        .pages{
            padding-top: 20px;
            text-align: right;
        }
        .flex-box span{
            width:16%;
            padding: 2px;
            display: center;
            /*border: 1px solid red;*/
            text-align: center;

        }
    </style>
</head>

<body>
<div class="container">
    <h3>商品列表</h3>

    <div>
        <div>
            <div class="flex-box">
            <span>
                产品图片
            </span>
                <span>
                产品名称
            </span>
                <span>
                产品价格
            </span>
                <span>
                产品描述
            </span>
                <span>
                修改商品
            </span>
                <span>
                删除商品
            </span>
            </div>

            <s:iterator value ="goodsList" var="p">
                <div class="flex-box">
                <span>



                    <!--  	<img  src="<c:url value='<%=context %>/from/showaction?imgUrl=${p.imgSrc }'/>"/> -->

                    <!--  <img src="${p.imgSrc }" style="height:50px; width:80px" /> -->



                    <img src="<%=context %>/UploadImages/${p.imgSrc }"/>

                </span>

                    <span>

                    <s:property value="#p.goodName"/> |
                </span>

                    <span>

                    <s:property value="#p.goodPrice"/> |
                </span>

                    <span>

                    <s:property value="#p.Description"/> |
                </span>


                    <span>


                    <a href="<%=context %>/manage/update?goodID=<s:property value='#p.goodID'/>">修改商品</a>
                        <%-- <a href="<%=context %>/admin/Category_updateinput?id=<s:property value="#c.id"/>">修改Category</a> --%>
                </span>

                    <span>


                    <a href="<%=context %>/manage/delete?goodID=<s:property value='#p.goodID'/>">删除商品</a>
                        <%-- <a href="<%=context %>/admin/Category_updateinput?id=<s:property value="#c.id"/>">修改Category</a> --%>
                </span>

                </div>
            </s:iterator>
        </div>
    </div>
    <div class="pages">
        <s:set name="page" value="#request['page']" />

        <s:set name="maxpage" value="#request['maxpage']" />

        <s:if test="#page==1">首页</s:if>

        <s:if test="#page>1 "><a class="button button-rounded button-tiny" href="<%=context %>/manage/listgood?page=1"> 首页</a></s:if>

        <s:if test="#page == 1 ">上一页</s:if>

        <s:if test="#page>1 "><a class="button button-rounded button-tiny" href="<%=context %>/manage/listgood?page=${page-1}"> 上一页</a></s:if>

        <s:if test="#page ==#maxpage">下一页</s:if>

        <s:if test="#page< #maxpage "><a class="button button-rounded button-tiny" href="<%=context %>/manage/listgood?page=${page + 1}"> 下一页</a></s:if>

        <s:if test="#page == #maxpage">末页</s:if>

        <s:if test="#page< #maxpage  "><a class="button button-rounded button-tiny" href="<%=context %>/manage/listgood?page=${maxpage}">末页</a></s:if>



        <a class="button button-rounded button-tiny" href="<%=context %>/manage/index.jsp">返回主页</a>
    </div>



</div>
</body>
</html>