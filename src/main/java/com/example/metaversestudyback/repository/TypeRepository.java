package com.example.metaversestudyback.repository;

import com.example.metaversestudyback.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String typeName) ;

    List<Type> findByUserId(Long userId);

    Type findByUserIdAndName(Long userId, String typeName);

    Type findByIdAndUserId(Long categoryId, Long userId);
}
