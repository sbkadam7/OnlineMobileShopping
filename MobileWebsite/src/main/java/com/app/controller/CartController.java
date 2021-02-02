package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Cart;
import com.app.pojos.Customer;
import com.app.pojos.CustomerAddress;
import com.app.service.ICartService;

@Controller
public class CartController {
	@Autowired
	private ICartService service;
	@GetMapping("/AddToCart")
	public String searchProduct(HttpSession hs,@RequestParam String id) {
		Customer user;
		System.out.println("In Search product");
		try {
			 user=(Customer)hs.getAttribute("user_dtls");
			if(user==null)
			{
				return "redirect:/user";
			}
			System.out.println("In Search product ->2");

			String str=service.addToCart(Integer.parseInt(id),user.getCustomerId());
			System.out.println("In Search product ->3 "+ str);

		}
		catch(Exception e)
		{
			System.out.println("In Search product ->4");
			e.printStackTrace();
			return "/";
		}
		return "redirect:/productPage?id="+id;
	}

	@GetMapping("/removefromcart")
	public String removeFromCart(HttpSession hs, @RequestParam String id)
	{
		boolean result=service.removeFromCart(Integer.parseInt(id));
		return "redirect:/cart";
	}
	
	@GetMapping("/cart")
	public String openCart(HttpSession hs)
	{
		Customer user=(Customer)hs.getAttribute("user_dtls");
		if(user==null)
		{
			return "redirect:/user";
		}
		try {
			Customer customer=(Customer)hs.getAttribute("user_dtls");
			System.out.println("openCart   1");
			List<Cart> cart=service.getCart(customer.getCustomerId());
			System.out.println("openCart   2");
			hs.setAttribute("Cart", cart);
			
			System.out.println("openCart   3" + cart.toString());
			return "/Cart/Cart";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "/";
	}
	
	@GetMapping("/Payment")
	public String payment(HttpSession hs)
	{
		Customer user=(Customer)hs.getAttribute("user_dtls");
	if(user==null)
	{
		return "redirect:/user";
	}
		try
		{
			List cart=(List<Cart>)hs.getAttribute("cart");
			List address=(List<CustomerAddress>)service.getCustomerAddress(user.getCustomerId());
			hs.setAttribute("Cus_Address", address);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("in payment catch");
		}
		
		return "/Cart/Payment";
	}
	
	
	@PostMapping("/Payment")
	public String cartProcessing(@ModelAttribute(name = "ProcessingCart") CustomerAddress transientPopulatedProduct,
			RedirectAttributes flashMap, HttpSession hs,@RequestParam String address, @RequestParam String cardNumber,
			@RequestParam String cardExpiry,@RequestParam String cardCVC, @RequestParam String cardHolderName)
	{
		
		try {
			System.out.println("in cartProcessing try");
			Customer customer=(Customer)hs.getAttribute("user_dtls");
			service.processOrder(customer.getCustomerId(),address,cardNumber,cardExpiry,cardCVC,cardHolderName);
		}
		catch(Exception e)
		{
			System.out.println("in cartProcessing catch");

			e.printStackTrace();
		}
		return "redirect:/orderDetails";
	}
}
