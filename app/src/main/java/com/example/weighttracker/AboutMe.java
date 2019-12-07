package com.example.weighttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AboutMe extends AppCompatActivity {
    public static final String PREFERENCES = "WT" ;
    EditText ed1,ed2,ed3,ed4,ed5;
    public Button button1;
    String username;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        ed1=(EditText)findViewById(R.id.txtname);
        ed2=(EditText)findViewById(R.id.txtdob);
        ed3=(EditText)findViewById(R.id.txtheight);
        ed4=(EditText)findViewById(R.id.txtweight);
        ed5=(EditText)findViewById(R.id.txtgoal);
        button1 = findViewById(R.id.btnLogin);


        SharedPreferences prefs = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
         username = prefs.getString("username", null);
        String name = prefs.getString(username+"_fullname", null);
        EditText FullName = (EditText)findViewById(R.id.txtname);
        FullName.setText(name, TextView.BufferType.EDITABLE);

        String dob = prefs.getString(username+"_dob", ed2.getText().toString());
        EditText date_birth = (EditText)findViewById(R.id.txtdob);
        date_birth.setText(dob, TextView.BufferType.EDITABLE);

        String height = prefs.getString(username+"_weight", ed3.getText().toString());
        EditText HeightEdit = (EditText)findViewById(R.id.txtheight);
        HeightEdit.setText(height, TextView.BufferType.EDITABLE);

        String weight = prefs.getString(username+"_weight", ed4.getText().toString());
        EditText WeightEdit = (EditText)findViewById(R.id.txtweight);
        WeightEdit.setText(weight, TextView.BufferType.EDITABLE);

        String goal = prefs.getString(username+"_goal", ed5.getText().toString());
        EditText GoalEdit = (EditText)findViewById(R.id.txtgoal);
        GoalEdit.setText(goal, TextView.BufferType.EDITABLE);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1.getText().toString().trim().length()==0|| ed2.getText().toString().trim().length()==0
                ||ed3.getText().toString().trim().length()==0||ed4.getText().toString().trim().length()==0
                ||ed5.getText().toString().trim().length()==0)
                {
                    Toast.makeText(AboutMe.this,"Required fields are missing",Toast.LENGTH_LONG).show();
                }
                else{



                    SharedPreferences.Editor editor = getSharedPreferences(PREFERENCES, MODE_PRIVATE).edit();







                    editor.putString(username+"_fullname", ed1.getText().toString());
                    editor.putString(username+"_dob", ed2.getText().toString());
                    editor.putString(username+"_height", ed3.getText().toString());
                    editor.putString(username+"_weight", ed4.getText().toString());
                  //  editor.putString(username+"_cweight", ed4.getText().toString());
                    editor.putString(username+"_goal", ed5.getText().toString());

                    editor.commit();
                    startActivity(new Intent(AboutMe.this, HomeActivity.class));
                }
            }
        });
    }
}
