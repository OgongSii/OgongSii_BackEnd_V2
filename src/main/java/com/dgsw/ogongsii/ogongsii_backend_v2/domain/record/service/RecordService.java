package com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.service;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain.Record;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain.repository.RecordRepository;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.presentation.dto.request.RecordRequest;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.Member;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.repository.MemberRepository;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;

    private final MemberRepository memberRepository;


    public void record(Record record) {
        recordRepository.save(record);
    }

    @Transactional
    public void saveRecord(String name, RecordRequest request) throws Exception {

        Member member = memberRepository.findByName(name)
                .orElseThrow(MemberNotFoundException::new);

        Record record = Record.builder()
                .h(request.getH())
                .m(request.getM())
                .member(member)
                .build();

        member.addRecord(record);
        memberRepository.save(member);
    }
}
