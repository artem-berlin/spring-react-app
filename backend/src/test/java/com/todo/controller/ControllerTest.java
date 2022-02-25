package com.todo.controller;


import com.todo.entity.ToDoItem;
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

        ToDoItem newItem1 = new ToDoItem("Violine", "Strings");

        ResponseEntity<Void> testPost = restTemplate.postForEntity("/todo", newItem1, Void.class);
        assertEquals(testPost.getStatusCode(), HttpStatus.OK);

        ResponseEntity<ToDoItem> testPost1 = restTemplate.getForEntity("/todo/getitembyname/Violine", ToDoItem.class);
        assertEquals(Objects.requireNonNull(testPost1.getBody()).getName(), newItem1.getName());
    }

    @Test
    void testPut(){
        ToDoItem newItem1 = new ToDoItem("Violine","Strings");
        ToDoItem newItem2 = new ToDoItem("Cello", "Strings2");

        ResponseEntity<Void> response1 = restTemplate.postForEntity("/todo", newItem1, Void.class);
        assertEquals(response1.getStatusCode(), HttpStatus.OK);
        ResponseEntity<Void> response = restTemplate.postForEntity("/todo", newItem2, Void.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);

        restTemplate.put("/todoapp/checkitem/violine", newItem1, Void.class);
        restTemplate.put("/todoapp/checkitem/cello", newItem2, Void.class);



        ResponseEntity<ToDoItem> responsePut1 = restTemplate.getForEntity("/todo/getitembyname/Violine", ToDoItem.class);
        ResponseEntity<ToDoItem> responsePut2 = restTemplate.getForEntity("/todo/getitembyname/Cello", ToDoItem.class);
        assertTrue(Objects.requireNonNull(responsePut1.getBody()).isStatus());
        assertTrue(Objects.requireNonNull(responsePut2.getBody()).isStatus());
    }



    @Test
    void testDelete(){

        ToDoItem newitem1 = new ToDoItem("Violine", "Strings");
        ToDoItem newItem2 = new ToDoItem("Cello", "Strings2");
        ToDoItem newItem3 = new ToDoItem("Bass", "Strings3");
        ResponseEntity<Void> entityItem1Response = restTemplate.postForEntity("/todo", newitem1, Void.class);
        assertEquals(entityItem1Response.getStatusCode(), HttpStatus.OK);
        ResponseEntity<Void> entityItem2Response = restTemplate.postForEntity("/todo", newItem2, Void.class);
        assertEquals(entityItem2Response.getStatusCode(), HttpStatus.OK);

        restTemplate.delete("/todo/deleteitem/Violine", Void.class);

        ResponseEntity<ToDoItem[]> allItemResponse = restTemplate.getForEntity("/todo/getallitems", ToDoItem[].class);
        assertEquals(2, Objects.requireNonNull(allItemResponse.getBody()).length);     // lengh -1!!!
        var check = Arrays.stream(allItemResponse.getBody()).filter(e -> e.equals(newItem2)).findFirst();
        assertEquals(check.get(), newItem2);   // get????

    }



}



