package com.eldar.operation_management.domain.model.brand;

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
        return (double) calendar.get(Calendar.YEAR) / calendar.get(Calendar.DAY_OF_MONTH);
    }

    private static class InstanceHolder {
        private static final Visa instance = builder().build();
    }
}
