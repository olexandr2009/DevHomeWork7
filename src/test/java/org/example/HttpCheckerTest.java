package org.example;

import org.example.httpcheck.HttpStatusChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpCheckerTest {
    HttpStatusChecker httpChecker;
    @BeforeEach
    void initHttpChecker(){
        httpChecker = new HttpStatusChecker();
    }

    @Test
    void testCheck200() throws Exception {
        assertEquals("https://http.cat/200.jpg",httpChecker.getStatusImage(200));
    }
//    @Test
//    void testCheck100(){
//        List<Integer> statusCodes = List.of(
//                100,101,102,103);
//        statusCodes.forEach(integer -> assertDoesNotThrow(() -> httpChecker.getStatusImage(integer),integer.toString()));
//    }
//    @Test
//    void testCheck200(){
//        List<Integer> statusCodes = List.of(
//                200,201,202,203,204,206,207);
//        statusCodes.forEach(integer -> assertDoesNotThrow(() -> httpChecker.getStatusImage(integer),integer.toString()));
//    }
//    @Test
//    void testCheck300(){
//        List<Integer> statusCodes = List.of(
//                300,301,302);
//        statusCodes.forEach(integer -> assertDoesNotThrow(() -> httpChecker.getStatusImage(integer),integer.toString()));
//    }
//    @Test
//    void testCheck400(){
//        List<Integer> statusCodes = List.of(
//                400,401,402,403,405,406,407);
//        statusCodes.forEach(integer -> assertDoesNotThrow(() -> httpChecker.getStatusImage(integer),integer.toString()));
//    }
//    @Test
//    void testCheck500(){
//        List<Integer> statusCodes = List.of(
//                500,501,502,503,504,506,525,530);
//        statusCodes.forEach(integer -> assertDoesNotThrow(() -> httpChecker.getStatusImage(integer),integer.toString()));
//    }



}