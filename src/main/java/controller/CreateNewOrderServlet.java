package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.OrderDetails;
import model.OrderList;

/**
 * Servlet implementation class CreateNewOrderServlet
 */
@WebServlet("/createNewOrderServlet")
public class CreateNewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderHelper oh = new OrderHelper();
		String orderName = request.getParameter("orderName");
		System.out.println("Order name: " + orderName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String customerName = request.getParameter("customerName");
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}
		catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String [] selectedDrinks = request.getParameterValues("allDrinksToAdd");
		List<OrderList> selectedDrinksInOrder = new ArrayList<OrderList>(); 
		
		if (selectedDrinks != null && selectedDrinks.length > 0) {
			for (int i = 0; i < selectedDrinks.length; i++) {
				System.out.println(selectedDrinks[i]);
				OrderList c = oh.searchDrinkByNum(Integer.parseInt(selectedDrinks[i]));
				selectedDrinksInOrder.add(c);
			}
		}
		
		Customer customer = new Customer(customerName);
		OrderDetails cod = new OrderDetails(orderName, ld, customer);
		
		cod.setListOfDrinks(selectedDrinksInOrder);
		OrderDetailsHelper coh = new OrderDetailsHelper();
		coh.insertNewOrderDetails(cod);
		
		System.out.println("Order Completed");
		System.out.println(cod.toString());
		
		getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
