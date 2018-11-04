package com.example.william.strongbox;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = login_username_pt.getText().toString();
                final String password = login_password_pt.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            AlertDialog.Builder builder = new AlertDialog.Builder(Login_Activity.this);
                            if (success)
                            {
                                Intent main_menu_intent = new Intent(Login_Activity.this, User_Main_Menu_Activity.class);
                                main_menu_intent.putExtra("username", username);
                                Login_Activity.this.startActivity(main_menu_intent);
                            }
                            else
                            {
                                builder.setMessage("Login Failed!").setNegativeButton("Retry",null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                Login_Connection login_connection = new Login_Connection(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Login_Activity.this);
                queue.add(login_connection);
            }
        });
    }
}
