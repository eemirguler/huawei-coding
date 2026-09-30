package com.huawei.livecoding.model.entity;

import com.huawei.livecoding.common.enums.MedalType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MedalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private MedalType medalType;
    @Column
    private Long countryId;
    @Column
    private Long sportId;
}
