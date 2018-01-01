package com.imotiontech.controller;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.imotiontech.Greeting;
import com.imotiontech.domain.Device;
import com.imotiontech.domain.Location;
import com.imotiontech.repository.DeviceRepository;
import com.imotiontech.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * http://localhost:8080/greeting
 *
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private Greeting _currentGreeting = new Greeting();

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    LocationRepository locationRepository;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, name));
        return _currentGreeting;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addGreeting(@RequestBody Greeting inGreeting) {
        _currentGreeting = inGreeting;
        System.out.println("addGreeting: " + inGreeting);
        Optional<Device> deviceOptional = deviceRepository.findById(inGreeting.getDeviceId());
        if (deviceOptional.isPresent()) {
            Device device = deviceOptional.get();
            device.getLocations().add(new Location(
                    device,
                    new Timestamp(inGreeting.getTime()),
                    String.valueOf(inGreeting.getLongitude()),
                    String.valueOf(inGreeting.getLatitude())));
            Device saved = deviceRepository.save(device);
            System.out.println("Saved: " + saved);
        } else {
            System.out.println("Error not found id: " + inGreeting.getDeviceId());
        }
        return "";
    }
}