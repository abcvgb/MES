package com.jpa.mes.repository;

import com.jpa.mes.model.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByItemIdAndWarehouseId(Long id, Long warehouseId);
}
