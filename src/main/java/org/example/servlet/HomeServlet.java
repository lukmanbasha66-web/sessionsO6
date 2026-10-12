
package org.example.servlet;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);

        if (session == null ||
                session.getAttribute("username") == null) {

            response.sendRedirect("login.html");
            return;
        }

        String username =
                (String) session.getAttribute("username");

        response.setContentType("text/html");

        response.getWriter().println(
                "<html><body>" +
                        "<h2>Welcome, " + username + "!</h2>" +
                        "<p>You are logged in successfully.</p>" +
                        "<a href='profile'>Go to Profile Page</a><br><br>" +
                        "<a href='logout'>Logout</a>" +
                        "</body></html>"
        );
    }
}
