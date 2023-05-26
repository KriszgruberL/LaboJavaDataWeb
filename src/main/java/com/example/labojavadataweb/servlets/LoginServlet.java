package com.example.labojavadataweb.servlets;

import com.example.labojavadataweb.models.dtos.ConnectedUserDTO;
import com.example.labojavadataweb.models.entities.User;
import com.example.labojavadataweb.models.exceptions.InvalidPasswordUserException;
import com.example.labojavadataweb.models.forms.UserLoginForm;
import com.example.labojavadataweb.models.forms.UserRegisterForm;
import com.example.labojavadataweb.services.UserService;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "login", urlPatterns = "/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {


    @Inject
    private UserService userService;

    @Override
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("login", "");
        request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserLoginForm userForm = new UserLoginForm(login,email, password);

        try {
            User user = userService.login(userForm.toEntity());
            request.getSession(true).setAttribute("connectedUser", ConnectedUserDTO.fromEntity(user));
            response.sendRedirect(request.getContextPath() + "/");
            return;
        } catch (EntityNotFoundException e){
            request.setAttribute("errorMessage","Login non valide");
        } catch (InvalidPasswordUserException e){
            request.setAttribute("errorMessage","Password non valide");
        } catch (RuntimeException e){
            request.setAttribute("errorMessage","Veuillez réessayer");
        }
        request.setAttribute("login", login);
        request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);

    }
}