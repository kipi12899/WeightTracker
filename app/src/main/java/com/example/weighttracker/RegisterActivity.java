package com.example.weighttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    public static final String PREFERENCES = "WT" ;
    EditText ed1,ed2,ed3;
    public  Button button1;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ed1= (EditText)findViewById(R.id.email);
        ed2=(EditText)findViewById(R.id.username);
        ed3=(EditText)findViewById(R.id.txtPwd);

        button1 = findViewById(R.id.btnLogin);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed2.getText().toString().trim().length()>0 && ed3.getText().toString().length()>0 && ed1.getText().toString().trim().length()>0) {

                    SharedPreferences.Editor editor = getSharedPreferences(PREFERENCES, MODE_PRIVATE).edit();

                    editor.putString("username", ed2.getText().toString().trim());
                    editor.putString("password", ed3.getText().toString());
                    editor.putString(ed2.getText().toString().trim() + "_email", ed1.getText().toString());
                    editor.commit();
                    startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"Missing Required Fields",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

