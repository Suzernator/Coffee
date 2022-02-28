/**
 * @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Feb 24, 2022
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.OrderDetails;

public class OrderDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Coffee");
	
	public void insertNewOrderDetails(OrderDetails c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<OrderDetails> getOrders() {
		EntityManager em = emfactory.createEntityManager();
		List<OrderDetails> allDetails = em.createQuery("SELECT d FROM OrderDetails d").getResultList();
		return allDetails;
	}
	
	public void deleteOrder(OrderDetails ordertoDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<OrderDetails> typedQuery = em.createQuery("select detail from OrderDetails detail where detail.number = :selectedNum", OrderDetails.class);
		
		typedQuery.setParameter("selectedNum", ordertoDelete.getNumber());
		
		typedQuery.setMaxResults(1);
		
		OrderDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateOrder(OrderDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public OrderDetails searchOrderDetailsByNum(Integer tempNum) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		OrderDetails found = em.find(OrderDetails.class, tempNum);
		em.close();
		return found;
	}
}
