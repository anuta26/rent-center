package com.anuta26.rent_center.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entity_user")
@Getter
@Setter
public class User {
    @Id
    private Long id;
}
