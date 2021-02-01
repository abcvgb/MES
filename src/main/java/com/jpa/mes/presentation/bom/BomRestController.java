package com.jpa.mes.presentation.bom;

import com.jpa.mes.presentation.bom.request.BomVO;
import com.jpa.mes.service.BomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BomRestController {

    private final BomService bomService;

    @PostMapping("/api/bom")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertBom(@RequestBody @Validated BomVO request) {
        bomService.insertBom(request);
    }

}
