package com.jpa.mes.repository;

import com.jpa.mes.model.bom.BomItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BomItemRepository extends JpaRepository<BomItem, Long> {
}
