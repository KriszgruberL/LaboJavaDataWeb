package com.example.labojavadataweb.servlets;

import com.example.labojavadataweb.models.entities.Product;
import com.example.labojavadataweb.models.forms.ProductForm;
import com.example.labojavadataweb.services.ProductService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@WebServlet(name = "addProduct", urlPatterns = "/addProduct")
@MultipartConfig
public class AddProductServlet extends HttpServlet {

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

        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");

        String productPriceStr = request.getParameter("productPrice");
        BigDecimal productPrice = null;
        if (productPriceStr != null) {
            productPrice = new BigDecimal(productPriceStr);
        }
//        BigDecimal productPrice = new BigDecimal(request.getParameter("productPrice"));
        String productEra = request.getParameter("era");
        String productType = request.getParameter("type");
        Part filePart = request.getPart("imageUpload");
        String fileName = generateUniqueFileName(filePart);
        String filePath = "C:\\Users\\studentdev02\\Desktop\\Technifutur\\Java\\JavaData-JavaWeb\\LaboJavaDataWeb\\src\\main\\webapp\\img\\" + fileName;

        try (InputStream fileContent = filePart.getInputStream()) {
            Files.copy(fileContent, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        }

        ProductForm productForm = new ProductForm(productName, productDescription, productPrice,productEra,productType,filePath);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<ProductForm>> constraints = validator.validate(productForm);

        if(constraints.size() > 0){
            for (ConstraintViolation<ProductForm> constraint : constraints){
                if(constraint.getPropertyPath().toString().equals("productName") ){
                    request.setAttribute("nameError", constraint.getMessage());
                }
                if(constraint.getPropertyPath().toString().equals("productDescription") ){
                    request.setAttribute("descriptionError", constraint.getMessage());
                }
                if(constraint.getPropertyPath().toString().equals("productPrice") ){
                    request.setAttribute("priceError", constraint.getMessage());
                }
                if(constraint.getPropertyPath().toString().equals("era") ){
                    request.setAttribute("eraError", constraint.getMessage());
                }
                if(constraint.getPropertyPath().toString().equals("type") ){
                    request.setAttribute("typeError", constraint.getMessage());
                }
                if(constraint.getPropertyPath().toString().equals("imageUrl") ){
                    request.setAttribute("imageUrlError", constraint.getMessage());
                }
                System.out.printf("%s.%s %s %n",constraint.getRootBeanClass().getSimpleName(), constraint.getPropertyPath(), constraint.getMessage());
            }
            request.setAttribute("productName",productName);
            request.setAttribute("productDescription", productDescription);
            request.setAttribute("productPrice", productPrice);
            request.setAttribute("era", productEra);
            request.setAttribute("type", productType);
            request.setAttribute("filePath", filePath);

            request.getRequestDispatcher("/WEB-INF/pages/product.jsp").forward(request, response);
        } else {
            Product product = productService.add(productForm);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

    private String generateUniqueFileName(Part filePart) {
        String originalFileName = filePart.getSubmittedFileName();
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String uniqueFileName = UUID.randomUUID().toString() + extension;
        return uniqueFileName;
    }
}