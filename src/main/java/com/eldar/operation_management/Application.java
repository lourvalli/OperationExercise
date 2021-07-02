package com.eldar.operation_management;

import com.eldar.operation_management.domain.model.card.Card;
import com.eldar.operation_management.domain.model.operation.Operation;
import com.eldar.operation_management.domain.repository.BrandRepository;
import com.eldar.operation_management.domain.repository.CardRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	@SuppressWarnings("MagicNumber")
	public static void main(String[] args) {
		final ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println("Booted!");

		final CardRepository cardRepository = context.getBean(CardRepository.class);
		final BrandRepository brandRepository = context.getBean(BrandRepository.class);
		final Card card1 = cardRepository.findByNumber(123L);
		System.out.println("Card info:");
		System.out.println(card1.toString());

		System.out.println("$500 operation is valid? -> " + Operation.isValid(500));
		System.out.println("$1500 operation is valid? -> " + Operation.isValid(1500));

		final Card card2 = cardRepository.findByNumber(456L);
		System.out.println("Card with due date on 2022-6-12 is valid? -> " + card1.isValid());
		System.out.println("Card with due date on 2021-6-12 is valid? -> " + card2.isValid());

		final Card card3 = cardRepository.findByNumber(123L);
		System.out.println("Card with different fields are equals? -> " + card1.equals(card2));
		System.out.println("Card with same fields are equals? -> " + card1.equals(card3));

		System.out.println("Amount with fee for $500 operation with Visa: $" + Operation.getFee(brandRepository.findByName("VISA"), 500));
		System.out.println("Amount with fee for $500 operation with Nara: $" + Operation.getFee(brandRepository.findByName("NARA"), 500));
		System.out.println("Amount with fee for $500 operation with Amex: $" + Operation.getFee(brandRepository.findByName("AMEX"), 500));

	}

}
