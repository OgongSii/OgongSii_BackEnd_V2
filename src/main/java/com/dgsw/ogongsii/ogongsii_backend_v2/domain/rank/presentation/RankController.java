package com.dgsw.ogongsii.ogongsii_backend_v2.domain.rank.presentation;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.rank.service.RankService;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.presentation.dto.ro.RecordRo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/rank")
public class RankController {

    private final RankService rankService;

    @GetMapping("/today")
    public List<RecordRo> getTodayRank() {
        return rankService.getTodayRank();
    }

    @GetMapping("/total")
    public List<RecordRo> getTotalRank() {
        return rankService.getTotalRank();
    }


}
