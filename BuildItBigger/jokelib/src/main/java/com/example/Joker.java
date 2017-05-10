package com.example;

import java.util.ArrayList;
import java.util.Random;

public class Joker {
    ArrayList<String> jokesList = new ArrayList<>();

    public String getRandomJoke() {
        return jokesList.get(new Random().nextInt(jokesList.size() - 1));
    }
}
