package com.huawei.livecoding.service.impl;

import com.huawei.livecoding.common.enums.MedalType;
import com.huawei.livecoding.model.dto.CountryRankingDTO;
import com.huawei.livecoding.model.entity.Country;
import com.huawei.livecoding.model.entity.MedalRecord;
import com.huawei.livecoding.service.AthleteService;
import com.huawei.livecoding.service.CountryService;
import com.huawei.livecoding.service.MedalRecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MedalRankingServiceImplTest {

    @Mock
    private CountryService countryService;

    @Mock
    private MedalRecordService medalRecordService;

    @InjectMocks
    private MedalRankingServiceImpl medalRankingService;

    @Test
    void test_getRankingByCountry() {
        Country tr = new Country();
        tr.setCode("TUR");
        tr.setId(1L);

        Country fra = new Country();
        fra.setCode("FRA");
        fra.setId(2L);

        Country italy = new Country();
        italy.setCode("ITA");
        italy.setId(3L);

        Map<Long, Country> countries = new HashMap<>();
        countries.put(1L, tr);
        countries.put(2L, fra);
        countries.put(3L, italy);

        when(countryService.getAllCountriesById()).thenReturn(countries);

        //        Map<Long, Country> countryByCountryId = countryService.getAllCountriesById();
        MedalRecord mr = new MedalRecord();
        mr.setCountryId(1L);
        mr.setMedalType(MedalType.GOLD);

        MedalRecord mr2 = new MedalRecord();
        mr2.setCountryId(1L);
        mr2.setMedalType(MedalType.SILVER);

        MedalRecord mr3 = new MedalRecord();
        mr3.setCountryId(2L);
        mr3.setMedalType(MedalType.SILVER);

        MedalRecord mr4 = new MedalRecord();
        mr4.setCountryId(3L);
        mr4.setMedalType(MedalType.BRONZE);

        MedalRecord mr5 = new MedalRecord();
        mr5.setCountryId(3L);
        mr5.setMedalType(MedalType.BRONZE);

        when(medalRecordService.getAll()).thenReturn(List.of(mr, mr2, mr3, mr4, mr5));

        List<CountryRankingDTO> response = medalRankingService.rankByCountry();

        for (CountryRankingDTO countryRankingDTO : response) {
            System.out.println(countryRankingDTO);
        }
    }

}
