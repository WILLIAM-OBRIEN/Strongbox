package com.example.william.strongbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class User_Main_Menu_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__main__menu_);

        final TextView username_tv  = findViewById(R.id.username_tv );

        Intent usernameIntent = getIntent();
        String username = usernameIntent.getStringExtra("username");

        username_tv.setText(username);
    }
}
