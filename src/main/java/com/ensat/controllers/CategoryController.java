package com.ensat.controllers;

import com.ensat.entities.Category;
import com.ensat.entities.Product;
import com.ensat.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/categories")  // http://localhost:8083/categories
@RestController
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/all")
    public ResponseEntity<List<Category>> list() {
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{cID}")
    public ResponseEntity<Category> get(@PathVariable Integer cID) {
        try {
            Category category = service.get(cID);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (NoSuchFieldError e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Category> add(@RequestBody Category category) {
        Category categoryNew = service.save(category);
        System.out.println("Thêm thành công");
        return new ResponseEntity<>(categoryNew, HttpStatus.OK);
    }

    @PutMapping("/update/{cID}")
    public ResponseEntity<Category> updateProduct(@PathVariable Integer cID, @RequestBody Category categoryDetails) {
        Category category = service.get(cID);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category.setCname(categoryDetails.getCname());
        category.setCimage(categoryDetails.getCimage());
        service.save(category);
        System.out.println("Update thành công");

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cID}")
    public   ResponseEntity<Category> delete(@PathVariable Integer cID) {
        service.delete(cID);
        System.out.println("Delete complete");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<Product>> getProductbyCategory(@PathVariable Integer cID) {
        return null;
    }
}

