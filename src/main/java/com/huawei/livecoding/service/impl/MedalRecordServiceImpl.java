package com.huawei.livecoding.service.impl;

import com.huawei.livecoding.model.entity.MedalRecord;
import com.huawei.livecoding.repository.MedalRecordRepository;
import com.huawei.livecoding.service.MedalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedalRecordServiceImpl implements MedalRecordService {

    private final MedalRecordRepository medalRecordRepository;

    @Override
    public List<MedalRecord> getAll() {
        return medalRecordRepository.findAll();
    }
}
