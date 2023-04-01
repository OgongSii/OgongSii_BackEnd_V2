package com.dgsw.ogongsii.ogongsii_backend_v2.domain.rank.service.Impl;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.rank.service.RankService;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain.Record;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain.repository.RecordRepository;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.presentation.dto.ro.RecordRo;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.Member;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RankServiceImpl implements RankService {

    private RecordRepository recordRepository;

    private MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Record> getTodayRank() {
        LocalDate reg = LocalDate.now();
        return recordRepository.findByRegDate(reg, Sort.by(Sort.Direction.DESC,"h","m"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecordRo> getTotalRank() {
        List<RecordRo> list = new ArrayList<>();
        for (Member member : memberRepository.findAll()) {
            RecordRo recordRo = new RecordRo(member);
            list.add(recordRo);
        }
        return list;
    }
}
