package com.ensat.services;

import com.ensat.entities.Category;
import com.ensat.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository catRepo;

    public List<Category> listAll() {
        return catRepo.findAll();
    }

    public Category save(Category category) {
        return catRepo.save(category);
    }

    public Category get(Integer cID) {
        return catRepo.findById(cID).orElse(null);
    }

    public void delete(Integer cID) {
        catRepo.deleteById(cID);
    }
}
