package com.example.ProductsCatalogOnSpringBoot.controller;

import com.example.ProductsCatalogOnSpringBoot.model.Products;
import com.example.ProductsCatalogOnSpringBoot.repository.ProductsRepository;
import com.example.ProductsCatalogOnSpringBoot.util.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
