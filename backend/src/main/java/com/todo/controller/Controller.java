package com.todo.controller;

import com.todo.ToDoItem;
import com.todo.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//  --------------------- Standart endpoints---------------------
@RestController
@RequestMapping("/todoapp")
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping
    public void addItem(@RequestBody ToDoItem newitem){
        service.addItem(newitem);
    }

    @GetMapping("/getitembyname/{name}")
    public ToDoItem getItemByName(@PathVariable String name){
        return service.getItemByName(name);
    }


    @DeleteMapping ("/deleteitem/{name}")
    public void deleteItem(@PathVariable String name){
        service.deleteItem(name);
    }

    @PutMapping("/checkitem/{name}")
    public void checkItem(@PathVariable String name){
        service.checkItem(name);
    }

    @GetMapping ("/getallitems")
    public List<ToDoItem> getAllItems(){
        return service.getAllItems();
    }



}
