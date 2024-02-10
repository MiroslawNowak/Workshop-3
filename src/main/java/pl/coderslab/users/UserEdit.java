package pl.coderslab.users;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserEdit", value = "/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = new UserDao();
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDao.read(id);

        request.setAttribute("userId", user.getId());
        request.setAttribute("userName", user.getUserName());
        request.setAttribute("userEmail", user.getEmail());
        request.setAttribute("userPassword", user.getPassword());

        request.getRequestDispatcher("/users/edit.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");

        User user = new User(userId, userName, userEmail, userPassword);
        UserDao userDao = new UserDao();
        userDao.update(user);

        response.sendRedirect(request.getContextPath() + "/user/list");

    }
}
