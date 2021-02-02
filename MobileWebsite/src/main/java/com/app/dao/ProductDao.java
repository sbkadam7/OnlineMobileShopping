package com.app.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.pojos.Product;
import com.app.pojos.Seller;
@Repository
public class ProductDao implements IProductDao{
	@PersistenceContext //JPA anno.
	private EntityManager mgr;
	
	
	@Override
	public String addProduct(Product transientProduct,Seller s) {
		String mesg="Product added successfully";
		System.out.println("in Add Product Detail -> 1");

		//s.getProduct().add(transientProduct);
		//mgr.merge(s);
		transientProduct.setSellerIdFk(s.getSellerId());
		mgr.persist(transientProduct);
		//mgr.getTransaction().commit();
		System.out.println("in Add Product Detail -> 2");
		//ProductDetail();
		return mesg;
	}
	@Override
public List<Product> getProductDetail(){
	String jpql="select u from Product u";
	System.out.println("in Product Detail -> product dao");
	
	
	List<Product> p= mgr.createQuery(jpql, Product.class).getResultList();
	System.out.println("in Product Detail -> product dao 2");

	for(Product pa : p) {
		System.out.println("--> " +pa.toString());}
	fileOperation(p);
	return p;
	}


/* fetch product through id*/

public Product getProductByID(int id) {
	String jpql="select u from Product u where u.productId :=para1";
	System.out.println("in getProduct  -> product dao " + id);
	
	Product p= mgr.find(Product.class, id);
			//createQuery(jpql, Product.class).setParameter("para1", id).getSingleResult();
	System.out.println("in Get getProduct  -> product dao 2 " +p.toString());
	
	
	
	
	
	return p;
}

private void fileOperation(List<Product> prod) {
	
	for(Product p:prod)
	{
		  String path="src/main/resources/static/image/productimage/";
		  
		  File file = new
		  File("src\\main\\resources\\static\\image\\productimage\\"+p.getProductId());
		 
		/*
		 * String path="target/classes/resources/static/image/productimage/";
		 * 
		 * File file = new
		 * File("target\\classes\\static\\image\\productimage\\"+p.getProductId());
		 */
		
		if(file.exists()!=true)
			file.mkdir();
		path+=p.getProductId()+"/";
		System.out.println(path);

		  // alternatively, file.getInputStream(); // application logic 
		  try (FileOutputStream stream = new FileOutputStream(path+"front.jpg")) {
			  System.out.println("in try front");

			    stream.write(p.getFrontImage());
			}
		  catch(Exception e)
		  {
			  e.printStackTrace();
			  System.out.println("in catch front");
		  }
		  try (FileOutputStream stream = new FileOutputStream(path+"back.jpg")) {
			  System.out.println("in try back");

			    stream.write(p.getBackImage());
			}
		  catch(Exception e)
		  {
			  System.out.println("in catch back");
		  }
		  try (FileOutputStream stream = new FileOutputStream(path+"bottom.jpg")) {
			  System.out.println("in try bottom");

			    stream.write(p.getBottomImage());
			}
		  catch(Exception e)
		  {
			  System.out.println("in catch bottom");
		  }
		  try (FileOutputStream stream = new FileOutputStream(path+"top.jpg")) {
			  System.out.println("in try top");

			    stream.write(p.getTopImage());
			}
		  catch(Exception e)
		  {
			  System.out.println("in catch top");
		  }
		  try (FileOutputStream stream = new FileOutputStream(path+"leftSide.jpg")) {
			  System.out.println("in try leftSide");

			    stream.write(p.getLeftSideImage());
			}
		  catch(Exception e)
		  {
			  System.out.println("in catch leftSide");
		  }
		  try (FileOutputStream stream = new FileOutputStream(path+"rightSide.jpg")) {
			  System.out.println("in try rightSide");

			    stream.write(p.getRightSideImage());
			}
		  catch(Exception e)
		  {
			  System.out.println("in catch rightSide");
		  }
		  
		
		
	}
}
@Override
public List<Product> searchProduct(String search) {
	
	String jpql="select u from Product u where u.name like '%"+search+"%'";
	System.out.println("in Product searchProduct -> product dao");
	
	
	List<Product> p= mgr.createQuery(jpql, Product.class).getResultList();
	System.out.println("in Product searchProduct -> product dao 2");

	for(Product pa : p) {
		System.out.println("--> " +pa.toString());}
	
	return p;
}

	
}
