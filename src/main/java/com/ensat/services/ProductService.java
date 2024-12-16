package com.ensat.services;

import com.ensat.Exception.ResourceNotFoundException;
import com.ensat.entities.Category;
import com.ensat.entities.Product;
import com.ensat.repositories.CategoryRepository;
import com.ensat.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository repo;
    public List<Product> listAll() {
        return  repo.findAll();
    }
    public void  save (Product product) {
        repo.save(product);
    }
    public  Product get(Integer pID) {
        return  repo.findById(pID).orElse(null);
    }
    public void  delete ( Integer pID) {
        Product byId = repo.findById(pID).orElseThrow(()->new ResourceNotFoundException(+pID+"from this product id product not found"));
        repo.deleteById(pID);
    }

    public List<Product> findProductBycCategoryId(Integer cID) {
        return repo.findProductBycCategoryId(cID);
    }
    public List<Product> findByName(String name) {
        return this.repo.findByNameContainingIgnoreCase(name);
    }
    public Product getProductById(Integer pID) {
        Optional<Product> optionalProduct = repo.findById(pID);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        else { return null; }
    }
}

