package pl.coderslab.users;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserShow", value = "/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new UserDao().read(Integer.parseInt(request.getParameter("id")));

        request.setAttribute("userId", user.getId());
        request.setAttribute("userName", user.getUserName());
        request.setAttribute("userEmail", user.getEmail());

        request.getRequestDispatcher("/users/show.jsp").forward(request, response);
    }
}
