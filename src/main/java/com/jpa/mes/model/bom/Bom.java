package com.jpa.mes.model.bom;

import com.jpa.mes.model.BaseTimeEntity;
import com.jpa.mes.model.item.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Bom extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bom_id")
    private Long id;

    private String bomNumber;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false, unique = true)
    private Item parentItem;

    @OneToMany(mappedBy = "bom", fetch=FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<BomItem> bomItemChilds = new ArrayList<>();


    public void addBomItemChild(BomItem bomItem) {
        if(ObjectUtils.isEmpty(bomItemChilds)) bomItemChilds = new ArrayList<>();
        bomItemChilds.add(bomItem);
    }

}