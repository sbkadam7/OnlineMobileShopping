<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@page import="com.app.pojos.Customer" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Profile</title>
           <%@ include file="../Common/header.html"%>
                <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>

                <link rel="stylesheet" href="css/style_login.css">
                <link rel="stylesheet" href="css/styleSideBar.css">
                <link rel="stylesheet" href="css/rightSide.css">
                    <link rel="stylesheet" href="css/style_Navbar_Fotter.css">
    <link rel="stylesheet" href="css/styles_elements.css">
        </head>

        <body>

           <div>

  <jsp:include page="../Common/navbar.jsp" flush="true" />


                         

        <div>
            <div class="sidebar">
                <a class="active" href="#news">Profile</a>
                <a href="<spring:url value='/userAddress' />">Address</a>
                <!-- <a href="#about">Payment</a> -->
                <a href="<spring:url value='/orderDetails' />">Orders</a>

            </div>
            <!-- <button onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Edit</button> -->
            <div class="right_bar">
                <div id="id02" class="modall inside_div ">
                     <%@page import="com.app.pojos.Seller,java.util.*"%> 
                    <%
                Customer s = (Customer) session.getAttribute("user_dtls");
            %>
                    <h1>Profile Details</h1>
                    <div>

                        <button id="btn"> Edit</button>
                        <div class="pos">
                            <form class="modal-contentt animatee " action="<spring:url value='/userUpdate'/>" method="post">
                                <div class="container">
                                    <table>
                                        <tr>
                                            <td>
                                                <label for="Firstname"><b>FirstName</b></label><br>
                                                <input type="text" name="FirstName" value="<%=s.getFirstName() %>" required disabled><br>
                                            </td>

                                            <td>
                                                <label for="Firstname"><b>LastName</b></label><br>
                                                <input type="text" value="<%=s.getLastName() %>" name="LastName" required disabled><br>

                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label for="psw"><b>Password</b></label><br>
                                                <input type="password" value="<%=s.getPassword() %>" name="Password" readonly disabled><br>

                                            </td>

                                            <td>
                                                <label for="email"><b>Email</b></label><br>
                                                <input type="email" value="<%=s.getEmail() %>" name="email" disabled><br>

                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label for="phone"><b>Mobile</b></label><br>
                                                <input type="number" value="<%=s.getMobile() %>" name="mobileNo" readonly disabled><br>

                                            </td>
                                        </tr>
                                    </table>

                                </div>
                                <button class="pos_btn" type="submit" id="updatebtn" style="display: none;">Update Profile</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
                            <!-- footer -->

                            <%@ include file="../Common/footer.html"%>
                                <script>
                                    $(document).ready(function() {


                                        $('#btn').click(function() {
                                            var b = document.getElementById("btn").innerText;

                                            if (b === 'Edit') {
                                                $('#btn').html('Cancel')
                                                $('input').attr('disabled', false);
                                                $('#updatebtn').css('display', 'block');
                                            }
                                            if (b === 'Cancel') {
                                                $('#btn').html('Edit')
                                                $('input').attr('disabled', true);
                                                $('#updatebtn').css('display', 'none');
                                            }
                                        })
                                    });
                                </script>

            </body>
            < </html>