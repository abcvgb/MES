package com.jpa.mes.model.bom;

import com.jpa.mes.repository.ItemRepository;
import com.jpa.mes.model.item.Item;
import com.jpa.mes.repository.BomItemRepository;
import com.jpa.mes.repository.BomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BomTest {


    @Autowired
    BomRepository bomRepository;
    @Autowired
    BomItemRepository bomItemRepository;
    @Autowired
    ItemRepository itemRepository;

    @Test
    void Bom이지워지면BomItem도같이삭제되어야한다() {
        Item item = Item.builder()
                .name("item1")
                .price(1000)
                .build();
        Item item2 = Item.builder()
                .name("item2")
                .price(100)
                .build();

        Item item3 = Item.builder()
                .name("item2")
                .price(130)
                .build();

        Item savedItem = itemRepository.save(item);
        itemRepository.save(item2);
        itemRepository.save(item3);


        Bom bom = Bom.builder()
                .parentItem(savedItem)
                .build();
        bomRepository.save(bom);

        BomItem bomItem1 = BomItem.builder()
                .childItem(item2)
                .bom(bom)
                .amount(2.0)
                .build();

        BomItem bomItem2 = BomItem.builder()
                .childItem(item3)
                .bom(bom)
                .amount(1.3)
                .build();

        bomItemRepository.save(bomItem1);
        bomItemRepository.save(bomItem2);

        assertThat(bomItemRepository.findAll().size()).isGreaterThan(0);
        bomRepository.deleteAll();
        assertThat(bomItemRepository.findAll().size()).isEqualTo(0);

    }

}