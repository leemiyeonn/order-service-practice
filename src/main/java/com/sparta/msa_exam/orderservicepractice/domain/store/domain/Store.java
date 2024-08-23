package com.sparta.msa_exam.orderservicepractice.domain.store.domain;

import com.sparta.msa_exam.orderservicepractice.global.base.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "stores")
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    public Store(String name) {
        this.name = name;
    }
}
