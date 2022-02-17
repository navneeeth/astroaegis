package com.example.astroaegis;

public class Graha {
    private int bhaavaNo;
    private int bhaavaNoFromChandra;
    private String grahaName;
    private Object grahaObj;
    private Surya surya;
    private Chandra chandra;
    private Budha budha;
    private Kuja kuja;
    private Guru guru;
    private Shukra shukra;
    private Shanaischara shani;
    private Rahu rahu;
    private Ketu ketu;

    private static int lagna;
    private static int chandraLagna;
    private PlanetMethods planetMethods = new PlanetMethods();

    Graha() {

    }

    public Object getGrahaObj() {
        return grahaObj;
    }

    public void setGrahaObj(Object grahaObj) {
        if(grahaObj instanceof Surya) {
            this.surya = (Surya) grahaObj;
            this.grahaObj = surya;
        }
        else if(grahaObj instanceof Chandra) {
            this.chandra = (Chandra) grahaObj;
            this.grahaObj = chandra;
        }
        else if(grahaObj instanceof Kuja) {
            this.kuja = (Kuja) grahaObj;
            this.grahaObj = kuja;
        }
        else if(grahaObj instanceof Budha) {
            this.budha = (Budha) grahaObj;
            this.grahaObj = budha;
        }
        else if(grahaObj instanceof Guru) {
            this.guru = (Guru) grahaObj;
            this.grahaObj = guru;
        }
        else if(grahaObj instanceof Shukra) {
            this.shukra = (Shukra) grahaObj;
            this.grahaObj = shukra;
        }
        else if(grahaObj instanceof Shanaischara) {
            this.shani = (Shanaischara) grahaObj;
            this.grahaObj = shani;
        }
        else if(grahaObj instanceof Rahu) {
            this.rahu = (Rahu) grahaObj;
            this.grahaObj = rahu;
        }
        else {
            this.ketu = (Ketu) grahaObj;
            this.grahaObj = ketu;
        }
    }
    public String getGrahaName() {
        return grahaName;
    }

    public void setGrahaName(String grahaName) {
        this.grahaName = grahaName;
    }

    public void setUpLagna(int raashiNumber) {
        lagna = raashiNumber;
    }
    public int getBhaavaNo() {
        return bhaavaNo;
    }

    public int getBhaavaNoFromChandra() {
        return bhaavaNoFromChandra;
    }

    public void setBhaavaNo(int bhaavaNo) {
        this.bhaavaNo = bhaavaNo;
    }

    public void setBhaavaNoFromChandra(int bhaavaNoFromChandra) {
        this.bhaavaNoFromChandra = bhaavaNoFromChandra;
    }
    public void setUpChandraLagna(int raashiNumber) {
        chandraLagna = raashiNumber;
    }
    public void setUpGraha(int raashiNumber) {
        setBhaavaNo(planetMethods.getBhaavaFromLagna(lagna, raashiNumber));
        setBhaavaNoFromChandra(planetMethods.getBhaavaFromChandra(chandraLagna, raashiNumber));
    }
}
