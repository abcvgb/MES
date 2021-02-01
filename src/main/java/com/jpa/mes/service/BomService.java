package com.jpa.mes.service;

import com.jpa.mes.repository.ItemRepository;
import com.jpa.mes.model.bom.Bom;
import com.jpa.mes.model.bom.BomItem;
import com.jpa.mes.repository.BomRepository;
import com.jpa.mes.model.item.Item;
import com.jpa.mes.presentation.bom.request.BomItemVO;
import com.jpa.mes.presentation.bom.request.BomVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BomService {

    private final BomRepository bomRepository;
    private final ItemRepository itemRepository;


    public void insertBom(BomVO request) {
        Item parentItem = itemRepository.findById(request.getItemId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 품목입니다."));
        Bom bom = Bom.builder()
                .parentItem(parentItem)
                .build();
        for (BomItemVO bomItem : request.getBomItems()) {

            Item childItem = itemRepository.findById(bomItem.getItemId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 품목입니다."));
            BomItem bomItem1 = BomItem.builder()
                    .bom(bom)
                    .amount(bomItem.getAmount())
                    .childItem(childItem)
                    .build();

            bom.addBomItemChild(bomItem1);
        }
        bomRepository.save(bom);

    }
}
