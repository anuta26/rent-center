package com.anuta26.rent_center.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Equipment {
    @Id
    private Long id;
}
