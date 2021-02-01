package com.jpa.mes.model.warehouse;

import com.jpa.mes.model.BaseTimeEntity;
import com.jpa.mes.model.warehouse.WarehouseType.WarehouseType;
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
public class Warehouse extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private Long id;

    private String name;

//    @Enumerated(EnumType.STRING)
//    private WarehouseType type;

}