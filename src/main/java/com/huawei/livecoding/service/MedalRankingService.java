package com.huawei.livecoding.service;

import com.huawei.livecoding.model.dto.CountryRankingDTO;

import java.util.List;

public interface MedalRankingService {

    List<CountryRankingDTO> rankByCountry();
}
