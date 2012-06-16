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
		
		<link rel="stylesheet" type="text/css" href="js/paging/css/style.css"/>
		<script type="text/javascript" src="js/paging/jquery.paginate.js" ></script> 
		
		<script type="text/javascript">
			function rollover_in() {
				$(this).attr('style', 'cursor:pointer;color:pink');
			}

			function rollover_out() {
				$(this).removeAttr('style', 'cursor:pointer;color:pink');
			}

			function subject_row() {
				var subject_index = $('.subject').index(this);
				$('.no')
					.each(function(i){
						if(i == subject_index) {
							var no = $(this).val();
							location.href = "<%=basePath%>content/"+no;
						}
					});
			}

			function getlistJson(page) {
				$.get("listJson/"+page, function(data){
					$('#listTable div#row').remove();
					$.each(data, function(k,v){
						$('#listTable')
							.append(getListHtml(v.rownum, v.no, v.name, v.subject, v.content, v.regdate));
						
						$('.subject')
							.hover(rollover_in, rollover_out)
							.click(subject_row);
					});
				}, "json");  
			}
			
			function getListHtml(rownum, no, name, subject, content, regdate) {
				var _html = '';
				
				_html += '<div id="row">';
				_html += 	'<div id="no">';
				_html += 		'<span>'+rownum+'</span>';
				_html += 		'<input class="no" type="hidden" value="'+no+'">';
				_html += 	'</div>';				
				_html += 	'<div id="subject">';
				_html += 		'<span class="subject">'+subject+'</span>';
				_html += 	'</div>';
				_html += 	'<div id="name">';
				_html += 		'<span>'+name+'</span>';
				_html += 	'</div>';				
				_html += 	'<div id="regdate">';
				_html += 		'<span>'+regdate+'</span>';
				_html += 	'</div>';
				_html += '</div>';

				return _html;
			}
			
			
			$(function(){
				$('#btn_write')
					.click(function() {
						location.href = "<%=basePath%>write";
					});
				
				var listCnt = ${listCnt};
				listCnt = Math.ceil(listCnt/10);
				
				getlistJson(1);
				
				if(listCnt == 0) {
					$("#paging").remove();
				} else {
					$("#paging").paginate({
						count 		: listCnt,
						start 		: 1,
						display     : 10,
						border					: false,
						text_color  			: '#79B5E3',
						background_color    	: 'none',	
						text_hover_color  		: '#2573AF',
						background_hover_color	: 'none', 
						images					: false,
						mouse					: 'press',
						onChange     			: function(page){getlistJson(page);}
					});
				} 
				
				
			});	
		</script>
	</head>
	
	<body>
		<div id="wrapper">
			<div>
				<span><img src="img/board_memubar.gif" /></span>
			</div>

			<div id="listTable"></div>

			<div>
				<span><img src="img/board_line.gif" /></span>
			</div> 
			
			<div id="paging"></div>
			
			<div id="buttons">
				<span id="btn_write"><img src="img/button_write.gif" /></span>
			</div>
		</div>
	</body>
</html>
