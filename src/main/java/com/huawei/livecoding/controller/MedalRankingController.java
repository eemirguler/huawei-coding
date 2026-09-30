package com.huawei.livecoding.controller;

import com.huawei.livecoding.service.MedalRankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medal-rankings")
public class MedalRankingController {

    private final MedalRankingService medalRankingService;

    @GetMapping("/country")
    public ResponseEntity<CountryMedalRankingResponse> rankByCountries() {
        return ResponseEntity.ok(new CountryMedalRankingResponse(medalRankingService.rankByCountry()));
    }
}
