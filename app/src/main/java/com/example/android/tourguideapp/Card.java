package com.example.android.tourguideapp;

/**
 * Class for any types of cards in app
 *
 */

public class Card {

    private int mImage;
    private String mHeader, mDescription, mUrl, mContactOne, mLat, mLon;

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
    public Card(int image, String header, String description, String lat, String lon) {
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
     */
    public Card(int image, String header, String description, String url, String lat, String lon, String contactOne) {
        mImage = image;
        mHeader = header;
        mDescription = description;
        mUrl = url;
        mLat = lat;
        mLon = lon;
        mContactOne = contactOne;
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
    public Card(int image, String header, String description, String url, String lat, String lon) {
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

    public String getmLat() {
        return mLat;
    }

    public String getmLon() {
        return mLon;
    }

    public String getmContactOne() {
        return mContactOne;
    }

    public boolean hasCardImage(){
        int NO_IMAGE_POVIDED = -1;
        return mImage != NO_IMAGE_POVIDED;
    }

    public boolean hasUrl(){
        return !mUrl.equals("");
    }

    public boolean hasCardFirstContact() {
        String NO_CONTACT_POVIDED = "";
        return !mContactOne.equals(NO_CONTACT_POVIDED);
    }

    public boolean hasCoordinates() {
        return (!mLat.equals("") && !mLon.equals(""));
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
                '}';
    }
}
