<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/www/css/w3.css">
<script type="text/javascript" src="/www/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
</script>
<title>Insert title here</title>
</head>
<body>

<c:forEach var="data" items="${LIST}">
	<div class="w3-col">
		<c:forEach var ="col" items ="${data}">
			<span>${data.M_NO} | ${data.ID} | ${data.NAME} | ${data.SDATE} </span>
		</c:forEach>
	
	</div>
</c:forEach>

</body>
</html>