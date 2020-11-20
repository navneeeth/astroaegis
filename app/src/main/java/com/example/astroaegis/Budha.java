package com.example.astroaegis;

public class Budha {
    PlanetHelper ph;
    private int raashiNumber, nakshatraNumber;
    private String raashi, nakshatra;
    public Budha(int raashiNo, int nakshatraNo) {
        raashiNumber = raashiNo;
        nakshatraNumber = nakshatraNo;
        ph = new PlanetHelper();
        raashi = ph.getRaashiFromNumber(raashiNumber);
        nakshatra = ph.getNakshatraFromNumber(nakshatraNumber);
    }
}
