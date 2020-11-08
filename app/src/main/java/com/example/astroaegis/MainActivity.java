package com.example.astroaegis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);
        Button newHoroscopeButton, openHoroscopeButton, worldChartButton;
        Intent newHoroscopeActivityIntent, openHoroscopeActivityIntent, worldChartButtonActivityIntent;
        newHoroscopeButton = findViewById(R.id.newHoroscopeButton);
        openHoroscopeButton = findViewById(R.id.openHoroscopeButton);
        worldChartButton = findViewById(R.id.worldChartButton);
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
            }
        });
    }
    private StringRequest searchNameStringRequest(String nameSearch) {
        final String API = "&api_key=<<YOUR_API_KEY_HERE>>";
        final String NAME_SEARCH = "&q=";
        final String DATA_SOURCE = "&ds=Standard Reference";
        final String FOOD_GROUP = "&fg=";
        final String SORT = "&sort=r";
        final String MAX_ROWS = "&max=25";
        final String BEGINNING_ROW = "&offset=0";
        final String URL_PREFIX = "https://api.nal.usda.gov/ndb/search/?format=json";

        String url = URL_PREFIX + API + NAME_SEARCH + nameSearch + DATA_SOURCE + FOOD_GROUP + SORT + MAX_ROWS + BEGINNING_ROW;

        // 1st param => type of method (GET/PUT/POST/PATCH/etc)
        // 2nd param => complete url of the API
        // 3rd param => Response.Listener -> Success procedure
        // 4th param => Response.ErrorListener -> Error procedure
        return new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    // 3rd param - method onResponse lays the code procedure of success return
                    // SUCCESS
                    @Override
                    public void onResponse(String response) {
                        // try/catch block for returned JSON data
                        // see API's documentation for returned format
                        try {
                            JSONObject result = new JSONObject(response).getJSONObject("list");
                            int maxItems = result.getInt("end");
                            JSONArray resultList = result.getJSONArray("item");
                            // catch for the JSON parsing error
                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    } // public void onResponse(String response)
                }, // Response.Listener<String>()
                new Response.ErrorListener() {
                    // 4th param - method onErrorResponse lays the code procedure of error return
                    // ERROR
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // display a simple message on the screen
                        Toast.makeText(MainActivity.this, "Error loading a response.", Toast.LENGTH_LONG).show();
                    }
                });
    }
    public void btnSearchClickEventHandler(View view) {
        // cancelling all requests about this search if in queue
        // queue.cancelAll(TAG_SEARCH_NAME);

        // first StringRequest: getting items searched
        // StringRequest stringRequest = searchNameStringRequest(txtSearch.getText().toString());
        // stringRequest.setTag(TAG_SEARCH_NAME);

        // executing the request (adding to queue)
        // queue.add(stringRequest);
    }
}