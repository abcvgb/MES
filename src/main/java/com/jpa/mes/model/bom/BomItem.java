package com.jpa.mes.model.bom;

import com.jpa.mes.model.BaseTimeEntity;
import com.jpa.mes.model.item.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"bom_id", "item_id"})})
public class BomItem extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bom_item_id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "bom_id", nullable = false)
    private Bom bom;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false, unique = true)
    private Item childItem;

    @Column(nullable = false)
    private Double amount;

}