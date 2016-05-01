package com.qi_zhao.hw2_zoo;

/**
 * Created by qizhao on 5/1/16.
 */

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Animal implements Serializable {
    private String name;
    private String filename;
    private String desc;

    public Animal(String name, String filename, String desc) {
        this.name = name;
        this.filename = filename;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getFilename() {
        return filename;
    }

    public String getDesc(){
        return desc;
    }
}
