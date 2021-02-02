<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page import="com.app.pojos.Seller"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
<%@ include file="../Common/header.html"%>
    <link rel="stylesheet" href="css/style_Navbar_Fotter.css">
    <link rel="stylesheet" href="css/styles_elements.css">
</head>
<body>
	
	<jsp:include page="../Common/navbar.jsp" flush="true" />
	

	<%
		String genral[] = { "name", "inTheBox", "modelNumber", "modelName", "color","simType", "hybridSimSlot", "otgCompatiable",
			"charging" };
	String genralName[] = { "Name", "In The Box", "Model Number", "Model Name","Color", "Sim Type", "Hybrid Sim Slot",
			"Otg Compatiable", "Charging" };

	String displayFeature[] = { "displaySize", "resolution", "resolutionType", "gpu", "displayType", "displayColor",
			"otherDisplayFeature" };           
	String displayFeatureName[] = { "Display Size", "Resolution", "Resolution Type", "GPU", "Display Type", "Display Color",
			"Other Display Feature" };

	String os[] = { "operatingSystem", "processorType", "processorCore", "primaryClockSpeed", "secondaryClockSpeed",
			"OperatingFrequenscy" };
	String osName[] = { "operatingSystem", "processorType", "processorCore", "primaryClockSpeed", "secondaryClockSpeed",
			"OperatingFrequenscy" };

	String Memory[] = { "internalStorage", "ram", "expandableStorage" };
	String MemoryName[] = { "Internal Storage", "RAM", "Expandable Storage" };

	String camera[] = { "primaryCamera", "primaryCameraFeatures", "secondaryCamera", "secondaryCameraFeatures", "recording",
			"videoRecordingResolution", "frameRate", "dualCameraLens" };
	String cameraName[] = { "Primary Camera", "Primary Camera Features", "Secondary Camera", "Secondary Camera Features",
			"Recording", "Video Recording Resolution", "Frame Rate", "Dual Camera Lens" };

	String connectivity[] = { "networkType", "supportedNetwork", "bluetoothSupport", "bluetoothVersion", "wifiVersion",
			"wifiHotspot", "nfc", "usbTethering", "usbConnectivity", "audioJack", "gpsSupport" };
	String connectivityName[] = { "Network Type", "Supported Network", "Bluetooth Support", "Bluetooth Version",
			"Wifi Version", "WiFi Hotspot", "NFC", "USB Tethering", "USB Connectivity", "Audio Jack", "GPS Support" };

	String otherDetails[] = { "touchScreenType", "GraphicPPi", "sensors", "otherFeatures" };
	String otherDetailsName[] = { "Touch Screen Type", "GraphicPPi", "Sensors", "Other Features" };

	String battery[] = { "batteryCapacity", "batteryType" };
	String batteryName[] = { "Battery Capacity", "Battery Type" };

	String dimension[] = { "width", "height", "depth", "weight" };
	String dimensionName[] = { "Width", "Height", "Depth", "Weight" };

	String manufacture[] = { "manufactureName", "manufacturerOtherDetails" };
	String manufactureName[] = { "Manufacture Name", "Manufacturer Other Details" };

	String warrentySummary[] = { "warrentySummary" };
	String warrentySummaryName[] = { "Warrenty Summary" };

	String price[] = { "actualMRP", "sellingPrice","Quantity"};
	String priceName[] = { "Actual MRP", "selling Price","quantity" };
	%>
	<div class="container">

		<form action="<spring:url value='/AddProductt'/>" method="post" enctype="multipart/form-data">
			<h1>Genral Specification</h1>
			<table>
				<%
					for (int i = 0; i < genral.length; i += 1) {
				%>
				<tr>
					<td><label for="<%=genral[i]%>"><b> <%=genralName[i]%></b></label></td>
					<td><input type="text" name="<%=genral[i]%>" required></td>
				</tr>
				<%
					}
				%>
			</table>
			<h1>Display Features</h1>
			<table>
				<%
					for (int i = 0; i < displayFeature.length; i += 1) {
				%>
				<tr>
					<td><label for="<%=displayFeature[i]%>"><b> <%=displayFeatureName[i]%></b></label></td>
					<td><input type="text" name="<%=displayFeature[i]%>" required></td>
				</tr>
				<%
					}
				%>
			</table>
			<h1>Os & Processor Features</h1>
			<table>
				<%
					for (int i = 0; i < os.length; i += 1) {
				%>
				<tr>
					<td><label for="<%=os[i]%>"><b> <%=osName[i]%></b></label></td>
					<td><input type="text" name="<%=os[i]%>" required></td>
				</tr>
				<%
					}
				%>
			</table>
			<h1>Memory & Storage Features</h1>
			<table>
				<%
					for (int i = 0; i < Memory.length; i += 1) {
				%>
				<tr>
					<td><label for="<%=Memory[i]%>"><b> <%=MemoryName[i]%></b></label></td>
					<td><input type="text" name="<%=Memory[i]%>" required></td>
				</tr>
				<%
					}
				%>
			</table>
			<h1>Camera Features</h1>
			<table>
				<%
					for (int i = 0; i < camera.length; i += 1) {
				%>
				<tr>
					<td><label for="<%=camera[i]%>"><b> <%=cameraName[i]%></b></label></td>
					<td><input type="text" name="<%=camera[i]%>" required></td>
				</tr>
				<%
					}
				%>
			</table>
			<h1>Connectivity Features</h1>
			<table>
				<%
					for (int i = 0; i < connectivity.length; i += 1) {
				%>
				<tr>
					<td><label for="<%=connectivity[i]%>"><b> <%=connectivityName[i]%></b></label></td>
					<td><input type="text" name="<%=connectivity[i]%>" required></td>
				</tr>
				<%
					}
				%>
			</table>
			<h1>Other Details</h1>
			<table>
				<%
					for (int i = 0; i < otherDetails.length; i += 1) {
				%>
				<tr>
					<td><label for="<%=otherDetails[i]%>"><b> <%=otherDetailsName[i]%></b></label></td>
					<td><input type="text" name="<%=otherDetails[i]%>" required></td>
				</tr>
				<%
					}
				%>
			</table>
			<h1>Multimedia Features</h1>
			<table>
				<%
					for (int i = 0; i < battery.length; i += 1) {
				%>
				<tr>
					<td><label for="<%=battery[i]%>"><b> <%=batteryName[i]%></b></label></td>
					<td><input type="text" name="<%=battery[i]%>" required></td>
				</tr>
				<%
					}
				%>
			</table>
			<h1>Dimensions</h1>
			<table>
				<%
					for (int i = 0; i < dimension.length; i += 1) {
				%>
				<tr>
					<td><label for="<%=dimension[i]%>"><b> <%=dimensionName[i]%></b></label></td>
					<td><input type="text" name="<%=dimension[i]%>" required></td>
				</tr>
				<%
					}
				%>
			</table>



			<h1>Manufacturer</h1>
			<table>
				<%
					for (int i = 0; i < manufacture.length; i += 1) {
				%>
				<tr>
					<td><label for="<%=manufacture[i]%>"><b> <%=manufactureName[i]%></b></label></td>
					<td><input type="text" name="<%=manufacture[i]%>" required></td>
				</tr>
				<%
					}
				%>
			</table>
			<h1>Warranty</h1>
			<table>
				<%
					for (int i = 0; i < warrentySummary.length; i += 1) {
				%>
				<tr>
					<td><label for="<%=warrentySummary[i]%>"><b> <%=warrentySummaryName[i]%></b></label></td>
					<td><input type="text" name="<%=warrentySummary[i]%>" required></td>
				</tr>
				<%
					}
				%>

			</table>

			<h1>Price</h1>
			<table>
				<%
					for (int i = 0; i < price.length; i += 1) {
				%>
				<tr>
					<td><label for="<%=price[i]%>"><b> <%=priceName[i]%></b></label></td>
					<td><input type="text" name="<%=price[i]%>" required></td>
				</tr>
				<%
					}
				%>
			</table>

			<table>
				<tr>
					<td><label for="front">Insert Front view image</label></td>
					<td><input type="file" name="front" accept="image/*" required>
					</td>
				</tr>
				<tr>
					<td><label for="back">Insert Back view image</label></td>
					<td><input type="file" name="back" accept="image/*" required>
					</td>
				</tr>
				<tr>
					<td><label for="bottom">Insert Bottom view image</label></td>
					<td><input type="file" name="bottom" accept="image/*" required>
					</td>
				</tr>
				<tr>
					<td><label for="top">Insert Top view image</label></td>
					<td><input type="file" name="top" accept="image/*" required>
					</td>
				</tr>
				<tr>
					<td><label for="left_side">Insert left side view image</label></td>
					<td><input type="file" name="left_side" accept="image/*"
						required></td>
				</tr>
				<tr>
					<td><label for="right_side">Insert right side view
							image</label></td>
					<td><input type="file" name="right_side" accept="image/*"
						required></td>
				</tr>
			</table>
			<button type="submit">Add</button>

		</form>
		<%@ include file="../Common/footer.html"%>
</body>
</html>