package com.todo.controller;


import com.todo.ToDoItem;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.MethodOrderer;

import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ToDoControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;

    @Test
    void testPost() {

        ToDoItem newItem1 = new ToDoItem("Violine", "Strings",0);

        ResponseEntity<Void> response = restTemplate.postForEntity("/todoapp", newItem1, Void.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);

        ResponseEntity<ToDoItem> response1 = restTemplate.getForEntity("/todoapp/getitembyname/Violine", ToDoItem.class);
        assertEquals(Objects.requireNonNull(response1.getBody()).getName(), newItem1.getName());
    }


    @Test
    void testDelete(){
        ToDoItem newItem2 = new ToDoItem("Cello", "Strings2",1);
        ToDoItem newitem1 = new ToDoItem("Violine", "Strings",0);
        ResponseEntity<Void> entityItem2Response = restTemplate.postForEntity("/todoapp", newItem2, Void.class);
        assertEquals(entityItem2Response.getStatusCode(), HttpStatus.OK);
        ResponseEntity<Void> entityItem1Response = restTemplate.postForEntity("/todoapp", newitem1, Void.class);
        assertEquals(entityItem1Response.getStatusCode(), HttpStatus.OK);


        restTemplate.delete("/todoapp/deleteitem/Violine", Void.class);

        ResponseEntity<ToDoItem[]> allItemResponse = restTemplate.getForEntity("/todoapp/getallitems", ToDoItem[].class);
        assertTrue(Objects.requireNonNull(allItemResponse.getBody()).length == 2);
        var check = Arrays.stream(allItemResponse.getBody()).filter(e -> e.equals(newItem2)).findFirst();
        assertTrue(check.get().equals(newItem2));

    }



}



