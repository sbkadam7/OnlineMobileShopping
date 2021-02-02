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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Customer;
import com.app.pojos.CustomerAddress;
import com.app.pojos.Ordertable;
import com.app.service.ICustomerService;
@Controller 
public class CustomerContoller {
	@Autowired
	private ICustomerService service;

	public CustomerContoller() {
		super();
		System.out.println("In constructor of" + getClass().getName());
	}
	
	@GetMapping("/userSignup")
	public String showCustomerSignup(Model map)
	{
		System.out.println("in showCustomerSignup form ");
		// How to tell SC : to bind form data to model (POJO) : Product?
		// Simply add Product pojo transient instance as a model attribute (in Model
		// map)
		map.addAttribute("new_product", new Customer()); // 1st step in form binding
		return "/Customer/UserSignup";// VR : /WEB-INF/views/product/add.jsp
	}
	@PostMapping("/userSignup")
	public String processAddCustomerForm(@ModelAttribute(name = "new_customer") Customer transientPopulatedProduct,
			RedirectAttributes flashMap) {
		System.out.println("in Customer form "+transientPopulatedProduct);
		//invoke service---dao --add product to db
		try {
		flashMap.addFlashAttribute("status",service.addCustomer(transientPopulatedProduct));
		}
		catch(Exception e)
		{
			System.out.println("uer exeit");
		}
		return "redirect:/user";// D.S : resp.sendRedirect(resp.encodeRedirectURL("/product/list"))
	}
	
	@GetMapping("/user") 
	public String showUserPage() {
		System.out.println("in customer page");
		return "/Customer/UserLogin";
	}
	
	
	@PostMapping("/userlogin")
		// @RequestParam String em => String em=request.getParamter("em") ....
		// Model map => map of model attrs(hold results of action : request scope only)
		// : SC injects empty Map
		public String processCustomerLoginForm(@RequestParam String email, @RequestParam String Password, 

				Model map, HttpSession hs,RedirectAttributes flashMap) {
			System.out.println("in process login form " + map);// {}
			try {
				// controller invokes service layer method for user authentication
				Customer authenticateUser = service.authenticateUser(email, Password);
				// login successful : valid user login
				hs.setAttribute("user_dtls", authenticateUser);
				hs.setAttribute("mesg", "Login Successful");
				// check role of the logged in user
				//D.S invokes : response.sendRedirect(response.encodeTedirectURL("/admin/list")) --resp is sent to clnt browser.
				//Clnt sends next url  with method=get : http://host:port/day14.1/admin/list
				// vendor : logged in
				flashMap.addFlashAttribute("mesg","Vendor Logged in successfully...");
				return "redirect:/";// create VendorController : add req mapping
			} catch (RuntimeException e) {
				// NoResultExc
				// e.printStackTrace();
				System.out.println("err in controller " + e);
				map.addAttribute("mesg", "Invalid Login , Pls retry");
				return "/Customer/UserLogin";// def nav : RD's forward
			}

		}

	@GetMapping("/userAddress")
	public String showCustomerAddress(Model map,HttpSession hs)
	{
		Customer customer=(Customer)hs.getAttribute("user_dtls");
		if(customer==null)
		{
			
			return "redirect:/";

		}
		System.out.println("in showCustomerSignup form ");
		hs.setAttribute("Customer_addr", service.getCustomerAddress(customer.getCustomerId()));
		// How to tell SC : to bind form data to model (POJO) : Product?
		// Simply add Product pojo transient instance as a model attribute (in Model
		// map)
		map.addAttribute("new_product", new CustomerAddress()); // 1st step in form binding
		return "/Customer/UserAddress";// VR : /WEB-INF/views/product/add.jsp
	}
	@PostMapping("/userAddress")
	public String processAddCustomerAddressForm(@ModelAttribute(name = "new_CustomerAddress") CustomerAddress transientPopulatedProduct,
			RedirectAttributes flashMap, HttpSession hs) {
		System.out.println("in process Ad dCustomer Address form "+transientPopulatedProduct);
		//invoke service---dao --add product to db
		
		Customer customer=(Customer)hs.getAttribute("user_dtls");
		if(customer==null)
		{
			
			return "redirect:/";

		}
		try {
			transientPopulatedProduct.setUserId(customer.getCustomerId());
		flashMap.addFlashAttribute("status",service.addCustomerAddress(transientPopulatedProduct));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("uer exeit");
		}
		return "redirect:/userAddress";// D.S : resp.sendRedirect(resp.encodeRedirectURL("/product/list"))
	}
	
	
	
	/*Profile*/
	
	@GetMapping("/userProfile")
	public String getSellerProfile(HttpSession hs)
	{
		System.out.println("in poduct page ");
		if(hs.getAttribute("user_dtls")==null)
		{
			
			return "redirect:/";

		}
			
		return "/Customer/UserProfileEdit";
	}
	
	@PostMapping("/userUpdate")
	public String updateUserProfile(@ModelAttribute(name = "new_userAddress") Customer transientPopulatedProduct,
			RedirectAttributes flashMap,HttpSession hs) {
		System.out.println("in updateuserProfile "+transientPopulatedProduct);
		//invoke service---dao --add product to db
		Customer customer=(Customer)hs.getAttribute("user_dtls");
		if(customer==null)
		{
			
			return "redirect:/";

		}
		try {
			
			Customer s=(Customer) hs.getAttribute("user_dtls");
			
			System.out.println(" _______>  "+s.toString());
			transientPopulatedProduct.setCustomerId(s.getCustomerId());
			System.out.println(" ++++++++++++++>  "+transientPopulatedProduct.toString());
		flashMap.addFlashAttribute("status",service.updateCustomerProfile(transientPopulatedProduct));
		hs.putValue("user_dtls", transientPopulatedProduct);
				//hs.setAttribute('seller_dtls', transientPopulatedProduct);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("uer exeit");
		}
		return "redirect:/userProfile";
	}
	
	
	@GetMapping("/orderDetails")
	public String getOrderDetails(HttpSession hs)
	{
		Customer customer=(Customer)hs.getAttribute("user_dtls");
		if(customer==null)
		{
			
			return "redirect:/";

		}
		
		try
		{
			List<Ordertable> order=service.getOrderDeatils(customer.getCustomerId());
			hs.setAttribute("order_details",order );
		}
		catch(Exception e)
		{
			
		}
		return "/Customer/UserOrder";
	}

}
