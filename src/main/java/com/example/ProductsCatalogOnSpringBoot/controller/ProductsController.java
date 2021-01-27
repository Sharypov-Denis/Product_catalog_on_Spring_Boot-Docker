package com.example.ProductsCatalogOnSpringBoot.controller;


import com.example.ProductsCatalogOnSpringBoot.model.Products;
import com.example.ProductsCatalogOnSpringBoot.repository.ProductsRepository;
import com.example.ProductsCatalogOnSpringBoot.util.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Controller
public class ProductsController {

    @Autowired
    private ProductsRepository repository;
    @Autowired
    private ProductValidation productValidation;

    @GetMapping("/")
    public String products(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        List<Products> filterProducts = new ArrayList<>();
        List<Products> productsList;

        if (filter != null && !filter.isEmpty()) {
            productsList = repository.getAll().stream().filter(p -> p.getName().contains(filter)).collect(Collectors.toList());
            System.out.println("тест" + productsList);
        } else {
            productsList = repository.getAll();
        }
        model.addAttribute("products", productsList);
        model.addAttribute("filter", filterProducts);
        System.out.println("тест" + productsList);
        System.out.println("тест" + filterProducts);
        return "products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        repository.delete(id);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create(Products products) {
        return "productForm";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        Products products = repository.get(id);
        model.addAttribute("products", products);
        return "productForm";
    }

    @PostMapping
    public String updateOrCreate(@Valid @ModelAttribute("product") Products products, BindingResult result) {
        if (products.isNew()) {
            productValidation.validate(products, result);
            if (result.hasErrors()) {
                return "productForm";
            }
            repository.save(products);
        } else {
            repository.update(products);
        }
        return "redirect:/";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}

    /*Для реализации отображение через JSP применять следующие методы

      @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        repository.delete(getId(request));
        return "redirect:/";
    }

     @GetMapping("/create")
    public String create(Model model) {
       model.addAttribute("product", new Products("", ""));
        return "productForm";
    }

    @GetMapping("/update")
    public String update(Model model, HttpServletRequest request) {
        model.addAttribute("product", repository.get(getId(request)));
        return "productForm";
    }

     private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
     */
//}
/*
//REST
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

//@RestController///можно без этой аннотации
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "products")
@Path("jersey/")
public class ProductsController {

    @Autowired
    private ProductsRepository repository;
    @Autowired
    private ProductValidation productValidation;

    @GET
    @Produces("application/json")//сериализация, для формата XML - "application/xml"
    public List<Products> getAllUsers() {
        List<Products> productsList = new ArrayList<>();
        productsList = repository.getAll();
        return productsList;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")//сериализация, для формата XML - "application/xml"
    public Response getById(@PathParam("id") int id) throws URISyntaxException {
        Products products = repository.get(id);
        if (products == null) {
            return Response.status(404).build();
        }
        return Response
                .status(200)
                .entity(products)
                .contentLocation(new URI("/user-management/" + id)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Response deleteUser(@PathParam("id") int id) throws URISyntaxException {
        Products products = repository.get(id);
        if (products != null) {
            repository.delete(id);
            return Response.status(200).build();
        }
        return Response.status(404).build();
    }

    @POST
    @Consumes("application/json")//ДЕсериализация, для формата XML - "application/xml"
    public Response create(Products products) throws URISyntaxException {
        if (products.getName() == null || products.getDescription() == null) {
            return Response.status(400).entity("Please provide all mandatory inputs").build();
        }
        repository.save(products);
        return Response.status(201).entity(products).build();
    }

    @PUT
    @Path("/update/{id}")
    @Consumes("application/json")//ДЕсериализация, для формата XML - "application/xml"
    @Produces("application/json")//сериализация, для формата XML - "application/xml"
    public Response update(@PathParam("id") int id, Products products) throws URISyntaxException
    {
        Products newProducts = repository.get(id);
        if(newProducts == null) {
            return Response.status(404).build();
        }
        newProducts.setName(products.getName());
        newProducts.setDescription(products.getDescription());
       repository.update(newProducts);
        return Response.status(200).entity(newProducts).build();
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

}

 */

