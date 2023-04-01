package com.dgsw.ogongsii.ogongsii_backend_v2.domain.rank.presentation;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.rank.service.RankService;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain.Record;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.presentation.dto.ro.RecordRo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/rank")
public class RankController {

    private final RankService rankService;

    @PostMapping("/today")
    public List<Record> getTodayRank() {
        return rankService.getTodayRank();
    }

    @PostMapping("/total")
    public List<RecordRo> getTotalRank() {
        return rankService.getTotalRank();
    }


}
