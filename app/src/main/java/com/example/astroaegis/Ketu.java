package com.example.astroaegis;
public class Ketu extends Graha {
    PlanetMethods ph;
    private int raashiNumber, nakshatraNumber, nakshatraPaada;
    private String raashi, nakshatra;
    private double degrees, degreesTotal;
    public Ketu(int raashiNo, int[] nakshatraSet) {
    raashiNumber = raashiNo;
    nakshatraNumber = nakshatraSet[0];
    nakshatraPaada = nakshatraSet[1];
        ph = new PlanetMethods();
    raashi = ph.getRaashiFromNumber(raashiNumber);
    nakshatra = ph.getNakshatraFromNumber(nakshatraNumber);
    }

    public Ketu() {
    }

    public double getDegrees() {
        return degrees;
    }

    public int getRaashiNumber() {
        return this.raashiNumber;
    }

    public String getRaashi() {
        return raashi;
    }

    public String getNakshatra() {
        return nakshatra;
    }

    public int getNakshatraPaada() {
        return nakshatraPaada;
    }

    public int getNakshatraNumber() {
        return nakshatraNumber;
    }

    public void setDegreesTotal(double degTotal) {
        degreesTotal = degTotal;
    }

    public void setDegrees(double degreesAbs) {
        degrees = degreesAbs;
    }
}
