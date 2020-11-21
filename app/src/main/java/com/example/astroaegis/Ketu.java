package com.example.astroaegis;
import com.example.astroaegis.PlanetHelper.*;
public class Ketu {
    PlanetHelper ph;
    private int raashiNumber, nakshatraNumber, nakshatraPaada;
    private String raashi, nakshatra;
    public Ketu(int raashiNo, int[] nakshatraSet) {
    raashiNumber = raashiNo;
    nakshatraNumber = nakshatraSet[0];
    nakshatraPaada = nakshatraSet[1];
    ph = new PlanetHelper();
    raashi = ph.getRaashiFromNumber(raashiNumber);
    nakshatra = ph.getNakshatraFromNumber(nakshatraNumber);
    }
}
