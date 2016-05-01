package com.qi_zhao.hw2_zoo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by qizhao on 5/1/16.
 */
public class Details  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);


        //shows the detail page according to each input
        Intent intent=getIntent();
        Animal animal=(Animal)intent.getSerializableExtra("animal");
       /* Toast.makeText(Detail.this, animal.getImage_id(), Toast.LENGTH_SHORT).show();*/

        TextView textView=(TextView)findViewById(R.id.textView);
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        TextView textView1=(TextView)findViewById(R.id.textView2);

        try {
            String filename = animal.getFilename();
            InputStream inputStream = getAssets().open(filename);
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } catch (IOException e) {
            e.printStackTrace();
        }

        textView.setText(animal.getName());

        textView1.setText(animal.getDesc());


    }
}
