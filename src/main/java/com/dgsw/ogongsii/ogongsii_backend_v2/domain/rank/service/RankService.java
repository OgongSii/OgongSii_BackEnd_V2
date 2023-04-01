package com.dgsw.ogongsii.ogongsii_backend_v2.domain.rank.service;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain.Record;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.presentation.dto.ro.RecordRo;

import java.util.List;

public interface RankService {

    List<Record> getTodayRank();

    List<RecordRo> getTotalRank();
}
