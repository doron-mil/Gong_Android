package org.beyachad.gongandroid.main;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import org.beyachad.gongandroid.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText viewById = findViewById(R.id.editText);


        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(this);

        viewById.setText(sharedPref.getString(super.getString(R.string.SP_TOKEN_KEY),"llll"));
    }
}
