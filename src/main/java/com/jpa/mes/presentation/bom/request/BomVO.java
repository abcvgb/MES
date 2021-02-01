package com.jpa.mes.presentation.bom.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class BomVO {

    private Long bomNumber;
    @NotNull(message = "품목은 반드시 존재하여야 합니다.")
    private Long itemId;
    @NotNull(message = "품목은 반드시 존재하여야 합니다.")
    private List<BomItemVO> bomItems;


}
