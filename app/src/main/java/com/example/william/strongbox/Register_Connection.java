package com.example.william.strongbox;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Register_Connection extends StringRequest {

    private static final String Android_Registration_URL = "http://www.strongboxencryption.com/android_registration.php";
    private Map<String, String> parametres;

    public Register_Connection(String name, String username, String email, String password, Response.Listener<String> listener)
    {
        super (Method.POST, Android_Registration_URL, listener, null);
        parametres = new HashMap<>();
        parametres.put("name", name);
        parametres.put("username", username);
        parametres.put("email", email);
        parametres.put("password", password);
    }

    public Map<String, String> getParametres() {
        return parametres;
    }
}
