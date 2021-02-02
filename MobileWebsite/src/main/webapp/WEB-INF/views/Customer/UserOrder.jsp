<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page import="com.app.pojos.*,java.util.*"%>
<!DOCTYPE html>
<html
	xmlns:th="http://www.thymeleaf.org >
<head>
<meta name=" viewport " content="width=device-width, initial-scale=1 ">
<title>Address</title>

<%@ include file="../Common/header.html"%>
<link rel="stylesheet " href="css/style_login.css ">
 <link rel="stylesheet " href="css/styleSideBar.css ">
 <link rel="stylesheet " href="css/rightSide.css ">
    <link rel="stylesheet" href="css/style_Navbar_Fotter.css">
    <link rel="stylesheet" href="css/styles_elements.css">
    <link rel="stylesheet" href="css/order.css">
</head>

<body>
<div>

     <jsp:include page="../Common/navbar.jsp" flush="true" />
                                 
     <div class="sidebar ">
	     <a href="<spring:url value='/userProfile' /> ">Profile</a>
	     <a href="<spring:url value='/userAddress' />">Address</a>
	    <!--  <a href="#about">Payment</a> -->
	     <a class="active" href=""<spring:url value='/orderDetails' />">Orders</a>
     </div>
     
     <div class="right_bar inside_div">
     
     
     
     	<h3>Order History</h3>
		<div class ="orderScroll" style="overflow-y: scroll;height:500px;">
	        <table class="table table-striped table-bordered">
	            <theader>
	                <tr>
	                <td style="width:10%"><Strong> Order ID</Strong> </td>
	                <td style="width:15%"><Strong>Order Date</Strong></td>
	                <td style="width:20%"><Strong>Product</Strong></td>
	                <td style="width:10%"><Strong>Quantity</Strong></td>
	                <td style="width:10%"><Strong>Payment</Strong></td>
	                <td style="width:10%"><Strong>Address Shipped</Strong></td>
	                <td style="width:10%"><Strong>Order Amount</Strong></td>
	                </tr>
	            </theader>
	            
	           <%List<Ordertable> order = (List<Ordertable>) session.getAttribute("order_details");
	           
				for (Ordertable o : order) {%>
	            <tr>
	                <td style="width:10%"><%=o.getOrderId()%></td>
	                <td style="width:10%"><%=o.getDate()%></td>
	                <td style="width:10%"><%=o.getProductId()%></td>
	                <td style="width:10%"><%=o.getQuantity()%></td>
	                <td style="width:30%"><%=o.getPayment()%></td>
	                <td style="width:20%"><%=o.getShipAddress() %></td>
	                <td style="width:10%"><%=o.getPrice()%></td>
	             </tr>
	          	 <%}%>
	        </table>
        </div>
    </div>
</div>
             
              <%@ include file="../Common/footer.html"%>
            <script>
                var modal = document.getElementById('id01');
					
                // When the user clicks anywhere outside of the modal, close it
                window.onclick = function(event) {
                    if (event.target == modal) {
                        modal.style.display = "none";
                    }
                }
            </script>
            </body>

            </html>