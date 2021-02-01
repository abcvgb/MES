package com.jpa.mes.service;

import com.jpa.mes.model.stock.Stock;
import com.jpa.mes.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;


    public Stock getItemStockList(Long id, Long warehouseId) {
        return stockRepository.findByItemIdAndWarehouseId(id, warehouseId).orElseThrow(IllegalArgumentException::new);
    }

}
