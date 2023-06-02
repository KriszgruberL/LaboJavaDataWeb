package com.example.labojavadataweb.servlets;

import com.example.labojavadataweb.models.entities.Product;
import com.example.labojavadataweb.services.ProductService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "product", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    @Inject
    ProductService productService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.getMany();
        request.setAttribute("products", products);
        request.getRequestDispatcher("WEB-INF/pages/product.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}