package com.qi_zhao.hw2_zoo;

/**
 * Created by qizhao on 5/1/16.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    List<Animal> animals;
    String[] desc = {"a",
            "b",
            "c",
            "d",
            "e"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // build animal list
        animals = new ArrayList<>();
        animals.add(new Animal("Yellow Fish", "fish.png", desc[0]));
        animals.add(new Animal("Brown Owl", "owl.png", desc[1]));
        animals.add(new Animal("Pink Pig", "pig.png", desc[2]));
        animals.add(new Animal("Orange Tiger", "tiger.png", desc[3]));
        animals.add(new Animal("Green Turtle", "turtle.png", desc[4]));

        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new AnimalArrayAdaptor(this, R.layout.custom_row, animals));
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Animal animal = animals.get(position);
        Intent intent=new Intent(MainActivity.this, Details.class);
        intent.putExtra("animal", animal);
        startActivity(intent);
    }
}
