package com.todo;

import java.util.Objects;

public class ToDoItem {
    private String name;
    private String itemType;

    private boolean status= false;

    public ToDoItem(String name , String itemType , int i) {
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
    }
}
