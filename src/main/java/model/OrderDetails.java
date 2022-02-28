/**
 * @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Feb 24, 2022
 */

package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrderDetails {
	@Id
	@GeneratedValue
	private int number;
	private String listName;
	private LocalDate orderDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Customer customer;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<OrderList> listOfDrinks;

	public OrderDetails() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public OrderDetails(String listName, LocalDate orderDate, Customer customer) {
		super();
		this.listName = listName;
		this.orderDate = orderDate;
		this.customer = customer;
	}
	
	public OrderDetails(String listName, LocalDate orderDate, Customer customer, List<OrderList> listOfDrinks) {
		super();
		this.listName = listName;
		this.orderDate = orderDate;
		this.customer = customer;
		this.listOfDrinks = listOfDrinks;
	}
	
	public OrderDetails(int number, String listName, LocalDate orderDate, Customer customer, List<OrderList> listOfDrinks) {
		super();
		this.number = number;
		this.listName = listName;
		this.orderDate = orderDate;
		this.customer = customer;
		this.listOfDrinks = listOfDrinks;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderList> getListOfDrinks() {
		return listOfDrinks;
	}

	public void setListOfDrinks(List<OrderList> listOfDrinks) {
		this.listOfDrinks = listOfDrinks;
	}

	@Override
	public String toString() {
		return "ListDetails [number=" + number + ", listName=" + listName + ", tripDate=" + orderDate + ", customer=" + customer
				+ "]";
	}
}
