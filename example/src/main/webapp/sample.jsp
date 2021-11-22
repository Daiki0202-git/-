<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.Date,java.text.SimpleDateFormat" %>

<%
//	ランダムで決定
	String[] luckArray = {"S","A","B","C"};
	int index = (int)(Math.random()*4);
	String luck = luckArray[index];
	
//	実行日を取得
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
	String today = sdf.format(date);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>占いsample</title>
</head>
<body>
<p><%= today %>の運勢は「<%= luck %>」です。</p>
</body>
</html>