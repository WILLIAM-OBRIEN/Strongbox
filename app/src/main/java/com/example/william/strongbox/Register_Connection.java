package com.example.william.strongbox;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class Register_Connection extends StringRequest {
    private static final String Android_Registration_URL = "http://www.strongboxencryption.com/android_registration.php";
    private Map<String, String> parameters;

    public Register_Connection(String name, String username, String email, String password, Response.Listener<String> listener)
    {
        super (Method.POST, Android_Registration_URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("name", name);
        parameters.put("username", username);
        parameters.put("email", email);
        parameters.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
