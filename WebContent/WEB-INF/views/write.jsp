<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		
		<link rel="stylesheet" type="text/css" href="css/board.css" />
		<script type="text/JavaScript" src="js/jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/ckeditor/ckeditor.js"></script>
		<script type="text/javascript" src="js/ckeditor/adapters/jquery.js"></script>
		
		<script type="text/javascript">
			$(function() {
				$('.jquery_ckeditor').ckeditor();

				var isUpdate = false;
				("${update[0].no}" != "")?isUpdate = true:isUpdate = false;
				
				$('#btn_list_wr')
					.click(function() {
						location.href = "<%=basePath%>list/1";
					});
				
				if(isUpdate) {
					$('#f').attr('action', 'update');

					$('#h').bind('value', function(e, val) {
						var v = $('<input />').attr({'type':'hidden', 'name':'no', 'value':val});
						$(this).append(v);
					});
					$('#h').trigger('value', '${update[0].no}');

					$(':input[name="subject"]').val('${update[0].subject}');
					
					$(':input[name="name"]')
						.val('${update[0].name}')
						.attr("disabled","disabled");
					
					$('.jquery_ckeditor').text('${update[0].content}');
				} 

				$('#btn_cancel_wr')
					.click(function() {
						$('#f')[0].reset();
						$('.jquery_ckeditor').val('');

						//$('#f')
						//	.each(function() {
						//		this.reset();
						//	});
					});
			});
		</script>
	</head>
	
	<body>
		<form action="write" method="post" id="f">
			<div id="wrapper">
				<div id="h"></div>
				<div>
					<span><img src="img/board_line_gray_1.gif" /><br></span>
				</div>
				<div>
					<span id="subject_wr">subject</span>
					<span id="text_wr"><input type="text" size="60" name="subject"></span>
				</div>
				<div>
					<span><img src="img/board_line_gray_2.gif" /><br></span>
				</div>
				<div>
					<span id="name_wr">name</span>
					<span id="text_wr"><input type="text" size="30" name="name"></span>
				</div>
				<div>
					<span><br><img src="img/board_line_gray_1.gif" /><br><br></span>
				</div>
				<div>
					<textarea class="jquery_ckeditor" cols="80" name="content" rows="10"></textarea>
				</div>
				<div>
					<span><br><img src="img/board_line_gray_1.gif" /><br></span>
				</div>
				<div id="buttons_wr">
					<span id="btn_reg_wr"><input type="image" src="img/button_reg.gif"></span>
					<span id="btn_cancel_wr"><img src="img/button_cancel.gif" /></span>
					<span id="btn_list_wr"><img src="img/button_list.gif" /></span>
				</div>
			</div>
		</form>	
	</body>
</html>