package com.example.astroaegis;
import com.example.astroaegis.PlanetHelper.*;
public class Ketu {
    PlanetHelper ph;
    private int raashiNumber, nakshatraNumber;
    private String raashi, nakshatra;
    public Ketu(int raashiNo, int nakshatraNo) {
    raashiNumber = raashiNo;
    nakshatraNumber = nakshatraNo;
    ph = new PlanetHelper();
    raashi = ph.getRaashiFromNumber(raashiNumber);
    nakshatra = ph.getNakshatraFromNumber(nakshatraNumber);
    }
}
