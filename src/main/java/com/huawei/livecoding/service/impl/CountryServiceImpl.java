package com.huawei.livecoding.service.impl;

import com.huawei.livecoding.model.entity.Country;
import com.huawei.livecoding.repository.CountryRepository;
import com.huawei.livecoding.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public Map<String, Country> getAllCountriesByCode() {
        return countryRepository.findAll().stream()
                .collect(Collectors.toMap(Country::getCode, Function.identity()));
    }

    @Override
    public Map<Long, Country> getAllCountriesById() {
        return countryRepository.findAll().stream()
                .collect(Collectors.toMap(Country::getId, Function.identity()));
    }
}
