package com.example.metaversestudyback.controller;

import com.example.metaversestudyback.model.Task;
import com.example.metaversestudyback.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.metaversestudyback.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@RestController
@RequestMapping(path = "/api")
public class CategoryController {
    private CategoryService categoryService;
    private static final Logger LOGGER = Logger.getLogger(CategoryController.class.getName());

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // get all categories
    // http://localhost:9092/api/user/{userId}/types
    @GetMapping("/categories")
    public List<Category> getCategories() {
        LOGGER.info("calling getCategories method from controller");
        return categoryService.getCategories();
    }

    // get category
    // http://localhost:9092/api/user/{userId}/types/{typeid}
    @GetMapping(path = "/categories/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId) {
        LOGGER.info("calling getCategory method from controller");
        return categoryService.getCategory(categoryId);
    }

    //create category
    //http://localhost:9092/api/{userId}/types
    @PostMapping(path = "/categories")
    public Category createCategory(@RequestBody Category categoryObject) {
        LOGGER.info("calling createCategory method from controller");
        return categoryService.createCategory(categoryObject);
    }

    // update category
    // http://localhost:9092/{userId}/types/{typeid}
    @PutMapping(path = "/categories/{categoryId}")
    public Category updateCategory(@PathVariable(value = "categoryId") Long categoryId, @RequestBody Category categoryObject) {
        LOGGER.info("calling updateCategory method from controller");
        return categoryService.updateCategory(categoryId, categoryObject);
    }

    //delete category
    // http://localhost:9092/api/{userId}/types/{typeid}
    @DeleteMapping("/categories/{categoryId}")
    public Category deleteCategory(@PathVariable(value = "categoryId") Long categoryId) {
        LOGGER.info("calling deleteCategory method from controller");
        return categoryService.deleteCategory(categoryId);
    }

    // get all tasks
    // http://localhost:9092/api/{userId}/types/{typeid}/resources
    @GetMapping(path = "/categories/{categoryId}/tasks")
    public List<Task> getCategoryItems(@PathVariable(value = "categoryId") Long categoryId) {
        LOGGER.info("calling getCategoryItems method from controller");
        return categoryService.getCategoryItems(categoryId);
    }

    // get task
    // http://localhost:9092/api/{userId}/types/{typeid}/resources/{resourcesid}
    @GetMapping(path = "/categories/{categoryId}/tasks/{taskId}")
    public Task getCategoryTask(@PathVariable(value = "categoryId") Long categoryId,
                                @PathVariable(value = "taskId") Long taskId) {
        LOGGER.info("calling getCategoryTask method from controller");
        return categoryService.getCategoryTask(categoryId, taskId);
    }

    //create task
    // http://localhost:9092/api/user/{userId}/types/{typeid}/resources
    @PostMapping("/categories/{categoryId}/tasks")
    public Task createCategoryItem(
            @PathVariable(value = "categoryId") Long categoryId,
            @RequestBody Task taskObject) {
        LOGGER.info("calling createCategoryItem method from controller");
        return categoryService.createCategoryItem(categoryId, taskObject);
    }

    //update task
    // http://localhost:9092/api/{userId}/types/{typeid}/resources/{resourcesid}
    @PutMapping(path = "/categories/{categoryId}/tasks/{taskId}")
    public Task updateCategoryTask(@PathVariable(value = "categoryId") Long categoryId,
                                   @PathVariable(value = "itemId") Long taskId,
                                   @RequestBody Task taskObject) {
        LOGGER.info("calling updateCategoryTask method from controller");
        return categoryService.updateCategoryTask(categoryId, taskId, taskObject);
    }

    // delete task
    // http://localhost:9092/api/{userId}/types/{typeid}/resources/{resourcesid}
    @DeleteMapping(path = "/categories/{categoryId}/tasks/{taskId}")
    public Task deleteCategoryTask(@PathVariable(value = "categoryId") Long categoryId,
                                   @PathVariable(value = "taskId") Long taskId) {
        LOGGER.info("calling deleteCategoryTask method from controller");
        return categoryService.deleteCategoryTask(categoryId, taskId);
    }
}
