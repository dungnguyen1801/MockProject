/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;

public class CreateBookControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("createbook.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("bid"));
            String author = request.getParameter("bauthor");
            String category = request.getParameter("bcate");
            String brief = request.getParameter("bbrief");
            String content = request.getParameter("bcontent");
            String publisher = request.getParameter("bpublisher");
            String title = request.getParameter("btitle");
            Book b = new Book(id, title, author, brief, publisher, content, category);
            boolean result = new BookDAO().addNewBook(b);
            if (result) {
                 request.setAttribute("create_message", "Add book successfully!");
            }else {
                 request.setAttribute("create_message", "Add book fail!");
            }
           

        } catch (Exception e) {
            request.setAttribute("create_message", "Add book fail!");
        }
        request.getRequestDispatcher("createbook.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
