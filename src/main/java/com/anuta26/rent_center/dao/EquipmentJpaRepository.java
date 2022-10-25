package com.anuta26.rent_center.dao;

import com.anuta26.rent_center.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentJpaRepository extends JpaRepository<Equipment, Long> {
}
