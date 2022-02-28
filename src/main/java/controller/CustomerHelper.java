/**
 * @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Feb 24, 2022
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Customer;

public class CustomerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Coffee");

	public void insertCustomer(Customer c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public Customer findCustomer(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Customer> typedQuery = em.createQuery("select ch from Customer ch where ch.customerName = :selectedName", Customer.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Customer foundCustomer;
		
		try {
			foundCustomer = typedQuery.getSingleResult();
		}
		catch (NoResultException ex) {
			foundCustomer = new Customer(nameToLookUp);
		}
		
		em.close();
		
		return foundCustomer;
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> showAllCustomers() {
		EntityManager em = emfactory.createEntityManager();
		List<Customer> allCustomers = em.createQuery("SELECT c FROM Customer c").getResultList();
		return allCustomers;
	}

}
