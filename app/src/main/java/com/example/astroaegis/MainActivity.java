package com.example.astroaegis;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    private TextView responseTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button newHoroscopeButton, openHoroscopeButton, worldChartButton;
        Intent newHoroscopeActivityIntent, openHoroscopeActivityIntent, worldChartButtonActivityIntent;
        newHoroscopeButton = findViewById(R.id.newHoroscopeButton);
        openHoroscopeButton = findViewById(R.id.openHoroscopeButton);
        worldChartButton = findViewById(R.id.worldChartButton);
        responseTV = findViewById(R.id.responseTV);
        newHoroscopeActivityIntent = new Intent(MainActivity.this, NewHoroscopeActivity.class);
        newHoroscopeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(newHoroscopeActivityIntent);
            }
        });
        openHoroscopeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast openHoroscopeButtonToast = Toast.makeText(MainActivity.this, "Feature still being developed!", Toast.LENGTH_LONG);
                openHoroscopeButtonToast.show();
            }
        });
        worldChartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast worldChartButtonToast = Toast.makeText(MainActivity.this, "Feature still being developed!", Toast.LENGTH_LONG);
                worldChartButtonToast.show();
                jsonParse();
            }
        });
        mQueue = Volley.newRequestQueue(this);
    }
    private void jsonParse() {
        String url = "https://astrology4.p.rapidapi.com/kundli?ayanamsa=1&datetime=2000-02-24T09%3A37%2B05%3A30&coordinates=12.97%2C%2077.59";
        //String url = "https://api.myjson.com/bins/kp9wz";
        JsonObjectRequest request  = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject nakshatra_details = response.getJSONObject("nakshatra_details");
                            JSONObject chandra_rasi = nakshatra_details.getJSONObject("chandra_rasi");
                            int rasiId = chandra_rasi.getInt("id");
                            /*
                            for(int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);
                                String firstName = employee.getString("firstname");
                                int age = employee.getInt("age");
                                String mail = employee.getString("nail");
                                responseTV.append(firstName+", "+String.valueOf(age)+", "+mail+"\n\n");

                            }

                             */
                            responseTV.append(String.valueOf(rasiId));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError{
                HashMap<String, String> headers = new HashMap<String, String>();
                //headers.put("x-rapidapi-key", "");
                headers.put("x-rapidapi-host", "astrology4.p.rapidapi.com");
                headers.put("x-rapidapi-key", "");
                headers.put("useQueryString", "true");
                headers.put("client-id", "");
                headers.put("client-secret", "");
                return headers;
            }
        };
        mQueue.add(request);
    }
}