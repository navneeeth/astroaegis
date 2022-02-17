package com.example.astroaegis;

public class Lagna {
    PlanetMethods ph;
    private int raashiNumber, nakshatraNumber, nakshatraPaada;
    private String raashi, nakshatra;
    private double degreesTotal, degrees;
    public Lagna(int raashiNo, int[] nakshatraSet) {
        raashiNumber = raashiNo;
        nakshatraNumber = nakshatraSet[0];
        nakshatraPaada = nakshatraSet[1];
        ph = new PlanetMethods();
        raashi = ph.getRaashiFromNumber(raashiNumber);
        nakshatra = ph.getNakshatraFromNumber(nakshatraNumber);
    }

    public Lagna() {
    }
    public double getDegrees() {
        return degrees;
    }

    public int getRaashiNumber() {
        return raashiNumber;
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