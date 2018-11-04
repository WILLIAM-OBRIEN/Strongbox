package com.example.william.strongbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        final EditText login_username_pt  = findViewById(R.id.login_username_pt);
        final EditText login_password_pt  = findViewById(R.id.login_password_pt );
        final Button login_button  = findViewById(R.id.login_button );
        final TextView register_tv  = findViewById(R.id.register_tv);

        register_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerlinkintent = new Intent(Login_Activity.this, Register_Activity.class);
                Login_Activity.this.startActivity(registerlinkintent);
            }
        });
    }
}
