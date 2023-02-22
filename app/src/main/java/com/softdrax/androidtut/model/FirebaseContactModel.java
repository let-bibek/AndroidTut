package com.softdrax.androidtut.model;

public class FirebaseContactModel {
    String name;
    String moNbr;
    String childID;



   public FirebaseContactModel(String name,String moNbr){
        this.name=name;
        this.moNbr=moNbr;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoNbr() {
        return moNbr;
    }

    public void setMoNbr(String moNbr) {
        this.moNbr = moNbr;
    }
}
