package com.example.boilerplate.BoilerPlate.controller;

import com.example.boilerplate.BoilerPlate.entity.Product;
import com.example.boilerplate.BoilerPlate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AjaxController {

    @Autowired
    private ProductService productService;

    @GetMapping("/items/list")
    @ResponseBody
    public List<Product> getItems() {
    	return productService.findAll();
    }
    
    @GetMapping("/ajax")
    public String listProducts(Model model) {
        return "item-form";
    } 
    
    @PostMapping("/ajax/add")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> saveProduct(@RequestBody Product product) {
        productService.save(product);
        List<Product> products = productService.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Data added");
        response.put("products", products);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/ajax/{id}")
    public ResponseEntity<Map<String, Object>> deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        List<Product> products = productService.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Product deleted");
        response.put("products", products);
        return ResponseEntity.ok(response);
    }
}
