package com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain.Record;
import com.dgsw.ogongsii.ogongsii_backend_v2.global.entity.BaseUUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member extends BaseUUID {

    @Column(unique = true)
    private String name;

    @Column
    private String password;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<Record> records;

    @Builder
    public Member(String name, String password, Set<Record> records) {
        this.name = name;
        this.password = password;
        this.records = records;
    }

    public void addRecord(Record record) {
        record.setMember(this);
        records.add(record);
    }

    public void removeRecord(Record record) {
        record.setMember(null);
        records.remove(record);
    }

}