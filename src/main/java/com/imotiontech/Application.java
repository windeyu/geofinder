package com.imotiontech;

import com.imotiontech.domain.Device;
import com.imotiontech.repository.AccountRepository;
import com.imotiontech.repository.DeviceRepository;
import com.imotiontech.repository.LocationRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.imotiontech.repository")
@EntityScan(basePackages = "com.imotiontech.domain")
public class Application {


//    @Bean
//    public InitializingBean seedDatabase(DeviceRepository repository) {
//        return () -> {
//            repository.save(new Device("Honda"));
//            repository.save(new Device("Honda"));
//            repository.save(new Device("Ford"));
//        };
//    }

    @Bean
    public CommandLineRunner exampleQuery(DeviceRepository repository) {
        return args -> repository.findByNameIgnoringCase("mydevice2")
                .forEach(System.err::println);
    }

    @Bean
    public CommandLineRunner exampleQuery2(LocationRepository repository) {
        return args -> repository.findByDeviceName("MyDevice2")
                .forEach(System.err::println);
    }

    @Bean
    public CommandLineRunner exampleQuery3(AccountRepository repository) {
        return args -> repository.findByName("tester")
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}