import java.time.LocalDate;
import java.util.List;

import controller.CustomerHelper;
import controller.OrderDetailsHelper;
import model.Customer;
import model.OrderDetails;

/**
 * @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Feb 24, 2022
 */

public class OrderDetailsTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer cameron = new Customer("Cameron"); //My best friend's son is named Cameron!
		
		CustomerHelper ch = new CustomerHelper();
		ch.insertCustomer(cameron);
		
		OrderDetailsHelper odh = new OrderDetailsHelper();
		OrderDetails cameronOrder = new OrderDetails("Cameron's Drink Order", LocalDate.now(), cameron);
		
		odh.insertNewOrderDetails(cameronOrder);
		
		List<OrderDetails> allOrders = odh.getOrders();
		
		for(OrderDetails a : allOrders) {
			System.out.println(a.toString());
		}
		
	}

}
