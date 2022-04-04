package com.crud.mvc.controllers;


import com.crud.mvc.models.Category;
import com.crud.mvc.models.Product;
import com.crud.mvc.repository.CategoryRepository;
import com.crud.mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping(path = "products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/{categoryID}", method = RequestMethod.GET)
    public String getProducts(ModelMap modelMap, @PathVariable String categoryID){
        Iterable<Product> products = productRepository.findProductByCategoryID(categoryID);
        modelMap.addAttribute("products", products);
        return "views/product";

    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(ModelMap modelMap){
        Iterable<Category> categories = categoryRepository.findAll();
        Product product = new Product();
        modelMap.addAttribute("categories", categories);
        modelMap.addAttribute("product", product);
        return "views/formproduct";
    }


    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public String store(Product product , BindingResult result){
        if(result.hasErrors()){
            return "views/formproduct";
        }
        productRepository.save(product);
        return "redirect:/products/" + product.getCategoryID();
    }

    @RequestMapping(value = "/delete/{productID}" , method = RequestMethod.GET)
    public String delete(@PathVariable String productID){
      Product product = productRepository.findById(productID).orElseThrow(() -> new IllegalArgumentException("Invalid product ID" + productID));
      productRepository.delete(product);
      return "redirect:/products/" + product.getCategoryID();
    }

}
