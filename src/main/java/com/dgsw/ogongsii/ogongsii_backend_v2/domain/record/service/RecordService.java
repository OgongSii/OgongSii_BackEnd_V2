package com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.service;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain.Record;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain.repository.RecordRepository;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.presentation.dto.request.RecordRequest;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.User;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.repository.UserRepository;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;

    private final UserRepository userRepository;


    public void record(Record record) {
        recordRepository.save(record);
    }

    @Transactional
    public void saveRecord(String name, RecordRequest request) {

        User user = userRepository.findByName(name)
                .orElseThrow(UserNotFoundException::new);

        Record record = Record.builder()
                .h(request.getH())
                .m(request.getM())
                .user(user)
                .build();

        user.addRecord(record);
        userRepository.save(user);
    }
}
