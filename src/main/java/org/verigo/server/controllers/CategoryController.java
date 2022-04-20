package org.verigo.server.controllers;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.verigo.server.data.entities.Category;
import org.verigo.server.data.repositories.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository repository;

    @GetMapping(value = "", produces = "application/json")
    public MappingJacksonValue getAllCategoriesPlain() {
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.serializeAll();

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("categoryFilter", simpleBeanPropertyFilter);
        List<Category> categories = repository.findAll();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(categories);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public MappingJacksonValue getCategory(@PathVariable int id) {
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.serializeAll();

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("categoryFilter", simpleBeanPropertyFilter);

        Category category = repository.findById(id).get();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(category);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }
}
