package com.qi_zhao.hw2_zoo;


import android.graphics.drawable.Drawable;

public class Animal {
    private String name;
    private int filename;

    public Animal(String name, int filename) {
        this.name = name;
        this.filename = filename;
    }

    public String getName() {
        return name;
    }

    public int getFilename() {
        return filename;
    }
}
