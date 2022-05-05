package servletAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import model.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dao.ProductDaoImpl;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDao productDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	productDao = new ProductDaoImpl();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/list": {
				listProduct(request, response);
				break;
			} default:
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Product> listProduct = productDao.selectAllProduct();
		request.setAttribute("listProduct", listProduct);
		RequestDispatcher rd = request.getRequestDispatcher("listProduct.jsp");
		rd.forward(request, response);
	}
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		productDao.deleteProduct(id);
		response.sendRedirect("list");
	}
	
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String Description = request.getParameter("description");
		LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"));
		boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
		Product product = new Product(id, title, name, Description, targetDate, isDone);
		productDao.updateProduct(product);
		response.sendRedirect("list");
	}
	
	private void getProudctEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = productDao.selectProductById(id);
		RequestDispatcher rd = request.getRequestDispatcher("createProduct.jsp");
		request.setAttribute("product", product);
		rd.forward(request, response);
	}
}
