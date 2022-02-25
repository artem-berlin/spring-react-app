package com.todo.controller;

import com.todo.entity.ToDoItem;
import com.todo.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

//  --------------------- Standart endpoints---------------------
@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class Controller {

    private final Service service;                                     //final???

    @GetMapping()                       //default
    public List<ToDoItem> getAl() {
        return service.getAllItems();
    }


    @GetMapping("/{id}")
    public ToDoItem getItemById(@PathVariable String id) {
        return service.getItemById(id);
    }

//    @GetMapping("/{id}")         //standart. id nutzen, lieber id
//    public ToDoItem getItemByName(@PathVariable String id) {
//        return service.getItemByName(id);
//    }



    @PostMapping
    public void addItem(@RequestBody ToDoItem newItem) {
        service.addItem(newItem);
    }

    @PutMapping("/{name}")
    public void checkItem(@PathVariable String name) {
        service.checkItem(name);
    }


    @DeleteMapping("/{name}")
    public void deleteItem(@PathVariable String name) {
        service.deleteItem(name);
    }


}
