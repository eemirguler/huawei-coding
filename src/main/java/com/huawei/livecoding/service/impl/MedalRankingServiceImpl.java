package com.huawei.livecoding.service.impl;

import com.huawei.livecoding.common.enums.MedalType;
import com.huawei.livecoding.model.dto.CountryRankingCalculationDTO;
import com.huawei.livecoding.model.dto.CountryRankingDTO;
import com.huawei.livecoding.model.entity.Athlete;
import com.huawei.livecoding.model.entity.Country;
import com.huawei.livecoding.model.entity.MedalRecord;
import com.huawei.livecoding.service.AthleteService;
import com.huawei.livecoding.service.CountryService;
import com.huawei.livecoding.service.MedalRankingService;
import com.huawei.livecoding.service.MedalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MedalRankingServiceImpl implements MedalRankingService {

    private final MedalRankingService medalRankingService;
    private final MedalRecordService medalRecordService;
    private final AthleteService athleteService;
    private final CountryService countryService;

    @Override
    public List<CountryRankingDTO> rankByCountry() {
        List<MedalRecord> medalRecords = medalRecordService.getAll();
        Map<Long, Country> countryByCountryId = countryService.getAllCountriesById();

        Map<Long, CountryRankingCalculationDTO> countryRakingByCountryId = new HashMap<>();
        for (MedalRecord medalRecord : medalRecords) {
            CountryRankingCalculationDTO countryRanking = countryRakingByCountryId
                    .getOrDefault(medalRecord.getCountryId(), new CountryRankingCalculationDTO());
            countryRanking.setCountryCode(countryByCountryId.get(medalRecord.getCountryId()).getCode());
            increaseMedalCount(countryRanking, medalRecord.getMedalType());
            countryRakingByCountryId.put(medalRecord.getCountryId(), countryRanking);
        }

        List<CountryRankingCalculationDTO> nonSortedRankings = new ArrayList<>(countryRakingByCountryId.values().stream().toList());

        nonSortedRankings.sort(Comparator.comparing(CountryRankingCalculationDTO::getGoldMetalCount, Comparator.reverseOrder())
                .thenComparing(CountryRankingCalculationDTO::getSilverMedalCount, Comparator.reverseOrder())
                .thenComparing(CountryRankingCalculationDTO::getBronzeMedalCount, Comparator.reverseOrder())
                .thenComparing(CountryRankingCalculationDTO::getCountryCode));

        int rank = 1;
        List<CountryRankingDTO> sortedRankings = new ArrayList<>(nonSortedRankings.size());
        for (CountryRankingCalculationDTO ranking : nonSortedRankings) {
            sortedRankings.add(
                    new CountryRankingDTO(rank++, ranking.getCountryCode(), ranking.getGoldMetalCount(), ranking.getSilverMedalCount(), ranking.getBronzeMedalCount())
            );
        }

        return sortedRankings;
    }

    private void increaseMedalCount(CountryRankingCalculationDTO rankingCalculation, MedalType medalType) {
        switch(medalType) {
            case GOLD -> rankingCalculation.setGoldMetalCount(rankingCalculation.getGoldMetalCount() + 1);
            case SILVER -> rankingCalculation.setSilverMedalCount(rankingCalculation.getSilverMedalCount() + 1);
            case BRONZE -> rankingCalculation.setBronzeMedalCount(rankingCalculation.getBronzeMedalCount() + 1);
            default -> throw new RuntimeException("Unsupported medal type");
        }
    }
}
