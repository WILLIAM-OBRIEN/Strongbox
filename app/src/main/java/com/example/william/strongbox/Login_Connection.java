package com.example.william.strongbox;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Login_Connection extends StringRequest {
    private static final String Android_Registration_URL = "http://www.strongboxencryption.com/android_login.php";
    private Map<String, String> parameters;

    public Login_Connection(String username, String password, Response.Listener<String> listener)
    {
        super (Request.Method.POST, Android_Registration_URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
