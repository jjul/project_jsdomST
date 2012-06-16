<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		
		<link rel="stylesheet" type="text/css" href="css/board.css" />
		<script type="text/JavaScript" src="js/jquery/jquery-1.7.2.min.js"></script>
		
		<script type="text/javascript">
			$(function() {
				$('#btn_list_ct')
					.click(function() {
						location.href = "<%=basePath%>list/1";
					});
				
				$('#btn_update_ct')
					.click(function() {
						var no = $('#no').val();
						location.href = "<%=basePath%>update/"+no;
					});
				
				$('#btn_del_ct')
					.click(function() {
						var flag = confirm("정말 삭제하시겠습니까?");
						if(flag) {
							var no = $('#no').val();
							location.href = "<%=basePath%>delete/"+no;
						}
					});
			});
		</script>
	</head>
	
	<body>
		<div id="wrapper">
			<c:forEach var="row" items="${content}">
			<input type="hidden" id="no" value="${row.no}" />
			<div>
				<span><img src="img/board_line_gray_1.gif" /></span>
			</div>
			<div>
				<span id="subject_ct">${row.subject}</span>
			</div>
			<div>
				<span><img src="img/board_line_gray_1.gif" /></span>
			</div>
			<div>
				<span id="name_ct_1">name</span><span id="name_ct_2">${row.name}</span>
				<span id="regdate_ct_1">date</span><span id="regdate_ct_2">${row.regdate}</span>
			</div>
			<div>
				<span><img src="img/board_line_gray_2.gif" /></span>
			</div>
			<div>
				<span id="space_ct_1"></span>
				<span id="space_ct_2"></span>
				<span id="content_ct">
					<br>${row.content}<br><br>
				</span>
			</div>
			<div>
				<span><img src="img/board_line_gray_1.gif" /></span>
			</div>
			</c:forEach>
			<div id="buttons_ct">
				<span id="btn_update_ct"><img src="img/button_update.gif"></span>
				<span id="btn_del_ct"><img src="img/button_del.gif" /></span>
				<span id="btn_list_ct"><img src="img/button_list.gif" /></span>
			</div>
		</div>			
	</body>
</html>

