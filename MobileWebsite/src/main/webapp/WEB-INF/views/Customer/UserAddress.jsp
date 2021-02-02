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
</head>

<body>
<div>

                            <jsp:include page="../Common/navbar.jsp" flush="true" />
                                 
                     <div class="sidebar ">
                            <a href="<spring:url value='/userProfile' /> ">Profile</a>
                            <a class="active" href="<spring:url value='/userAddress' />">Address</a>
        <!--     <a href="#about">Payment</a> -->
            <a href="<spring:url value='/orderDetails' />">Orders</a>

            </div>
            <!-- <button onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Edit</button> -->
            <div class="right_bar inside_div">
                <button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Add Address</button>
                <div id="id01" class="modall " style="display:none; position:relative; top:-100px;">

                    <form class="modal-content animate " action="<spring:url value='/userAddress' />" method="post">
                        <div class="container">
                            <label for="Name"><b>Full Name</b></label>
                            <input type="text" name="fullName" required>

                            <label for="Mobile"><b>Mobile</b></label>
                            <input type="text" name="mobile" required>

                            <label for="country"><b>Country</b></label>
                            <input type="text" name="country" required>

                            <label for="pinCode"><b>PIN Code</b></label>
                            <input type="text" name="pinCode" required>

                            <label for="flat"><b>Flat, House no., Building, Company, Apartment</b></label>
                            <input type="text" name="flat" required>

                            <label for="area"><b>Area, Colony, Street, Sector, Village</b></label>
                            <input type="text" name="area" required>

                            <label for="landmark"><b>Landmark</b></label>
                            <input type="text" name="landmark">

                            <label for="city"><b>Town/City</b></label>
                            <input type="text" name="city" required>

                            <label for="state"><b>State / Province / Region</b></label>
                            <input type="text" name="state" required>
                            <div>
                                <button type="submit">Add Address</button>
                                <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn" >Cancel</button>

                            </div>
                        </div>

                        <div class="container" style="background-color:#f1f1f1">
                            <!--  <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
          -->
                        </div>
                    </form>
                    
                    
                    
                </div>
                
                <div>
        <table class="table table-striped table-bordered">
            <th>
                <tr>
                <td><Strong> Name</Strong> </td>
                <td><Strong>Mobile</Strong></td>
                <td><Strong>pincode</Strong></td>
                <td><Strong>Country</Strong></td>
                <td><Strong>Flat, House no., Building, Company, Apartment</Strong></td>
                <td><Strong>Area, Colony, Street, Sector, Village</Strong></td>
                <td><Strong>landmark</Strong></td>
                <td><Strong>Town/City</Strong></td>
                <td><Strong>State / Province / Region</Strong></td></tr>
            </th>
           <%
           List<CustomerAddress> add=(List<CustomerAddress>)session.getAttribute("Customer_addr");
           for(CustomerAddress a:add){ %>
            <tr>
                <td><%=a.getFullName() %></td>
                <td><%=a.getMobile() %></td>
                <td><%=a.getPinCode() %></td>
                <td><%=a.getCountry() %></td>
                <td><%=a.getFlat() %></td>
                <td><%=a.getArea() %></td>
                <td><%=a.getLandmark()%></td>
                <td><%=a.getCity() %></td>
                <td><%=a.getState() %></td>
            </tr>
           <%} %>
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