
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogoutControl extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.getSession().invalidate();
       response.sendRedirect("index.jsp");
       return;
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.getSession().invalidate();
       response.sendRedirect("index.jsp");
       return;
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
