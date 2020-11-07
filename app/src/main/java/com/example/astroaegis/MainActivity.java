package com.example.astroaegis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                Toast.makeText(MainActivity.this, "Feature still being developed!", Toast.LENGTH_LONG);
            }
        });
        worldChartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Feature still being developed!", Toast.LENGTH_LONG);
            }
        });
    }
}