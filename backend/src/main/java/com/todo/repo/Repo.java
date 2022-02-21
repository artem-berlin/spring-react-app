package com.todo.repo;

import com.todo.ToDoItem;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Locale;
import java.util.Optional;

//----------------------------Repo List---------------------------
@Repository
public class Repo {
    List<ToDoItem> todo;

    public Repo(List<ToDoItem> todo) {
        this.todo = todo;
    }

    public void addItem(ToDoItem newitem){
        todo.add(newitem);
    }

    public List <ToDoItem> getAllItems(){
        return todo;
    }

    public ToDoItem getItemByName(String name){
        var result = searchitem(name);
        if (result.isPresent()) {
            return result.get();
        } else throw new RuntimeException("Item doesn't exist");
    }


    public void deleteItem(String name){
        var result = searchitem(name);
        if (result.isPresent()) {
            todo.remove(result.get());
        } else throw new RuntimeException("Item doesn't exist");

    }


    public void checkItem(String name){
        var result = searchitem(name);
        if (result.isPresent()) {
            result.get().setStatus(!result.get().isStatus());
        }
             else throw new RuntimeException("Item doesn't exist");
    }

    public Optional<ToDoItem> searchitem(String name){
        var todostream =todo.stream();
        return todostream.filter(e -> e.getName().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT)))
                .findFirst();
    }

}
