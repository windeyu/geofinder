package com.imotiontech.repository;

import com.imotiontech.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByDeviceName(String deviceName);
}
