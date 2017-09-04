<%@ page language="java" contentType="text/html; charset=UTF-8"
              pageEncoding="UTF-8"%>
<% String context = request.getContextPath(); %>

<%@taglib uri="/struts-tags" prefix="s" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdn.bootcss.com/Buttons/2.0.0/css/buttons.css">

    <title>我的购物车</title>
    <style type="text/css">
        .container{
            width: 960px;
            /*	border: 1px solid #ccc;
            */	margin: auto;

        }
        .btn-container{
            width: 960px;
            justify-content: space-around;
            margin:auto;

        }
        .cart-box{
            margin-top: -1px;
            border: 1px solid #ccc;
            display: flex;
            flex-direction: row;
            flex-wrap: nowrap;
            justify-content: space-between;
        }
        .cart-box span{
            width: 20%;
            padding: 2px;
            /*border: 1px solid red;*/
            word-break: break-all;
            text-align: center;
        }

        .cart-title{
            margin-bottom: 20px;
        }
        .price{
            color: red;
            font-weight: bold;
        }
        .total{
            margin-top: 20PX;
            text-align: right;
            margin-right: 10PX;
        }
        .contact{
            margin-left: 20px;
        }

    </style>
</head>
<body>
<div class="container">
    <H2 align=center>
        你所购买的商品如下：
    </H2>
    <div >
        <div>
            <div class="cart-box">
					<span >
						商品名称
					</span>
                <span>
						单价
					</span>
                <span >
						数量
					</span>
                <span >
						合计
					</span>
            </div>
            <c:forEach var="item" items="${sessionScope.cart.items}">
                <div class="cart-box">
						<span >
                                ${item.value.goodID.goodName }
                        </span>
                    <span >
                            ${item.value.goodID.goodPrice }
                    </span>
                    <span >
                            ${item.value.itemAmount }
                    </span>
                    <span class="price">
                            ${item.value.cost }
                    </span>
                </div>
            </c:forEach>
            <div class="total">
					<span>
						您的购物车中所有商品总金额：<span class="price">${sessionScope.cart.price }</span>
					</span>
            </div>
        </div>
    </div>
    <P>
    <H3 align=left>
        您的联系方式：
    </H3>
    <P></P>
    <form action="<%=context %>/from/cart_post!postOrder" method="post">
        <!-- <html:hidden property="method" value="postOrder" /> -->
        <TABLE class="contact">
            <TBODY>
            <TR>
                <TD width=117 height=23>
                    姓名：
                </TD>
                <TD width=383>
                    <INPUT value="${sessionScope.user.userName }" name="name">
                </TD>
            </TR>
            <TR>
                <TD height=24>
                    地址：
                </TD>
                <TD>
                    <INPUT value="${sessionScope.user.userAddr }" name="address">
                </TD>
            </TR>

            <TR>
                <TD height=23>
                    E-mail：
                </TD>
                <TD>
                    <INPUT value="${sessionScope.user.userEmail }" name="email">
                </TD>
            </TR>
            <TR>
                <TD height=23>
                    联系电话：
                </TD>
                <TD>
                    <INPUT value="${sessionScope.user.userPhone }" name="phone">
                </TD>
            </TR>
            </TBODY>
        </TABLE>
        <BR>
        <div>
            <div>
                <div align="right">
						<span >
							<INPUT
                                    class="button button-primary button-rounded button-small" onclick="javascript:location.href='userlistaction?method=userlist'"
                                    type=button value="继续购物" name=Submit42>
						</span>
                    <span >
							<INPUT
                                    class="button button-primary button-rounded button-small" onclick="javascript:location.href='cart_index?method=CartIndex'"
                                    type=button value="回到购物车" name=Submit42>
						</span>
                    <span >
							<!-- <INPUT type=submit value=结帐 name=Submit> -->
							<input class="button button-caution button-rounded button-small" type="submit" value="结帐">
						</span>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>