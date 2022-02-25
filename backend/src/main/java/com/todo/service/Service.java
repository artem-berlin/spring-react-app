package com.todo.service;

import com.todo.entity.ToDoItem;
import com.todo.repo.Repo;


import java.util.List;

@org.springframework.stereotype.Service
// convert record

//-----------------------Functional-------------------------------
public class Service {
    private  final Repo appRepo;

    public Service(Repo appRepo) {
        this.appRepo = appRepo;
    }

    public void addItem(ToDoItem newItem) {
        appRepo.addItem(newItem);
    }

    public void deleteItem(String name) {
        appRepo.deleteItem(name);
    }

    public void checkItem(String name) {
        appRepo.checkItem(name);
    }

    public List<ToDoItem> getAllItems() {
        return appRepo.getAllItems();
    }

    public ToDoItem getItemById(String id) {
        return appRepo.getItemById(id);
    }

    public ToDoItem getItemByName(String name) {
        return appRepo.getItemByName(name);
    }


//---------------save problem------------------
//    public void changeTodoItem(String id, ToDoItem toDoItem){
//        ToDoItem changedItem = Repo.getToDoItemById(id);
//
//        toDoItem.setName(toDoItem.getName());
//        toDoItem.setItemType(toDoItem.getItemType());
//
//        Repo.save(toDoItem);
//    }


}
