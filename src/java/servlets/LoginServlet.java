
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
        
        String logout = request.getParameter("logout");
        
        if(logout != null){
            session.invalidate();
            session = request.getSession();
            String message = "You have successfully logged out";
            request.setAttribute("message", message);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
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
        }else{
            User user = AccountService.login(username, password);
            //session.setAttribute("user", user);
            if(user == null){
                String message = "Invild user";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
            }else{
                session.setAttribute("user", user);
                //String message = user.getUsername();
                //request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                    .forward(request, response);
            }
        }
        
                
                
        
    }

}
