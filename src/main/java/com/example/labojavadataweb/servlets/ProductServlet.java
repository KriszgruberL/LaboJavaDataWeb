package com.example.labojavadataweb.servlets;

import com.example.labojavadataweb.models.dtos.ProductDTO;
import com.example.labojavadataweb.services.ProductService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "product", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    @Inject
    ProductService productService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<ProductDTO> product = productService.getMany()
                .stream()
                .map(ProductDTO::fromEntity)
                .collect(Collectors.toList());

        request.setAttribute("product", product);
        request.getRequestDispatcher("WEB-INF/pages/product.jsp").forward(request,response);
    }
}