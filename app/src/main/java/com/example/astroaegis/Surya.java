package com.example.astroaegis;

public class Surya {
    PlanetHelper ph;
    private int raashiNumber, nakshatraNumber, nakshatraPaada;
    private String raashi, nakshatra;
    public Surya(int raashiNo, int[] nakshatraSet) {
        raashiNumber = raashiNo;
        nakshatraNumber = nakshatraSet[0];
        nakshatraPaada = nakshatraSet[1];
        ph = new PlanetHelper();
        raashi = ph.getRaashiFromNumber(raashiNumber);
        nakshatra = ph.getNakshatraFromNumber(nakshatraNumber);
    }
}
