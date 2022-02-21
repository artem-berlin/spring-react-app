package com.todo.service;

import com.todo.ToDoItem;
import com.todo.repo.Repo;


import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final Repo appRepo;

    public Service(Repo appRepo) {
        this.appRepo = appRepo;
    }

    public  void addItem(ToDoItem newItem){
        appRepo.addItem(newItem);
    }

    public List<ToDoItem> getAllItems(){
        return appRepo.getAllItems();
    }

    public ToDoItem getItemByName(String name){
        return appRepo.getItemByName(name);
    }

    public void deleteItem( String name){
        appRepo.deleteItem(name);
    }

    public void checkItem(String name){
        appRepo.checkItem(name);
    }


}
