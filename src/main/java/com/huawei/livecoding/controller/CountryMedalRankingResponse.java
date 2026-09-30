package com.huawei.livecoding.controller;

import com.huawei.livecoding.model.dto.CountryRankingDTO;

import java.util.List;

public record CountryMedalRankingResponse(List<CountryRankingDTO> rankings) {
}
