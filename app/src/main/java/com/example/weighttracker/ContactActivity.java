package com.example.weighttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {
    public static final String PREFERENCES = "WT" ;
    public static final String SUPPORT_EMAIL = "igorlik@svsu.edu";
    EditText ed1;
    public Button button1;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ed1=(EditText)findViewById(R.id.edit_text);

        button1 = findViewById(R.id.btnEmail);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences prefs = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
                String username = prefs.getString("username", null);
                String email = prefs.getString(username.trim()+"_email", null);


                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL,  new String[]{SUPPORT_EMAIL});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Weight Tracker Question");
                intent.putExtra(Intent.EXTRA_TEXT, ed1.getText().toString());


                startActivity(Intent.createChooser(intent, "Send email..."));


            }
        });


    }
}
