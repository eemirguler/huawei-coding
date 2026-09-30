package com.huawei.livecoding.repository;

import com.huawei.livecoding.model.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {

}
