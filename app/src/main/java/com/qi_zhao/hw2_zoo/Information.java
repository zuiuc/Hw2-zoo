package com.qi_zhao.hw2_zoo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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
                Intent intent2=new Intent(Information.this, Information.class);
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
