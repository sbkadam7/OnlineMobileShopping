package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Customer;
import com.app.pojos.CustomerAddress;
import com.app.pojos.Ordertable;
import com.app.pojos.Seller;
import com.app.pojos.SellerAddress;
import com.app.service.ISellerService;
@Controller 
public class SellerContoller {
	@Autowired
	private ISellerService service;

	public SellerContoller() {
		super();
		System.out.println("In constructor of" + getClass().getName());
	}
	
	
	
	@GetMapping("/sellerSignup")
	public String showSellerSignup(Model map)
	{
		System.out.println("in showSellerSignup form ");
		// How to tell SC : to bind form data to model (POJO) : Product?
		// Simply add Product pojo transient instance as a model attribute (in Model
		// map)
		map.addAttribute("new_product", new Seller()); // 1st step in form binding
		return "/Seller/SellerSignup";// VR : /WEB-INF/views/product/add.jsp
	}
	@PostMapping("/sellerSignup")
	public String processAddSellerForm(@ModelAttribute(name = "new_seller") Seller transientPopulatedProduct,
			RedirectAttributes flashMap) {
		System.out.println("in Seller form "+transientPopulatedProduct);
		//invoke service---dao --add product to db
		try {
		flashMap.addFlashAttribute("status",service.addSeller(transientPopulatedProduct));
		}
		catch(Exception e)
		{
			System.out.println("seller exeit");
			
		}
		return "redirect:/seller";// D.S : resp.sendRedirect(resp.encodeRedirectURL("/product/list"))
	}
	
	
	@GetMapping("/seller")
	public String showSellerPage() {
		
		System.out.println("in seller page");
		return "/Seller/SellerLogin";
	}
	
	@PostMapping("/sellerlogin")
	// @RequestParam String em => String em=request.getParamter("em") ....
	// Model map => map of model attrs(hold results of action : request scope only)
	// : SC injects empty Map
	public String processSellerLoginForm(@RequestParam String email, @RequestParam String password, 
			Model map, HttpSession hs,RedirectAttributes flashMap) {
		System.out.println("in process seller login form " + map);// {}
		try {
			// controller invokes service layer method for user authentication
			Seller authenticateUser = service.authenticateSeller(email, password);
			// login successful : valid user login
			hs.setAttribute("seller_dtls", authenticateUser);
			
			hs.setAttribute("Seller_mesg", "Login Successful");
			//D.S invokes : response.sendRedirect(response.encodeTedirectURL("/admin/list")) --resp is sent to clnt browser.
			//Clnt sends next url  with method=get : http://host:port/day14.1/admin/list
			// vendor : logged in
			flashMap.addFlashAttribute("mesg","Vendor Logged in successfully...");
			return "redirect:/sellerHome";// create VendorController : add req mapping
		} catch (RuntimeException e) {
			// NoResultExc
			// e.printStackTrace();
			System.out.println("err in controller " + e);
			map.addAttribute("mesg", "Invalid Login , Pls retry");
			return "/Seller/SellerLogin";// def nav : RD's forward
		}
		

	}
	
	
	
	
	@GetMapping("/sellerAddress")
	public String showCustomerAddress(Model map,HttpSession hs)
	{
		Seller seller=(Seller)hs.getAttribute("seller_dtls");
		if(seller==null)
		{
			
			return "redirect:/";

		}
		System.out.println("in showCustomerSignup form ");
		// How to tell SC : to bind form data to model (POJO) : Product?
		// Simply add Product pojo transient instance as a model attribute (in Model
		// map)
		map.addAttribute("new_product", new CustomerAddress()); // 1st step in form binding
		hs.setAttribute("Seller_addr", service.getSellerAddress(seller.getSellerId()));
		return "/Seller/SellerAddress";// VR : /WEB-INF/views/product/add.jsp
	}
	@PostMapping("/sellerAddress")
	public String processAddCustomerAddressForm(@ModelAttribute(name = "new_SellerAddress") SellerAddress transientPopulatedProduct,
			RedirectAttributes flashMap,HttpSession hs) {
		System.out.println("in process Ad dCustomer Address form "+transientPopulatedProduct);
		//invoke service---dao --add product to db
		Seller seller=(Seller)hs.getAttribute("seller_dtls");
		if(seller==null)
		{
			
			return "redirect:/";

		}
		try {
			transientPopulatedProduct.setSellerId(seller.getSellerId());
		flashMap.addFlashAttribute("status",service.addSellerAddress(transientPopulatedProduct));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("uer exeit");
		}
		return "redirect:/sellerAddress";// D.S : resp.sendRedirect(resp.encodeRedirectURL("/product/list"))
	}
	
	
	@GetMapping("/sellerHome")
	public String showProductHome(HttpSession hs)
	{
		Seller seller=(Seller)hs.getAttribute("seller_dtls");
		if(seller==null)
		{
			return "redirect:/";

		}
		//HttpSession hs=request.getSession(); ;
		//hs.getAttribute("seller_dtls");
		hs.setAttribute("Seller_Product", service.getSellerProduct(seller.getSellerId()));
		System.out.println("**************"+SessionScope.class.toString());
		System.out.println("in poduct page ");
		return "/Seller/ProductHome";// VR : /WEB-INF/views/product/add.jsp
	}
	
	
	
	
	/*seller profile edit*/
	
	@GetMapping("/sellerProfile")
	public String getSellerProfile(HttpSession hs)
	{
		System.out.println("in poduct page ");
		Seller seller=(Seller)hs.getAttribute("seller_dtls");
		if(seller==null) {
			
			return "redirect:/";

		}
			
		return "/Seller/SellerProfileEdit";
	}
	
	@PostMapping("/sellerUpdate")
	public String updateSellerProfile(@ModelAttribute(name = "new_SellerAddress") Seller transientPopulatedProduct,
			RedirectAttributes flashMap,HttpSession hs) {
		System.out.println("in updateSellerProfile "+transientPopulatedProduct);
		//invoke service---dao --add product to db
		try {
			
			Seller s=(Seller) hs.getAttribute("seller_dtls");
			
			System.out.println(" _______>  "+s.toString());
			transientPopulatedProduct.setSellerId(s.getSellerId());
			System.out.println(" ++++++++++++++>  "+transientPopulatedProduct.toString());
		flashMap.addFlashAttribute("status",service.updateSellerProfile(transientPopulatedProduct));
		hs.putValue("seller_dtls", transientPopulatedProduct);
				//hs.setAttribute('seller_dtls', transientPopulatedProduct);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("uer exeit");
		}
		return "redirect:/sellerProfile";
	}
	
	@GetMapping("/orderHistory")
	public String getOrderDetails(HttpSession hs)
	{
		Seller seller=(Seller)hs.getAttribute("seller_dtls");
		if(seller==null) {
			
			return "redirect:/";

		}
		
		try
		{
			List<Ordertable> order=service.getOrderDeatils(seller.getSellerId());
			hs.setAttribute("order_details_seller",order );
		}
		catch(Exception e)
		{
			
		}
		return "/Seller/SellerOrder";
	}
}
