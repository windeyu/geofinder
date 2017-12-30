package com.imotiontech.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.imotiontech.Greeting;
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

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, name));
        return _currentGreeting;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addGreeting(@RequestBody Greeting inGreeting) {
        _currentGreeting = inGreeting;
        return _currentGreeting.toString();
    }
}