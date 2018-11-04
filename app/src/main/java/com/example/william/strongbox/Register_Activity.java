package com.example.william.strongbox;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Register_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);

        final EditText name_pt = findViewById(R.id.name_pt);
        final EditText register_username_pt = findViewById(R.id.register_username_pt );
        final EditText register_email_pt = findViewById(R.id.register_email_pt);
        final EditText register_password_pw = findViewById(R.id.register_password_pw );
        final Button register_button = findViewById(R.id.register_button );

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = name_pt.getText().toString();
                final String username = register_username_pt.getText().toString();
                final String email = register_email_pt.getText().toString();
                final String password = register_password_pw.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = (boolean) jsonObject.get("success");

                            if (success)
                            {
                                Intent loginPageIntent = new Intent(Register_Activity.this, Login_Activity.class);
                                Register_Activity.this.startActivity(loginPageIntent);
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Register_Activity.this);
                                builder.setMessage("Registration failure!").setNegativeButton("Retry",null).create().show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                Register_Connection register_connection = new Register_Connection(name,username,email,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(Register_Activity.this);
                queue.add(register_connection);
            }
        });
    }
}
