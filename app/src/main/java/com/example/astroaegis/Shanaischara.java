package com.example.astroaegis;

public class Shanaischara {
    PlanetHelper ph;
    private int raashiNumber, nakshatraNumber, nakshatraPaada;
    private String raashi, nakshatra;
    public Shanaischara(int raashiNo, int[] nakshatraSet) {
        raashiNumber = raashiNo;
        nakshatraNumber = nakshatraSet[0];
        nakshatraPaada = nakshatraSet[1];
        ph = new PlanetHelper();
        raashi = ph.getRaashiFromNumber(raashiNumber);
        nakshatra = ph.getNakshatraFromNumber(nakshatraNumber);
    }
}
