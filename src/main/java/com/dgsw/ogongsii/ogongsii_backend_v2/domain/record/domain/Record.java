package com.dgsw.ogongsii.ogongsii_backend_v2.domain.record.domain;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "h")
    private Integer h;

    @Column(name = "m")
    private Integer m;

    @Column(name = "regDate")
    @CreationTimestamp
    private LocalDate regDate;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Record(Long id, Integer h, Integer m, User user, LocalDate regDate) {
        this.id = id;
        this.h = h;
        this.m = m;
        this.user = user;
        this.regDate = regDate;
    }

    public void setMember(User user) {
        this.user = user;
    }
}
