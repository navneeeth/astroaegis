package com.example.astroaegis;

public class Kuja extends Graha {
    PlanetMethods ph;
    private int raashiNumber, nakshatraNumber, nakshatraPaada;
    private String raashi, nakshatra;
    private double degreesTotal, degrees;
    public Kuja(int raashiNo, int[] nakshatraSet) {
        raashiNumber = raashiNo;
        nakshatraNumber = nakshatraSet[0];
        nakshatraPaada = nakshatraSet[1];
        ph = new PlanetMethods();
        raashi = ph.getRaashiFromNumber(raashiNumber);
        nakshatra = ph.getNakshatraFromNumber(nakshatraNumber);
    }

    public Kuja() {
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
