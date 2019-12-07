package com.example.weighttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    public static final String PREFERENCES = "WT" ;
    EditText ed1,ed2;
    public  Button button1;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed1=(EditText)findViewById(R.id.username);
        ed2=(EditText)findViewById(R.id.txtPwd);
        button1 = findViewById(R.id.btnLogin);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
                String s_username = prefs.getString("username", null);
                String s_pass = prefs.getString("password", null);
                String dob = prefs.getString(s_username+"_dob", null);
                String e_username  = ed1.getText().toString().trim();
                String e_pass  = ed2.getText().toString();
                if(s_username.toLowerCase().equals(e_username.toLowerCase()) && s_pass.equals(e_pass)) {
                    if(dob!=null)
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    else {
                        Intent intent = new Intent(LoginActivity.this,AboutMe.class);
                        intent.putExtra("EXTRA_USERNAME", s_username);
                        startActivity(intent);
                    }
                }
                else
                    Toast.makeText(LoginActivity.this,"Wrong User Name or Password",Toast.LENGTH_LONG).show();
            }
        });

        Button button2 = findViewById(R.id.btnRegister);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }


}
