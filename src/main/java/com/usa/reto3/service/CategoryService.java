/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto3.service;

import com.usa.reto3.model.Category;
import com.usa.reto3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nancy
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository metodosCrud;

    public List<Category> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Category> getCategory(int categoryId) {
        return metodosCrud.getCategory(categoryId);
    }

    public Category save(Category categoria) {
        if (categoria.getId() == null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<Category> e = metodosCrud.getCategory(categoria.getId());
            if (e.isEmpty()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }
public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> g = metodosCrud.getCategory(category.getId());
            if (!g.isEmpty()) {
                if (category.getDescription() != null) {
                    g.get().setDescription(category.getDescription());
                }
                if (category.getName() != null) {
                    g.get().setName(category.getName());
                }
                metodosCrud.save(g.get());
                return g.get();

            } else {
                return category;
            }
        } else{
                return category;
            }

    }

 

    public boolean deleteCategory(int categoriaId) {
        Boolean d = getCategory(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
}
