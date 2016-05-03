package com.qi_zhao.hw2_zoo;

/**
 * Created by qizhao on 5/1/16.
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //define list of animals
    List<Animal> animals;
    //define description as an array
    String[] desc = {"Nick Wilde is a charming, small-time, con artist fox with a big mouth and a lot of opinions. But when a rabbit cop outsmarts him, he finds himself actually helping her solve a mystery.).",
            "Judy Hopps is the first bunny ever to join Zootopia's police department. Determined to prove herself, Judy jumps at the chance to crack a case, even if it means teaming up with a con artist fox.",
            "[Flash is] the fastest sloth working at the DMV—the Department of Mammal Vehicles.",
            "Assistant Mayor Bellwether is a sweet sheep with a little voice and a lot of wool, who constantly finds herself under foot of the larger-than-life Mayor Lionheart.",
            "Clawhauser is the ZPD's resident cheetah, and has been under their employment for a number of years, working at the front desk as a receptionist. Because his particular job on the force requires very little mobility, Clawhauser spends most of his time indulging himself in food and media which, after so many years, would result in his hefty size"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // build animal list
        animals = new ArrayList<>();
        animals.add(new Animal("Fox-Nick", "FoxN.png", "FoxB.png", desc[0]));
        animals.add(new Animal("Rabbit-Judy", "RabbitJ.png", "RabbitB.png", desc[1]));
        animals.add(new Animal("Sloth-Flash", "FlashN.png", "FlashB.png", desc[2]));
        animals.add(new Animal("Sheep-Bellwether", "Sheep.png", "SheepB.png", desc[3]));
        animals.add(new Animal("Cheetah-Clawhauser", "Cla.png", "Clawhauser_Promo.png", desc[4]));
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Zootopia Animals");

        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new AnimalArrayAdaptor(this, R.layout.custom_row, animals));
        lv.setOnItemClickListener(this);
    }

    //add click listener to each of the animal
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int pos=position;
        Animal animal = animals.get(position);
        final Intent intent=new Intent(MainActivity.this, Details.class);
        intent.putExtra("animal", animal);
        if (position != 4) {
            startActivity(intent);
        }
        if(position == 4){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setIcon(R.mipmap.ic_launcher)
                    .setTitle("Danger!")
                    .setMessage("This animal is very scary. Do you want to proceed?")
                    .setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setCancelable(false)
            ;
            builder.create().show();

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
                Intent intent2=new Intent(MainActivity.this, Information.class);
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
