package org.verigo.server.controllers;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.verigo.server.data.entities.Category;
import org.verigo.server.data.repositories.CategoryRepository;
import org.verigo.server.payloads.requests.category.CategoryUpdateRequest;
import org.verigo.server.payloads.responses.category.DeleteResponse;
import org.verigo.server.payloads.responses.category.UpdateResponse;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @PatchMapping(value = "/{id}", produces = "application/json")
    public UpdateResponse updateCategory(@PathVariable int id, @RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        if(!repository.existsById(id)) return new UpdateResponse(id, null, 404, "Категория не найдена.");

        Category category = repository.findById(id).get();
        category.setName(categoryUpdateRequest.getName());
        repository.save(category);

        return new UpdateResponse(id, category.getName(), 200, "Категория успешно изменена.");
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public DeleteResponse deleteCategory(@PathVariable int id) {
        Boolean isPresent = repository.existsById(id);
        if(!isPresent) return new DeleteResponse(404, "Категория не найдена.");
        repository.deleteById(id);
        return new DeleteResponse(200, "Категория удалена.");
    }
}
