package com.anuta26.rent_center.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipmentId;

    private String name;

    @OneToMany(mappedBy = "equipment")
    private List<Reservation> reservations = new ArrayList<>();


}
