<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
              pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String context = request.getContextPath(); %> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户注册</title>
    <style type="text/css">
        .form-bg{
            background: #00b4ef;
        }
        .form-horizontal{
            background: #fff;
            padding-bottom: 40px;
            border-radius: 15px;
            text-align: center;
        }
        .form-horizontal .heading{
            display: block;
            font-size: 35px;
            font-weight: 700;
            padding: 35px 0;
            border-bottom: 1px solid #f0f0f0;
            margin-bottom: 30px;
        }
        .form-horizontal .form-group{
            padding: 0 40px;
            margin: 0 0 25px 0;
            position: relative;
        }
        .form-horizontal .form-control{
            background: #f0f0f0;
            border: none;
            border-radius: 20px;
            box-shadow: none;
            padding: 0 20px 0 45px;
            height: 40px;
            transition: all 0.3s ease 0s;
        }
        .form-horizontal .form-control:focus{
            background: #e0e0e0;
            box-shadow: none;
            outline: 0 none;
        }
        .form-horizontal .form-group i{
            position: absolute;
            top: 12px;
            left: 60px;
            font-size: 17px;
            color: #c8c8c8;
            transition : all 0.5s ease 0s;
        }
        .form-horizontal .form-control:focus + i{
            color: #00b4ef;
        }
        .form-horizontal .fa-question-circle{
            display: inline-block;
            position: absolute;
            top: 12px;
            right: 60px;
            font-size: 20px;
            color: #808080;
            transition: all 0.5s ease 0s;
        }
        .form-horizontal .fa-question-circle:hover{
            color: #000;
        }
        .form-horizontal .main-checkbox{
            float: left;
            width: 20px;
            height: 20px;
            background: #11a3fc;
            border-radius: 50%;
            position: relative;
            margin: 5px 0 0 5px;
            border: 1px solid #11a3fc;
        }
        .form-horizontal .main-checkbox label{
            width: 20px;
            height: 20px;
            position: absolute;
            top: 0;
            left: 0;
            cursor: pointer;
        }
        .form-horizontal .main-checkbox label:after{
            content: "";
            width: 10px;
            height: 5px;
            position: absolute;
            top: 5px;
            left: 4px;
            border: 3px solid #fff;
            border-top: none;
            border-right: none;
            background: transparent;
            opacity: 0;
            -webkit-transform: rotate(-45deg);
            transform: rotate(-45deg);
        }
        .form-horizontal .main-checkbox input[type=checkbox]{
            visibility: hidden;
        }
        .form-horizontal .main-checkbox input[type=checkbox]:checked + label:after{
            opacity: 1;
        }
        .form-horizontal .text{
            float: left;
            margin-left: 7px;
            line-height: 20px;
            padding-top: 5px;
            text-transform: capitalize;
        }
        .form-horizontal .btn{
            float: right;
            font-size: 14px;
            color: #fff;
            background: #00b4ef;
            border-radius: 30px;
            padding: 10px 25px;
            border: none;
            text-transform: capitalize;
            transition: all 0.5s ease 0s;
        }
        @media only screen and (max-width: 479px){
            .form-horizontal .form-group{
                padding: 0 25px;
            }
            .form-horizontal .form-group i{
                left: 45px;
            }
            .form-horizontal .btn{
                padding: 10px 20px;
            }
        }

        .reg-btn{
            margin-left: 300px;
        }
    </style>
</head>
<body>

<!-- private Long id; //主键   主键和manager主键问题

	private String name; //用户名

	private  int password; //密码

	private String address; //地址

	private String postCode; //邮编

	private String email; //email地址

	private String homePhone;// 家庭电话号码

	private String cellPhone; //手机号码

	private String officePhone; //办公室电话号码 -->
<!--
	<h1>用户注册</h1>


	<form action="<%=context %>/from/user_register"  method="post">

	<table    border="1">

	<tr><td>用户名：<td> <input type="text" name="name"></td></tr>
	<tr><td>密码：<td> <input type="password" name="password1"></td></tr>
	<tr><td>确定密码：<td> <input type="password" name="password2"></td></tr>
	<tr><td>地址：<td> <input type="text" name="address"></td></tr>
	<tr><td>邮编：<td> <input type="text" name="postCode"></td></tr>
	<tr><td>E-Mail：<td> <input type="text" name="email"></td></tr>
	<tr><td>家庭电话号码：<td> <input type="text" name="homePhone"></td></tr>
	<tr><td>手机号码：<td> <input type="text" name="cellPhone"></td></tr>
	<tr><td>办公室号码：<td> <input type="text" name="officePhone"></td></tr>
	<tr>
	<td>验证码：<td> <input type="text" name="rand" size="4">

	&nbsp;

	<img  src="<c:url value="/from/user_code"/>"/>

	</td>

	</tr>
	<tr>

		<td colspan="2" align="center">

		<input type="submit" value="注册">

		<input type="reset" value="重置">

		</td>

	</table>




	</form> -->

<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" action="<%=context %>/from/user_register" method="post">
                <span class="heading">用户注册</span>
                <div class="form-group">
                    <input class="form-control"  type="text" name="name" placeholder="用户名">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" name="password1" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>

                <div class="form-group help">
                    <input type="password" class="form-control" name="password2" placeholder="确认密码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>

                <div class="form-group">
                    <input class="form-control"  type="text" name="address" placeholder="地址">
                    <i class="fa fa-user"></i>
                </div>

                <div class="form-group">
                    <input class="form-control"  type="text" name="email" placeholder="电子邮箱">
                    <i class="fa fa-user"></i>
                </div>
                <!-- 后面的不写拉，没必要写这么多 -->

                <div class="form-group">
                    <!--                     <div class="main-checkbox">
                                            <input type="checkbox" value="None" id="checkbox1" name="check"/>
                                            <label for="checkbox1"></label>
                                        </div>
                                        <span class="text">Remember me</span> -->
                    <button type="submit" class="btn btn-default reg-btn" >注册</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>