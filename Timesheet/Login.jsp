<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="viewBean" scope="request" class="bean.LoginViewBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
<title>ログイン画面</title>
</head>
<body>

<jsp:include page="./jsp/header.jsp"></jsp:include>

<div class="contents text-center">

	<h3>ログイン画面</h3>
	
	<%if(viewBean.getErrList() != null){ %>
		<%for(int i=0; i<viewBean.getErrList().size(); i++){ %>
			<p class="Err_Massege"><%=viewBean.getErrList().get(i) %></p>
		<%} %>
	<%} %>
	
	<form action="./Login" method="post">
		<div class="login_area mb10">
			<table class="tbl-center">
				<tr><th class="right-text pd5">ID：</th><td class="pd5"><input type="text" name="ID" maxlength="10"></td></tr>
				<tr><th class="right-text pd5">PW：</th><td class="pd5"><input type="password" name="PW" maxlength="12"></td></tr>
			</table>
		</div><!-- login_area -->
		
		<div class="button">
			<input type="submit" class="btn btn-primary btn-sm" value="ログイン" name="LOGIN">
		</div>
	</form>
</div><!-- contents -->
</body>
</html>