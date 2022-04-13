package control;

import dao.BookDAO;
import dao.CaseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

public class EditBookCase extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = (String) request.getParameter("action");
        if (type == null) {
            response.sendRedirect("editbookcase.jsp");
        } else {
            switch (type) {
                case "add":
                    request.setAttribute("edit_type", "add");
                    break;
                case "remove":
                    request.setAttribute("edit_type", "remove");
                    break;
                case "clear":
                    request.setAttribute("edit_type", "clear");
                    break;
                default:
                    request.setAttribute("edit_type", null);
            }
            request.getRequestDispatcher("editbookcase.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = (String) request.getParameter("action");
        try {
            if (type == null) {
                response.sendRedirect("editbookcase.jsp");
            } else {
                String sr = request.getParameter("feild");
                int bookID = Integer.parseInt(sr);
                int user_id = (int) request.getSession().getAttribute("uid");
                boolean result;
                switch (type) {
                    case "add":
                        result = new CaseDAO().addNewBookToCase(user_id, bookID);
                        if (result) {
                            request.setAttribute("bc_message", "Add book to case success!");
                        } else {
                            request.setAttribute("bc_message", "Add book to case failed!");
                        }

                        break;
                    case "remove":
                        result = new CaseDAO().deleteBookFromCase(user_id, bookID);
                        if (result) {
                            request.setAttribute("bc_message", "Remove book from case success!");
                        } else {
                            request.setAttribute("bc_message", "Remove book from case failed!");
                        }
                        break;
                    case "clear":
                        result = new CaseDAO().ClearBookCase(user_id);
                        if (result) {
                            request.setAttribute("bc_message", "Clear case success!");
                        } else {
                            request.setAttribute("bc_message", "Clear case failed!");
                        }
                        break;
                    default:
                        request.setAttribute("bc_message", "");
                }

            }
        } catch (Exception e) {
            request.setAttribute("bc_message", "Failed!" + e.getMessage());
        }
        request.getRequestDispatcher("editbookcase.jsp").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
