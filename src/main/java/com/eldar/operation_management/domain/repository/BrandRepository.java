package com.eldar.operation_management.domain.repository;

import com.eldar.operation_management.domain.model.brand.Brand;

import java.util.List;

public interface BrandRepository {

    void deleteAll();

    List<Brand> findAll();

    Brand findByName(String name);

    <S extends Brand> S save(S s);

    <S extends Brand> List<S> saveAll(Iterable<S> iterable);

}
