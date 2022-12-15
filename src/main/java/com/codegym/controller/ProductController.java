package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public ModelAndView index() {
        List<Product> products = productService.findAll();
        return new ModelAndView("index", "products", products);
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("create", "product",new Product());
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes requestAttribute) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        requestAttribute.addFlashAttribute("success", "product has been added successfully!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id) {
        Product p = productService.findById(id);
        return new ModelAndView("edit", "product",p);
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("success", "product has been edited successfully!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable int id) {
        Product p = productService.findById(id);
        return new ModelAndView("delete", "product",p);
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success", "product has been removed successfully!");
        return "redirect:/products";
    }

    @GetMapping ("/{id}/view")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("view", "product", productService.findById(id));
    }
}
