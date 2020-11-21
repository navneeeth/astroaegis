package com.example.astroaegis;

public class Budha {
    PlanetHelper ph;
    private int raashiNumber, nakshatraNumber, nakshatraPaada;
    private String raashi, nakshatra;
    public Budha(int raashiNo, int[] nakshatraSet) {
        raashiNumber = raashiNo;
        nakshatraNumber = nakshatraSet[0];
        nakshatraPaada = nakshatraSet[1];
        ph = new PlanetHelper();
        raashi = ph.getRaashiFromNumber(raashiNumber);
        nakshatra = ph.getNakshatraFromNumber(nakshatraNumber);
    }
}
