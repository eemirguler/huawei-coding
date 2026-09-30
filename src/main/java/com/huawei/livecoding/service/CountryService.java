package com.huawei.livecoding.service;

import com.huawei.livecoding.model.entity.Country;

import java.util.Map;

public interface CountryService {

    Map<String, Country> getAllCountriesByCode();
    Map<Long, Country> getAllCountriesById();
}
