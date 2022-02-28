import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.CustomerHelper;
import controller.OrderDetailsHelper;
import model.Customer;
import model.OrderDetails;
import model.OrderList;

/**
 * @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Feb 24, 2022
 */

public class CustomerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer suze = new Customer("Suzette");
		CustomerHelper ch = new CustomerHelper();
		ch.insertCustomer(suze);
		
		Customer dan = new Customer("Daniel");
		ch.insertCustomer(dan);
		
		Customer em = new Customer("Emma");
		ch.insertCustomer(em);
		
		Customer cameron = new Customer("Cameron");
		OrderDetailsHelper odh = new OrderDetailsHelper();
		OrderList hc = new OrderList("Cameron", "Hot Cocoa");
		OrderList smoothie = new OrderList("Cameron", "Fruit Smoothie");
		List<OrderList> cameronsOrderList = new ArrayList<OrderList>();
		cameronsOrderList.add(hc);
		cameronsOrderList.add(smoothie);
		OrderDetails cameronsOrder = new OrderDetails("Cameron's Drink orders", LocalDate.now(), cameron);
		cameronsOrder.setListOfDrinks(cameronsOrderList);
		odh.insertNewOrderDetails(cameronsOrder);
		List<OrderDetails> allOrders = odh.getOrders();
		for(OrderDetails a: allOrders) {
			System.out.println(a.toString());
		}
		
		
		List<Customer> allCustomers = ch.showAllCustomers();
		
		for(Customer a: allCustomers) {
			System.out.println(a.toString());
		}
	}

}
