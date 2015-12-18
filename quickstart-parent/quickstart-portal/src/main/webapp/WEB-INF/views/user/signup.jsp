<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/WEB-INF/views/fragments/commons.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="${ctx}/resources/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="${ctx}/resources/css/core.css" rel="stylesheet" media="screen" />
    <script type="text/javascript" src="${ctx}/resources/js/ref/jquery/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="${ctx}/resources/js/bootstrap.min.js" ></script>
</head>
<body>
	<form class="form-narrow form-horizontal" method="post" action="signup">
	    <!--/* Show general error message when form contains errors */-->
	    <fieldset>
	        <legend>新用户注册</legend>
	        <div class="form-group">
	            <label for="email" class="col-lg-2 control-label">邮箱</label>
	            <div class="col-lg-10">
	                <input type="text" class="form-control" id="email" placeholder="邮件地址" />
	            </div>
	        </div>
	        <div class="form-group" >
	            <label for="name" class="col-lg-2 control-label">昵称</label>
	            <div class="col-lg-10">
	                <input type="text" class="form-control" id="name" placeholder="昵称" />
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="password" class="col-lg-2 control-label">密码</label>
	            <div class="col-lg-10">
	                <input type="password" class="form-control" id="password" placeholder="密码"/>
	            </div>
	        </div>
	        <div class="form-group">
	            <div class="col-lg-offset-2 col-lg-10">
	                <button type="submit" class="btn btn-default">注册</button>
	            </div>
	        </div>
	        <div class="form-group">
	            <div class="col-lg-offset-2 col-lg-10">
	                <p>已经注册有账号？ <a href="signin" >登录</a></p>
	            </div>
	        </div>
	    </fieldset>
	</form>
</body>
</html>