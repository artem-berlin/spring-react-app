package com.todo.entity;

import java.util.Objects;
import java.util.UUID; // for database
public class ToDoItem {
    private String name;
    private String itemType;
    private String id;
    private boolean status = false;

    public ToDoItem() {this.id = UUID.randomUUID().toString();  // always default constructor
    }

    public ToDoItem(String name, String itemType) {
        this.name = name;
        this.itemType = itemType;
        this.id = UUID.randomUUID().toString();
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoItem toDoItem = (ToDoItem) o;
        return isStatus() == toDoItem.isStatus() && Objects.equals(getName(), toDoItem.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }   //????

    public String getId() {
        return id;
    }


}
