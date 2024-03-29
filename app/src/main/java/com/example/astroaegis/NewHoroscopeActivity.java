package com.example.astroaegis;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import static android.R.layout.simple_list_item_1;

public class NewHoroscopeActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    TextView userName, datePickerText, timePickerText, latitudeText, longitudeText;
    Button generateButton;
    SearchView locationSearchView;
    ListView locationSearchViewList;
    Intent displayChartIntent;
    ArrayList<String> list;
    private ArrayAdapter<String> adapter;
    Geocoder geocoder;
    Calendar timeInstance;
    String addressSelected = "";
    Double locationLatitude = 0.0, locationLongitude = 0.0;
    int selectedDay, selectedMonth, selectedYear;
    String chosenLocation;
    RiseAndSetRetrieval rsr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_horoscope);
        RequestQueue queue = Volley.newRequestQueue(this);

        userName = (TextView) findViewById(R.id.editTextName);
        datePickerText = (TextView) findViewById(R.id.datePickerText);
        timePickerText = (TextView) findViewById(R.id.timePickerText);
        locationSearchView = (SearchView) findViewById(R.id.locationSearchView);
        locationSearchViewList = (ListView) findViewById(R.id.locationSearchViewList);
        latitudeText = (TextView) findViewById(R.id.latitudeText);
        longitudeText = (TextView) findViewById(R.id.longitudeText);
        generateButton = (Button) findViewById(R.id.generateButton);
        displayChartIntent = new Intent(NewHoroscopeActivity.this, DisplayChartActivity.class);
        geocoder = new Geocoder(this);
        Calendar c = Calendar.getInstance();
        selectedDay = c.get(Calendar.DAY_OF_MONTH);
        selectedMonth = c.get(Calendar.MONTH);
        selectedYear = c.get(Calendar.YEAR);
        String defaultDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        defaultDateString = defaultDateString.substring(defaultDateString.indexOf(",")+1, defaultDateString.length());
        datePickerText.setText(defaultDateString);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int seconds = c.get(Calendar.SECOND);
        timeInstance = Calendar.getInstance();
        timeInstance.set(Calendar.MINUTE, minute);
        timeInstance.set(Calendar.HOUR_OF_DAY, hour);
        timeInstance.set(Calendar.SECOND, seconds);
        timePickerText.setText(""+hour+":"+minute+":"+seconds);
        locationSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                try {
                    List<Address> addresses = geocoder.getFromLocationName(newText, 5);
                    int noOfAddresses = addresses.size();
                    list = new ArrayList<String>();
                    for(int i = 0; i < noOfAddresses; i++) {
                        Address address = addresses.get(i);
                        String addressCity = address.getFeatureName();
                        String addressCountry = address.getCountryName();
                        Log.d("tag", addressCity+"is/n");
                        list.add(""+addressCity+", "+addressCountry);
                    }
                    adapter = new ArrayAdapter<String>(NewHoroscopeActivity.this, simple_list_item_1, list);
                    if(adapter!=null) {
                        locationSearchViewList.setAdapter(adapter);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        locationSearchViewList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addressSelected = locationSearchViewList.getItemAtPosition(position).toString();
                locationSearchView.setQuery(addressSelected, false);
                try {
                    if(addressSelected.length()>0) {
                        addressSelected = addressSelected.substring(0, addressSelected.indexOf(","));
                    }
                    List<Address> selectedLocationList = geocoder.getFromLocationName(addressSelected, 1);
                    Address selectedLocation = selectedLocationList.get(0);
                    locationLatitude = selectedLocation.getLatitude();
                    locationLongitude = selectedLocation.getLongitude();
                    latitudeText.setText(""+locationLatitude);
                    longitudeText.setText(""+locationLongitude);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        datePickerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getFragmentManager(), "date picker");
            }
        });
        timePickerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DialogFragment timePicker = new TimePickerFragment();
               timePicker.show(getFragmentManager(), "time picker");
            }
        });
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //RiseAndSetRetrieval rsr = new RiseAndSetRetrieval(queue, latitudeString, longitudeString, selectedMonthString, selectedYearString, selectedDayString);
                String name = userName.getText().toString();
                String timeOfBirth = timePickerText.getText().toString();
                double latitude = Double.parseDouble(latitudeText.getText().toString());
                Log.d("latitude", String.valueOf(latitude));
                double longitude = Double.parseDouble(longitudeText.getText().toString());
                Log.d("longitude", String.valueOf(longitude));
                String timeZone = TimezoneMapper.latLngToTimezoneString(latitude, longitude);
                Log.d("timezone", timeZone);
                TimeZone tz = TimeZone.getTimeZone(timeZone);
                long timeDifference = tz.getOffset(timeInstance.getTimeInMillis()) / 1000 / 60;
                Log.d("tz", String.valueOf(timeDifference));
                String finalHourString = timeOfBirth.substring(0, timeOfBirth.indexOf(":"));
                int finalHour = Integer.parseInt(finalHourString);
                String minuteSubString = timeOfBirth.substring(timeOfBirth.indexOf(":")+1, timeOfBirth.length());
                String finalMinuteString = minuteSubString.substring(0, minuteSubString.indexOf(":"));
                int finalMinute = Integer.parseInt(finalMinuteString);
                String finalSecondString = minuteSubString.substring(minuteSubString.indexOf(":")+1,minuteSubString.length());
                int finalSecond = Integer.parseInt(finalSecondString);
                double finalMinuteDouble = finalMinute + finalSecond/60.0;
                long noOfHours = timeDifference / 60;
                Log.d("noofhours", String.valueOf(noOfHours));
                double remainderMinutes = timeDifference % 60;
                Log.d("remainderMinutes", String.valueOf(remainderMinutes));
                double hourValue = noOfHours + remainderMinutes / 60;
                Log.d("hourValue", String.valueOf(hourValue));
                Log.d("finalHour", String.valueOf(finalHour));
                Log.d("finalMinuteDouble", String.valueOf(finalMinuteDouble));
                double finalTime = finalHour + finalMinuteDouble / 60. - hourValue;
                Log.d("finaltime", String.valueOf(finalTime));
                String latitudeString = String.valueOf(latitude);
                String longitudeString = String.valueOf(longitude);
                String finalTimeString = String.valueOf(finalTime);
                String selectedDayString = String.valueOf(selectedDay);
                String selectedMonthString = String.valueOf(selectedMonth);
                String selectedYearString = String.valueOf(selectedYear);

                rsr = new RiseAndSetRetrieval(queue, latitudeString, longitudeString, selectedMonthString, selectedYearString, selectedDayString);
                String nameString = String.valueOf(userName.getText().toString());
                displayChartIntent.putExtra("latitude", latitudeString);
                displayChartIntent.putExtra("longitude", longitudeString);
                displayChartIntent.putExtra("finalTime", finalTimeString);
                displayChartIntent.putExtra("day", selectedDayString);
                displayChartIntent.putExtra("month", selectedMonthString);
                displayChartIntent.putExtra("year", selectedYearString);
                displayChartIntent.putExtra("name", nameString);
                startActivity(displayChartIntent);
            }
        });
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        timeInstance = Calendar.getInstance();
        timeInstance.set(Calendar.MINUTE, minute);
        timeInstance.set(Calendar.HOUR_OF_DAY, hourOfDay);
        timePickerText.setText(""+hourOfDay+":"+minute);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        selectedDay = dayOfMonth;
        selectedMonth = month;
        selectedYear = year;
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        currentDateString = currentDateString.substring(currentDateString.indexOf(",")+1, currentDateString.length());
        datePickerText.setText(currentDateString);
    }
}