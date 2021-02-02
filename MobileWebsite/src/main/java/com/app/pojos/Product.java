package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	private String name;
	private String inTheBox;
	private String modelNumber;
	private String modelName;
	private String simType;
	private String hybridSimSlot;
	private String otgCompatiable;
	private String charging;
	private String displaySize;
	private String resolution;
	private String resolutionType;
	private String gpu;
	private String displayType;
	private String displayColor;
	private String otherDisplayFeature;
	private String operatingSystem;
	private String processorType;
	private String processorCore;
	private String primaryClockSpeed;
	private String secondaryClockSpeed;
	private String OperatingFrequenscy;
	//Memory and storage
	private String internalStorage;
	private String ram;
	private  String expandableStorage;
	//camer and feature
	private String primaryCamera;
	private String primaryCameraFeatures;
	private String secondaryCamera;
	private String secondaryCameraFeatures;
	private String recording;
	private String videoRecordingResolution;
	private String frameRate;
	private String dualCameraLens;
	// Connectivity feature
	private String networkType;
	private String supportedNetwork;
	private String bluetoothSupport;
	private String bluetoothVersion;
	private String wifiVersion;
	private String wifiHotspot;
	private String nfc;
	private String usbTethering;
	private String usbConnectivity;
	private String audioJack;
	private String gpsSupport;
	// other details
	private String touchScreenType;
	private String GraphicPPi;
	private String sensors;
	private String otherFeatures;
	//battery multimedia features
	private String batteryCapacity;
	private String batteryType;
	//Dimension
	private String width;
	private String height;
	private String depth;
	private String weight;
	//manufacture
	private String manufactureName;
	private String manufacturerOtherDetails;
	//warenty
	private String warrentySummary;
	//price
	private double actualMRP;
	private double sellingPrice;
	private String color;
	private int sellerIdFk;
	@Column(length = 16777215)
	private byte[] frontImage;
	@Column(length = 16777215)
	private byte[] backImage;
	@Column(length = 16777215)
	private byte[] topImage;
	@Column(length = 16777215)
	private byte[] bottomImage;
	@Column(length = 16777215)
	private byte[] leftSideImage;
	@Column(length = 16777215)
	private byte[] rightSideImage;
	
	private double quantity;
	/*
	@OneToMany(mappedBy = "product")
	private List<Color> color = new ArrayList<>();
	*/
	/*
	@ManyToOne
	private Seller seller = new Seller();*/
	
	
	//@ManyToOne
	//private Cart carts = new Cart();
	/*
	@OneToMany(mappedBy = "product", cascade=CascadeType.ALL)
	private List<Cart> carts=new ArrayList<>();
	*/
	
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer productId, String name, String inTheBox, String modelNumber, String modelName,
			String simType, String hybridSimSlot, String otgCompatiable, String charging, String displaySize,
			String resolution, String resolutionType, String gpu, String displayType, String displayColor,
			String otherDisplayFeature, String operatingSystem, String processorType, String processorCore,
			String primaryClockSpeed, String secondaryClockSpeed, String operatingFrequenscy, String internalStorage,
			String ram, String expandableStorage, String primaryCamera, String primaryCameraFeatures,
			String secondaryCamera, String secondaryCameraFeatures, String recording, String videoRecordingResolution,
			String frameRate, String dualCameraLens, String networkType, String supportedNetwork,
			String bluetoothSupport, String bluetoothVersion, String wifiVersion, String wifiHotspot, String nfc,
			String usbTethering, String usbConnectivity, String audioJack, String gpsSupport, String touchScreenType,
			String graphicPPi, String sensors, String otherFeatures, String batteryCapacity, String batteryType,
			String width, String height, String depth, String weight, String manufactureName,
			String manufacturerOtherDetails, String warrentySummary, double actualMRP, double sellingPrice) {
		super();
		this.productId = productId;
		this.name = name;
		this.inTheBox = inTheBox;
		this.modelNumber = modelNumber;
		this.modelName = modelName;
		this.simType = simType;
		this.hybridSimSlot = hybridSimSlot;
		this.otgCompatiable = otgCompatiable;
		this.charging = charging;
		this.displaySize = displaySize;
		this.resolution = resolution;
		this.resolutionType = resolutionType;
		this.gpu = gpu;
		this.displayType = displayType;
		this.displayColor = displayColor;
		this.otherDisplayFeature = otherDisplayFeature;
		this.operatingSystem = operatingSystem;
		this.processorType = processorType;
		this.processorCore = processorCore;
		this.primaryClockSpeed = primaryClockSpeed;
		this.secondaryClockSpeed = secondaryClockSpeed;
		OperatingFrequenscy = operatingFrequenscy;
		this.internalStorage = internalStorage;
		this.ram = ram;
		this.expandableStorage = expandableStorage;
		this.primaryCamera = primaryCamera;
		this.primaryCameraFeatures = primaryCameraFeatures;
		this.secondaryCamera = secondaryCamera;
		this.secondaryCameraFeatures = secondaryCameraFeatures;
		this.recording = recording;
		this.videoRecordingResolution = videoRecordingResolution;
		this.frameRate = frameRate;
		this.dualCameraLens = dualCameraLens;
		this.networkType = networkType;
		this.supportedNetwork = supportedNetwork;
		this.bluetoothSupport = bluetoothSupport;
		this.bluetoothVersion = bluetoothVersion;
		this.wifiVersion = wifiVersion;
		this.wifiHotspot = wifiHotspot;
		this.nfc = nfc;
		this.usbTethering = usbTethering;
		this.usbConnectivity = usbConnectivity;
		this.audioJack = audioJack;
		this.gpsSupport = gpsSupport;
		this.touchScreenType = touchScreenType;
		GraphicPPi = graphicPPi;
		this.sensors = sensors;
		this.otherFeatures = otherFeatures;
		this.batteryCapacity = batteryCapacity;
		this.batteryType = batteryType;
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.weight = weight;
		this.manufactureName = manufactureName;
		this.manufacturerOtherDetails = manufacturerOtherDetails;
		this.warrentySummary = warrentySummary;
		this.actualMRP = actualMRP;
		this.sellingPrice = sellingPrice;
		//this.color = color;
		//this.seller = seller;
		
	}
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInTheBox() {
		return inTheBox;
	}
	public void setInTheBox(String inTheBox) {
		this.inTheBox = inTheBox;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getSimType() {
		return simType;
	}
	public void setSimType(String simType) {
		this.simType = simType;
	}
	public String getHybridSimSlot() {
		return hybridSimSlot;
	}
	public void setHybridSimSlot(String hybridSimSlot) {
		this.hybridSimSlot = hybridSimSlot;
	}
	public String getOtgCompatiable() {
		return otgCompatiable;
	}
	public void setOtgCompatiable(String otgCompatiable) {
		this.otgCompatiable = otgCompatiable;
	}
	public String getCharging() {
		return charging;
	}
	public void setCharging(String charging) {
		this.charging = charging;
	}
	public String getDisplaySize() {
		return displaySize;
	}
	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getResolutionType() {
		return resolutionType;
	}
	public void setResolutionType(String resolutionType) {
		this.resolutionType = resolutionType;
	}
	public String getGpu() {
		return gpu;
	}
	public void setGpu(String gpu) {
		this.gpu = gpu;
	}
	public String getDisplayType() {
		return displayType;
	}
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	public String getDisplayColor() {
		return displayColor;
	}
	public void setDisplayColor(String displayColor) {
		this.displayColor = displayColor;
	}
	public String getOtherDisplayFeature() {
		return otherDisplayFeature;
	}
	public void setOtherDisplayFeature(String otherDisplayFeature) {
		this.otherDisplayFeature = otherDisplayFeature;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public String getProcessorType() {
		return processorType;
	}
	public void setProcessorType(String processorType) {
		this.processorType = processorType;
	}
	public String getProcessorCore() {
		return processorCore;
	}
	public void setProcessorCore(String processorCore) {
		this.processorCore = processorCore;
	}
	public String getPrimaryClockSpeed() {
		return primaryClockSpeed;
	}
	public void setPrimaryClockSpeed(String primaryClockSpeed) {
		this.primaryClockSpeed = primaryClockSpeed;
	}
	public String getSecondaryClockSpeed() {
		return secondaryClockSpeed;
	}
	public void setSecondaryClockSpeed(String secondaryClockSpeed) {
		this.secondaryClockSpeed = secondaryClockSpeed;
	}
	public String getOperatingFrequenscy() {
		return OperatingFrequenscy;
	}
	public void setOperatingFrequenscy(String operatingFrequenscy) {
		OperatingFrequenscy = operatingFrequenscy;
	}
	public String getInternalStorage() {
		return internalStorage;
	}
	public void setInternalStorage(String internalStorage) {
		this.internalStorage = internalStorage;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getExpandableStorage() {
		return expandableStorage;
	}
	public void setExpandableStorage(String expandableStorage) {
		this.expandableStorage = expandableStorage;
	}
	public String getPrimaryCamera() {
		return primaryCamera;
	}
	public void setPrimaryCamera(String primaryCamera) {
		this.primaryCamera = primaryCamera;
	}
	public String getPrimaryCameraFeatures() {
		return primaryCameraFeatures;
	}
	public void setPrimaryCameraFeatures(String primaryCameraFeatures) {
		this.primaryCameraFeatures = primaryCameraFeatures;
	}
	public String getSecondaryCamera() {
		return secondaryCamera;
	}
	public void setSecondaryCamera(String secondaryCamera) {
		this.secondaryCamera = secondaryCamera;
	}
	public String getSecondaryCameraFeatures() {
		return secondaryCameraFeatures;
	}
	public void setSecondaryCameraFeatures(String secondaryCameraFeatures) {
		this.secondaryCameraFeatures = secondaryCameraFeatures;
	}
	public String getRecording() {
		return recording;
	}
	public void setRecording(String recording) {
		this.recording = recording;
	}
	public String getVideoRecordingResolution() {
		return videoRecordingResolution;
	}
	public void setVideoRecordingResolution(String videoRecordingResolution) {
		this.videoRecordingResolution = videoRecordingResolution;
	}
	public String getFrameRate() {
		return frameRate;
	}
	public void setFrameRate(String frameRate) {
		this.frameRate = frameRate;
	}
	public String getDualCameraLens() {
		return dualCameraLens;
	}
	public void setDualCameraLens(String dualCameraLens) {
		this.dualCameraLens = dualCameraLens;
	}
	public String getNetworkType() {
		return networkType;
	}
	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}
	public String getSupportedNetwork() {
		return supportedNetwork;
	}
	public void setSupportedNetwork(String supportedNetwork) {
		this.supportedNetwork = supportedNetwork;
	}
	public String getBluetoothSupport() {
		return bluetoothSupport;
	}
	public void setBluetoothSupport(String bluetoothSupport) {
		this.bluetoothSupport = bluetoothSupport;
	}
	public String getBluetoothVersion() {
		return bluetoothVersion;
	}
	public void setBluetoothVersion(String bluetoothVersion) {
		this.bluetoothVersion = bluetoothVersion;
	}
	public String getWifiVersion() {
		return wifiVersion;
	}
	public void setWifiVersion(String wifiVersion) {
		this.wifiVersion = wifiVersion;
	}
	public String getWifiHotspot() {
		return wifiHotspot;
	}
	public void setWifiHotspot(String wifiHotspot) {
		this.wifiHotspot = wifiHotspot;
	}
	public String getNfc() {
		return nfc;
	}
	public void setNfc(String nfc) {
		this.nfc = nfc;
	}
	public String getUsbTethering() {
		return usbTethering;
	}
	public void setUsbTethering(String usbTethering) {
		this.usbTethering = usbTethering;
	}
	public String getUsbConnectivity() {
		return usbConnectivity;
	}
	public void setUsbConnectivity(String usbConnectivity) {
		this.usbConnectivity = usbConnectivity;
	}
	public String getAudioJack() {
		return audioJack;
	}
	public void setAudioJack(String audioJack) {
		this.audioJack = audioJack;
	}
	public String getGpsSupport() {
		return gpsSupport;
	}
	public void setGpsSupport(String gpsSupport) {
		this.gpsSupport = gpsSupport;
	}
	public String getTouchScreenType() {
		return touchScreenType;
	}
	public void setTouchScreenType(String touchScreenType) {
		this.touchScreenType = touchScreenType;
	}
	public String getGraphicPPi() {
		return GraphicPPi;
	}
	public void setGraphicPPi(String graphicPPi) {
		GraphicPPi = graphicPPi;
	}
	public String getSensors() {
		return sensors;
	}
	public void setSensors(String sensors) {
		this.sensors = sensors;
	}
	public String getOtherFeatures() {
		return otherFeatures;
	}
	public void setOtherFeatures(String otherFeatures) {
		this.otherFeatures = otherFeatures;
	}
	public String getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	public String getBatteryType() {
		return batteryType;
	}
	public void setBatteryType(String batteryType) {
		this.batteryType = batteryType;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getManufactureName() {
		return manufactureName;
	}
	public void setManufactureName(String manufactureName) {
		this.manufactureName = manufactureName;
	}
	public String getManufacturerOtherDetails() {
		return manufacturerOtherDetails;
	}
	public void setManufacturerOtherDetails(String manufacturerOtherDetails) {
		this.manufacturerOtherDetails = manufacturerOtherDetails;
	}
	public String getWarrentySummary() {
		return warrentySummary;
	}
	public void setWarrentySummary(String warrentySummary) {
		this.warrentySummary = warrentySummary;
	}
	public double getActualMRP() {
		return actualMRP;
	}
	public void setActualMRP(double actualMRP) {
		this.actualMRP = actualMRP;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	/*public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}*/
	/*
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}*/
	
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", inTheBox=" + inTheBox + ", modelNumber="
				+ modelNumber + ", modelName=" + modelName + ", simType=" + simType + ", hybridSimSlot=" + hybridSimSlot
				+ ", otgCompatiable=" + otgCompatiable + ", charging=" + charging + ", displaySize=" + displaySize
				+ ", resolution=" + resolution + ", resolutionType=" + resolutionType + ", gpu=" + gpu
				+ ", displayType=" + displayType + ", displayColor=" + displayColor + ", otherDisplayFeature="
				+ otherDisplayFeature + ", operatingSystem=" + operatingSystem + ", processorType=" + processorType
				+ ", processorCore=" + processorCore + ", primaryClockSpeed=" + primaryClockSpeed
				+ ", secondaryClockSpeed=" + secondaryClockSpeed + ", OperatingFrequenscy=" + OperatingFrequenscy
				+ ", internalStorage=" + internalStorage + ", ram=" + ram + ", expandableStorage=" + expandableStorage
				+ ", primaryCamera=" + primaryCamera + ", primaryCameraFeatures=" + primaryCameraFeatures
				+ ", secondaryCamera=" + secondaryCamera + ", secondaryCameraFeatures=" + secondaryCameraFeatures
				+ ", recording=" + recording + ", videoRecordingResolution=" + videoRecordingResolution + ", frameRate="
				+ frameRate + ", dualCameraLens=" + dualCameraLens + ", networkType=" + networkType
				+ ", supportedNetwork=" + supportedNetwork + ", bluetoothSupport=" + bluetoothSupport
				+ ", bluetoothVersion=" + bluetoothVersion + ", wifiVersion=" + wifiVersion + ", wifiHotspot="
				+ wifiHotspot + ", nfc=" + nfc + ", usbTethering=" + usbTethering + ", usbConnectivity="
				+ usbConnectivity + ", audioJack=" + audioJack + ", gpsSupport=" + gpsSupport + ", touchScreenType="
				+ touchScreenType + ", GraphicPPi=" + GraphicPPi + ", sensors=" + sensors + ", otherFeatures="
				+ otherFeatures + ", batteryCapacity=" + batteryCapacity + ", batteryType=" + batteryType + ", width="
				+ width + ", height=" + height + ", depth=" + depth + ", weight=" + weight + ", manufactureName="
				+ manufactureName + ", manufacturerOtherDetails=" + manufacturerOtherDetails + ", warrentySummary="
				+ warrentySummary + ", actualMRP=" + actualMRP + ", sellingPrice=" + sellingPrice + ", seller=" + sellerIdFk + "]";
	}
	public int getSellerIdFk() {
		return sellerIdFk;
	}
	public void setSellerIdFk(int sellerIdFk) {
		this.sellerIdFk = sellerIdFk;
	}
	public byte[] getFrontImage() {
		return frontImage;
	}
	public void setFrontImage(byte[] frontImage) {
		this.frontImage = frontImage;
	}
	public byte[] getBackImage() {
		return backImage;
	}
	public void setBackImage(byte[] backImage) {
		this.backImage = backImage;
	}
	public byte[] getTopImage() {
		return topImage;
	}
	public void setTopImage(byte[] topImage) {
		this.topImage = topImage;
	}
	public byte[] getBottomImage() {
		return bottomImage;
	}
	public void setBottomImage(byte[] bottomImage) {
		this.bottomImage = bottomImage;
	}
	public byte[] getLeftSideImage() {
		return leftSideImage;
	}
	public void setLeftSideImage(byte[] leftSideImage) {
		this.leftSideImage = leftSideImage;
	}
	public byte[] getRightSideImage() {
		return rightSideImage;
	}
	public void setRightSideImage(byte[] rightSideImage) {
		this.rightSideImage = rightSideImage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	
	
	
	
	
}
