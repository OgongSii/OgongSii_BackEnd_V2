package com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.service;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain.Record;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.presentation.dto.request.RecordRequest;

public interface RecordService {

    public void record(Record record);

    public void saveRecord(String name, RecordRequest request) throws Exception;

}
