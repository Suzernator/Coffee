package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrderDetails;

/**
 * Servlet implementation class OrderNavigationServlet
 */
@WebServlet("/orderNavigationServlet")
public class OrderNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderNavigationServlet() {
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
		String act = request.getParameter("doThisToOrder");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
		}
		
		else if (act.equals("delete")) {
			try {
				Integer tempNum = Integer.parseInt(request.getParameter("number"));
				OrderDetails orderToDelete = dao.searchOrderDetailsByNum(tempNum);
				dao.deleteOrder(orderToDelete);
			}
			catch (NumberFormatException e) {
				System.out.println("Forgot to select a button!");
			}
			finally {
				getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
			}
		}
		
		else if (act.equals("edit")) {
			try {
				Integer tempNum = Integer.parseInt(request.getParameter("number"));
				OrderDetails orderToEdit = dao.searchOrderDetailsByNum(tempNum);
				request.setAttribute("orderToEdit", orderToEdit);
				
				request.setAttribute("month", orderToEdit.getOrderDate().getMonthValue());
				request.setAttribute("day", orderToEdit.getOrderDate().getDayOfMonth());
				request.setAttribute("year", orderToEdit.getOrderDate().getYear());
				
				OrderHelper daoForDrinks = new OrderHelper();
				
				request.setAttribute("allDrinks", daoForDrinks.showAllDrinks());
				
				if(daoForDrinks.showAllDrinks().isEmpty()) {
					request.setAttribute("allDrinks", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-order.jsp").forward(request, response);
			}
			catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
			}
		}
		
		else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-order.html").forward(request, response);	
		}
	}
}
