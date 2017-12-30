package com.imotiontech.repository;

import com.imotiontech.domain.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeviceRepository extends CrudRepository<Device, Long> {

    Iterable<Device> findByNameIgnoringCase(String deviceName);

    Optional<Device> findByName(String deviceName);
}
