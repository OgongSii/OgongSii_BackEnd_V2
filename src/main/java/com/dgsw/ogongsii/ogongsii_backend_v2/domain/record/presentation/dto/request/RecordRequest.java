package com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecordRequest {
    private Integer h;
    private Integer m;

}
