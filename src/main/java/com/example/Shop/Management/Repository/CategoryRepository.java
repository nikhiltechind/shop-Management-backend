package com.example.Shop.Management.Repository;

import com.example.Shop.Management.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {


    List<Category> findByName(String name);
    List<Category> findByDescription(String description);

    List<Category> findByNameAndDescription(String name,String description);



}
