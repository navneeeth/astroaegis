package com.example.astroaegis;

public class Chandra {
    PlanetHelper ph;
    private int raashiNumber, nakshatraNumber;
    private String raashi, nakshatra;
    public Chandra(int raashiNo, int nakshatraNo) {
        raashiNumber = raashiNo;
        nakshatraNumber = nakshatraNo;
        ph = new PlanetHelper();
        raashi = ph.getRaashiFromNumber(raashiNumber);
        nakshatra = ph.getNakshatraFromNumber(nakshatraNumber);
    }
}
