<%@page import="java.io.BufferedReader" %>
<%@page import="java.io.FileReader" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="entranceViewBean" scope="session" class="bean.EntranceViewBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8>
	<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
	<link rel="stylesheet" href="./css/common.css">
	<link rel="stylesheet" href="./bootstrap/css/bootstrap.css">
	<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
	<title>出退勤入力画面</title>
	<script type="text/javascript">
		<!--
		history.forward();
		//-->
	</script>
</head>
<body>
<%
int today = entranceViewBean.getToday();
String NAME = (String)session.getAttribute("name");
%>

<jsp:include page="./jsp/header.jsp"></jsp:include>

<div class="contents text-center pd5">
	<h3 style="margin-top: 0px;">出退勤入力</h3>
	
	<div class="MEMNAME">
		<p><%=NAME %></p>
	</div>
	
	<form action="./input" method="post">
		<div class="time_type">
			<select name="time">
				<option value="10">10分単位</option>
				<option value="15">15分単位</option>
				<option value="30">30分単位</option>
			</select>
		</div>
		
		<ul>
			<li><input type="submit" class="btn btn-primary btn-lg" name="START" value="出勤" <%=entranceViewBean.getSTART()[today-1]==null ? "" : "disabled" %>></li>
			<li><input type="submit" class="btn btn-primary btn-lg ml20 mr20" name="END" value="退勤" <%=entranceViewBean.getEND()[today-1]==null || "".equals(entranceViewBean.getEND()[today-1]) ? "" : "disabled" %>></li>
			<li><input type="submit" class="btn btn-primary btn-lg" name="MODIFY" value="修正"></li>
		</ul>
	</form>
	
	<div class="ErrArea">
		<%if(entranceViewBean.getErrList() != null){ %>
			<%for(int i=0; i<entranceViewBean.getErrList().size(); i++){ %>
				<p class="Err_Massege"><%=entranceViewBean.getErrList().get(i) %></p>
			<%} %>
		<%} %>
	</div>
	
	<ul class="nav nav-tabs">
		<li class="active"><a href="#home" data-toggle="tab">1～15日</a></li>
		<li><a href="#profile" data-toggle="tab">16～月末</a></li>
	</ul>
	
	<div class="tab-content">
		<div class="tab-pane active" id="home">
			<div class="time_sheet">
				<table class="default_tbl table-striped tbl-center table">
					<tr class="info"><th></th><th>出勤</th><th>退勤</th><th>備考</th></tr>
					<%for(int i = 0; i<15;i++){ %>
						<%if(i == 0){ %>
							<tr><th>1日</th><td><%=entranceViewBean.getSTART()[i] == null ? "" : entranceViewBean.getSTART()[i] %></td><td><%=entranceViewBean.getEND()[i] == null ? "" : entranceViewBean.getEND()[i] %></td><td><%=entranceViewBean.getCOMMENT()[i] == null ? "" : entranceViewBean.getCOMMENT()[i] %></td></tr>
						<%} else { %>
							<tr><th><%=i+1 %>日</th><td><%=entranceViewBean.getSTART()[i] == null ? "" : entranceViewBean.getSTART()[i] %></td><td><%=entranceViewBean.getEND()[i] == null ? "" : entranceViewBean.getEND()[i] %></td><td><%=entranceViewBean.getCOMMENT()[i] == null ? "" : entranceViewBean.getCOMMENT()[i] %></td></tr>
						<%} %>
					<%} %>
				</table>
			</div><!-- time_sheet -->
		</div><!-- tab-pane active -->
		
		<div class="tab-pane" id="profile">
			<div class="time_sheet">
				<table class="default_tbl table-striped tbl-center table">
					<tr class="info"><th></th><th>出勤</th><th>退勤</th><th>備考</th></tr>
					<%for(int i = 15; i<31;i++){ %>
							<tr><th><%=i+1 %>日</th><td><%=entranceViewBean.getSTART()[i] == null ? "" : entranceViewBean.getSTART()[i] %></td><td><%=entranceViewBean.getEND()[i] == null ? "" : entranceViewBean.getEND()[i] %></td><td><%=entranceViewBean.getCOMMENT()[i] == null ? "" : entranceViewBean.getCOMMENT()[i] %></td></tr>
					<%} %>
				</table>
			</div><!-- time_sheet -->
		</div><!-- tab-pane -->
	</div><!-- tab-content -->
	
	<script src="//code.jquery.com/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	
</div><!-- contents -->
</body>
</html>