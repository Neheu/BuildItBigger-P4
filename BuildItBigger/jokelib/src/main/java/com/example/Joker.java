package com.example;

import java.util.ArrayList;
import java.util.Random;

public class Joker {
    static ArrayList<String> jokesList = new ArrayList<>();

    public static String getRandomJoke() {
        return jokesList.get(new Random().nextInt(jokesList.size() - 1));
    }
}
