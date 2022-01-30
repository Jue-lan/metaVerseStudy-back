package com.example.metaversestudyback.repository;

import com.example.metaversestudyback.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    Resource findByTitle(String resourceTitle);

    List<Resource> findByTypeId(Long typeId);

    Resource findByTitleAndUserId(String resourceTitle, Long userId);
}