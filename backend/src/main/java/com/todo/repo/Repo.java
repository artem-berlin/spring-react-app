package com.todo.repo;

import com.todo.entity.ToDoItem;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

//----------------------------Repo List---------------------------
@Repository
public class Repo {
   private  ArrayList<ToDoItem> todo;                  // static nur einmal in speicher, dont use

    public Repo() {
        this.todo = new ArrayList<>();
    }

//    public static void save(String id, String name) {
//        todo.put(getToDoItemById(id), getToDoItemById(id).getName());
//    }


    public List<ToDoItem> getAllItems() {
        return todo;
    }

    public  void addItem(ToDoItem newitem) {
        todo.add(newitem);
    }

    public ToDoItem getItemByName(String name) {
        var result = searchitem(name);
        if (result.isPresent()) {
            return result.get();
        } else throw new RuntimeException("Item doesn't exist");
    }


    public void deleteItem(String name) {
        var result = searchitem(name);
        if (result.isPresent()) {
            todo.remove(result.get());
        } else throw new RuntimeException("Item doesn't exist");

    }

    public Optional<ToDoItem> searchitemID(String id) {
        var todostream = todo.stream();
        return todostream.filter(e -> e.getId().equals(id))
                .findFirst();
    }


    public void checkItem(String name) {
        var result = searchitem(name);
        if (result.isPresent()) {
            result.get().setStatus(!result.get().isStatus());
        } else throw new RuntimeException("Item doesn't exist");
    }
//    public static void save(ToDoItem toDoItem) {
//        todo.put(toDoItem.getId(), toDoItem);
//    }

    public Optional<ToDoItem> searchitem(String name) {
        var todostream = todo.stream();
        return todostream.filter(e -> e.getName().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT)))
                .findFirst();
    }

    public  ToDoItem getItemById(String id) {
        var result = searchitemID(id);
        if (result.isPresent()) {
            return result.get();
        } else throw new RuntimeException("Item with this id doesn't exist!");
    }

}
