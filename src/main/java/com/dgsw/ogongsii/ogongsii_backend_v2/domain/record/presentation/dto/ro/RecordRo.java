package com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.presentation.dto.ro;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain.Record;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.Member;
import lombok.Getter;

import java.util.Set;

@Getter
public class RecordRo {

    private final String name;
    private final int hour;
    private final int minutes;

    public RecordRo(Member member) {
        this.name = member.getName();
        final Set<Record> records = member.getRecords();
        this.hour = records.stream().mapToInt(record -> record.getH()).sum();
        this.minutes = records.stream().mapToInt(record -> record.getM()).sum();
    }
}
