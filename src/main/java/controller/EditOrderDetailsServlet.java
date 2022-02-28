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
 * Servlet implementation class EditOrderDetailsServlet
 */
@WebServlet("/editOrderDetailsServlet")
public class EditOrderDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrderDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderDetailsHelper dao = new OrderDetailsHelper();
		OrderHelper oh = new OrderHelper();
		CustomerHelper ch = new CustomerHelper();
		
		Integer tempNum = Integer.parseInt(request.getParameter("number"));
		OrderDetails orderToUpdate = dao.searchOrderDetailsByNum(tempNum);
		
		int newOrderNumber = Integer.parseInt(request.getParameter("orderNumber"));
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String customerName = request.getParameter("customerName");
		
		Customer newCustomer = ch.findCustomer(customerName);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}
		catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		try {
			String [] selectedDrinks = request.getParameterValues("allItemsToAdd");
			List<OrderList> selectedDrinksInOrder = new ArrayList<OrderList>();
			
			for (int i = 0; i < selectedDrinks.length; i++) {
				System.out.println(selectedDrinks[i]);
				OrderList c = oh.searchDrinkByNum(Integer.parseInt(selectedDrinks[i]));
				selectedDrinksInOrder.add(c);
			}
			orderToUpdate.setListOfDrinks(selectedDrinksInOrder);
		}
		catch (NullPointerException ex) {
			List<OrderList> selectedDrinksInOrder = new ArrayList<OrderList>();
			orderToUpdate.setListOfDrinks(selectedDrinksInOrder);
		}
		
		orderToUpdate.setNumber(newOrderNumber);
		orderToUpdate.setOrderDate(ld);
		orderToUpdate.setCustomer(newCustomer);
		
		dao.updateOrder(orderToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
	}
}
