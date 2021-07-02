package com.eldar.operation_management.domain.model.brand;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Calendar;

@Entity
@Builder
@NoArgsConstructor
public class Amex extends Brand {

    //~ Static Fields ...........................................................................................................................

    public static final double FEE_CONST = 0.1;

    //~ Methods .................................................................................................................................

    public static Amex getInstance() {
        if (Amex.InstanceHolder.instance.getName() == null) {
            Amex.InstanceHolder.instance.setName("AMEX");
        }
        return Amex.InstanceHolder.instance;
    }

    @Override
    public double getFee() {
        final Calendar calendar = Calendar.getInstance();
        return (double) (calendar.get(Calendar.MONTH) + 1) * FEE_CONST;
    }

    private static class InstanceHolder {
        private static final Amex instance = builder().build();
    }
}
