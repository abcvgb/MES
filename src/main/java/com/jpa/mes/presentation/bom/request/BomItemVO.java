package com.jpa.mes.presentation.bom.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BomItemVO {

    @NotNull(message = "품목은 반드시 존재하여야 합니다.")
    private Long itemId;
    private Double amount;
}
