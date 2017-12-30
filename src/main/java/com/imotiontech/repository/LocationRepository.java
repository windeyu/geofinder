package com.imotiontech.repository;

import com.imotiontech.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Collection<Location> findByDeviceName(String deviceName);
}
