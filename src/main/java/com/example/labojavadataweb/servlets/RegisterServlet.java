package com.example.labojavadataweb.servlets;

import com.example.labojavadataweb.models.dtos.ConnectedUserDTO;
import com.example.labojavadataweb.models.entities.User;
import com.example.labojavadataweb.models.forms.UserRegisterForm;
import com.example.labojavadataweb.services.UserService;
import com.example.labojavadataweb.services.UserServiceImpl;
import jakarta.inject.Inject;
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

@WebServlet(name = "register", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        UserRegisterForm userForm = new UserRegisterForm(username, email, password, confirmPassword);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<UserRegisterForm>> constraints = validator.validate(userForm);

        if(constraints.size() > 0){
            for (ConstraintViolation<UserRegisterForm> constraint : constraints){
                if(constraint.getPropertyPath().toString().equals("name") ){
                    request.setAttribute("nameError", constraint.getMessage());
                }
                if(constraint.getPropertyPath().toString().equals("email") ){
                    request.setAttribute("emailError", constraint.getMessage());
                }
                if(constraint.getPropertyPath().toString().equals("password") ){
                    request.setAttribute("passwordError", constraint.getMessage());
                }
                System.out.printf("%s.%s %s %n",constraint.getRootBeanClass().getSimpleName(), constraint.getPropertyPath(), constraint.getMessage());
            }
            request.setAttribute("username",username);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);

        } else {
            User user = userService.register(userForm);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

}