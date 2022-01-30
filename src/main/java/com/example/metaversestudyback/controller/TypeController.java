package com.example.metaversestudyback.controller;

import com.example.metaversestudyback.model.Resource;
import com.example.metaversestudyback.service.TypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.metaversestudyback.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@RestController
@RequestMapping(path = "/api")
public class TypeController {
    private TypeService typeService;
    private static final Logger LOGGER = Logger.getLogger(TypeController.class.getName());

    @Autowired
    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    // get all types
    // http://localhost:9092/api/user/{userId}/types
    @GetMapping("/types")
    public List<Type> getTypes() {
        LOGGER.info("calling getTypes method from controller");
        return typeService.getTypes();
    }

    // get type
    // http://localhost:9092/api/user/{userId}/types/{typeid}
    @GetMapping(path = "/types/{typeId}")
    public Type getType(@PathVariable Long typeId) {
        LOGGER.info("calling getType method from controller");
        return typeService.getType(typeId);
    }

    //create type
    //http://localhost:9092/api/{userId}/types
    @PostMapping(path = "/types")
    public Type createType(@RequestBody Type typeObject) {
        LOGGER.info("calling createType method from controller");
        return typeService.createType(typeObject);
    }

    // update type
    // http://localhost:9092/{userId}/types/{typeid}
    @PutMapping(path = "/types/{typeId}")
    public Type updateType(@PathVariable(value = "typeId") Long typeId, @RequestBody Type typeObject) {
        LOGGER.info("calling updateType method from controller");
        return typeService.updateType(typeId, typeObject);
    }

    //delete type
    // http://localhost:9092/api/{userId}/types/{typeid}
    @DeleteMapping("/types/{typeId}")
    public Type deleteType(@PathVariable(value = "typeId") Long typeId) {
        LOGGER.info("calling deleteType method from controller");
        return typeService.deleteType(typeId);
    }

    // get all resources
    // http://localhost:9092/api/{userId}/types/{typeid}/resources
    @GetMapping(path = "/types/{typeId}/resources")
    public List<Resource> getTypeResources(@PathVariable(value = "typeId") Long typeId) {
        LOGGER.info("calling getTypeResources method from controller");
        return typeService.getTypeResources(typeId);
    }

    // get resource
    // http://localhost:9092/api/{userId}/types/{typeid}/resources/{resourcesid}
    @GetMapping(path = "/types/{typeId}/tasks/{taskId}")
    public Resource getTypeResource(@PathVariable(value = "typeId") Long typeId,
                                @PathVariable(value = "taskId") Long resourceId) {
        LOGGER.info("calling getTypeResource method from controller");
        return typeService.getTypeResource(typeId, resourceId);
    }

    //create resource
    // http://localhost:9092/api/user/{userId}/types/{typeid}/resources
    @PostMapping("/types/{typeId}/Resources")
    public Resource createTypeResource(
            @PathVariable(value = "typeId") Long typeId,
            @RequestBody Resource resourceObject) {
        LOGGER.info("calling createTypeResource method from controller");
        return typeService.createTypeResource(typeId, resourceObject);
    }

    //update resource
    // http://localhost:9092/api/{userId}/types/{typeid}/resources/{resourcesid}
    @PutMapping(path = "/types/{typeId}/Resources/{resourceId}")
    public Resource updateTypeResource(@PathVariable(value = "typeId") Long typeId,
                                   @PathVariable(value = "resourceId") Long resourceId,
                                   @RequestBody Resource resourceObject) {
        LOGGER.info("calling updateTypeResource method from controller");
        return typeService.updateTypeResource(typeId, resourceId, resourceObject);
    }

    // delete resource
    // http://localhost:9092/api/{userId}/types/{typeid}/resources/{resourcesid}
    @DeleteMapping(path = "/types/{categoryId}/Resources/{resourceId}")
    public Resource deleteTypeResource(@PathVariable(value = "typeId") Long typeId,
                                   @PathVariable(value = "resourceId") Long resourceId) {
        LOGGER.info("calling deleteTypeResource method from controller");
        return typeService.deleteTypeResource(typeId, resourceId);
    }


}