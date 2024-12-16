package com.ensat.controllers;

import com.ensat.entities.Category;
import com.ensat.entities.Product;
import com.ensat.services.CategoryService;
import com.ensat.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products") //http://localhost:8083/products
// báo lỗi CORS thì fix như sau
// *: chấp nhận các đường dẫn FE gọi api
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Product>> list() {
        return new ResponseEntity<>(productService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{pID}")
    public ResponseEntity<Product> get(@PathVariable Integer pID) {
        Product product = productService.get(pID);
        if(product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestParam Integer cID, @RequestBody Product product) {
        Category category = this.categoryService.get(cID);
        product.setCategory(category);
        productService.save(product);
        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/{pID}/{cID}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer pID,
                                                 @PathVariable Integer cID,
                                                 @RequestBody Product productUpdate) {
        Product product = productService.get(pID);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Category category = this.categoryService.get(cID);
        productUpdate.setCategory(category);
        productUpdate.setPID(pID);
        productService.save(productUpdate);
        return new ResponseEntity<>(productUpdate, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{pID}")
    public void delete(@PathVariable Integer pID) {
        productService.delete(pID);
        System.out.println("Delete complete");
    }

    @GetMapping("/search") // http://localhost:8083/products/search?name=..
    public ResponseEntity<List<Product>> searchProductsByName(@RequestParam String name) {
        List<Product> products = productService.findByName(name);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/category/{cID}")
    public ResponseEntity<List<Product>> findByCategoryId(@PathVariable Integer cID) {
        return new ResponseEntity<>(productService.findProductBycCategoryId(cID), HttpStatus.OK);
    }
}

