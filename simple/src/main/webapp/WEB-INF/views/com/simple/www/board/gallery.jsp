<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="/www/js/jquery-3.4.1.min.js" ></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#btn').click(function(){
		$(location).attr('href', '/www/board/gallery.van');
	});
	
	
});
</script>
<body>
<div class="w3-container w3-teal">
<h1>Summer Holiday</h1>
</div>

<div class="w3-row-padding w3-margin-top">

<div class="w3-third">
<div class="w3-card">
<img src="img_5terre.jpg" style="width:100%">
<div class="w3-container">
<h4>5 Terre</h4>
</div>
</div>
</div>

<div class="w3-third">
<div class="w3-card">
<img src="img_monterosso.jpg" style="width:100%">
<div class="w3-container">
<h4>Monterosso</h4>
</div>
</div>
</div>

<div class="w3-third">
<div class="w3-card">
<img src="img_vernazza.jpg" style="width:100%">
<div class="w3-container">
<h4>Vernazza</h4>
</div>
</div>
</div>

</div>
<div class="w3-row-padding w3-margin-top">

<div class="w3-third">
<div class="w3-card">
<img src="img_manarola.jpg" style="width:100%">
<div class="w3-container">
<h4>Manarola</h4>
</div>
</div>
</div>

<div class="w3-third">
<div class="w3-card">
<img src="img_corniglia.jpg" style="width:100%">
<div class="w3-container">
<h4>Corniglia</h4>
</div>
</div>
</div>

<div class="w3-third">
<div class="w3-card">
<img src="img_riomaggiore.jpg" style="width:100%">
<div class="w3-container">
<h4>Riomaggiore</h4>
</div>
</div>

</div>
<button class="btn" >글쓰기</button>

</div>
</body>
</html>