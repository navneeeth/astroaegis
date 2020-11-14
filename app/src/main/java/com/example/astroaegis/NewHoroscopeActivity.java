package com.example.astroaegis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import swisseph.SweConst;
import swisseph.SweDate;
import swisseph.SwissEph;

import static android.R.layout.simple_list_item_1;

public class NewHoroscopeActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    TextView testingSETV, datePickerText, timePickerText;
    SearchView locationSearchView;
    ListView locationSearchViewList;
    ArrayList<String> list;
    private ArrayAdapter<String> adapter, adapter1;
    Geocoder geocoder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_horoscope);
        testingSETV = findViewById(R.id.testingSETV);
        datePickerText = (TextView) findViewById(R.id.datePickerText);
        timePickerText = (TextView) findViewById(R.id.timePickerText);
        locationSearchView = (SearchView) findViewById(R.id.locationSearchView);
        locationSearchViewList = (ListView) findViewById(R.id.locationSearchViewList);
        geocoder = new Geocoder(this);
        Calendar c = Calendar.getInstance();
        String defaultDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        datePickerText.setText(defaultDateString);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        timePickerText.setText(""+hour+":"+minute);
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
                    locationSearchViewList.setAdapter(adapter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //adapter.getFilter().filter(newText);
                return false;
            }
        });
        new CopyAssetFiles(".*\\.se1", getApplicationContext()).copy();
        computeChart();
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
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        timePickerText.setText(""+hourOfDay+":"+minute);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        datePickerText.setText(currentDateString);
    }

    private void computeChart() {
        // Input data:
        int year = 2000;
        int month = 2;
        int day = 24;
        double longitude = 77 + 59 / 60.0;    // Chennai
        double latitude = 12 + 57 / 60.0;
        double hour = 9 + 37. / 60. - 5.5; // IST
        String printString;

        /*Instances of utility classes */
        SwissEph sw = new SwissEph(getApplicationContext().getFilesDir() + File.separator + "/ephe");
        SweDate sd = new SweDate(year, month, day, hour);

        // Set sidereal mode:
        sw.swe_set_sid_mode(SweConst.SE_SIDM_LAHIRI, 0, 0);

        // Print input details:
        printString = getDateinfo(sd);
        printString += getLocationinfo(longitude, latitude);

        //////////////////////////////////////////////
        // Output ayanamsa value:
        //////////////////////////////////////////////
        printString += "\n" + getAyanamsainfo(sw, sd);

        //////////////////////////////////////////////
        // Output lagna:
        //////////////////////////////////////////////
        printString += getLagnainfo(sw, sd, longitude, latitude);

        //////////////////////////////////////////////
        // Calculate all planets:
        //////////////////////////////////////////////
        printString += "\n" + getAllplanets(sw, sd);

        //testingSETV.setText(printString);
    }

    private String getAllplanets(SwissEph sw, SweDate sd) {
        double[] xp = new double[6];
        StringBuffer serr = new StringBuffer();
        String s = "";

        int[] planets = { SweConst.SE_SUN,
                SweConst.SE_MOON,
                SweConst.SE_MARS,
                SweConst.SE_MERCURY,
                SweConst.SE_JUPITER,
                SweConst.SE_VENUS,
                SweConst.SE_SATURN,
                SweConst.SE_TRUE_NODE };	// Some systems prefer SE_MEAN_NODE

        int flags = SweConst.SEFLG_SWIEPH |        // slow and least accurate calculation method
                SweConst.SEFLG_SIDEREAL |    // sidereal zodiac
                SweConst.SEFLG_NONUT |        // will be set automatically for sidereal calculations, if not set here
                SweConst.SEFLG_SPEED;        // to determine retrograde vs. direct motion
        boolean retrograde = false;

        for(int p = 0; p < planets.length; p++) {
            int planet = planets[p];
            String planetName = sw.swe_get_planet_name(planet);
            int ret = sw.swe_calc_ut(sd.getJulDay(),
                    planet,
                    flags,
                    xp,
                    serr);

            if (ret != flags) {
                if (serr.length() > 0) {
                    System.err.println("Warning: " + serr);
                } else {
                    System.err.println(
                            String.format("Warning, different flags used (0x%x)", ret));
                }
            }

            retrograde = (xp[3] < 0);

            s += String.format("%-9s %s %c\n",
                    planetName, toDMS(xp[0]), (retrograde ? 'R' : 'D'));
        }
        // KETU
        xp[0] = (xp[0] + 180.0) % 360;
        String planetName = "Ketu";

        s += String.format("%-9s %s %c\n",
                planetName, toDMS(xp[0]), (retrograde ? 'R' : 'D'));
        return s;
    }

    private String getAyanamsainfo(SwissEph sw, SweDate sd) {
        double ayanamsa = sw.swe_get_ayanamsa_ut(sd.getJulDay());
        return "Ayanamsa  " + toDMS(ayanamsa) + "\n";
    }

    private String getLocationinfo(double longitude, double latitude) {
        return "\nLocation  " +
                toDMS(longitude) + (longitude > 0 ? "E" : "W") +
                "\n          " +
                toDMS(latitude) + (latitude > 0 ? "N" : "S");
    }

    private String getDateinfo(SweDate sd) {
        double hour = sd.getHour() + 0.5/3600.;
        int min = (int)((hour - (int)hour) * 60);
        int sec = (int)(((hour - (int)hour) * 60 - min) * 60);
        return String.format(Locale.US, "Date: %4d-%02d-%02d, %d:%02d:%02dh UTC / %.8fh\nJul.day:    %.6f\nDelta t:  %s\n",
                sd.getYear(),
                sd.getMonth(),
                sd.getDay(),
                (int)hour,
                min,
                sec,
                hour,
                sd.getJulDay(),
                toDMS(sd.getDeltaT()));
    }

    private String getLagnainfo(SwissEph sw, SweDate sd, double longitude, double latitude) {
        int flags = SweConst.SEFLG_SIDEREAL;
        double[] cusps = new double[13];
        double[] acsc = new double[10];

        int result = sw.swe_houses(sd.getJulDay(),
                flags,
                latitude,
                longitude,
                'P',
                cusps,
                acsc);

        return "Ascendant " + toDMS(acsc[0]) + "\n";
    }

    static String toDMS(double d) {
        d += 0.5/3600./10000.;	// round to 1/1000 of a second
        int deg = (int) d;
        d = (d - deg) * 60;
        int min = (int) d;
        d = (d - min) * 60;
        double sec = d;

        return String.format("%3d° %02d' %07.4f\"", deg, min, sec);
    }

}