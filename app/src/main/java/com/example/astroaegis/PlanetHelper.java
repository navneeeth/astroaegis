package com.example.astroaegis;

import java.util.HashMap;

public class PlanetHelper {
    private double suryaDegreeTotal, chandraDegreeTotal, kujaDegreeTotal, budhaDegreeTotal, guruDegreeTotal, shukraDegreeTotal, shanaischaraDegreeTotal, rahuDegreeTotal, ketuDegreeTotal, lagnaDegreeTotal;
    Surya surya;
    Chandra chandra;
    Kuja kuja;
    Budha budha;
    Guru guru;
    Shukra shukra;
    Shanaischara shanaischara;
    Rahu rahu;
    Ketu ketu;
    Lagna lagna;
    PlanetMethods pm;
    Graha graha = new Graha();
    Graha[] g = new Graha[9];
    Integer[] planetRaashiNumbers = new Integer[9];
    public PlanetHelper() {

    }

    public void setUpBhaavas() {
        graha.setUpLagna(lagna.getRaashiNumber());
    }
    public void setUpChandraLagna(int raashiNumber) {
        graha.setUpChandraLagna(raashiNumber);
    }

    public int getRaashiNumber(double degrees) {
        int raashiNo = ((int) Math.floor(degrees) / 30)+1;
        return raashiNo;
    }

    String toDMS(double d) {
        d += 0.5/3600./10000.;	// round to 1/1000 of a second
        int deg = (int) d;
        d = (d - deg) * 60;
        int min = (int) d;
        d = (d - min) * 60;
        double sec = d;

        return String.format("%3d° %02d' %07.4f\"", deg, min, sec);
    }

    public String getGrahaDetailsAsAString() {
        pm = new PlanetMethods();
        String finalPrintString = "";
        finalPrintString+="Lagna\t";
        finalPrintString+=toDMS(pm.getRaashiDegreesFromDegrees(lagnaDegreeTotal))+"\t";
        finalPrintString+=lagna.getRaashi()+" \t";
        finalPrintString+=lagna.getNakshatra()+" \t";
        finalPrintString+="1\t";
        finalPrintString+=lagna.getNakshatraPaada()+"\n";

        finalPrintString+="Surya\t";
        finalPrintString+=toDMS(pm.getRaashiDegreesFromDegrees(suryaDegreeTotal))+"\t";
        finalPrintString+=surya.getRaashi()+" \t";
        finalPrintString+=surya.getNakshatra()+" \t";
        finalPrintString+=surya.getBhaavaNo()+" \t";
        finalPrintString+=surya.getNakshatraPaada()+"\n";

        finalPrintString+="Chandra\t";
        finalPrintString+=toDMS(pm.getRaashiDegreesFromDegrees(chandraDegreeTotal))+"\t";
        finalPrintString+=chandra.getRaashi()+" \t";
        finalPrintString+=chandra.getNakshatra()+" \t";
        finalPrintString+=chandra.getBhaavaNo()+" \t";
        finalPrintString+=chandra.getNakshatraPaada()+"\n";

        finalPrintString+="Mangala\t";
        finalPrintString+=toDMS(pm.getRaashiDegreesFromDegrees(kujaDegreeTotal))+"\t";
        finalPrintString+=kuja.getRaashi()+"\t";
        finalPrintString+=kuja.getNakshatra()+"\t";
        finalPrintString+=kuja.getBhaavaNo()+"\t";
        finalPrintString+=kuja.getNakshatraPaada()+"\n";

        finalPrintString+="Budha\t";
        finalPrintString+=toDMS(pm.getRaashiDegreesFromDegrees(budhaDegreeTotal))+"\t";
        finalPrintString+=budha.getRaashi()+"\t";
        finalPrintString+=budha.getNakshatra()+"\t";
        finalPrintString+=budha.getBhaavaNo()+"\t";
        finalPrintString+=budha.getNakshatraPaada()+"\n";

        finalPrintString+="Brihaspati\t";
        finalPrintString+=toDMS(pm.getRaashiDegreesFromDegrees(guruDegreeTotal))+"\t";
        finalPrintString+=guru.getRaashi()+"\t";
        finalPrintString+=guru.getNakshatra()+"\t";
        finalPrintString+=guru.getBhaavaNo()+"\t";
        finalPrintString+=guru.getNakshatraPaada()+"\n";

        finalPrintString+="Shukra\t";
        finalPrintString+=toDMS(pm.getRaashiDegreesFromDegrees(shukraDegreeTotal))+"\t";
        finalPrintString+=shukra.getRaashi()+"\t";
        finalPrintString+=shukra.getNakshatra()+"\t";
        finalPrintString+=shukra.getBhaavaNo()+"\t";
        finalPrintString+=shukra.getNakshatraPaada()+"\n";

        finalPrintString+="Shani\t";
        finalPrintString+=toDMS(pm.getRaashiDegreesFromDegrees(shanaischaraDegreeTotal))+"\t";
        finalPrintString+=shanaischara.getRaashi()+"\t";
        finalPrintString+=shanaischara.getNakshatra()+"\t";
        finalPrintString+=shanaischara.getBhaavaNo()+"\t";
        finalPrintString+=shanaischara.getNakshatraPaada()+"\n";

        finalPrintString+="Raahu\t";
        finalPrintString+=toDMS(pm.getRaashiDegreesFromDegrees(rahuDegreeTotal))+"\t";
        finalPrintString+=rahu.getRaashi()+"\t";
        finalPrintString+=rahu.getNakshatra()+"\t";
        finalPrintString+=rahu.getBhaavaNo()+"\t";
        finalPrintString+=rahu.getNakshatraPaada()+"\n";

        finalPrintString+="Ketu\t";
        finalPrintString+=toDMS(pm.getRaashiDegreesFromDegrees(ketuDegreeTotal))+"\t";
        finalPrintString+=ketu.getRaashi()+"\t";
        finalPrintString+=ketu.getNakshatra()+"\t";
        finalPrintString+=ketu.getBhaavaNo()+"\t";
        finalPrintString+=ketu.getNakshatraPaada()+"\n";
        return finalPrintString;
    }
    public String putGrahasInBhaavasInString(String finalPrintString) {
        HashMap<Integer, Graha[]> grahasInBhaavas = getGrahasInBhaavas();
        for(int i = 0; i < 12; i++) {
            finalPrintString+="Grahas in Bhaava "+(i+1)+": ";

            if(grahasInBhaavas.get(i+1).length==0) {
                finalPrintString += " - \n";
            }
            else {
                int grahaCount = 0;
                for(int j = 0; j<grahasInBhaavas.get(i+1).length; j++) {
                    if(grahasInBhaavas.get(i+1)[j] != null) {
                        if(grahaCount == 0) {
                            finalPrintString += grahasInBhaavas.get(i+1)[j].getGrahaName();

                        }
                        else {
                            finalPrintString += ", ";
                            finalPrintString += grahasInBhaavas.get(i+1)[j].getGrahaName();
                        }
                        grahaCount++;


                    }
                }
                finalPrintString+="\n";
            }
        }
        return finalPrintString;
    }

    public int[] getNakshatraNumber(int raashiNo, double degrees) {
        int nextHighestThirtyMultiple = (int) degrees/30;
        double minutes = (degrees - nextHighestThirtyMultiple*30);
        System.out.println("Minutes: "+minutes+" Raashi no "+raashiNo+ " and Degrees "+degrees);
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

    public Graha[] getGrahas() {
        return g;
    }

    public void setUpGrahas() {
        g[0] = surya;
        g[0].setGrahaName("Suurya");
        g[0].setGrahaObj(surya);
        g[1] = chandra;
        g[1].setGrahaName("Chandra");
        g[1].setGrahaObj(chandra);
        g[2] = kuja;
        g[2].setGrahaName("Mangala");
        g[2].setGrahaObj(kuja);
        g[3] = budha;
        g[3].setGrahaName("Budha");
        g[3].setGrahaObj(budha);
        g[4] = guru;
        g[4].setGrahaName("Brihaspati");
        g[4].setGrahaObj(guru);
        g[5] = shukra;
        g[5].setGrahaName("Shukra");
        g[5].setGrahaObj(shukra);
        g[6] = shanaischara;
        g[6].setGrahaName("Shani");
        g[6].setGrahaObj(shanaischara);
        g[7] = rahu;
        g[7].setGrahaName("Raahu");
        g[7].setGrahaObj(rahu);
        g[8] = ketu;
        g[8].setGrahaName("Ketu");
        g[8].setGrahaObj(ketu);
        for(int i = 0; i < g.length; i++) {
            g[i].setUpGraha(planetRaashiNumbers[i]);
        }
    }

    public HashMap<Integer, Graha[]> getGrahasInBhaavas() {
        HashMap<Integer, Graha[]> grahasInBhaavas = new HashMap<>(13);
        Graha[] grahasInHouse1 = new Graha[9];
        Graha[] grahasInHouse2 = new Graha[9];
        Graha[] grahasInHouse3 = new Graha[9];
        Graha[] grahasInHouse4 = new Graha[9];
        Graha[] grahasInHouse5 = new Graha[9];
        Graha[] grahasInHouse6 = new Graha[9];
        Graha[] grahasInHouse7 = new Graha[9];
        Graha[] grahasInHouse8 = new Graha[9];
        Graha[] grahasInHouse9 = new Graha[9];
        Graha[] grahasInHouse10 = new Graha[9];
        Graha[] grahasInHouse11 = new Graha[9];
        Graha[] grahasInHouse12 = new Graha[9];
        int h1 =0, h2=0, h3=0, h4=0, h5=0, h6=0, h7=0, h8=0, h9=0, h10=0, h11=0, h12=0;
        for(int i = 0; i < g.length; i++) {
            switch(g[i].getBhaavaNo()) {
                case 1:
                    grahasInHouse1[h1++] = g[i];
                    break;
                case 2:
                    grahasInHouse2[h2++] = g[i];
                    break;
                case 3:
                    grahasInHouse3[h3++] = g[i];
                    break;
                case 4:
                    grahasInHouse4[h4++] = g[i];
                    break;
                case 5:
                    grahasInHouse5[h5++] = g[i];
                    break;
                case 6:
                    grahasInHouse6[h6++] = g[i];
                    break;
                case 7:
                    grahasInHouse7[h7++] = g[i];
                    break;
                case 8:
                    grahasInHouse8[h8++] = g[i];
                    break;
                case 9:
                    grahasInHouse9[h9++] = g[i];
                    break;
                case 10:
                    grahasInHouse10[h10++] = g[i];
                    break;
                case 11:
                    grahasInHouse11[h11++] = g[i];
                    break;
                case 12:
                    grahasInHouse12[h12++] = g[i];
                    break;
            }
        }
        grahasInBhaavas.put(1, grahasInHouse1);
        grahasInBhaavas.put(2, grahasInHouse2);
        grahasInBhaavas.put(3, grahasInHouse3);
        grahasInBhaavas.put(4, grahasInHouse4);
        grahasInBhaavas.put(5, grahasInHouse5);
        grahasInBhaavas.put(6, grahasInHouse6);
        grahasInBhaavas.put(7, grahasInHouse7);
        grahasInBhaavas.put(8, grahasInHouse8);
        grahasInBhaavas.put(9, grahasInHouse9);
        grahasInBhaavas.put(10, grahasInHouse10);
        grahasInBhaavas.put(11, grahasInHouse11);
        grahasInBhaavas.put(12, grahasInHouse12);
        System.out.println(grahasInBhaavas);
        return grahasInBhaavas;
    }

    public void setPlanetDegrees(String planetName, double degrees) {

        if(planetName.equals("Sun")) {
            System.out.println("Sun: "+ degrees);
            suryaDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            surya = new Surya(raashiNo, nakshatraSet);
            surya.setDegrees(suryaDegreeTotal);
            planetRaashiNumbers[0] = raashiNo;
        }
        else if(planetName.equals("Moon")) {
            System.out.println("Moon: "+ degrees);
            chandraDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            chandra = new Chandra(raashiNo, nakshatraSet);
            chandra.setDegrees(chandraDegreeTotal);
            planetRaashiNumbers[1] = raashiNo;
        }
        else if(planetName.equals("Mars")) {
            System.out.println("Mars: "+ degrees);
            kujaDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            kuja = new Kuja(raashiNo, nakshatraSet);
            kuja.setDegrees(kujaDegreeTotal);
            planetRaashiNumbers[2] = raashiNo;
        }
        else if(planetName.equals("Mercury")) {
            System.out.println("Mercury: "+ degrees);
            budhaDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            budha = new Budha(raashiNo, nakshatraSet);
            budha.setDegrees(budhaDegreeTotal);
            planetRaashiNumbers[3] = raashiNo;
        }
        else if(planetName.equals("Jupiter")) {
            System.out.println("Jupiter: "+ degrees);
            guruDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            guru = new Guru(raashiNo, nakshatraSet);
            guru.setDegrees(guruDegreeTotal);
            planetRaashiNumbers[4] = raashiNo;
        }
        else if(planetName.equals("Venus")) {
            System.out.println("Venus: "+ degrees);
            shukraDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            shukra = new Shukra(raashiNo, nakshatraSet);
            shukra.setDegrees(shukraDegreeTotal);
            planetRaashiNumbers[5] = raashiNo;
        }
        else if(planetName.equals("Saturn")) {
            System.out.println("Saturn: "+ degrees);
            shanaischaraDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            shanaischara = new Shanaischara(raashiNo, nakshatraSet);
            shanaischara.setDegrees(shanaischaraDegreeTotal);
            planetRaashiNumbers[6] = raashiNo;
        }
        else if(planetName.equals("true Node")) {
            System.out.println("Rahu: "+ degrees);
            rahuDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            rahu = new Rahu(raashiNo, nakshatraSet);
            rahu.setDegrees(rahuDegreeTotal);
            planetRaashiNumbers[7] = raashiNo;
        }
        else if(planetName.equals("Ketu")) {
            System.out.println("Ketu: "+ degrees);
            ketuDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            ketu = new Ketu(raashiNo, nakshatraSet);
            ketu.setDegrees(ketuDegreeTotal);
            planetRaashiNumbers[8] = raashiNo;
        }
        else if(planetName.equals("Ascendant")) {
            System.out.println("Lagna: "+ degrees);
            lagnaDegreeTotal = degrees;
            int raashiNo = getRaashiNumber(degrees);
            int[] nakshatraSet = getNakshatraNumber(raashiNo, degrees);
            lagna = new Lagna(raashiNo, nakshatraSet);
            lagna.setDegrees(lagnaDegreeTotal);
        }
    }
}
