package com.example.Shop.Management.Service;

import com.example.Shop.Management.Model.Category;
import com.example.Shop.Management.Model.Product;
import com.example.Shop.Management.Repository.CategoryRepository;
import com.example.Shop.Management.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryrepository;

    public Category save(Category category){
        return categoryrepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryrepository.findAll();
    }

    public Optional<Category> findcategorybyid(int id){
        return categoryrepository.findById(id);
    }
    public Category updateCategory(Category category,int id){
        Category category1= findcategorybyid(id).get();
        if(category.getName()!=null)category1.setName(category.getName());

        if(category.getDescription()!=null)category1.setDescription(category.getDescription());
        return categoryrepository.save(category1);
    }

    public List<Category> getCategoryByField(Category category){

         if(category.getDescription()!=null && category.getName()!=null)
            return categoryrepository.findByNameAndDescription(category.getName(), category.getDescription());
        else if(category.getName()!=null) {
            return categoryrepository.findByName(category.getName());
        }
        else if(category.getDescription()!=null)
            return categoryrepository.findByDescription(category.getDescription());


           return null;
    }

    public String deleteById(int id) {
        if (categoryrepository.existsById(id)) {
            categoryrepository.deleteById(id);
            return " Category deleted ";
        } else
            return "Id does not exist";
    }



}
