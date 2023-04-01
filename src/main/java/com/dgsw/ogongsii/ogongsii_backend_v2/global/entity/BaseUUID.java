package com.dgsw.ogongsii.ogongsii_backend_v2.global.entity;

import com.fasterxml.uuid.Generators;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@NoArgsConstructor
@MappedSuperclass
public class BaseUUID {

    @Id
    @NotNull
    private UUID id = Generators.randomBasedGenerator().generate();

}
