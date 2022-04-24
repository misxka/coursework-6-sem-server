package org.verigo.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.verigo.server.data.entities.Category;
import org.verigo.server.data.repositories.CategoryRepository;
import org.verigo.server.payloads.requests.category.CreateRequest;
import org.verigo.server.payloads.requests.category.UpdateRequest;
import org.verigo.server.payloads.responses.category.CreateResponse;
import org.verigo.server.payloads.responses.DeleteResponse;
import org.verigo.server.payloads.responses.category.UpdateResponse;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {
    @Autowired
    private CategoryRepository repository;

    @GetMapping(value = "", produces = "application/json")
    public List<Category> getAllCategoriesPlain() {
        List<Category> categories = repository.findAll();
        return categories;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Category getCategory(@PathVariable int id) {
        Category category = repository.findById(id).get();
        return category;
    }

    @PatchMapping(value = "/{id}", produces = "application/json")
    public UpdateResponse updateCategory(@PathVariable int id, @RequestBody UpdateRequest updateRequest) {
        if(!repository.existsById(id)) return new UpdateResponse(id, null, 404, "Категория не найдена.");

        Category category = repository.findById(id).get();
        category.setName(updateRequest.getName());
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

    @PostMapping(value = "", produces = "application/json")
    public CreateResponse createCategory(@RequestBody CreateRequest createRequest) {
        if(repository.existsByName(createRequest.getName())) return new CreateResponse(null, 400, "Категория с таким именем уже существует.");

        Category category = repository.save(new Category(createRequest.getName()));
        return new CreateResponse(category, 201, "Категория успешно создана.");
    }
}
