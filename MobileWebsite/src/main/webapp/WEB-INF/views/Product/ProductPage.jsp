<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page
	import="com.app.pojos.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Product</title>


<!-- Fonts -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/3e8edbd1f8.js"
	crossorigin="anonymous"></script>



<%@ include file="../Common/header.html"%>

<!-- CSS -->
<link href="css/styleproduct.css" rel="stylesheet">
<link rel="stylesheet" href="css/style_Navbar_Fotter.css">
<link rel="stylesheet" href="css/styles_elements.css">
<%@page
	import="javax.persistence.*,com.app.dao.ProductDao,com.app.pojos.Product,java.util.*"%>
</head>

<body>

	<jsp:include page="../Common/navbar.jsp" flush="true" />


	<%
		Product p = (Product) session.getAttribute("Product");
	%>


	<main class="container">

		<!-- Left Column / Headphones Image -->
		<div class="left-column">
			<div>
				<div id="demo" class="carousel slide" data-ride="carousel">

					<!-- Indicators -->
					<ul class="carousel-indicators">
						<li data-target="#demo" data-slide-to="0" class="active"></li>
						<li data-target="#demo" data-slide-to="1"></li>
						<li data-target="#demo" data-slide-to="2"></li>
						<li data-target="#demo" data-slide-to="3"></li>
						<li data-target="#demo" data-slide-to="4"></li>
						<li data-target="#demo" data-slide-to="5"></li>
					</ul>

					<!-- The slideshow -->
					<div class="carousel-inner">
						<div class="carousel-item active">
						<%String src="image/productimage/"+p.getProductId()+"/front.jpg"; %>
							<img src="<%=src %>" alt="Los Angeles">
						</div>
						<div class="carousel-item">
						<% src="image/productimage/"+p.getProductId()+"/back.jpg"; %>
							<img src="<%=src %>" alt="Chicago">
						</div>
						<div class="carousel-item">
						<% src="image/productimage/"+p.getProductId()+"/bottom.jpg"; %>
							<img src="<%=src %>" alt="New York">
						</div>
						<div class="carousel-item">
						<% src="image/productimage/"+p.getProductId()+"/top.jpg"; %>
							<img src="<%=src %>" alt="New York">
						</div>
						<div class="carousel-item">
						<% src="image/productimage/"+p.getProductId()+"/rightSide.jpg"; %>
							<img src="<%=src %>" alt="New York">
						</div>
						<div class="carousel-item">
						<% src="image/productimage/"+p.getProductId()+"/leftSide.jpg"; %>
							<img src="<%=src %>" alt="New York">
						</div>
					</div>

					<!-- Left and right controls -->
					<a class="carousel-control-prev" href="#demo" data-slide="prev">
						<!-- <span class="carousel-control-prev-icon" style="color:blue;"></span> -->
						<span><i class="fa fa-angle-left" aria-hidden="true"></i></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#demo" data-slide="next">
						<!--  <span class="carousel-control-next-icon" style="color:blue;"></span> -->
						<span><i class="fa fa-angle-right" aria-hidden="true"></i></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<%Customer c=(Customer)session.getAttribute("user_dtls");
			
			if(c!=null){%>
			<div class="product-price">
			<%String link="/AddToCart?id="+p.getProductId(); %>
				<a href="<spring:url value='<%=link %>' /> " class="cart-btn">Add to cart</a>
			</div>
			<%} %>
		</div>

		</div>


		<!-- Right Column -->
		<div class="right-column">

			<!-- Product Description -->
			<div class="product-description">
				<span>Mobile</span>
				<h1>
					<strong><%=p.getName()%></strong>
				</h1>
				<div>
					<p><%=p.getSellingPrice()%>
						&nbsp <span><del><%=p.getActualMRP()%></del></span>
					</p>
				</div>
			</div>

			<!-- Product Configuration -->
			<div class="product-configuration">



				<!-- Cable Configuration -->
				<div class="cable-config">
					<span><h4>Highlights</h4></span>

					<div class="cable-choose">
						<ul>
							<li><%=p.getRam() + " Ram | " + p.getInternalStorage() + " Internal Storage"%></li>
							<li><%=p.getDisplaySize() + " "%> Display</li>
							<li><%=p.getPrimaryCamera() + " Rear Camera " + p.getSecondaryCamera() + " Front Camera"%></li>
							<li><%=p.getProcessorType() + " Processor | " + p.getProcessorCore() + " Cores"%></li>
							<li><%=p.getOperatingSystem()%></li>
							<li><%=p.getCharging()%></li>
							<!--  replace with color -->

						</ul>
					</div>

					<div class="cable-config">
						<div>
							<br>
							<h4>Genral Specification</h4>
							<table>

								<tbody>
									<tr>
										<td>Name</td>
										<td><%=p.getName()%></td>
									</tr>

									<tr>
										<td>In The Box</td>
										<td><%=p.getInTheBox()%></td>
									</tr>

									<tr>
										<td>Model Number</td>
										<td><%=p.getModelNumber()%></td>
									</tr>

									<tr>
										<td>Model Name</td>
										<td><%=p.getModelName()%></td>
									</tr>

									<tr>
										<td>Sim Type</td>
										<td><%=p.getSimType()%></td>
									</tr>

									<tr>
										<td>Hybrid Sim Slot</td>
										<td><%=p.getHybridSimSlot()%></td>
									</tr>

									<tr>
										<td>Otg Compatiable</td>
										<td><%=p.getOtgCompatiable()%></td>
									</tr>

									<tr>
										<td>Charging</td>
										<td><%=p.getCharging()%></td>
									</tr>

								</tbody>
							</table>
							<br>
							<h4>Display Features</h4>
							<table>

								<tbody>
									<tr>
										<td>Display Size</td>
										<td><%=p.getDisplaySize()%></td>
									</tr>

									<tr>
										<td>Resolution</td>
										<td><%=p.getResolution()%></td>
									</tr>

									<tr>
										<td>Resolution Type</td>
										<td><%=p.getResolutionType()%></td>
									</tr>

									<tr>
										<td>GPU</td>
										<td><%=p.getGpu()%></td>
									</tr>

									<tr>
										<td>Display Type</td>
										<td><%=p.getDisplayType()%></td>
									</tr>

									<tr>
										<td>Display Color</td>
										<td><%=p.getDisplayColor()%></td>
									</tr>

									<tr>
										<td>Other Display Feature</td>
										<td><%=p.getOtherDisplayFeature()%></td>
									</tr>

								</tbody>
							</table>
							<br>
							<h4>Os &amp; Processor Features</h4>
							<table>

								<tbody>
									<tr>
										<td>operatingSystem</td>
										<td><%=p.getOperatingSystem()%></td>
									</tr>

									<tr>
										<td>processorType</td>
										<td><%=p.getProcessorType()%></td>
									</tr>

									<tr>
										<td>processorCore</td>
										<td><%=p.getProcessorCore()%></td>
									</tr>

									<tr>
										<td>primaryClockSpeed</td>
										<td><%=p.getPrimaryClockSpeed()%></td>
									</tr>

									<tr>
										<td>secondaryClockSpeed</td>
										<td><%=p.getSecondaryClockSpeed()%></td>
									</tr>

									<tr>
										<td>OperatingFrequenscy</td>
										<td><%=p.getOperatingFrequenscy()%></td>
									</tr>

								</tbody>
							</table>
							<br>
							<h4>Memory &amp; Storage Features</h4>
							<table>

								<tbody>
									<tr>
										<td>Internal Storage</td>
										<td><%=p.getInternalStorage()%></td>
									</tr>

									<tr>
										<td>RAM</td>
										<td><%=p.getRam()%></td>
									</tr>

									<tr>
										<td>Expandable Storage</td>
										<td><%=p.getExpandableStorage()%></td>
									</tr>

								</tbody>
							</table>
							<br>
							<h4>Camera Features</h4>
							<table>

								<tbody>
									<tr>
										<td>Primary Camera</td>
										<td><%=p.getPrimaryCamera()%></td>
									</tr>

									<tr>
										<td>Primary Camera Features</td>
										<td><%=p.getPrimaryCameraFeatures()%></td>
									</tr>

									<tr>
										<td>Secondary Camera</td>
										<td><%=p.getSecondaryCamera()%></td>
									</tr>

									<tr>
										<td>Secondary Camera Features</td>
										<td><%=p.getSecondaryCameraFeatures()%></td>
									</tr>

									<tr>
										<td>Recording</td>
										<td><%=p.getRecording()%></td>
									</tr>

									<tr>
										<td>Video Recording Resolution</td>
										<td><%=p.getVideoRecordingResolution()%></td>
									</tr>

									<tr>
										<td>Frame Rate</td>
										<td><%=p.getFrameRate()%></td>
									</tr>

									<tr>
										<td>Dual Camera Lens</td>
										<td><%=p.getDualCameraLens()%></td>
									</tr>

								</tbody>
							</table>
							<br>
							<h4>Connectivity Features</h4>
							<table>

								<tbody>
									<tr>
										<td>Network Type</td>
										<td><%=p.getNetworkType()%></td>
									</tr>

									<tr>
										<td>Supported Network</td>
										<td><%=p.getSupportedNetwork()%></td>
									</tr>

									<tr>
										<td>Bluetooth Support</td>
										<td><%=p.getBluetoothSupport()%></td>
									</tr>

									<tr>
										<td>Bluetooth Version</td>
										<td><%=p.getBluetoothVersion()%></td>
									</tr>

									<tr>
										<td>Wifi Version</td>
										<td><%=p.getWifiVersion()%></td>
									</tr>

									<tr>
										<td>WiFi Hotspot</td>
										<td><%=p.getWifiHotspot()%></td>
									</tr>

									<tr>
										<td>NFC</td>
										<td><%=p.getNfc()%></td>
									</tr>

									<tr>
										<td>"USB Tethering</td>
										<td><%=p.getUsbTethering()%></td>
									</tr>

									<tr>
										<td>USB Connectivity</td>
										<td><%=p.getUsbConnectivity()%></td>
									</tr>

									<tr>
										<td>Audio Jack</td>
										<td><%=p.getAudioJack()%></td>
									</tr>

									<tr>
										<td>GPS Support</td>
										<td><%=p.getGpsSupport()%></td>
									</tr>

								</tbody>
							</table>
							<br>
							<h4>Other Details</h4>
							<table>

								<tbody>
									<tr>
										<td>Touch Screen Type</td>
										<td><%=p.getTouchScreenType()%></td>
									</tr>

									<tr>
										<td>GraphicPPi</td>
										<td><%=p.getGraphicPPi()%></td>
									</tr>

									<tr>
										<td>Sensors</td>
										<td><%=p.getSensors()%></td>
									</tr>

									<tr>
										<td>Other Features</td>
										<td><%=p.getOtherFeatures()%></td>
									</tr>

								</tbody>
							</table>
							<br>
							<h4>Multimedia Features</h4>
							<table>

								<tbody>
									<tr>
										<td>Battery Capacity</td>
										<td><%=p.getBatteryCapacity()%></td>
									</tr>

									<tr>
										<td>Battery Type</td>
										<td><%=p.getBatteryType()%></td>
									</tr>

								</tbody>
							</table>
							<br>
							<h4>Dimensions</h4>
							<table>

								<tbody>
									<tr>
										<td>Width</td>
										<td><%=p.getWidth()%></td>
									</tr>

									<tr>
										<td>Height</td>
										<td><%=p.getHeight()%></td>
									</tr>

									<tr>
										<td>Depth</td>
										<td><%=p.getDepth()%></td>
									</tr>

									<tr>
										<td>Weight</td>
										<td><%=p.getWeight()%></td>
									</tr>

								</tbody>
							</table>


							<br>
							<h4>Manufacturer</h4>
							<table>

								<tbody>
									<tr>
										<td>Manufacture Name</td>
										<td><%=p.getManufactureName()%></td>
									</tr>

									<tr>
										<td>Manufacturer Other Details</td>
										<td><%=p.getManufacturerOtherDetails()%></td>
									</tr>

								</tbody>
							</table>
							<br>
							<h4>Warranty</h4>
							<table>

								<tbody>
									<tr>
										<td>Warrenty Summary</td>
										<td><%=p.getWarrentySummary()%></td>
									</tr>


								</tbody>
							</table>
							<br>
							<h4>Price</h4>
							<table>

								<tbody>
									<tr>
										<td>Actual MRP</td>
										<td><%=p.getActualMRP()%></td>
									</tr>

									<tr>
										<td>selling Price</td>
										<td><%=p.getSellingPrice()%></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>

				</div>
			</div>

			<!-- Product Pricing -->

		</div>
	</main>
			<%-- <%@ include file="../Common/footer.html"%> --%>

	<!-- <!-- Footer -->
	 <footer class="white-section" id="footer" th:fragment="footer" style="position :absolute;top:700px;right:50%">
        <div class="container-fluid">

            <a href="https://www.facebook.com/shwetank.bst/" target="_blank"><i class="fab fa-facebook footer-icon" ></i></a>
            <a href="https://twitter.com/shwetankssy" target="_blank"><i class="fab fa-twitter footer-icon"></i></a>
            <a href="https://www.instagram.com/shwetankssy" target="_blank"><i class="fab fa-instagram footer-icon"></i></a>
            <a href="mailto: shwetank.bst@gmail.com" target="_blank"><i class="fas fa-envelope footer-icon"></i></a>
            <p>© Copyright 2021 MobileSite</p>
        </div>
    </footer>
	<!-- Scripts -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"
		charset="utf-8"></script>
	<script src="js/scriptproduct.js" charset="utf-8"></script>
</body>
</html>
