package com.movie.view;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.movie.model.MovieItem;
@WebServlet(name = "ListLibraryServlet", urlPatterns = {"/list_library.view"})
public class ListLibraryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            List<MovieItem> movies = new ArrayList<>();
            movies.add(new MovieItem("Spiderman No Way Home", "2022", "Action"));
            movies.add(new MovieItem("Avengers", "2022", "Action"));
            movies.add(new MovieItem("Maleficient", "2022", "Action"));

            out.println("<html>");
            out.println("<head>");
            out.println("<title>ListLibraryServlet</title>");
            out.println("</head>");
            out.println("<body bgcolor='white'>");
            out.println("You currently have <b>" + movies.size() + "</b> Movies in your collection:<br>");
            out.println("<table border='0' cellspacing='0' cellpadding='5'>");
            out.println("<tr>");
            out.println("<th>TITLE</th>");
            out.println("<th>YEAR</th>");
            out.println("<th>GENRE</th>");
            out.println("</tr>");

            Iterator<MovieItem> it = movies.iterator();
            while (it.hasNext()) {
                MovieItem item = it.next();
                out.println("<tr>");
                out.println("<td>" + item.getTitle() + "</td>");
                out.println("<td>" + item.getYear() + "</td>");
                out.println("<td>" + item.getGenre() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("End of list...");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}