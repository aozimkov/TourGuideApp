package com.example.android.tourguideapp;

import java.net.URL;

/**
 * Class for any types of cards in app
 *
 */

public class Card {

    private int mImage;
    private String mHeader, mDescription, mUrl, mContactOne, mContactTwo;
    private double mLat, mLon = 180.01;

    private static String NO_CONTACT_POVIDED = "";
    private static int NO_IMAGE_POVIDED = -1;


    /**
     * Constructor for News type
     * @param image
     * @param header
     * @param description
     * @param url
     */
    public Card(int image, String header, String description, String url) {
        mImage = image;
        mHeader = header;
        mDescription = description;
        mUrl = url;
    }

    /**
     * Constructor for Locations
     * @param image
     * @param header
     * @param description
     * @param lat
     * @param lon
     */
    public Card(int image, String header, String description, double lat, double lon) {
        mImage = image;
        mHeader = header;
        mDescription = description;
        mLat = lat;
        mLon = lon;
    }

    /**
     * Constructor for Food
     * @param image
     * @param header
     * @param description
     * @param url
     * @param lat
     * @param lon
     * @param contactOne
     * @param contactTwo
     */
    public Card(int image, String header, String description, String url, double lat, double lon, String contactOne, String contactTwo) {
        mImage = image;
        mHeader = header;
        mDescription = description;
        mUrl = url;
        mLat = lat;
        mLon = lon;
        mContactOne = contactOne;
        mContactTwo = contactTwo;
    }

    /**
     * Constructor for Hotels
     * @param image
     * @param header
     * @param description
     * @param url
     * @param lat
     * @param lon
     */
    public Card(int image, String header, String description, String url, double lat, double lon) {
        mImage = image;
        mHeader = header;
        mDescription = description;
        mUrl = url;
        mLat = lat;
        mLon = lon;
    }

    public int getmImage() {
        return mImage;
    }

    public String getmHeader() {
        return mHeader;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmUrl() {
        return mUrl;
    }

    public double getmLat() {
        return mLat;
    }

    public double getmLon() {
        return mLon;
    }

    public String getmContactOne() {
        return mContactOne;
    }

    public String getmContactTwo() {
        return mContactTwo;
    }

    public boolean hasCardImage(){
        return mImage != NO_IMAGE_POVIDED;
    }

    public boolean hasUrl(){
        return !mUrl.equals("");
    }

    public boolean hasCardFirstContact() {
        return !mContactTwo.equals(NO_CONTACT_POVIDED);
    }

    public boolean hasCardSecondContact() {
        return !mContactTwo.equals(NO_CONTACT_POVIDED);
    }

    public boolean hasCoordinates() {
        return (mLat < 181 && mLon < 181);
    }



    //For Logging
    @Override
    public String toString() {
        return "Card{" +
                "mImage=" + mImage +
                ", mHeader='" + mHeader + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mUrl=" + mUrl +
                ", mLat=" + mLat +
                ", mLon=" + mLon +
                ", mContactOne='" + mContactOne + '\'' +
                ", mContactTwo='" + mContactTwo + '\'' +
                '}';
    }
}
