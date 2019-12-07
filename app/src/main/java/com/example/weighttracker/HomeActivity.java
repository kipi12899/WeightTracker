package com.example.weighttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class HomeActivity extends AppCompatActivity {
    private String[] values = new String[] { "My Progress","Profile", "Healthy Foods","Healthy Snacks","Contact Us" };
    public static final String PREFERENCES = "WT" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ListView listView1 = (ListView) findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position,
                                    long id) {
                String selected = id+"";
                Intent intent = new Intent(HomeActivity.this,HomeActivity.class);
                switch (selected){
                      case "0":
                        intent = new Intent(HomeActivity.this,StatusActivity.class);
                        break;
                    case "1":
                        intent = new Intent(HomeActivity.this,AboutMe.class);
                        break;
                    case "2":
                        intent = new Intent(HomeActivity.this,FoodActivity.class);
                        break;
                    case "3":
                        intent = new Intent(HomeActivity.this,SnackActivity.class);
                        break;
                    case "4":
                        intent = new Intent(HomeActivity.this,ContactActivity.class);
                        break;
                    default:
                }


                //based on item add info to intent
                startActivity(intent);
            }
        });
    }




}
