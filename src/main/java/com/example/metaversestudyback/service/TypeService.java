package com.example.metaversestudyback.service;

import com.example.metaversestudyback.model.Category;
import com.example.metaversestudyback.model.Task;
import com.example.metaversestudyback.model.Type;
import com.example.metaversestudyback.model.Resource;
import com.example.metaversestudyback.repository.TypeRepository;
import com.example.metaversestudyback.repository.ResourceRepository;
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
public class TypeService {

    private TypeRepository typeRepository;
    private ResourceRepository resourceRepository;
    private static final Logger LOGGER = Logger.getLogger(TypeService.class.getName());

    @Autowired
    public void setTypeRepository(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Autowired
    public void setTypeRepository(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<Type> getTypes() {
        LOGGER.info("service calling getTypes ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(userDetails.getUser().getId());
//        List<Type> type = typeRepository.findByUserId(userDetails.getUser().getId());
//        if (type.isEmpty()) {
//            throw new InformationNotFoundException("no types found for user id " + userDetails.getUser().getId());
//        } else {
//            return type;
//        }
       return typeRepository.findAll();
    }

    public Optional getType(Long typeId) {
//        LOGGER.info("service calling getType ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        Type type = typeRepository.findByIdAndUserId(typeId, userDetails.getUser().getId());
//        if (type != null) {
//            return type;
//        } else {
//            throw new InformationNotFoundException("type with id " + typeId + " not found");
//        }
        Optional type = typeRepository.findById(typeId);
        if (type.isPresent()) {
            return type;
        } else {
            throw new InformationNotFoundException("type with id " + typeId + " not found");
        }
    }

    public Type createType(Type typeObject) {
//        LOGGER.info("service calling createCategory ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Type type = typeRepository.findByUserIdAndName(userDetails.getUser().getId(), typeObject.getName());
//        if (type != null) {
//            throw new InformationExistException("type with name " + type.getName() + " already exists");
//        } else {
//            typeObject.setUser(userDetails.getUser());
//            return typeRepository.save(typeObject);
//        }
        Type type = typeRepository.findByName(typeObject.getName());
        if (type != null) {
            throw new InformationExistException("type with name " + type.getName() + " already exists");
        } else {
            return typeRepository.save(typeObject);
        }
    }

    public Type updateType(Long typeId, Type typeObject) {
        LOGGER.info("service calling updateCategory ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        Type type = typeRepository.findByIdAndUserId(typeId, userDetails.getUser().getId());
        Optional<Type> type = typeRepository.findById(typeId);
        if (type.isPresent()) {
            if (typeObject.getName().equals(type.get().getName())) {
                throw new InformationExistException("type " + type.get().getName() + " is already exists");
            } else {
                Type updateType = typeRepository.findById(typeId).get();
                updateType.setName(typeObject.getName());
                return typeRepository.save(updateType);
            }
        } else {
            throw new InformationNotFoundException("type with id " + typeId + " not found");
        }
    }

    public Optional<Type> deleteType(Long typeId) {
        System.out.println("service calling deleteCategory ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        Type type = typeRepository.findByIdAndUserId(typeId, userDetails.getUser().getId());
//        if (type != null) {
//            typeRepository.deleteById(typeId);
//            return type;
//        } else {
//            throw new InformationNotFoundException("type with id " + typeId + " not found");
//        }
        Optional<Type> type = typeRepository.findById(typeId);
        if (type.isPresent()) {
            typeRepository.deleteById(typeId);
            return type;
        } else {
            throw new InformationNotFoundException("type with id " + typeId + " not found");
        }
    }

    public List<Resource> getTypeResources(Long typeId) {
        LOGGER.info("service calling getTypeResources ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        Type type = typeRepository.findByIdAndUserId(typeId, userDetails.getUser().getId());
//        if (type != null) {
//            return type.getResourceList();
//        } else {
//            throw new InformationNotFoundException("type with id " + typeId + " not found");
//        }
        Optional<Type> type = typeRepository.findById(typeId);
        if (type.isPresent()) {
            return type.get().getResourceList();
        } else {
            throw new InformationNotFoundException("type with id " + typeId + " not found");
        }
    }

    public Resource getTypeResource(Long typeId, Long resourceId) {
        LOGGER.info("service calling getTypeResource ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        Type type = typeRepository.findByIdAndUserId(typeId, userDetails.getUser().getId());
//        if (type != null) {
//            Optional<Resource> resource = resourceRepository.findByTypeId(typeId).stream().filter(
//                    p -> p.getId().equals(resourceId)).findFirst();
//            if (resource.isEmpty()) {
//                throw new InformationNotFoundException("resource with id " + resourceId + " not found");
//            } else {
//                return resource.get();
//            }
//        } else {
//            throw new InformationNotFoundException("type with id " + typeId + " not found");
//        }
        Optional<Type> type = typeRepository.findById(typeId);
        if (type.isPresent()) {
            Optional<Resource> resource = resourceRepository.findByTypeId(typeId).stream().filter(
                    p -> p.getId().equals(resourceId)).findFirst();
            if (resource.isEmpty()) {
                throw new InformationNotFoundException("resource with id " + resourceId + " not found");
            } else {
                return resource.get();
            }
        } else {
            throw new InformationNotFoundException("category with id " + typeId + " not found");
        }
    }

    public Resource createTypeResource(Long typeId, Resource resourceObject) {
        LOGGER.info("service calling createTypeResource ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        Type type = typeRepository.findByIdAndUserId(typeId, userDetails.getUser().getId());
//        try {
//            Resource resource = resourceRepository.findByTitleAndUserId(resourceObject.getTitle(), userDetails.getUser().getId());
//            if (resource != null) {
//                throw new InformationExistException("resource with title " + resource.getTitle() + " already exists");
//            }
//            resourceObject.setUser(userDetails.getUser());
//            resourceObject.setType(type);
//            return resourceRepository.save(resourceObject);
//        } catch (NoSuchElementException e) {
//            throw new InformationNotFoundException("type with id " + typeId + " not found");
//        }
        try {
            Optional type = typeRepository.findById(typeId);
            resourceObject.setType((Type) type.get());
            return resourceRepository.save(resourceObject);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("type with id " + typeId + " not found");
        }
    }

    public Resource updateTypeResource(Long typeId, Long resourceId, Resource resourceObject) {
        LOGGER.info("service calling updateCategoryTask ==>");
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
        //Category type = typeRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        try {
            Resource resource = (resourceRepository.findByTypeId(
                    typeId).stream().filter(p -> p.getId().equals(resourceId)).findFirst()).get();
            resource.setTitle(resourceObject.getTitle());
            resource.setDescription(resourceObject.getDescription());
            return resourceRepository.save(resource);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("resource or type not found");
        }
    }

    public Resource deleteTypeResource(Long typeId, Long resourceId) {
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //Category category = categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        try {
            Resource resource = (resourceRepository.findByTypeId(
                    typeId).stream().filter(p -> p.getId().equals(resourceId)).findFirst()).get();
            resourceRepository.deleteById(resource.getId());
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("resource or type not found");
        }
        return null;
    }
}
