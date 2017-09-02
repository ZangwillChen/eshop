<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
              pageEncoding="UTF-8"%>
<% String context = request.getContextPath(); %>


<%@taglib uri="/struts-tags" prefix="s" %>
-->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdn.bootcss.com/Buttons/2.0.0/css/buttons.css">
    <title>我的购物车</title>
    <style type="text/css">

        div{
            /*border: 1px solid #ccc;*/
        }
        .container{
            /*border: 1px solid #ccc;*/
            width: 980px;
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
        .flex-box span{
            /*		border: 1px solid red;
            */
        }

        .image{
            display: inline-block;
            width: 40px;
            height: 30px;
        }
        .pages{
            text-align: right;
        }
        .btn{

        }
    </style>
</head>
<body>
<div class="container">
    本系统的所有商品列表如下：
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
							添加到购物车
						</span>
            </div>
            <!-- 					<%-- <c:forEach var="p" items="${requestScope.products}">
					<TR>
						<TD>
							${p.name}
						</TD>
						<TD>
							<A href="ListAction.do?method=addItem&productId=${p.id}">添加到购物车</A>
						</TD>
					</TR>
					</c:forEach> --%> -->

            <s:iterator value ="findlist" var="p">
                <div class="flex-box">
						<span>
						<img class="image" src="<%=context %>/UploadImages/${p.imageSrc }" />
						</span>

                    <span>
						<s:property value="#p.name"/> | p.name
						</span>

                    <span>
						<a href="<%=context %>/from/addaction!addItem?type=1&productId=<s:property value="#p.id"/>">添加到购物车</a>
						<%-- <a href="<%=context %>/admin/Category_updateinput?id=<s:property value="#c.id"/>">修改Category</a> --%>
						</span>
                </div>
            </s:iterator>
        </div>
    </div>

    <!-- 2014.8.29 分页功能 -->
    <BR>
    <div class="pages">
        <s:set name="page" value="#request['fpage']" />

        <s:set name="maxpage" value="#request['fmaxpage']" />

        <s:if test="#page==1">首页</s:if>

        <s:if test="#page>1 "><a  class="button button-rounded button-tiny" href="<%=context %>/from/find?page=1"> 首页</a></s:if>

        <s:if test="#page == 1 ">上一页</s:if>

        <s:if test="#page>1 "><a  class="button button-rounded button-tiny" href="<%=context %>/from/find?page=${page-1}"> 上一页</a></s:if>

        <s:if test="#page ==#maxpage">下一页</s:if>

        <s:if test="#page< #maxpage "><a  class="button button-rounded button-tiny" href="<%=context %>/from/find?page=${page + 1}"> 下一页</a></s:if>

        <s:if test="#page == #maxpage">末页</s:if>

        <s:if test="#page< #maxpage  "><a  class="button button-rounded button-tiny" href="<%=context %>/from/find?page=${maxpage}">末页</a></s:if>

    </div>




    <BR>
    <div class="pages">
        <a class="button button-primary button-rounded button-small" href="<%=context %>/from/cart_inedx!CartIndex">查看购物车</a>&nbsp;&nbsp;
        <a class="button button-primary button-rounded button-small" href="<%=context %>/from/order_index!index">结帐</a>&nbsp;&nbsp;
        <a class="button button-primary button-rounded button-small" href="<%=context %>/from/listaction!list?page=1"> 返回首页</a>&nbsp;&nbsp;
        <a class="button button-primary button-rounded button-small" href="<%=context %>/from/loginaction">登录</a>&nbsp;&nbsp;
        <a class="button button-primary button-rounded button-small" href="<%=context %>/userregister.jsp">注册</a>&nbsp;&nbsp;
        <!-- <A href="CartAction.do?method=index">查看购物车</A>&nbsp;&nbsp;
        <A href="OrderAction.do?method=index">结账</A>&nbsp;&nbsp;
        <A href="login.jsp">登录</A> -->
    </div>
</div>

</body>
</html>