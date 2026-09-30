package com.huawei.livecoding.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryRankingCalculationDTO {
    private String countryCode;
    private Integer goldMetalCount = 0;
    private Integer silverMedalCount = 0;
    private Integer bronzeMedalCount = 0;
}
