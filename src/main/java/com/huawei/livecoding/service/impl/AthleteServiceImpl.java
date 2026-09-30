package com.huawei.livecoding.service.impl;

import com.huawei.livecoding.model.entity.Athlete;
import com.huawei.livecoding.repository.AthleteRepository;
import com.huawei.livecoding.service.AthleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AthleteServiceImpl implements AthleteService {

    private final AthleteRepository athleteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Athlete> getAll() {
        return athleteRepository.findAll();
    }
}
