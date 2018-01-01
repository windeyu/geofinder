package com.imotiontech;

/**
 * Created by yued on 12/31/2017.
 */

public class Greeting {

    private long deviceId;
    private long time;
    private double longitude;
    private double latitude;

    public Greeting(long deviceId, long time, double longitude, double latitude) {
        this.deviceId = deviceId;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    // default constructor is need for http POST
    public Greeting() {}

    public long getDeviceId() {
        return deviceId;
    }

    public long getTime() {
        return time;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String toString() {
        return time + ": " + longitude + "," + latitude;
    }
}