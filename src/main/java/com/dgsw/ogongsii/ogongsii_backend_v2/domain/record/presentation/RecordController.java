package com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.presentation;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.presentation.dto.request.RecordRequest;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.service.RecordService;
import com.dgsw.ogongsii.ogongsii_backend_v2.global.annotation.Auth;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(value = "/api/record")
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;
    @Auth
    @PostMapping("/")
    public ResponseEntity<?> record(@RequestBody RecordRequest recordDto,
                                 @RequestAttribute String name) throws Exception {
        recordService.saveRecord(name, recordDto);
        return ResponseEntity.ok("시간이 성공적으로 저장 되었습니다");
    }

}
