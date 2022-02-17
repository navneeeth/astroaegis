package com.example.astroaegis;

public class PlanetMethods {
    public PlanetMethods() {

    }

    public int getBhaavaFromLagna(int lagnaRaashi, int grahaRaashi) {
        int bhaava;
        if(grahaRaashi>=lagnaRaashi) {
            bhaava = grahaRaashi - lagnaRaashi + 1;
        }
        else {
            bhaava = grahaRaashi - lagnaRaashi + 13;
        }
        return bhaava;
    }

    public int getBhaavaFromChandra(int chandraRaashi, int grahaRaashi) {
        int bhaava;
        if(grahaRaashi>=chandraRaashi) {
            bhaava = grahaRaashi - chandraRaashi + 1;
        }
        else {
            bhaava = grahaRaashi - chandraRaashi + 13;
        }
        return bhaava;
    }

    public String getRaashiFromNumber(int raashiNumber) {
        switch(raashiNumber) {
            case 1:
                return "Mesha";
            case 2:
                return "Vrshabha";
            case 3:
                return "Mithuna";
            case 4:
                return "Kataka";
            case 5:
                return "Simha";
            case 6:
                return "Kanyaa";
            case 7:
                return "Thulaa";
            case 8:
                return "Vrschika";
            case 9:
                return "Dhanu";
            case 10:
                return "Makara";
            case 11:
                return "Kumbha";
            default:
                return "Meena";
        }
    }
    public String getNakshatraFromNumber(int raashiNumber) {
        switch(raashiNumber) {
            case 1:
                return "Ashwini";
            case 2:
                return "Bharani";
            case 3:
                return "Krittika";
            case 4:
                return "Rohini";
            case 5:
                return "Mrigashira";
            case 6:
                return "Ardra";
            case 7:
                return "Punarvasu";
            case 8:
                return "Pushya";
            case 9:
                return "Ashlesha";
            case 10:
                return "Magha";
            case 11:
                return "Poorvaphalguni";
            case 12:
                return "Uttaraphalguni";
            case 13:
                return "Hasta";
            case 14:
                return "Chitta";
            case 15:
                return "Swati";
            case 16:
                return "Vishakha";
            case 17:
                return "Anuradha";
            case 18:
                return "Jyestha";
            case 19:
                return "Moola";
            case 20:
                return "Poorvaashaadha";
            case 21:
                return "Uttaraashaadha";
            case 22:
                return "Shravana";
            case 23:
                return "Dhanishta";
            case 24:
                return "Shatabhisha";
            case 25:
                return "Poorvaabhaadrapada";
            case 26:
                return "Uttaraabhaadrapada";
            default:
                return "Revati";
        }
    }
    public double getRaashiDegreesFromDegrees(double degrees) {
        int quotient = (int) degrees / 30;
        System.out.println("Quotient is" + quotient);
        double raashi_degrees = degrees - quotient * 30;
        System.out.println("Raashi Degree is" + raashi_degrees);
        return raashi_degrees;
    }
}
