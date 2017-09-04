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
    <title>后台管理</title>
    <style type="text/css">
        body{
            background-color: #eee;
        }

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
            /*border: 1px solid red;*/
            text-align: center;

        }
        .btn-container{
            margin-top: 15px;
            text-align: right;
        }
        .btn-container a{
            margin:6px;
        }
    </style>
</head>
<body>

<H1 align=center>
    订单列表
</H1>

<div class="container">
    <div>
        <div class="flex-box">
        <span>
            订单状态
        </span>
            <span>
            订单用户名
        </span>
            <span>
            订单号
        </span>
            <span>
            订单总价
        </span>
            <span>
            操作
        </span>
        </div>
        <!--     <%-- <c:forEach var="o" items="${requestScope.orders}">
        <TR>
            <TD>
                ${o.statusText}
            </TD>
            <TD>
                ${o.user.name}
            </TD>
            <TD>
                ${o.orderNum}
            </TD>
            <TD>
                ${o.cost}
            </TD>
            <TD>
                <c:if test="${o.status != 4}">
                    <A href="ManageAction.do?method=next&orderId=${o.id}">下一步</A>
                </c:if>
            </TD>
        </TR>
    </c:forEach> --%> -->
        <s:iterator value ="orders" var="o">
            <div class="flex-box">
            <span>

                <s:property value="#o.status"/>

            </span>

                <span>

                <s:property value="#o.user.userName"/>

            </span>
                <span>

                <s:property value="#o.orderName"/>

            </span>
                <span>

                <s:property value="#o.orderPrice"/>

            </span>
                <span>
                <c:if test="${o.status != 4}">

                    <a href="<%=context %>/manage/nextaction!next?orderID=<s:property value="#o.orderID"/>">下一步</a>

                </c:if>


                    <%-- <a href="<%=context %>/admin/Category_updateinput?id=<s:property value="#c.id"/>">修改Category</a> --%>
            </span>
            </div>
        </s:iterator>
    </div>

    <div class="btn-container">
        <a class="button button-primary button-rounded button-small" href="<%=context %>/from/logoutaction">退出<a>
            <a class="button button-primary button-rounded button-small" href="<%=context %>/manage/index.jsp">返回主页</a>
    </div>


</div>




</body>
</html>