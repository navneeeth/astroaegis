package com.example.astroaegis;

public class Surya extends Graha {
    PlanetMethods ph;
    private int raashiNumber, nakshatraNumber, nakshatraPaada;
    private double degrees, degreesTotal;
    private String raashi, nakshatra;
    public Surya(int raashiNo, int[] nakshatraSet) {
        raashiNumber = raashiNo;
        nakshatraNumber = nakshatraSet[0];
        nakshatraPaada = nakshatraSet[1];
        System.out.println("Surya raashi number "+raashiNo);
        System.out.println("Surya nakshatrano "+nakshatraNumber);
        System.out.println("Surya nakshatra paada "+nakshatraPaada);
        ph = new PlanetMethods();
        raashi = ph.getRaashiFromNumber(raashiNumber);
        nakshatra = ph.getNakshatraFromNumber(nakshatraNumber);
        System.out.println("Surya raashi "+ raashi);
        System.out.println("Surya nakshatra "+nakshatra);
    }

    public Surya() {

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
