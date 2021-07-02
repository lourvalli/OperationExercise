package com.eldar.operation_management;

import com.eldar.operation_management.domain.model.Card;
import com.eldar.operation_management.domain.model.brand.Amex;
import com.eldar.operation_management.domain.model.brand.Nara;
import com.eldar.operation_management.domain.model.brand.Visa;
import com.eldar.operation_management.domain.repository.BrandRepository;
import com.eldar.operation_management.domain.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class Executor implements CommandLineRunner {

    //~ Instance Fields ...........................................................................................................................

    private final BrandRepository brandRepository;
    private final CardRepository cardRepository;

    //~ Constructors .............................................................................................................................

    @Autowired
    public Executor(CardRepository cardRepository, BrandRepository brandRepository) {
        this.cardRepository = cardRepository;
        this.brandRepository = brandRepository;
    }

    //~ Methods .................................................................................................................................

    @Override
    @SuppressWarnings("MagicNumber")
    public void run(String... args) {
        brandRepository.save(Visa.getInstance());
        brandRepository.save(Nara.getInstance());
        brandRepository.save(Amex.getInstance());

        final Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JUNE,12);
        cardRepository.save(Card.builder().number(123L).cardHolder("Jose Perez").brand(brandRepository.findByName("VISA")).dueDate(calendar.getTime()).build());

        calendar.set(2021, Calendar.JUNE,12);
        cardRepository.save(Card.builder().number(456L).cardHolder("Manuel Fernandez").brand(brandRepository.findByName("AMEX")).dueDate(calendar.getTime()).build());

        System.out.println("Number of brands : " + brandRepository.findAll().size());
        System.out.println("Number of cards : " + cardRepository.findAll().size());
    }
}
