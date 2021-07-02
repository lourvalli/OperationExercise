package com.eldar.operation_management.domain.model.brand;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Calendar;

@Entity
@Builder
@NoArgsConstructor
public class Nara extends Brand {

    //~ Static Fields ...........................................................................................................................

    public static final double FEE_CONST = 0.5;

    //~ Methods .................................................................................................................................

    public static Nara getInstance() {
        if (Nara.InstanceHolder.instance.getName() == null) {
            Nara.InstanceHolder.instance.setName("NARA");
        }
        return Nara.InstanceHolder.instance;
    }

    @Override
    public double getFee() {
        final Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH) * FEE_CONST;
    }

    private static class InstanceHolder {
        private static final Nara instance = builder().build();
    }
}
