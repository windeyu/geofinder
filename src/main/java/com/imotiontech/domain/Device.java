package com.imotiontech.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Device {

    @OneToMany(mappedBy = "device")
    private Set<Location> locations = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    private Account account;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    Device() { // required by JPA but hide it for our purpose
    }

    public Device(String inName) {
        name = inName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    @Override
    public String toString() {
//        Set<Location> locations = getLocations();
//        StringBuilder sb = new StringBuilder();
//        sb.append("Id=" + id);
//        sb.append(" Device=" + name);
//        locations.forEach(location ->
//                sb.append(location.toString())
//        );
//        return sb.toString();
        return "Id=" + id + " Device=" + name;
    }
}
