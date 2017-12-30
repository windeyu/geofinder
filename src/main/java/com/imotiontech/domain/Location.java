package com.imotiontech.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Location {

    @JsonIgnore
    @ManyToOne
    private Device device;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String longitude;
    private String latitude;

    Location() {  // jpa only
    }

    public Location(Device device, String longitute, String latitude) {
        this.device = device;
        this.longitude = longitute;
        this.latitude = latitude;
    }

    public Device getDevice() {
        return device;
    }

    public Long getId() {
        return id;
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
