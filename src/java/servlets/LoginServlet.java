
package servlets;

import domain.AccountService;
import domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 730676
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String logout = (String) session.getAttribute("logout");
        try{
            if(logout.equals("logout")){
            session.invalidate();
            session = request.getSession();
            String message = "You have successfully logged out";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
            }
        }catch(Exception e){
            response.sendRedirect("home");
        }

        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String username = request.getParameter("user_name");
        String password = request.getParameter("user_pass");
        
        if(username.trim().equals("") || password.trim().equals("")){
            String message = "Invild information";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
            return;
        }else{
            User user = AccountService.login(username, password);
            if(user == null){
                String message = "Invalid login";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
                return;
            }
            
            session.setAttribute("user", user);
            /*getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                    .forward(request, response);*/
            response.sendRedirect("home");
            
        }
        
                
                
        
    }

}
