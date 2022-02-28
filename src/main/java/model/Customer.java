/**
 * @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Feb 24, 2022
 */

package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	private String customerName;
	
	public Customer() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Customer(int id, String customerName) {
		super();
		this.id = id;
		this.customerName = customerName;
	}

	public Customer(String customerName) {
		super();
		this.customerName = customerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + "]";
	}
}
