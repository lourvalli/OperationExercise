package com.eldar.operation_management.domain.repository;

import com.eldar.operation_management.domain.model.Card;

import java.util.List;

public interface CardRepository {

    void deleteAll();

    List<Card> findAll();

    Card findByNumber(Long number);

    List<Card> findByCardHolder(String cardHolder);

    <S extends Card> S save(S s);

    <S extends Card> List<S> saveAll(Iterable<S> iterable);

}
