<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
<%@page import="javax.persistence.*,com.app.dao.ProductDao,com.app.pojos.Product,java.util.*"%>
    <table width="500" border="1"><tr><th>Sr. No</th><th>First Name</th><th>Last Name</th><th>Age</th>
	<th>When Inserted</th></tr>
        <% 
    	//private EntityManager mgr;
       // String jpql="select u from Product u";
    	//System.out.println("in Product Detail -> product dao");
    	
    	
    	List<Product> p=(List<Product>)session.getAttribute("Product_Details");
    	//System.out.println("in Product Detail -> product dao 2");

    	for(Product pa : p) {
    		%> <h5><%=pa.toString()%></h5><%}%>
            
        
       
    </table>

</body>
</html>