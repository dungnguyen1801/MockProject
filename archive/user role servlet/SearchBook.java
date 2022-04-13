package control;

import dao.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;

public class SearchBook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = (String) request.getParameter("type");
        if (type == null) {
            response.sendRedirect("searchbook.jsp");
        } else {
            switch (type) {
                case "name":
                    request.setAttribute("search_type", "name");
                    break;
                case "author":
                    request.setAttribute("search_type", "author");
                    break;
                case "category":
                    request.setAttribute("search_type", "category");
                    break;
                default:
                    request.setAttribute("search_type", null);
            }
            request.getRequestDispatcher("searchbook.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = (String) request.getParameter("type");
        try {
            if (type == null) {
                response.sendRedirect("searchbook.jsp");
            } else {
                String sr = request.getParameter("content");
                ArrayList<Book> result = new ArrayList<>();
                int size = 0;
                switch (type) {
                    case "name":
                        result = new BookDAO().getBookByName(sr);
                        request.setAttribute("book_list", result);
                        size = result.size();
                        request.setAttribute("total_result", size != 0 ? "About " + size + " value(s) for book named '" + sr + "':" : "There is no resultfor book named '" + sr + "'!");
                        break;
                    case "author":
                        result = new BookDAO().getBookByAuthor(sr);
                        request.setAttribute("book_list", result);
                        size = result.size();
                        request.setAttribute("total_result", size != 0 ? "About " + size + " value(s) for book written by '" + sr + "':" : "There is no resultfor book written by '" + sr + "'!");
                        break;
                    case "category":
                        result = new BookDAO().getBookByCategory(sr);
                        request.setAttribute("book_list", result);
                        size = result.size();
                        request.setAttribute("total_result", size != 0 ? "About " + size + " value(s) for book categoried '" + sr + "':" : "There is no resultfor book categoried '" + sr + "'!");
                        break;
                    default:
                        request.setAttribute("search_type", null);
                }
                request.getRequestDispatcher("searchresult.jsp").forward(request, response);
            }
        } catch (Exception e) {
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
