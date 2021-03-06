
package servlets;

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
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
               
        if(u == null){
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
            return;
        }else{
            request.setAttribute("u", u);
            String logout = request.getParameter("logout");
                    
            try{
                if(logout.equals("logout")){
                    session.setAttribute("logout", logout);
                    /*getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(request, response);*/
                    response.sendRedirect("login");
                }
            }catch(Exception e){
                getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                    .forward(request, response);
            }
          
        }
   
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
