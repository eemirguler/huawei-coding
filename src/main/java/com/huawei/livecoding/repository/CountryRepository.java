package com.huawei.livecoding.repository;

import com.huawei.livecoding.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
