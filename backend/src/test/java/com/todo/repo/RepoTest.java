package com.todo.repo;

import com.todo.entity.ToDoItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;

class RepoTest {

    @Test
    void ShouldAddAnItem(){

        Repo myRepo = new Repo();

        ToDoItem newItem = new ToDoItem("Violine", "Strings");
        myRepo.addItem(newItem);

        Assertions.assertEquals(myRepo.getItemById(newItem.getId()), newItem);

    }


}