package com.eldar.operation_management.application.rest;

import com.eldar.operation_management.domain.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class OperationRestController {

    private final OperationService myService;

    //~ Constructors .................................................................................................................................

    @Autowired
    public OperationRestController(OperationService myService) {
        this.myService = myService;
    }

    //~ Methods .................................................................................................................................

    @GetMapping(value = "/operation/fee", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOperationFee(@RequestParam String brand, @RequestParam double amount) {
        return myService.getOperationFee(brand, amount);
    }
}
