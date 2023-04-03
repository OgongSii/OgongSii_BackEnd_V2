package com.dgsw.ogongsii.ogongsii_backend_v2.domain.rank.service;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain.Record;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain.repository.RecordRepository;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.presentation.dto.ro.RecordRo;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.User;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RankService {

    private RecordRepository recordRepository;

    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<RecordRo> getTodayRank() {
        LocalDate reg = LocalDate.now();
        List<Record> recordList = recordRepository.findByRegDate(reg, Sort.by(Sort.Direction.DESC,"h","m"));
        return recordList.stream()
                .map(
                        record -> new RecordRo(record.getUser())
                ).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<RecordRo> getTotalRank() {
        List<RecordRo> list = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            RecordRo recordRo = new RecordRo(user);
            list.add(recordRo);
        }
        return list;
    }
}
