<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
            <%@page import="com.app.pojos.*" %>
            <%@page	import="java.util.*"%>
            <%List<Cart> cart=(List<Cart>)session.getAttribute("Cart"); 
            List<CustomerAddress> address=(List<CustomerAddress>)session.getAttribute("Cus_Address");%>
            
            
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>



    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MobileSite</title>
    
    <%@ include file="../Common/header.html"%>
    
    <script src="js/home.js"></script>
<link rel="stylesheet " href="css/style_login.css ">
 <link rel="stylesheet " href="css/styleSideBar.css ">
 <link rel="stylesheet " href="css/rightSide.css ">
    <link rel="stylesheet" href="css/style_Navbar_Fotter.css">
    <link rel="stylesheet" href="css/styles_elements.css">
    <link rel="stylesheet" href="/css/checkout.css">
    <script src="js/checkout.js"></script>
</head>

<body>
                            <jsp:include page="../Common/navbar.jsp" flush="true" />

    <form role="form" id="payment-form" name="ProcessingCart" action='<spring:url value="/Payment" ></spring:url>'method="post">
        <div>
            <div class="row">
                <!-- Select address -->
                <div class="col-md-4" style="border: solid 1px;">
                    <label for="address">Choose an Address:</label>
                    <select id="cars" name="address">
                    <% int i=1;
                    for(CustomerAddress add:address){ 
                    String a1=add.getFullName()+", "+add.getMobile();
                    String a2=add.getPinCode() +", "+add.getFlat()+", "+add.getArea()+", " +add.getCity();
                                  
                    %>
                     <option title="<%=a1+", "+a2 %> " value="<%=add.getAddressId() %>" style="height:20px;">
                     <div>
                     <p><%=i %></p><br>
                     
                     </div>
                     </option>
                    <%
                    i++;} %>
                </select>

                </div>

                <!-- select payment -->
                <div class="col-md-4" style="border: solid 1px;">
                    <div class="container">
                        <div class="row">
                            <!-- You can make it whatever width you want. I'm making it full width
                    on <= small devices and 4/12 page width on >= medium devices -->
                            <div class="col">


                                <!-- CREDIT CARD FORM STARTS HERE -->
                                <div class="panel panel-default credit-card-box">
                                    <div class="panel-heading display-table">
                                        <div class="row display-tr">
                                            <h3 class="panel-title display-td">Payment Details</h3>
                                            <div class="display-td">
                                                <!-- <img class="img-responsive pull-right" src="http://i76.imgup.net/accepted_c22e0.png"> -->
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel-body">
                                        <!-- <form role="form" id="payment-form"> -->
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <div class="form-group">
                                                    <label for="cardNumber">CARD NUMBER</label>
                                                    <div class="input-group">
                                                        <input type="tel" class="form-control" name="cardNumber" placeholder="Valid Card Number" autocomplete="cc-number" required autofocus />
                                                        <span class="input-group-addon"><i class="fa fa-credit-card"></i></span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xs-7 col-md-7" style="padding-left: 0% ;">
                                                <div class="form-group">
                                                    <label for="cardExpiry"><span class="hidden-xs">EXPIRATION</span><span class="visible-xs-inline">EXP</span> DATE</label>
                                                    <input type="tel" class="form-control" name="cardExpiry" placeholder="MM / YY" autocomplete="cc-exp" required />
                                                </div>
                                            </div>
                                            <div class="col-xs-5 col-md-5 pull-right" style="padding-right: 0% ;">
                                                <div class="form-group">
                                                    <label for="cardCVC">CV CODE</label>
                                                    <input type="tel" class="form-control" name="cardCVC" placeholder="CVC" autocomplete="cc-csc" required />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <div class="form-group">
                                                    <label for="cardHolderName">Card Holder Name</label>
                                                    <input type="text" class="form-control" name="cardHolderName" />
                                                </div>
                                            </div>
                                        </div>
                                        <!-- <div class="row">
                                            <div class="col-xs-12">
                                                <button class="btn btn-success btn-lg btn-block" type="submit">Proceed</button>
                                            </div>
                                        </div> -->
                                        <div class="row" style="display:none;">
                                            <div class="col-xs-12">
                                                <p class="payment-errors"></p>
                                            </div>
                                        </div>
                                        <!-- </form> -->
                                    </div>
                                </div>
                                <!-- CREDIT CARD FORM ENDS HERE -->


                            </div>



                        </div>
                    </div>


                </div>

                <!-- select order -->
                <div class="col" style="border: solid 1px;">
                    <div class="col">

                        <!-- Card -->
                        <div class="card mb-4">
                            <div class="card-body">

                                <h5 class="mb-3">The total amount of</h5>

                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                                        Total amount
                                        <%double price=0.0;
                                for(Cart ca:cart){
                                price += ca.getPrice();	
                                }
                                    %>

                                            <span>Rs. <%=price %></span>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center px-0">
                                        Shipping
                                        <span>Free</span>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                                        <div>
                                            <strong>The total amount of</strong>
                                            <strong>
                  <p class="mb-0">(including TAX)</p>
                </strong>
                                        </div>
                                        <span><strong>Rs. <%=price %></strong></span>
                                    </li>
                                </ul>

                                <button type="submit" class="btn btn-primary btn-block waves-effect waves-light">Order</button>

                            </div>
                        </div>
                        <!-- Card -->

                    </div>
                    <!--Grid column-->

                </div>
            </div>
        </div>
        </div>
    </form>
    
    <%@ include file="../Common/footer.html"%>
</body>

</html>