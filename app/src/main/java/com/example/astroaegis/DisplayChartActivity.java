package com.example.astroaegis;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.Locale;
import java.util.HashMap;

import swisseph.SweConst;
import swisseph.SweDate;
import swisseph.SwissEph;


public class DisplayChartActivity extends AppCompatActivity {
    Intent newHoroscopeActivityIntent;
    TextView chartDisplayText;
    PlanetHelper ph;
    PlanetMethods pm;
    double suryaDegreeTotal, chandraDegreeTotal, kujaDegreeTotal, budhaDegreeTotal, guruDegreeTotal, shukraDegreeTotal, shanaischaraDegreeTotal, rahuDegreeTotal, ketuDegreeTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_chart);
        chartDisplayText = (TextView) findViewById(R.id.chartDisplayText);
        new CopyAssetFiles(".*\\.se1", getApplicationContext()).copy();
        newHoroscopeActivityIntent = getIntent();
        ph = new PlanetHelper();
        pm = new PlanetMethods();
        double latitude = Double.parseDouble(newHoroscopeActivityIntent.getStringExtra("latitude"));
        double longitude = Double.parseDouble(newHoroscopeActivityIntent.getStringExtra("longitude"));
        int year = Integer.parseInt(newHoroscopeActivityIntent.getStringExtra("year"));
        int month = Integer.parseInt(newHoroscopeActivityIntent.getStringExtra("month"));
        month++;
        int day = Integer.parseInt(newHoroscopeActivityIntent.getStringExtra("day"));
        double hour = Double.parseDouble(newHoroscopeActivityIntent.getStringExtra("finalTime"));
        String name = newHoroscopeActivityIntent.getStringExtra("name");
        computeChart(year, month, day, longitude, latitude, hour);
    }
    private void computeChart(int year, int month, int day, double longitude, double latitude, double hour) {

        String printString;

        /*Instances of utility classes */
        SwissEph sw = new SwissEph(getApplicationContext().getFilesDir() + File.separator + "/ephe");
        SweDate sd = new SweDate(year, month, day, hour);

        // Set sidereal mode:
        //sw.swe_set_sid_mode(SweConst.SE_SIDM_LAHIRI, 0, 0);
        sw.swe_set_sid_mode(SweConst.SE_SIDM_USER, 2415020, 23.1360266);
        System.out.println("Lahiri value"+SweConst.SE_SIDM_LAHIRI);
        // Print input details:
        printString = getDateinfo(sd);
        printString += getLocationinfo(longitude, latitude);
        // Output ayanamsa value:
        //////////////////////////////////////////////
        printString += "\n" + getAyanamsainfo(sw, sd);
        // Output lagna:
        //////////////////////////////////////////////
        printString += getLagnainfo(sw, sd, longitude, latitude);

        //////////////////////////////////////////////
        // Calculate all planets:
        //////////////////////////////////////////////
        printString += "\n" + getAllplanets(sw, sd);

        //testingSETV.setText(printString);
        printString += "\n Lagna " + ph.lagna.getRaashi();
        printString += " " + ph.lagna.getNakshatra();
        printString += " " + ph.lagna.getNakshatraPaada();

        printString += "\n Surya " + ph.surya.getRaashi();
        printString += " " + ph.surya.getNakshatra();
        printString += " " + ph.surya.getNakshatraPaada();
        printString += " " + ph.surya.getBhaavaNo();
        printString += " " + ph.surya.getBhaavaNoFromChandra();

        printString += "\n Chandra " + ph.chandra.getRaashi();
        printString += " " + ph.chandra.getNakshatra();
        printString += " " + ph.chandra.getNakshatraPaada();
        printString += " " + ph.chandra.getBhaavaNo();
        printString += " " + ph.chandra.getBhaavaNoFromChandra();

        printString += "\n Mangala " + ph.kuja.getRaashi();
        printString += " " + ph.kuja.getNakshatra();
        printString += " " + ph.kuja.getNakshatraPaada();
        printString += " " + ph.kuja.getBhaavaNo();
        printString += " " + ph.kuja.getBhaavaNoFromChandra();

        printString += "\n Budha " + ph.budha.getRaashi();
        printString += " " + ph.budha.getNakshatra();
        printString += " " + ph.budha.getNakshatraPaada();
        printString += " " + ph.budha.getBhaavaNo();
        printString += " " + ph.budha.getBhaavaNoFromChandra();

        printString += "\n Brihaspati " + ph.guru.getRaashi();
        printString += " " + ph.guru.getNakshatra();
        printString += " " + ph.guru.getNakshatraPaada();
        printString += " " + ph.guru.getBhaavaNo();
        printString += " " + ph.guru.getBhaavaNoFromChandra();

        printString += "\n Shukra " + ph.shukra.getRaashi();
        printString += " " + ph.shukra.getNakshatra();
        printString += " " + ph.shukra.getNakshatraPaada();
        printString += " " + ph.shukra.getBhaavaNo();
        printString += " " + ph.shukra.getBhaavaNoFromChandra();

        printString += "\n Shanaischara " + ph.shanaischara.getRaashi();
        printString += " " + ph.shanaischara.getNakshatra();
        printString += " " + ph.shanaischara.getNakshatraPaada();
        printString += " " + ph.shanaischara.getBhaavaNo();
        printString += " " + ph.shanaischara.getBhaavaNoFromChandra();

        printString += "\n Rahu " + ph.rahu.getRaashi();
        printString += " " + ph.rahu.getNakshatra();
        printString += " " + ph.rahu.getNakshatraPaada();
        printString += " " + ph.rahu.getBhaavaNo();
        printString += " " + ph.rahu.getBhaavaNoFromChandra();

        printString += "\n Ketu " + ph.ketu.getRaashi();
        printString += " " + ph.ketu.getNakshatra();
        printString += " " + ph.ketu.getNakshatraPaada();
        printString += " " + ph.ketu.getBhaavaNo();
        printString += " " + ph.ketu.getBhaavaNoFromChandra();

        System.out.println("print string "+printString);
        String finalPrintString = "";
        finalPrintString = ph.putGrahasInBhaavasInString(finalPrintString);
        Graha[] grahas = ph.getGrahas();
        finalPrintString+="Graha information:\n";
        finalPrintString+="Name\tDegrees\tRaashi\tNakshatra\tBhaava\tNakshatra Paada\n";
        finalPrintString = finalPrintString + ph.getGrahaDetailsAsAString();
        System.out.println(finalPrintString);
        chartDisplayText.setText(finalPrintString);

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
            System.out.println(planetName + "AND p is " + planet);
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
            System.out.println("XP values for "+planetName);
            for(int i = 0; i < xp.length; i++) {
                System.out.println(xp[i]+ " ");
            }
            s += String.format("%-9s %s %c\n",
                    planetName, toDMS(xp[0]), (retrograde ? 'R' : 'D'));
            double planetPosition = getPlanetPosition(xp[0]);
            System.out.println("Planet position: "+ planetPosition);
            double raashi_degrees = pm.getRaashiDegreesFromDegrees(planetPosition);
            System.out.println("Planet degrees in raashi: "+raashi_degrees);
            ph.setPlanetDegrees(planetName, planetPosition);
        }
        // KETU
        xp[0] = (xp[0] + 180.0) % 360;
        String planetName = "Ketu";

        s += String.format("%-9s %s %c\n",
                planetName, toDMS(xp[0]), (retrograde ? 'R' : 'D'));
        double planetPosition = getPlanetPosition(xp[0]);
        ph.setPlanetDegrees(planetName, planetPosition);
        ph.setUpChandraLagna(ph.chandra.getRaashiNumber());
        ph.setUpGrahas();
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
        ph.setPlanetDegrees("Ascendant", getPlanetPosition(acsc[0]));
        ph.setUpBhaavas();

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

    static int getDegrees(double d) {
        d += 0.5/3600./10000.;	// round to 1/1000 of a second
        int deg = (int) d;
        return deg;
    }

    static int getMinutes(double d) {
        d += 0.5/3600./10000.;	// round to 1/1000 of a second
        int deg = (int) d;
        d = (d - deg) * 60;
        int min = (int) d;
        return min;
    }

    static double getSeconds(double d) {
        d += 0.5/3600./10000.;	// round to 1/1000 of a second
        int deg = (int) d;
        d = (d - deg) * 60;
        int min = (int) d;
        d = (d - min) * 60;
        double sec = d;
        return sec;
    }

    double getPlanetPosition(double loc) {
        int planetDegree = getDegrees(loc);
        int planetMinute = getMinutes(loc);
        double planetSeconds = getSeconds(loc);
        String degreesDetails = planetDegree+"."+planetMinute;
        double planetPosition = Double.parseDouble(degreesDetails);
        return planetPosition;
    }
}