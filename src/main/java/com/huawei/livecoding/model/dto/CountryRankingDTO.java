package com.huawei.livecoding.model.dto;


public record CountryRankingDTO(Integer rank,
                                String countryCode,
                                Integer goldMetalCount,
                                Integer silverMedalCount,
                                Integer bronzeMedalCount) {
}
