<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<spring:url value='/AddFile'/>" method="post" enctype="multipart/form-data">
        <input type="file" name="front" id="">
                <input type="submit" value="submit">
        
    </form>
</body>
</html>