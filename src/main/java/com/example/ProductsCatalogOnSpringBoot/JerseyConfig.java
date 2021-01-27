package com.example.ProductsCatalogOnSpringBoot;

import com.example.ProductsCatalogOnSpringBoot.controller.ProductsController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

//@Component //для jersey
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig()
    {
        register(ProductsController.class);
    }
}
