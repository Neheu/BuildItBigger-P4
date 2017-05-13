package com.example.Lenovo.myapplication.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private String myData;

    public MyBean(String randomJoke) {
    myData = randomJoke;
    }


    public String getData() {
        return myData;
    }


}