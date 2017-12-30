package com.imotiontech.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {

    @OneToMany(mappedBy = "account")
    private Set<Device> devices = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String password;
    private boolean enabled;

    Account() { // required by JPA but hide it for our purpose
    }

    public Account(String inName, String inPassword) {
        this.name = inName;
        this.password = inPassword;
        enabled = true;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Set<Device> getDevices() {
        return devices;
    }
}
