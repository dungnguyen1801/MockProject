
package control;

import dao.CaseDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;


public class LoginControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != "" || request.getSession().getAttribute("user") != null) {
            request.getSession().setAttribute("login_message", "");
            response.sendRedirect("index.jsp");
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String account = request.getParameter("username");
            String password = request.getParameter("password");
            User result = new UserDAO().getUserAccount(account, password);
            if (result != null) {
                request.getSession().setAttribute("uid", result.getId());
                request.getSession().setAttribute("user", account);
                request.getSession().setAttribute("role", result.getRole());
                request.getSession().setAttribute("login_message", "");
                new CaseDAO().getCase(result.getId(), result.getUsername()+"_case");
                if (result.getRole() == 1) {
                    response.sendRedirect("home1.jsp");
                } else {
                    response.sendRedirect("home.jsp");
                }

            } else {
                request.getSession().setAttribute("login_message", "Login failed! Check your username or password and try again!");
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
            request.getSession().setAttribute("login_message", "Login failed! Check your username or password and try again!");
            response.sendRedirect("index.jsp");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
