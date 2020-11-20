package com.example.astroaegis;

public class PlanetHelper {
    private double suryaDegreeTotal, chandraDegreeTotal, kujaDegreeTotal, budhaDegreeTotal, guruDegreeTotal, shukraDegreeTotal, shanaischaraDegreeTotal, rahuDegreeTotal, ketuDegreeTotal;
    public PlanetHelper() {

    }
    public void setPlanetDegrees(String planetName, double degrees) {
        if(planetName.equals("Sun")) {
            suryaDegreeTotal = degrees;
        }
        else if(planetName.equals("Moon")) {
            chandraDegreeTotal = degrees;
        }
        else if(planetName.equals("Mars")) {
            kujaDegreeTotal = degrees;
        }
        else if(planetName.equals("Mercury")) {
            budhaDegreeTotal = degrees;
        }
        else if(planetName.equals("Jupiter")) {
            guruDegreeTotal = degrees;
        }
        else if(planetName.equals("Venus")) {
            shukraDegreeTotal = degrees;
        }
        else if(planetName.equals("Saturn")) {
            shanaischaraDegreeTotal = degrees;
        }
        else if(planetName.equals("true Node")) {
            rahuDegreeTotal = degrees;
        }
        else if(planetName.equals("Ketu")) {
            ketuDegreeTotal = degrees;
        }
    }
}
