<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1000/xhtml">
<head th:replace="Home/common :: common-header" />
<%@ include file="Common/header.html"%>

</head>
<body>
	<%@ include file="Common/navbar.jsp"%>

	<h2>
		<a href="/MobileWebsite/user">User </a>
	</h2>
	<h2>
		<a href="/MobileWebsite/seller"> Seller</a>
	</h2>

	<!-- footer -->

	<%@ include file="Common/footer.html"%>
</body>

</html>