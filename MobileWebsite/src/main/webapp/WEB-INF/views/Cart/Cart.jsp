<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
            <%@page import="com.app.pojos.Cart" %>
            <%@page	import="java.util.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>

<%@ include file="../Common/header.html"%>
<link rel="stylesheet " href="css/style_login.css ">
 <link rel="stylesheet " href="css/styleSideBar.css ">
 <link rel="stylesheet " href="css/rightSide.css ">
    <link rel="stylesheet" href="css/style_Navbar_Fotter.css">
    <link rel="stylesheet" href="css/styles_elements.css">
    
     
     



<%List<Cart> cart=(List<Cart>)session.getAttribute("Cart"); %>
    <body class="skin-light" aria-busy="true">

        <!--Main Navigation-->
     <jsp:include page="../Common/navbar.jsp" flush="true" />


        <div class="jumbotron color-grey-light mt-70">
            <div class="d-flex align-items-center h-10"></div>
            <div class="container text-center py-5">
                <h3 class="mb-0">Shopping cart</h3>
            </div>
        </div>
        </div>


        <!--Main Navigation-->

        <!--Main layout-->
        <main>
            <div class="container">

                <!--Section: Block Content-->
                <section class="mt-5 mb-4">

                    <!--Grid row-->
                    <div class="row">

                        <!--Grid column-->
                        <div class="col-lg-8">

                            <!-- Card -->
                            <div class="card wish-list mb-4">
                                <div class="card-body">

                                    <h5 class="mb-4">Cart (<span><%=cart.size() %></span> items)</h5>

                                    <%for(Cart c:cart)
                                    {%>
                                    <div class="row mb-4">
                                        <div class="col-md-5 col-lg-3 col-xl-3">
                                            <div class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
												<%String src="image/productimage/"+c.getProduct_id()+"/front.jpg"; %>
                                                <img class="img-fluid w-100" src="<%=src %>" style="height:150px;width:140px;" alt="Sample">
                                            </div>
                                        </div>
                                        <div class="col-md-7 col-lg-9 col-xl-9">
                                            <div>
                                                <div class="d-flex justify-content-between">
                                                    <div>
                                                        <h5><%=c.getProductName() %></h5>
                                                        <p class="mb-3 text-muted text-uppercase small">RAM : <%=c.getRam() %>" | ROM : "<%=c.getRom() %></p>
                                                        <p class="mb-2 text-muted text-uppercase small">Color: <%=c.getColor() %></p>
                                                        <p class="mb-3 text-muted text-uppercase small"></p>
                                                    </div>
                                                    <div>
                                                        <!-- <div class="def-number-input number-input safari_only mb-0 w-100">
                                                            <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="minus"></button>
                                                            <input class="quantity" min="0" name="quantity" value="1" type="number">
                                                            <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="plus"></button>
                                                        </div> -->
                                                        <small id="passwordHelpBlock" class="form-text text-muted text-center">
                                  (Note, 1 piece)
                                </small>
                                                    </div>
                                                </div>
                                                <div class="d-flex justify-content-between align-items-center">
                                                    <div>
                                                    <%String srcc="/removefromcart?id="+c.getCartID(); %>
                                                        <a href="<spring:url value='<%=srcc %>' />" type="button" class="card-link-secondary small text-uppercase mr-3"><i class="fas fa-trash-alt mr-1"></i> Remove item </a>
<!--                                                         <a href="#!" type="button" class="card-link-secondary small text-uppercase"><i class="fas fa-heart mr-1"></i> Move to wish list </a>-->                                                    </div>
                                                    <p class="mb-0"><span><strong>Rs. <%=c.getPrice() %></strong></span></p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <%} %>


                                </div>
                            </div>
                            <!-- Card -->

                            <!-- Card -->
                            <div class="card mb-4">
                                <div class="card-body">

                                    <h5 class="mb-4">Expected shipping delivery</h5>

                                    <p class="mb-0"> Thu., 12.03. - Mon., 16.03.</p>
                                </div>
                            </div>
                            <!-- Card -->

                            <!-- Card -->
                            <div class="card mb-4">
                                <div class="card-body">

                                    <h5 class="mb-4">We accept</h5>

                                    <img class="mr-2" width="45px" src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/visa.svg" alt="Visa">
                                    <img class="mr-2" width="45px" src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/amex.svg" alt="American Express">
                                    <img class="mr-2" width="45px" src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/mastercard.svg" alt="Mastercard">
                                </div>
                            </div>
                            <!-- Card -->

                        </div>
                        <!--Grid column-->

                        <!--Grid column-->
                        <div class="col-lg-4">

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

                                    <a href="<spring:url value='/Payment' />"><button type="button" class="btn btn-primary btn-block waves-effect waves-light">go to
                        checkout</button></a>

                                </div>
                            </div>
                            <!-- Card -->

                        </div>
                        <!--Grid column-->

                    </div>
                    <!--Grid row-->

                </section>
                <!--Section: Block Content-->

            </div>
        </main>
        <!--Main layout-->

        <!-- Footer -->

        <!-- Footer -->

        <div class="hiddendiv common"></div>
        
        <div class="card mb-4">
                                <div class="card-body">
 <%@ include file="../Common/footer.html"%>
                                    </div>
                            </div>
    </body>

</html>
     
