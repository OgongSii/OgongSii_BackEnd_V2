package com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain.repository;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain.Record;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {

    public List<Record> findByRegDate(LocalDate regDate, Sort sort);

}
