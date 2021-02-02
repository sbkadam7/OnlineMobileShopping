<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@page
	import="com.app.pojos.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ include file="../Common/header.html"%>
    <title>Home</title>
    
    <link rel="stylesheet" href="css/style_login.css">
        <link rel="stylesheet" href="css/style_Navbar_Fotter.css">
    <link rel="stylesheet" href="css/styles_elements.css">
</head>
<body>

  <jsp:include page="../Common/navbar.jsp" flush="true" />
  
<%Seller s =(Seller)session.getAttribute("seller_dtls");
//System.out.println(s.toString());%>
<h2>Hi! <%=s.getFirstName() %></h2>
	<div>
	<a href="<spring:url value='/AddProduct'/>"><button type="button" class="btn btn-info">Add Product</button></a><br>
	
	
	
	<%List<Product> products=(List<Product>)session.getAttribute("Seller_Product"); %>

	<h2>Your added products</h2>
	<div class="touchup">
		<div class="container">
			<%Iterator<Product> it = products.iterator();
		while(it.hasNext()){ 
		int i=-1;%>
			<div class="row">
				<%while(++i!=3 && it.hasNext()){ 
					Product p=it.next();
						/* if(++i==3)
						{break;} */%>

				<div class="col-md-4 column-extra">
					<div class="card">
					<%String src="image/productimage/"+p.getProductId()+"/front.jpg"; %>
						<img class="card-img-top" src="<%=src %>" alt="Card image">
						<div class="card-body">
						<%String link="/productPage?id="+p.getProductId();%>
							<%-- <h4 class="card-title"><a href="<%=link %>"><%=p.getName() %></a></h4> --%>
							<h4 class="card-title"><a href="<spring:url value='<%=link %>' /> "><%=p.getName() %></a></h4>
							<p class="card-text"><%=p.getRam()+" RAM | "+p.getInternalStorage()+" Storage |" %></p>
							<p class="card-text"><%=p.getSellingPrice() %> <%=" | "+p.getActualMRP() %></p>
						</div>
					</div>
				</div>
				<%} %>
			</div>
			<%} %>
		</div>
	</div>
	

	
	</div>
	<%@ include file="../Common/footer.html"%>
</body>
</html>