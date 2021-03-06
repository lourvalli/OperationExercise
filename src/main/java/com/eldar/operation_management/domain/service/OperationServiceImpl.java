package com.eldar.operation_management.domain.service;

import com.eldar.operation_management.domain.model.brand.Brand;
import com.eldar.operation_management.domain.model.operation.Operation;
import com.eldar.operation_management.domain.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationServiceImpl implements OperationService {

    //~ Instance Fields ..........................................................................................................................

    private final BrandRepository brandRepository;

    //~ Constructors .............................................................................................................................

    @Autowired
    public OperationServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    //~ Methods .................................................................................................................................

    @Override
    @Transactional(readOnly = true)
    public String getOperationFee(String brandName, double amount) {
        final Brand brand = brandRepository.findByName(brandName);
        if (brand == null) return "La marca ingresada es inválida";
        return Operation.getFee(brand, amount);
    }

}
