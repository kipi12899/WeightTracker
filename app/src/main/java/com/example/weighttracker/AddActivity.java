package com.example.weighttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;
public class AddActivity extends AppCompatActivity {
    public static final String PREFERENCES = "WT" ;
    EditText ed1,ed2;
    public Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        String today = new SimpleDateFormat("MM-dd-yyyy", Locale.getDefault()).format(new Date());
        EditText editText = (EditText)findViewById(R.id.txtDate);
        editText.setText(today, TextView.BufferType.EDITABLE);

        ed1=(EditText)findViewById(R.id.txtDate);
        ed2=(EditText)findViewById(R.id.txtWeight);

        button1 = findViewById(R.id.btnSave);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
                String username = prefs.getString("username", null);
                String date = ed1.getText().toString();
                String weight = ed2.getText().toString();
                if(date.trim().length()>0 && weight.trim().length()>0) {

                    SharedPreferences.Editor editor = getSharedPreferences(PREFERENCES, MODE_PRIVATE).edit();
                    editor.putString(username+"_cweight", ed2.getText().toString());
                    editor.commit();

                    Intent intent = new Intent(AddActivity.this,StatusActivity.class);

                    startActivity(intent);
                }
                else
                    Toast.makeText(AddActivity.this,"Required fields are missing",Toast.LENGTH_LONG).show();
            }
        });
    }
}
