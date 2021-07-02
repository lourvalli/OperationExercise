package com.eldar.operation_management.domain.model.brand;

import javafx.beans.binding.IntegerBinding;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Calendar;

@Entity
@Builder
@NoArgsConstructor
public class Visa extends Brand {

    //~ Methods .................................................................................................................................

    public static Visa getInstance() {
        if (InstanceHolder.instance.getName() == null) {
            InstanceHolder.instance.setName("VISA");
        }
        return InstanceHolder.instance;
    }

    @Override
    public double getFee() {
        final Calendar calendar = Calendar.getInstance();
        final char[] digits = String.valueOf(calendar.get(Calendar.YEAR)).toCharArray();
        final int year = Integer.valueOf(digits[digits.length - 2] + String.valueOf(digits[digits.length - 1]));
        return (double) year / calendar.get(Calendar.DAY_OF_MONTH);
    }

    private static class InstanceHolder {
        private static final Visa instance = builder().build();
    }
}
