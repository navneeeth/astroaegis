package com.example.astroaegis;

public class Kuja {
    PlanetHelper ph;
    private int raashiNumber, nakshatraNumber;
    private String raashi, nakshatra;
    public Kuja(int raashiNo, int nakshatraNo) {
        raashiNumber = raashiNo;
        nakshatraNumber = nakshatraNo;
        ph = new PlanetHelper();
        raashi = ph.getRaashiFromNumber(raashiNumber);
        nakshatra = ph.getNakshatraFromNumber(nakshatraNumber);
    }
}
