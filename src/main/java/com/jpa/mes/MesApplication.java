package com.jpa.mes;

import com.jpa.mes.model.item.Item;
import com.jpa.mes.model.stock.Stock;
import com.jpa.mes.model.warehouse.Warehouse;
import com.jpa.mes.repository.ItemRepository;
import com.jpa.mes.repository.StockRepository;
import com.jpa.mes.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // enable auditing
public class MesApplication implements ApplicationRunner {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    public static void main(String[] args) {
        SpringApplication.run(MesApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        init();



    }

    private void init(){
        Item item1 = Item.builder()
                .name("치자맛단무지")
                .price(10000)
                .build();

        Item item2 = Item.builder()
                .name("품목2")
                .price(1000)
                .build();

        Item item3 = Item.builder()
                .name("품목3")
                .price(20000)
                .build();
        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);

        Warehouse warehouse1 = Warehouse.builder()
                .name("창고1")
                .build();

        warehouseRepository.save(warehouse1);



        Item item = itemRepository.findByName("치자맛단무지").stream().findFirst().orElseThrow(IllegalArgumentException::new);
        Stock stock = Stock.builder()
                .item(item)
                .warehouse(warehouse1)
                .amount(0.0)
                .build();

        stockRepository.save(stock);

    }
}
