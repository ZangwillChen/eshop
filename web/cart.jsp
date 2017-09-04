 <%@ page language="java" contentType="text/html; charset=UTF-8"
              pageEncoding="UTF-8"%>
<% String context = request.getContextPath(); %>

<%@taglib uri="/struts-tags" prefix="s" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>  
    <link rel="stylesheet" href="https://cdn.bootcss.com/Buttons/2.0.0/css/buttons.css">
    <link href="css/style.css" rel='stylesheet' type='text/css' />     
    <link rel="stylesheet" type="text/css" href="css/cart.css">
    <title>我的购物车</title>
    <SCRIPT language=javascript>
        function clearCart(){
            cartForm.action="cart_clear?method=clear";
            cartForm.submit();
        }
        function deleteCartItem(){
            cartForm.action="cart_delete?method=deleteItem";
            cartForm.submit();
        }

        function modifyNumber(){
            cartForm.action="cart_modify?method=modifyItemNumber";
            cartForm.submit();
        }
    </SCRIPT>
    <style type="text/css">
        *{
            margin: 0px;
            padding: 0px;
        }
        .container{
            width: 960px;
            border: 1px solid #ccc;
            margin: auto;

        }
        .btn-container{
            width: 960px;
            justify-content: space-around;
            margin:auto;

        }
        .cart-box{
            display: flex;
            /*flex-direction: row;*/
            flex-wrap: wrap;
            justify-content: space-between;
        }

        .cart-box span{

            width: 17%;
            padding: 2px;
            display: block;
            text-align: center;
            border: 1px solid red;
            word-break:break-all;
            /*word-warp:break-word;*/
        }

        .cart-title{
            margin-bottom: 20px;
        }
        .price{
            color: red;
            font-weight: bold;
            font-size: 120%;
        }

        .total{
            margin-top: 20PX;
            float: right;
            margin-right: 10PX;
        }


    </style>
</head>
<body>

<H2 align=center>
    购物车
</H2>

<FORM name=cartForm action="<%=context %>/from/userlistaction!userlist" method=post>
    <input type="hidden" name="method" value="index" />
    <div class="container">
        <div>
            <div class="cart-box cart-title">
                <span>选择</span> <span>	商品名称</span>    <span>单价</span> <span>数量</span> <span>合计</span>
            </div>
            <c:forEach var="item" items="${sessionScope.cart.items}">
                <div class="cart-box">
							<span >
								<INPUT type=checkbox value=${item.key } name=itemCheck>
							</span>
                    <span >
                            ${item.value.goodID.goodName}
                    </span>
                    <span>
                            ${item.value.goodID.goodPrice}
                    </span>
                    <span >
								<INPUT maxLength=10 size=10 value=${item.value.itemAmount
                                        } name="number${item.key}">
							</span>
                    <span class="price">
                            ${item.value.cost}
                    </span>
                </div>
            </c:forEach>



            <div >
						<span class="total">
							您的购物车中所有商品总金额：<span class="price">${sessionScope.cart.price }</span>
						</span>
            </div>
        </div>
    </div>
    <BR>
    <BR>
    <div class="btn-container">
        <div>
            <div class="cart-box">
                <div >
                    <INPUT class="button button-primary button-rounded button-small" onclick=modifyNumber() type=button value=修改所选项的数量
                           name=Button>

                </div>
                <div >
                    <INPUT class="button button-primary button-rounded button-small" onclick=deleteCartItem(); type=button value=删除所选项
                           name=Submit2>
                </div>
                <div >
                    <INPUT class="button button-primary button-rounded button-small" onclick="clearCart();" type=button value=清空购物车
                           name=Submit3>
                </div>
                <div >
                    <INPUT
                            class="button button-primary button-rounded button-small" onclick="javascript:location.href='userlistaction?method=userlist'"
                            type=button value=继续购物 name=Submit42>
                </div>
                <div >
                    <INPUT
                            class="button button-caution button-rounded button-small" onclick="javascript:location.href='order_index?method=index'"
                            type=button value=结账 name=Submit42>


                </div>
            </div>
        </div>
    </div>
    <P align=center>
        &nbsp;
    </P>
</FORM>


</body>
</html>