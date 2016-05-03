package com.qi_zhao.hw2_zoo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Zootopia Animals");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        //shows the detail page according to each input
        Intent intent=getIntent();
        Animal animal=(Animal)intent.getSerializableExtra("animal");
       /* Toast.makeText(Detail.this, animal.getImage_id(), Toast.LENGTH_SHORT).show();*/

        TextView textView=(TextView)findViewById(R.id.textView);
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        TextView textView1=(TextView)findViewById(R.id.textView2);

        try {
            String filename = animal.getFilenameB();
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.information:
                Intent intent2=new Intent(Details.this, Information.class);
                startActivity(intent2);
                break;
            case R.id.uninstall:
                uninstall();
                break;
            default:

        }

        return super.onOptionsItemSelected(item);
    }
    private void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
    private void uninstall() {
        Uri packageURI = Uri.parse("package:com.qi_zhao.hw2_zoo");
        Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
        startActivity(uninstallIntent);
    }
}
