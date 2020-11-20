package com.example.astroaegis;

public class PlanetHelper {
    private double suryaDegreeTotal, chandraDegreeTotal, kujaDegreeTotal, budhaDegreeTotal, guruDegreeTotal, shukraDegreeTotal, shanaischaraDegreeTotal, rahuDegreeTotal, ketuDegreeTotal;
    public PlanetHelper() {

    }

    public int getRaashiNumber(double degrees) {
        int raashiNo = ((int) Math.floor(degrees) % 30)+1;
        return raashiNo;
    }

    public int getNakshatraNumber(int raashiNo, double degrees) {
        int minutes = (int) (degrees - Math.floor(degrees));
        int nakshatraNo;
        if(raashiNo == 1 || raashiNo == 5 || raashiNo == 9) {
            if(minutes<13.20) {
                nakshatraNo = 3*(raashiNo-1)+1;
            }
            else if(minutes<26.40) {
                nakshatraNo = 3*(raashiNo-1)+2;
            }
            else {
                nakshatraNo = 3*(raashiNo-1)+3;
            }
        }
        else if(raashiNo == 2 || raashiNo == 6 || raashiNo == 10) {
            if(minutes<10) {
                nakshatraNo = 3*(raashiNo-1)+1;
            }
            else if(minutes<23.20){
                nakshatraNo = 3*(raashiNo-1)+2;
            }
            else {
                nakshatraNo = 3*(raashiNo-1)+3;
            }
        }
        else if(raashiNo == 3 || raashiNo == 7 || raashiNo == 11) {
            if(minutes<6.40) {
                nakshatraNo = 3*(raashiNo-1)+1;
            }
            else if(minutes<20.00) {
                nakshatraNo = 3*(raashiNo-1)+2;
            }
            else {
                nakshatraNo = 3*(raashiNo-1)+3;
            }
        }
        else {
            if(minutes<3.20) {
                nakshatraNo = 3*(raashiNo-1)+1;
            }
            else if(minutes<16.40) {
                nakshatraNo = 3*(raashiNo-1)+2;
            }
            else {
                nakshatraNo = 3*(raashiNo-1)+3;
            }
        }
        return nakshatraNo;
    }

    public void setPlanetDegrees(String planetName, double degrees) {
        if(planetName.equals("Sun")) {
            suryaDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int nakshatraNo = getNakshatraNumber(raashiNo, degrees);
            new Surya(raashiNo, nakshatraNo);
        }
        else if(planetName.equals("Moon")) {
            chandraDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int nakshatraNo = getNakshatraNumber(raashiNo, degrees);
            new Chandra(raashiNo, nakshatraNo);
        }
        else if(planetName.equals("Mars")) {
            kujaDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int nakshatraNo = getNakshatraNumber(raashiNo, degrees);
            new Kuja(raashiNo, nakshatraNo);
        }
        else if(planetName.equals("Mercury")) {
            budhaDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int nakshatraNo = getNakshatraNumber(raashiNo, degrees);
            new Budha(raashiNo, nakshatraNo);
        }
        else if(planetName.equals("Jupiter")) {
            guruDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int nakshatraNo = getNakshatraNumber(raashiNo, degrees);
            new Guru(raashiNo, nakshatraNo);
        }
        else if(planetName.equals("Venus")) {
            shukraDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int nakshatraNo = getNakshatraNumber(raashiNo, degrees);
            new Shukra(raashiNo, nakshatraNo);
        }
        else if(planetName.equals("Saturn")) {
            shanaischaraDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int nakshatraNo = getNakshatraNumber(raashiNo, degrees);
            new Shanaischara(raashiNo, nakshatraNo);
        }
        else if(planetName.equals("true Node")) {
            rahuDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int nakshatraNo = getNakshatraNumber(raashiNo, degrees);
            new Rahu(raashiNo, nakshatraNo);
        }
        else if(planetName.equals("Ketu")) {
            ketuDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int nakshatraNo = getNakshatraNumber(raashiNo, degrees);
            new Ketu(raashiNo, nakshatraNo);
        }
    }
    public String getRaashiFromNumber(int raashiNumber) {
        switch(raashiNumber) {
            case 1:
                return "Aries";
            case 2:
                return "Taurus";
            case 3:
                return "Gemini";
             case 4:
                return "Cancer";
            case 5:
                return "Leo";
            case 6:
                return "Virgo";
            case 7:
                return "Libra";
            case 8:
                return "Scorpio";
            case 9:
                return "Sagittarius";
            case 10:
                return "Capricorn";
            case 11:
                 return "Aquarius";
            default:
                 return "Pisces";
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
}
