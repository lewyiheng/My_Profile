package com.example.a17010407.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.radioGroupGender);

    }

    @Override
    protected void onPause() {
        super.onPause();

        //Get the user input from the EditText and store it in a variable
        String strName = etName.getText().toString();
        String dbGPA = etGPA.getText().toString();
        int gender = rgGender.getCheckedRadioButtonId();

        //Obtain an Instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Obtain an Instance of the SharedPreferences Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        //Add the key-value pair
        prefEdit.putString("name",strName);
        prefEdit.putString("gpa",dbGPA);
        prefEdit.putInt("gender",gender);
        //          The value should be form the variable defined.
        //Call commit() method to save the changes into SharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Retrieve the saved data from the SharedPreferences object
        String msg = prefs.getString("name","Default Name");
        String gpa = prefs.getString("gpa","Default GPA");
        int gender = prefs.getInt("gender",-1);

        //Update the UI element with the value
        etName.setText(msg);
        etGPA.setText(gpa);
        

    }
}
