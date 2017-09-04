 <%@ page language="java" contentType="text/html; charset=UTF-8"
			  pageEncoding="UTF-8"%>
<% String context = request.getContextPath(); %>

<%@taglib uri="/struts-tags" prefix="s" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://cdn.bootcss.com/Buttons/2.0.0/css/buttons.css">

	<title>商品</title>
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
		.flex-box span{
			width: 16%;
			display: block;
			text-align: center;
			padding: 2px;
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
			text-align: right;
		}
	</style>
</head>
<body>
<div class="container">
	<!-- <a href="<%=context %>/find.jsp">搜索商品</a>&nbsp;&nbsp; -->
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
				<!-- 				<span>
                                            添加到购物车
                                        </span> -->
			</div>
			<!-- 					<%-- <c:forEach var="p" items="${requestScope.products}">
					<div>
						<TD>
							${p.name}
						</TD>
						<TD>
							<A href="ListAction.do?method=addItem&productId=${p.id}">添加到购物车</A>
						</TD>
					</TR>
					</c:forEach> --%> -->

			<s:iterator value ="goodsList" var="p">
				<div class="flex-box">
						<span>



						<img class="image" src="<%=context %>from/showaction?imageUrl=${p.imgSrc}" />


						</span>

					<span>

						<s:property value="#p.goodName"/>
						</span>

					<span class="price">

						<s:property value="#p.goodPrice"/>
						</span>

					<span>

						<s:property value="#p.Description"/>
						</span>

				</div>
			</s:iterator>
		</div>
	</div>

	<!-- 2014.8.29 分页功能 -->
	<BR>
	<div class="pages">
		<s:set name="page" value="#request['page']" />

		<s:set name="maxpage" value="#request['maxpage']" />

		<s:if test="#page==1">首页</s:if>

		<s:if test="#page>1 "><a class="button button-rounded button-tiny" href="<%=context %>/from/listaction!list?page=1"> 首页</a></s:if>

		<s:if test="#page == 1 ">上一页</s:if>

		<s:if test="#page>1 "><a class="button button-rounded button-tiny" href="<%=context %>/from/listaction!list?page=${page-1}"> 上一页</a></s:if>

		<s:if test="#page ==#maxpage">下一页</s:if>

		<s:if test="#page< #maxpage "><a class="button button-rounded button-tiny" href="<%=context %>/from/listaction!list?page=${page + 1}"> 下一页</a></s:if>

		<s:if test="#page == #maxpage">末页</s:if>

		<s:if test="#page< #maxpage  "><a class="button button-rounded button-tiny" href="<%=context %>/from/listaction!list?page=${maxpage}">末页</a></s:if>
	</div>





	<BR>
	<div class="pages">
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