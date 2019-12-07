package com.example.weighttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class StatusActivity extends AppCompatActivity {
    public static final String PREFERENCES = "WT" ;
    ProgressBar progressBar;
    public  Button button1;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        SharedPreferences prefs = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
        String username = prefs.getString("username", null);

        String goal_str = prefs.getString(username+"_goal", null);
        String weight_str = prefs.getString(username+"_cweight", null);
        String init_weight_str = prefs.getString(username+"_weight", null);
        if(weight_str == null)
            weight_str = init_weight_str;
        double goal = Double.parseDouble(goal_str);
        double weight = Double.parseDouble(weight_str);
        double init_weight = Double.parseDouble(init_weight_str);
        double total = init_weight - goal;
        double progress = weight - goal;
        int percentage = (int)(100-(progress/total*100));
        progressBar.setProgress(percentage);
        final TextView cWeightText = (TextView) findViewById(R.id.cweight);
        cWeightText.setText("Current: "+weight_str+"LB");
        final TextView gWeightText = (TextView) findViewById(R.id.gweight);
        gWeightText.setText("Goal: "+goal_str+"LB");
        final TextView pWeightText = (TextView) findViewById(R.id.percent);
        pWeightText.setText((String.valueOf(percentage))+"%");

        button1 = findViewById(R.id.btnLogin);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    startActivity(new Intent(StatusActivity.this, AddActivity.class));


            }
        });
    }
}
