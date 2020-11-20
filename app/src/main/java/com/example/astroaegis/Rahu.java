package com.example.astroaegis;

public class Rahu {
    PlanetHelper ph;
    private int raashiNumber, nakshatraNumber;
    private String raashi, nakshatra;
    public Rahu(int raashiNo, int nakshatraNo) {
        raashiNumber = raashiNo;
        nakshatraNumber = nakshatraNo;
        ph = new PlanetHelper();
        raashi = ph.getRaashiFromNumber(raashiNumber);
        nakshatra = ph.getNakshatraFromNumber(nakshatraNumber);
    }
}
