package com.app.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.pojos.Cart;
import com.app.pojos.Customer;
import com.app.pojos.CustomerAddress;
import com.app.pojos.Ordertable;
import com.app.pojos.Payment;
import com.app.pojos.Product;

@Repository
public class CartDao implements ICartDao {
	@PersistenceContext
	private EntityManager mgr;

	@Override
	public String addToCart(int id, int user) {

		System.out.println("In add to cart -> 1 ");
		Customer customer = mgr.find(Customer.class, user);
		System.out.println("In add to cart -> 2 ");

		Product product = mgr.find(Product.class, id);
		System.out.println("In add to cart -> 3 ");

		Cart cart = new Cart(product.getManufactureName(), 1, product.getSellingPrice(), customer.getCustomerId(),
				product.getProductId(), product.getColor(), product.getRam(), product.getInternalStorage());
		mgr.persist(cart);

		System.out.println("In add to cart -> 4 ");
		return "true";
	}

	@Override
	public boolean removeFromCart(int id) {
		Cart cart = mgr.find(Cart.class, id);
		try {
			System.out.println("in remove from cart try " + id);
			mgr.remove(cart);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("in remove from cart catch");
		}
		return false;
	}

	@Override
	public List<Cart> getCart(int id) {
		/* String jpql="Select u from Cart u where user_id :=para1"; */
		String jpql = "Select u from Cart u where user_id =" + id;

		List<Cart> cart = mgr.createQuery(jpql, Cart.class).getResultList();

		return cart;
	}

	@Override
	public List<CustomerAddress> getCustomerAddress(int id) {
		String jpql = "Select u from CustomerAddress u where u.userId=" + id;
		return mgr.createQuery(jpql, CustomerAddress.class).getResultList();
	}

	@Override
	public String processOrder(int customerId, String address, String cardNumber, String cardExpiry,
			String cardCVC, String cardHolderName) {
		try {
			System.out.println("------> in process order Dao  -> 1");
			System.out.println("customerId" + customerId);

			CustomerAddress add = mgr.find(CustomerAddress.class, Integer.parseInt(address));
			System.out.println("------> in process order Dao  -> 1.1");
			String createAddress = add.getFullName() + ", " + add.getMobile() + ", " + add.getPinCode() + ", "
					+ add.getFlat() + ", " + add.getArea() + ", " + add.getState() + ", " + add.getCountry() + ", "
					+ add.getLandmark();
			Payment pay;
			System.out.println("createAddress" + createAddress);

			pay = new Payment(Integer.parseInt(cardNumber), cardHolderName, Integer.parseInt(cardCVC), cardExpiry,
					customerId);
			System.out.println("1");
			mgr.persist(pay);
			System.out.println("2");

			List<Cart> ca = getCart(customerId);
			for (Cart c : ca) {
				// Ordertable order;
				System.out.println("------> in process order Dao  -> 2   " + c.getProduct_id());

				Product pro = mgr.find(Product.class, c.getProduct_id());

				System.out.println("------> in process order Dao  -> 3");

				String payDetails = cardHolderName + ", " + cardNumber + ", " + cardExpiry;
				// Order

				System.out.println("------> in process order Dao  -> 4");
				Date date = new Date();

				Ordertable order = new Ordertable(createAddress, payDetails, customerId, pro.getSellerIdFk(),
						pro.getProductId(), c.getPrice(), c.getQuantity(), date);
				mgr.persist(order);

				removeFromCart(c.getCartID());

			}

		} catch (Exception e) {
			System.out.println("------> in process order Dao catch");

			e.printStackTrace();
		}

		return "";
	}

}
