package com.example.metaversestudyback.service;

import com.example.metaversestudyback.model.Category;
import com.example.metaversestudyback.model.Task;
import com.example.metaversestudyback.repository.CategoryRepository;
import com.example.metaversestudyback.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;
import com.example.metaversestudyback.exception.InformationExistException;
import com.example.metaversestudyback.exception.InformationNotFoundException;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private TaskRepository taskRepository;
    private static final Logger LOGGER = Logger.getLogger(CategoryService.class.getName());

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Category> getCategories() {
        LOGGER.info("service calling getCategories ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(userDetails.getUser().getId());
//        List<Category> categories = categoryRepository.findByUserId(userDetails.getUser().getId());
//        if (categories.isEmpty()) {
//            throw new InformationNotFoundException("no categories found for user id " + userDetails.getUser().getId());
//        } else {
//            return categories;
//        }
        return categoryRepository.findAll();
    }

    public Optional getCategory(Long categoryId) {
        LOGGER.info("service calling getCategory ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        Category category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
//        if (category != null) {
//            return category;
//        } else {
//            throw new InformationNotFoundException("category with id " + categoryId + " not found");
//        }
        Optional category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            return category;
        } else {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        }
    }

    public Category createCategory(Category categoryObject) {
        LOGGER.info("service calling createCategory ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Category category = categoryRepository.findByUserIdAndName(userDetails.getUser().getId(), categoryObject.getName());
//        if (category != null) {
//            throw new InformationExistException("category with name " + category.getName() + " already exists");
//        } else {
//            categoryObject.setUser(userDetails.getUser());
//            return categoryRepository.save(categoryObject);
//        }
        Category category = categoryRepository.findByName(categoryObject.getName());
        if (category != null) {
            throw new InformationExistException("category with name " + category.getName() + " already exists");
        } else {
            return categoryRepository.save(categoryObject);
        }
    }

    public Category updateCategory(Long categoryId, Category categoryObject) {
        LOGGER.info("service calling updateCategory ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        Category category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            if (categoryObject.getName().equals(category.get().getName())) {
                System.out.println("Same");
                throw new InformationExistException("category " + category.get().getName() + " is already exists");
            } else {
                Category updateCategory = categoryRepository.findById(categoryId).get();
                updateCategory.setName(categoryObject.getName());
                return categoryRepository.save(updateCategory);
            }
        } else {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        }
    }

    public Optional<Category> deleteCategory(Long categoryId) {
        System.out.println("service calling deleteCategory ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        Category category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
//        if (category != null) {
//            categoryRepository.deleteById(categoryId);
//            return category;
//        } else {
//            throw new InformationNotFoundException("category with id " + categoryId + " not found");
//        }
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            categoryRepository.deleteById(categoryId);
            return category;
        } else {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        }
    }

    public List<Task> getCategoryTasks(Long categoryId) {
        LOGGER.info("service calling getCategoryTasks ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        Category category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
//        if (category != null) {
//            return category.getTaskList();
//        } else {
//            throw new InformationNotFoundException("category with id " + categoryId + " not found");
//        }
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            return category.get().getTaskList();
        } else {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        }
    }

    public Task getCategoryTask(Long categoryId, Long taskId) {
        LOGGER.info("service calling getCategoryTask ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        Category category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
//        if (category != null) {
//            Optional<Task> task = taskRepository.findByCategoryId(categoryId).stream().filter(
//                    p -> p.getId().equals(taskId)).findFirst();
//            if (task.isEmpty()) {
//                throw new InformationNotFoundException("task with id " + taskId + " not found");
//            } else {
//                return task.get();
//            }
//        } else {
//            throw new InformationNotFoundException("category with id " + categoryId + " not found");
//        }
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            Optional<Task> task = taskRepository.findByCategoryId(categoryId).stream().filter(
                    p -> p.getId().equals(taskId)).findFirst();
            if (task.isEmpty()) {
                throw new InformationNotFoundException("task with id " + taskId + " not found");
            } else {
                return task.get();
            }
        } else {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        }
    }

    public Task createCategoryTask(Long categoryId, Task taskObject) {
        LOGGER.info("service calling createCategoryTask ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        Category category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
//        try {
//            Task task = taskRepository.findByTitleAndUserId(taskObject.getTitle(), userDetails.getUser().getId());
//            if (task != null) {
//                throw new InformationExistException("task with title " + task.getTitle() + " already exists");
//            }
//            taskObject.setUser(userDetails.getUser());
//            taskObject.setCategory(category);
//            return taskRepository.save(taskObject);
//        } catch (NoSuchElementException e) {
//            throw new InformationNotFoundException("category with id " + categoryId + " not found");
//        }
        try {
            Optional category = categoryRepository.findById(categoryId);
            taskObject.setCategory((Category) category.get());
            return taskRepository.save(taskObject);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        }
    }

    public Task updateCategoryTask(Long categoryId, Long taskId, Task taskObject) {
        LOGGER.info("service calling updateCategoryTask ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
        //Category category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        try {
            Task task = (taskRepository.findByCategoryId(
                    categoryId).stream().filter(p -> p.getId().equals(taskId)).findFirst()).get();
            task.setTitle(taskObject.getTitle());
            task.setDescription(taskObject.getDescription());
            task.setProgressNotes(taskObject.getProgressNotes());
            task.setCompletion(taskObject.isCompletion()); // how to change on button click
            return taskRepository.save(task);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("task or category not found");
        }
    }

    public Task deleteCategoryTask(Long categoryId, Long taskId) {
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //Category category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        try {
            Task task = (taskRepository.findByCategoryId(
                    categoryId).stream().filter(p -> p.getId().equals(taskId)).findFirst()).get();
            taskRepository.deleteById(task.getId());
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("task or category not found");
        }
        return null;
    }



}
