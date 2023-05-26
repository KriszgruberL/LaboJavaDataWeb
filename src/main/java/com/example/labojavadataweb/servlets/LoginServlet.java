package com.example.labojavadataweb.servlets;

import com.example.labojavadataweb.models.dtos.ConnectedUserDTO;
import com.example.labojavadataweb.models.entities.User;
import com.example.labojavadataweb.models.exceptions.InvalidPasswordUserException;
import com.example.labojavadataweb.models.forms.UserLoginForm;
import com.example.labojavadataweb.models.forms.UserRegisterForm;
import com.example.labojavadataweb.services.UserService;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet(name = "login", urlPatterns = "/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {


    protected EntityManagerFactory emf;
    protected EntityManager em;
    @Inject
    private UserService userService;

    @Override
    public void init() {
        this.emf = Persistence.createEntityManagerFactory("LaboJavaDataWeb");
        this.em = emf.createEntityManager();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("login", "");
        request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserLoginForm userForm = new UserLoginForm(login, password);

        // Verify the entered credentials
        if (authenticateUser(username, password)) {
            // Successful login
            response.getWriter().println("Login successful!");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            // Invalid credentials
            response.getWriter().println("Invalid login or password");
            request.setAttribute("login", login);
            request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
        }

        //TODO login servlet using jpa with password using bcrypt to db

    }

    private boolean authenticateUser(String login, String password) {
        boolean authenticated = false;


        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :identifier OR u.email = :identifier", User.class);
        query.setParameter("identifier", login);
        List<User> users = query.getResultList();

        if (!users.isEmpty()) {
            User user = users.get(0);

            // Verify the entered password against the hashed password using bcrypt
            if (BCrypt.checkpw(password, user.getPassword())) {
                authenticated = true;
            }
        }


        return authenticated;
    }
}