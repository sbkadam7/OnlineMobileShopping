<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html
	xmlns:th="http://www.thymeleaf.org >

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
        <%@ include file="../Common/header.html"%>
    	<link rel="stylesheet" href="css/style_login.css">
    <link rel="stylesheet" href="css/style_Navbar_Fotter.css">
    <link rel="stylesheet" href="css/styles_elements.css">
</head>

<body>
 <jsp:include page="../Common/navbar.jsp" flush="true" />
<div class="login_signup">

        <div class="signuptouch" id="rightbox">
            <img src="image/Already-customer-icon.jpg" alt="" class="img_touch">
           <!--  <a href="" onclick="document.getElementById('id01').style.display='block'"> -->
           <br>
            <button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Already connected with us</button>
                
           
        </div>

        <div class="logintouch" id="leftbox">
            <img src="image/login.png" alt="" class="img_touch">
            <br>
            <button onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Want to join?</button>
        </div>
</div>
<!--  <button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</button>-->
    <div id="id01" class="modal"> 

        <form class="modal-content animate" action="<spring:url value='/userlogin'/>" method="post">
            <!-- website logo !-->
           <!-- <div class="imgcontainer">
                <span onclick="document.getElementById('id01').style.display='none'" class="close"
                    title="Close Modal">&times;</span>
                 <img src="img_avatar2.png" alt="Avatar" class="avatar">
            </div>!-->
            <div class="container">
                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="email" required>

                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="Password" required>

                <button type="submit">Login</button>
                <label>
                    <input type="checkbox" checked="checked" name="remember"> Remember me
                </label>
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button type="button" onclick="document.getElementById('id01').style.display='none'"
                    class="cancelbtn">Cancel</button>
                  <%-- <button class ="signup"><a href ="<spring:url value='/userSignup'/>">Signup</a></button>   --%>
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </form>
    </div>

    <div id="id02" class="modal">

<form class="modal-content animate"
	action="<spring:url value='/userSignup'/>" method="post">
	<div class="container">
		<label for="Firstname"><b>FirstName</b></label> <input type="text"
			placeholder="Enter FirstName" name="FirstName" required> <label
			for="Firstname"><b>LastName</b></label> <input type="text"
			placeholder="Enter LastName" name="LastName" required> <label
			for="psw"><b>Password</b></label> <input type="password"
			placeholder="Enter Password" name="Password" required> <label
			for="email"><b>Email</b></label> <input type="email"
			placeholder="Enter Email" name="email"> <label for="phone"><b>Mobile</b></label>
		<input type="number" placeholder="Enter Mobile Number" name="mobile">

		<button type="submit">Sign Up</button>

	</div>

	<div class="container" style="background-color: #f1f1f1">
		<button type="button"
			onclick="document.getElementById('id02').style.display='none'"
			class="cancelbtn">Cancel</button>

	</div>
</form>
</div>
    	<!-- footer -->

	<%@ include file="../Common/footer.html"%>
    
    
    <script>
        
         // Get the modal
        var modal = document.getElementById('id01');
		var modal2 = document.getElementById('id02');
		
        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function (event) {
            if (event.target == modal || event.target == modal2) {
                modal.style.display = "none";
                modal2.style.display = "none";
            }
        }
    </script>

</body>

</html>