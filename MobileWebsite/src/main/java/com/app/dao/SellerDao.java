package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.pojos.CustomerAddress;
import com.app.pojos.Ordertable;
import com.app.pojos.Product;
import com.app.pojos.Seller;
import com.app.pojos.SellerAddress;
@Repository
public class SellerDao implements ISellerDao{
	@PersistenceContext //JPA anno.
	private EntityManager mgr;
	@Override
	public String addSeller(Seller transientProduct) {
		String mesg="Seller added successfully";
		mgr.persist(transientProduct);
		return mesg;
	}
	@Override
	public Seller authenticateSeller(String email1, String pwd1) {
		
		
		/*String jpqll="select u from Seller u";
		Seller sl=mgr.createQuery(jpqll, Seller.class).getSingleResult();
		System.out.println("in sellerffffffffffffffffff authenticate seller"+sl.getEmail()+sl.getPassword());
		System.out.println("------------------------------------------------------------------------");

		String jpqlp="select u from Product u";
		System.out.println("in Product Detail -> product dao");
		
		
		List<Product> p= mgr.createQuery(jpqlp, Product.class).getResultList();
		System.out.println("in Product Detail -> product dao 2");

		for(Product pa : p) {
			System.out.println("== "+pa.toString());
		}
		System.out.println("------------------------------------------------------------------------");
*/
		String jpql="select u from Seller u where u.email =:em and u.password=:pa";
		Seller s=mgr.createQuery(jpql, Seller.class).setParameter("em", email1).
				setParameter("pa", pwd1).getSingleResult();
		System.out.println("in seller authenticate seller"+s.getEmail()+s.getPassword());
		return s;
	}
	@Override
	public String addSellerAddress(SellerAddress transientProduct) {
		String mesg="Product added successfully"; 
		//transientProduct.setSeller(null);
		mgr.persist(transientProduct);
		return mesg;
	}
	
	
	@Override
	public String updateSellerProfile(Seller transientProduct) {
		String mesg="Product update successfully"; 
		System.out.println("in update Detail -> product dao" +transientProduct.toString());
		//transientProduct.setSeller(null);
		mgr.merge(transientProduct);		
		return mesg;
	}
	
	@Override
	public List<SellerAddress> getSellerAddress(int id)
	{
		String jpql="Select u from SellerAddress u where u.sellerId="+id;
		
		return mgr.createQuery(jpql,SellerAddress.class).getResultList();
	}
	@Override
	public List<Product> getSellerProduct(int id) {
		String jpql="select u from Product u where u.sellerIdFk="+id;
		System.out.println("in getSellerProduct Detail -> product dao");
		
		
		List<Product> p= mgr.createQuery(jpql, Product.class).getResultList();
		System.out.println("in Product Detail -> product dao 2");

		
		//fileOperation(p);
		return p;
	}
	
	@Override
	public List<Ordertable> getOrderDetails(int sellerId) {
			String jpql="Select u from Ordertable u where u.sellerId="+sellerId;
		
			return mgr.createQuery(jpql,Ordertable.class).getResultList();
		
	}
}
