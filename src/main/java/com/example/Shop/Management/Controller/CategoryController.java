package com.example.Shop.Management.Controller;

import com.example.Shop.Management.Model.Category;
import com.example.Shop.Management.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/category","/categories"})
public class CategoryController {

    @Autowired
    private CategoryService categoryservice;

    @PostMapping("/add-category")
    public Category save(@RequestBody Category category){
        return categoryservice.save(category);
    }


    @PostMapping("/{id}")
    public Category updateCategory(@PathVariable int id,@RequestBody Category category){
        Category updatedcategory = categoryservice.updateCategory(category,id);
        return updatedcategory;
    }

    @GetMapping("/")
    public List<Category> getCategoryByField(@RequestBody(required = false) Category category){
        System.out.println(category);
       if(category==null){
            return categoryservice.getAllCategories();
        }

       return categoryservice.getCategoryByField(category);

    }

    @PostMapping("delete/{id}")
    public String deleteCategoryById(@PathVariable Integer id){
        return categoryservice.deleteById(id);
    }
 }
