package control;

import dao.BookDAO;
import dao.CaseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;

public class ViewBookCase extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Book> data = new ArrayList<>();
        try {
            CaseDAO dataAccess = new CaseDAO();
            int user_id = (int) request.getSession().getAttribute("uid");
            data = dataAccess.getListBookOnCase(user_id);
            int total = data.size();
            request.setAttribute("total_message", "Your book case has " + total + " book(s)");
            request.setAttribute("book_list", data);
        } catch (Exception e) {

        }
        request.getRequestDispatcher("viewcase.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
