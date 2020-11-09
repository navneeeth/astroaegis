package com.example.astroaegis;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button newHoroscopeButton, openHoroscopeButton, worldChartButton;
        TextView responseTV;
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
            }
        });

    }
}