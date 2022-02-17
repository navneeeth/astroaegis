package com.example.astroaegis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class OpenHoroscopeActivity extends AppCompatActivity {
    RiseAndSetRetrieval rsr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_horoscope);
        RequestQueue queue = Volley.newRequestQueue(this);;
        rsr = new RiseAndSetRetrieval(queue);

    }
}