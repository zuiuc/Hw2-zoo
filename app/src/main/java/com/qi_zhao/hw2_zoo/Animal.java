package com.qi_zhao.hw2_zoo;


import android.graphics.drawable.Drawable;

public class Animal {
    private String name;
    private String filename;

    public Animal(String name, String filename) {
        this.name = name;
        this.filename = filename;
    }

    public String getName() {
        return name;
    }

    public String getFilename() {
        return filename;
    }
}
