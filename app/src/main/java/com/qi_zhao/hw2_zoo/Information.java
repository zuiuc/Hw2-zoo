package com.qi_zhao.hw2_zoo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by Qi on 5/2/2016.
 */
public class Information extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Zootopia Animals");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        //shows the detail page according to each input
        Intent intent=getIntent();




    }
    public void myClickHandler(View target) {
        try {
            String myPhoneNumberUri = "tel:1-888-888-8888";
            Intent myActivity2 = new Intent(Intent.ACTION_CALL,
                    Uri.parse(myPhoneNumberUri));
            startActivity(myActivity2);
        } catch (Exception e) {
            Log.e("Demo application", "Failed to invoke call", e);
        }
    }
}
