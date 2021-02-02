package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.ProductDao;
import com.app.pojos.Product;
import com.app.pojos.Seller;
import com.app.service.IProductService;

@Controller
public class ProductController {
	@Autowired
	private IProductService service;
	@GetMapping("/AddProduct")
	public String addproduct(HttpSession session){
		System.out.println("in add product");
		Seller s=(Seller)session.getAttribute("seller_dtls");
		System.out.println(s.getEmail());
		return "/Product/Product";
	}
	
	@PostMapping("/AddProductt")
	public String processAddCustomerForm(@ModelAttribute(name = "new_product") Product transientPopulatedProduct,
			RedirectAttributes flashMap,HttpSession session,@RequestParam("front") MultipartFile file1,@RequestParam("back") MultipartFile file2,
			@RequestParam("top") MultipartFile file3,@RequestParam("bottom") MultipartFile file4,@RequestParam("left_side") MultipartFile file5,
			@RequestParam("right_side") MultipartFile file6) {
		System.out.println("in Product form "+transientPopulatedProduct);
		//invoke service---dao --add product to db
		//HttpSession session = request.getSession();
		Seller s=(Seller)session.getAttribute("seller_dtls");
		System.out.println(s.getEmail());
		try {
			byte[] bytes = file1.getBytes();
			transientPopulatedProduct.setFrontImage(bytes);
			bytes = file2.getBytes();
			transientPopulatedProduct.setBackImage(bytes);
			bytes = file3.getBytes();
			transientPopulatedProduct.setTopImage(bytes);
			bytes = file4.getBytes();
			transientPopulatedProduct.setBottomImage(bytes);
			bytes = file5.getBytes();
			transientPopulatedProduct.setLeftSideImage(bytes);
			bytes = file6.getBytes();
			transientPopulatedProduct.setRightSideImage(bytes);
			
			
			
			
		flashMap.addFlashAttribute("status",service.addProduct(transientPopulatedProduct,s));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Product exit");
		}
		return "redirect:/AddProduct";// D.S : resp.sendRedirect(resp.encodeRedirectURL("/product/list"))
	}
	
	@GetMapping("/Home")
	public String editproduct(HttpSession session){
		System.out.println("in edit product");
        ProductDao pd=new ProductDao();
        session.setAttribute("All_Product",service.getProductDetail());
		//List<Product> prod=pd.ProductDetail();
		System.out.println("in edit product 2");

		return "/Product/SiteHome";
	}
	
	
	@GetMapping("/productPage")
	public String productPageReq(@RequestParam String id,HttpSession session)
	{

		ProductDao pd=new ProductDao();
		//Product p=pd.getProductByID(Integer.parseInt(id));
		
		System.out.println("in productPageReq -> 1");
        session.setAttribute("Product",service.getProductByID(Integer.parseInt(id)));
        
        System.out.println("in productPageReq  -> 2");
		return "/Product/ProductPage";
	}
	
	
	@GetMapping("/productimg")
	public String editimg(HttpSession session){
		System.out.println("in edit product");
        ProductDao pd=new ProductDao();
        session.setAttribute("Product_Details",service.getProductDetail());
		//List<Product> prod=pd.ProductDetail();
		return "/Product/image";
	}


	@GetMapping("/search")
	public String searchProduct(@RequestParam String search ,HttpSession session)
	{
		
		List <Product> product=service.searchProduct(search);
        session.setAttribute("All_Product",product);

		return "/Product/SiteHome";
	}
}
