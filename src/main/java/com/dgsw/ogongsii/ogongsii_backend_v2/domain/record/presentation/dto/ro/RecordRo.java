package com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.presentation.dto.ro;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain.Record;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
public class RecordRo {

    private final String name;
    private final int hour;
    private final int minutes;

    public RecordRo(User user) {
        this.name = user.getName();
        final Set<Record> records = user.getRecords();
        this.hour = records.stream().mapToInt(record -> record.getH()).sum();
        this.minutes = records.stream().mapToInt(record -> record.getM()).sum();
    }
}
