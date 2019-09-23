

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IWorkWithJSPServlet
 */
@WebServlet("/greetingsServletNew")
public class IWorkWithJSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IWorkWithJSPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String counter = (String) request.getSession().getAttribute("counter");
		if(counter == null) {
			counter = "1";
		}else {
			counter = String.valueOf((Integer.parseInt(counter) + 1));
		}
		request.getSession().setAttribute("counter", counter);
		String greeting = "Hi " + request.getParameter("name") + ". You visited this site " + request.getSession().getAttribute("counter")+ " times";
		request.setAttribute("personalizedGreeting", greeting);
		RequestDispatcher rs = request.getServletContext().getRequestDispatcher("/WEB-INF/NewGreetingsJSP.jsp");  
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
