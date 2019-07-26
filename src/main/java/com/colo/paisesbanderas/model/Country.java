package com.colo.paisesbanderas.model;

public class Country {

    private String name;
    private String alpha2Code;
    private String capital;
    private String country;
    private String region;
    private int population;

    private String nativeName;
    private String demonym;
    private String subregion;

    //constructor
    public Country (){  }

    //metodos
    public String getAlpha2Code() {
        return alpha2Code;
    }
    public void setAlpha2Code(String alpha2code) {
        this.alpha2Code = alpha2code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
    public String getCapital() {  return capital;  }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegion(String region) { this.region = region;  }
    public String getRegion() { return region;  }

    public String getSubregion() { return subregion; }
    public void setSubregion(String subregion) { this.subregion = subregion;  }

    public String getPopulation() {  return Integer.toString(population); }
    public void setPopulation(int population) {  this.population = population;  }

    public String getNativeName() { return nativeName; }
    public void setNativename(String nativeName) { this.nativeName = nativeName; }

    public String getDemonym() { return demonym; }
    public void setDemonym(String demonym) { this.demonym = demonym; }
}
