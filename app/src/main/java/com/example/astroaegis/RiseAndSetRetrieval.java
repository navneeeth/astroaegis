package com.example.astroaegis;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RiseAndSetRetrieval {
    private Calendar c;
    private int selectedDay, selectedMonth, selectedYear;

    RiseAndSetRetrieval(RequestQueue queue, String latitudeString, String longitudeString, String selectedMonthString, String selectedYearString, String selectedDayString) {
        c = Calendar.getInstance();
        selectedDay = c.get(Calendar.DAY_OF_MONTH);
        selectedMonth = c.get(Calendar.MONTH);
        selectedYear = c.get(Calendar.YEAR);
        System.out.println(" date info "+selectedDay+" "+selectedYear+" "+selectedMonth);
        makeAPICall(queue, latitudeString, longitudeString, selectedMonthString, selectedYearString, selectedDayString);
    }
    RiseAndSetRetrieval(RequestQueue queue) {
        c = Calendar.getInstance();
        selectedDay = c.get(Calendar.DAY_OF_MONTH);
        selectedMonth = c.get(Calendar.MONTH);
        selectedYear = c.get(Calendar.YEAR);
        System.out.println(" date info "+selectedDay+" "+selectedYear+" "+selectedMonth);

    }
    public void makeAPICallForSecondDay(RequestQueue queue, String latitudeString, String longitudeString, String nextDate) {
        String url ="https://api.sunrise-sunset.org/json?lat=";
        url+=latitudeString+"&lng="+longitudeString+"&date="+nextDate;
        System.out.println(url);
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        System.out.println("Response 2 is: "+ response);
                        //processResponse(response);
                        processResponseForSecondAPICall(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("That didn't work!");
            }
        });
    }

    public String getNextDay(String selectedYear, String selectedMonth, String selectedDay) throws ParseException {
        // Millseconds in a day
        long ONE_DAY_MILLI_SECONDS = 24 * 60 * 60 * 1000;

        // date format
        String DATE_FORMAT = "yyyy-MM-dd";
        String dateInString = selectedYear+"-"+selectedMonth+"-"+selectedDay;

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = dateFormat.parse(dateInString);

        // Getting the next day and formatting into 'YYYY-MM-DD'
        long nextDayMilliSeconds = date.getTime() + ONE_DAY_MILLI_SECONDS;
        Date nextDate = new Date(nextDayMilliSeconds);
        String nextDateStr = dateFormat.format(nextDate);
        System.out.println("Next date is "+nextDateStr);
        return nextDateStr;
    }
    public void makeAPICall(RequestQueue queue, String latitudeString, String longitudeString, String selectedMonthString, String selectedYearString, String selectedDayString) {

        //https://api.sunrise-sunset.org/json?lat=36.7201600&lng=-4.4203400&date=2022-02-14
        String url ="https://api.sunrise-sunset.org/json?lat=";
        url+=latitudeString+"&lng="+longitudeString+"&date="+selectedYearString+"-"+selectedMonthString+"-"+selectedDayString;
        System.out.println(url);
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        System.out.println("Response is: "+ response);
                        processResponse(response);
                        String nextDay = null;
                        try {
                            nextDay = getNextDay(selectedYearString, selectedMonthString, selectedDayString);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        makeAPICallForSecondDay(queue, latitudeString, longitudeString, nextDay);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
    public void processResponse(String response) {
        //System.out.println("Response is: "+ response);
        String jsonString = response; //assign your JSON String here
        JSONObject obj = null;
        try {
            obj = new JSONObject(jsonString);
            String sunrise = obj.getJSONObject("results").getString("sunrise");
            String sunset = obj.getJSONObject("results").getString("sunset");
            String day_length = obj.getJSONObject("results").getString("day_length");
            System.out.println("Sunrise"+sunrise);
            System.out.println("Sunset"+sunset);
            System.out.println("Day Length"+day_length);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void processResponseForSecondAPICall(String response) {
        String jsonString = response; //assign your JSON String here
        JSONObject obj = null;
        try {
            obj = new JSONObject(jsonString);
            String sunrise = obj.getJSONObject("results").getString("sunrise");

            System.out.println("Sunrise second day "+sunrise);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
