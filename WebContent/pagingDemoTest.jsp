<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/board.css" />
<link rel="stylesheet" type="text/css" href="js/paging/css/style.css" />
<script type="text/JavaScript" src="js/jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/paging/jquery.paginate.js"></script>

<script type="text/javascript">
	$(function(){
			
		$("#demo").paginate({
				count 		: 10,
				start 		: 1,
				display     : 5,
				border					: false,
				text_color  			: '#79B5E3',
				background_color    	: 'none',	
				text_hover_color  		: '#2573AF',
				background_hover_color	: 'none', 
				images		: false,
				mouse		: 'press',
				onChange     			: function(page){
					alert(page);	
				}
			});



	});
  </script>

</head>
<body>

	<div class="demo">
		<h1>Demo</h1>
		<div id="demo"></div>
	</div>

</body>
</html>