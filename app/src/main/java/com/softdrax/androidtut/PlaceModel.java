package com.softdrax.androidtut;


public class PlaceModel {
    int imgPlace;
    String placeName,placeDesc,placeLocation;
    public PlaceModel(int imgPlace,String placeName,String placeDesc){
        this.imgPlace=imgPlace;
        this.placeName=placeName;
        this.placeDesc=placeDesc;
    }

    public PlaceModel(int imgPlace,String placeName, String placeDesc,String placeLocation) {
        this.placeName = placeName;
        this.placeLocation=placeLocation;
        this.placeDesc = placeDesc;
    }
}
