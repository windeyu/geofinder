package com.imotiontech.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Device {

    @OneToMany(mappedBy = "device")
    private List<Location> locations = new LinkedList<>();

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

    public List<Location> getLocations() {
        return locations;
    }

    public Location getMostRecentLocation() {
        if (!locations.isEmpty()) {
            return locations.iterator().next();
        }
        return null;
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
