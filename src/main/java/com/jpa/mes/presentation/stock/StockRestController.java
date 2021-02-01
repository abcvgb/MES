package com.jpa.mes.presentation.stock;

import com.jpa.mes.model.stock.Stock;
import com.jpa.mes.repository.StockRepository;
import com.jpa.mes.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StockRestController {

    private final StockService stockService;

    @GetMapping("/api/stock/items/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Stock getItemStockList(@PathVariable Long id, @RequestParam("warehouseId") Long warehouseId) {
        return stockService.getItemStockList(id, warehouseId);
    }


}
