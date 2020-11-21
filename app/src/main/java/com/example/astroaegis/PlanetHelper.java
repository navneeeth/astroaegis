package com.example.astroaegis;

public class PlanetHelper {
    private double suryaDegreeTotal, chandraDegreeTotal, kujaDegreeTotal, budhaDegreeTotal, guruDegreeTotal, shukraDegreeTotal, shanaischaraDegreeTotal, rahuDegreeTotal, ketuDegreeTotal;
    public PlanetHelper() {

    }

    public int getRaashiNumber(double degrees) {
        int raashiNo = ((int) Math.floor(degrees) % 30)+1;
        return raashiNo;
    }

    public int[] getNakshatraNumber(int raashiNo, double degrees) {
        int minutes = (int) (degrees - Math.floor(degrees));
        int nakshatraNo, nakshatraPaada;
        if(raashiNo == 1) {
            if(minutes<13.20) {
                nakshatraNo = 1;
                if(minutes<3.2) {
                    nakshatraPaada = 1;
                }
                else if(minutes<6.4) {
                    nakshatraPaada = 2;
                }
                else if(minutes<10) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else if(minutes<26.40) {
                nakshatraNo = 2;
                if(minutes<16.4) {
                    nakshatraPaada = 1;
                }
                else if(minutes<20) {
                    nakshatraPaada = 2;
                }
                else if(minutes<23.2) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else {
                nakshatraNo = 3;
                nakshatraPaada = 1;
            }
        }
        else if(raashiNo == 2) {
            if(minutes<10) {
                nakshatraNo = 3;
                if(minutes<3.2) {
                    nakshatraPaada = 2;
                }
                else if(minutes<6.4) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else if(minutes<23.20){
                nakshatraNo = 4;
                if(minutes<13.2) {
                    nakshatraPaada = 1;
                }
                else if(minutes<16.4) {
                    nakshatraPaada = 2;
                }
                else if(minutes<20) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else {
                nakshatraNo = 5;
                if(minutes<26.4) {
                    nakshatraPaada = 1;
                }
                else {
                    nakshatraPaada = 2;
                }
            }
        }
        else if(raashiNo == 3) {
            if(minutes<6.40) {
                nakshatraNo = 5;
                if(minutes<3.2) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else if(minutes<20.00) {
                nakshatraNo = 6;
                if(minutes<10) {
                    nakshatraPaada = 1;
                }
                else if(minutes<13.2) {
                    nakshatraPaada = 2;
                }
                else if(minutes<16.4) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else {
                nakshatraNo = 7;
                if(minutes<23.2) {
                    nakshatraPaada = 1;
                }
                else if(minutes<26.4) {
                    nakshatraPaada = 2;
                }
                else {
                    nakshatraPaada = 3;
                }
            }
        }
        else if(raashiNo == 4) {
            if(minutes<3.20) {
                nakshatraNo = 7;
                nakshatraPaada = 4;
            }
            else if(minutes<16.40) {
                nakshatraNo = 8;
                if(minutes<6.4) {
                    nakshatraPaada = 1;
                }
                else if(minutes<10) {
                    nakshatraPaada = 2;
                }
                else if(minutes<13.2) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else {
                nakshatraNo = 9;
                if(minutes<20) {
                    nakshatraPaada = 1;
                }
                else if(minutes<23.2) {
                    nakshatraPaada = 2;
                }
                else if(minutes<26.4) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
        }
        else if(raashiNo == 5) {
             if (minutes < 13.20) {
                nakshatraNo = 10;
                 if(minutes<3.2) {
                     nakshatraPaada = 1;
                 }
                 else if(minutes<6.4) {
                     nakshatraPaada = 2;
                 }
                 else if(minutes<10) {
                     nakshatraPaada = 3;
                 }
                 else {
                     nakshatraPaada = 4;
                 }
             }
             else if (minutes < 26.40) {
                nakshatraNo = 11;
                 if(minutes<16.4) {
                     nakshatraPaada = 1;
                 }
                 else if(minutes<20) {
                     nakshatraPaada = 2;
                 }
                 else if(minutes<23.2) {
                     nakshatraPaada = 3;
                 }
                 else {
                     nakshatraPaada = 4;
                 }
                }
             else {
                nakshatraNo = 12;
                 nakshatraPaada = 1;
            }
        }
        else if(raashiNo == 6) {
            if(minutes<10) {
                nakshatraNo = 12;
                if(minutes<3.2) {
                    nakshatraPaada = 2;
                }
                else if(minutes<6.4) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else if(minutes<23.20){
                nakshatraNo = 13;
                if(minutes<13.2) {
                    nakshatraPaada = 1;
                }
                else if(minutes<16.4) {
                    nakshatraPaada = 2;
                }
                else if(minutes<20) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else {
                nakshatraNo = 14;
                if(minutes<26.4) {
                    nakshatraPaada = 1;
                }
                else {
                    nakshatraPaada = 2;
                }
            }
        }
        else if(raashiNo == 7) {
            if(minutes<6.40) {
                nakshatraNo = 14;
                if(minutes<3.2) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else if(minutes<20.00) {
                nakshatraNo = 15;
                if(minutes<10) {
                    nakshatraPaada = 1;
                }
                else if(minutes<13.2) {
                    nakshatraPaada = 2;
                }
                else if(minutes<16.4) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else {
                nakshatraNo = 16;
                if(minutes<23.2) {
                    nakshatraPaada = 1;
                }
                else if(minutes<26.4) {
                    nakshatraPaada = 2;
                }
                else {
                    nakshatraPaada = 3;
                }
            }
        }
        else if(raashiNo == 8) {
            if(minutes<3.20) {
                nakshatraNo = 16;
                nakshatraPaada = 4;
            }
            else if(minutes<16.40) {
                nakshatraNo = 17;
                if(minutes<6.4) {
                    nakshatraPaada = 1;
                }
                else if(minutes<10) {
                    nakshatraPaada = 2;
                }
                else if(minutes<13.2) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else {
                nakshatraNo = 18;
                if(minutes<20) {
                    nakshatraPaada = 1;
                }
                else if(minutes<23.2) {
                    nakshatraPaada = 2;
                }
                else if(minutes<26.4) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
        }
        else if(raashiNo == 9) {
            if (minutes < 13.20) {
                nakshatraNo = 19;
                if(minutes<3.2) {
                    nakshatraPaada = 1;
                }
                else if(minutes<6.4) {
                    nakshatraPaada = 2;
                }
                else if(minutes<10) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else if (minutes < 26.40) {
                nakshatraNo = 20;
                if(minutes<16.4) {
                    nakshatraPaada = 1;
                }
                else if(minutes<20) {
                    nakshatraPaada = 2;
                }
                else if(minutes<23.2) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
                }
            else {
                nakshatraNo = 21;
                nakshatraPaada = 1;
                }
        }
        else if(raashiNo == 10) {
            if(minutes<10) {
                nakshatraNo = 21;
                if(minutes<3.2) {
                    nakshatraPaada = 2;
                }
                else if(minutes<6.4) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else if(minutes<23.20){
                nakshatraNo = 22;
                if(minutes<13.2) {
                    nakshatraPaada = 1;
                }
                else if(minutes<16.4) {
                    nakshatraPaada = 2;
                }
                else if(minutes<20) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else {
                nakshatraNo = 23;
                if(minutes<26.4) {
                    nakshatraPaada = 1;
                }
                else {
                    nakshatraPaada = 2;
                }
            }
        }
        else if(raashiNo == 11) {
            if(minutes<6.40) {
                nakshatraNo = 23;
                if(minutes<3.2) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else if(minutes<20.00) {
                nakshatraNo = 24;
                if(minutes<10) {
                    nakshatraPaada = 1;
                }
                else if(minutes<13.2) {
                    nakshatraPaada = 2;
                }
                else if(minutes<16.4) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else {
                nakshatraNo = 25;
                if(minutes<23.2) {
                    nakshatraPaada = 1;
                }
                else if(minutes<26.4) {
                    nakshatraPaada = 2;
                }
                else {
                    nakshatraPaada = 3;
                }
            }
        }
        else {
            if(minutes<3.20) {
                nakshatraNo = 25;
                nakshatraPaada = 4;
            }
            else if(minutes<16.40) {
                nakshatraNo = 26;
                if(minutes<6.4) {
                    nakshatraPaada = 1;
                }
                else if(minutes<10) {
                    nakshatraPaada = 2;
                }
                else if(minutes<13.2) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
            else {
                nakshatraNo = 27;
                if(minutes<20) {
                    nakshatraPaada = 1;
                }
                else if(minutes<23.2) {
                    nakshatraPaada = 2;
                }
                else if(minutes<26.4) {
                    nakshatraPaada = 3;
                }
                else {
                    nakshatraPaada = 4;
                }
            }
        }
        int[] nakshatraSetInt = new int[2];
        nakshatraSetInt[0] = nakshatraNo;
        nakshatraSetInt[1] = nakshatraPaada;
        return nakshatraSetInt;
    }

    public void setPlanetDegrees(String planetName, double degrees) {
        if(planetName.equals("Sun")) {
            suryaDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            new Surya(raashiNo, nakshatraSet);
        }
        else if(planetName.equals("Moon")) {
            chandraDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            new Chandra(raashiNo, nakshatraSet);
        }
        else if(planetName.equals("Mars")) {
            kujaDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            new Kuja(raashiNo, nakshatraSet);
        }
        else if(planetName.equals("Mercury")) {
            budhaDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            new Budha(raashiNo, nakshatraSet);
        }
        else if(planetName.equals("Jupiter")) {
            guruDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            new Guru(raashiNo, nakshatraSet);
        }
        else if(planetName.equals("Venus")) {
            shukraDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            new Shukra(raashiNo, nakshatraSet);
        }
        else if(planetName.equals("Saturn")) {
            shanaischaraDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            new Shanaischara(raashiNo, nakshatraSet);
        }
        else if(planetName.equals("true Node")) {
            rahuDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            new Rahu(raashiNo, nakshatraSet);
        }
        else if(planetName.equals("Ketu")) {
            ketuDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            new Ketu(raashiNo, nakshatraSet);
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
