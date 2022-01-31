package com.example.metaversestudyback.repository;

import com.example.metaversestudyback.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//    Category findByName(String categoryName) ;

    List<Category> findByUserId(Long userId);

    Category findByUserIdAndName(Long userId, String categoryName);

    Category findByIdAndUserId(Long categoryId, Long userId);
}
