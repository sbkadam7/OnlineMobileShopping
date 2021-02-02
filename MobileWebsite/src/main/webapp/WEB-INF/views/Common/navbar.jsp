<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page import="com.app.pojos.*" %>
    <section class="coloured-section title-section" id="title" th:fragment="navbar">

        <!-- Nav Bar -->

        <div class="container-fluid">
            <nav class="navbar navbar-expand-md navbar-dark">
                <% if ((Customer)session.getAttribute("user_dtls")!=null){%>
                <a class="navbar-brand" href="<spring:url value='/'/>"> MobileSite</a>
                <%}else{ %>
                <a class="navbar-brand" href="<spring:url value='/sellerHome'/>"> MobileSite</a>
                <%}%>
                <%  if((Customer)session.getAttribute("user_dtls")!=null){%>
                <form action="<spring:url value='/search'/>"method="get">

                    <input type="text" name="search" placeholder="Search.. and Press Enter" class="seac">

                </form>
                <% }%>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto">
                        <li class=" nav-item">
                            <a class="nav-link" href="#footer"> Contact </a>

                        </li>
                        <% if ((Customer)session.getAttribute("user_dtls")==null && (Seller)session.getAttribute("seller_dtls")==null) { %>
                        <li class="nav-item">
                            <a class="nav-link dropbtn" onclick="myFunction()"> Login/Signup </a>
                            <!-- <button class="nav-link dropbtn" onclick="myFunction()"> Login/Signup</button> -->
                            <div id="myDropdown" class="dropdown-content">
                                <a href="<spring:url value='/user'/>">User   Login/Signup</a>
                                <a href="<spring:url value='/seller'/>">Seller Login/Signup</a>
                            </div>
                        </li>
                        <% }  else  { %>
                        <li class="nav-item">
                            <!-- <a class="nav-link" onclick="myFunction()" class="dropbtn"> Login/Signup </a> -->
                            <a class="nav-link dropbtn" href="<spring:url value='/logout'/>"> Logout </a>
                        </li>
                        
                         <% } %>
                         
                         
                        <li class="nav-item">
                        
                         <% if ((Customer)session.getAttribute("user_dtls")==null && ((Seller)session.getAttribute("seller_dtls")==null)) { %>
                                                 <a class="nav-link" >  </a>
                        
                       <% }else{%>
                                              
                        <% if ((Customer)session.getAttribute("user_dtls")==null) { %>
                         <a class="nav-link" href="<spring:url value='/sellerProfile'/>"> Profile </a>
                        <% }  if ((Seller)session.getAttribute("seller_dtls")==null)  { %>
                         <a class="nav-link" href="<spring:url value='/userProfile'/>"> Profile </a>
                        
                         <% }}%>
                         
                          <% if ((Customer)session.getAttribute("user_dtls")!=null) { %> 
                        </li>
                        <li class="nav-item">
                            <a href="<spring:url value='/cart'/>" class="nav-link navbar-link-2 waves-effect">
                                <span class="badge badge-pill red"></span>
                                <i class="fas fa-shopping-cart pl-0"></i>
                            </a>
                        </li>
                        <%} %>
                    </ul>
                </div>
            </nav>
        </div>
    </section>