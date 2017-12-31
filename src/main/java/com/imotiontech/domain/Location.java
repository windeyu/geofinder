package com.imotiontech.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Location {

    @JsonIgnore
    @ManyToOne
    private Device device;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp timestamp;
    private String longitude;
    private String latitude;

    Location() {  // jpa only
    }

    public Location(Device device, Timestamp timesamp, String longitute, String latitude) {
        this.device = device;
        this.timestamp = timesamp;
        this.longitude = longitute;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public Device getDevice() {
        return device;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return device.toString() + " long=" + longitude + " lat=" + latitude;
    }
}
