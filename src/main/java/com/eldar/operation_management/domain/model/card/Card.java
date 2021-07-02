package com.eldar.operation_management.domain.model.card;

import com.eldar.operation_management.domain.model.brand.Brand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Card {

    //~ Instance Fields ..........................................................................................................................

    @Id
    private Long number;
    @ManyToOne
    @JoinColumn(name = "brand_name")
    private Brand brand;
    private String cardHolder;
    private Date dueDate;

    //~ Methods .................................................................................................................................

    public boolean isValid() {
        return dueDate.after(new Date());
    }

    public static double getFee() {
        return 0;
    }

    public String toString() {
        return "Card{" +
                "number='" + number + '\'' +
                ", brand='" + brand + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        final Card card = (Card) object;
        return number.equals(card.number) &&
                brand.equals(card.brand) &&
                cardHolder.equals(card.cardHolder) &&
                dueDate.equals(card.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, brand, cardHolder, dueDate);
    }
}
