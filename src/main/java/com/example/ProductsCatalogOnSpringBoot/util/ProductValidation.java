package com.example.ProductsCatalogOnSpringBoot.util;


import com.example.ProductsCatalogOnSpringBoot.model.Products;
import com.example.ProductsCatalogOnSpringBoot.repository.ProductsRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductValidation implements Validator {

    private final ProductsRepository repository;

    public ProductValidation(ProductsRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Products.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Products newProduct = (Products) target;
        String name = newProduct.getName();
        if (repository.findOneProductsByName(name) != null) {
            errors.rejectValue(
                    "name", "","This name is already in use"
            );
        }

    }
}
