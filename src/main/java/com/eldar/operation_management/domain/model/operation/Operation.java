package com.eldar.operation_management.domain.model.operation;

import com.eldar.operation_management.domain.model.brand.Brand;

public class Operation {

    //~ Constructors ............................................................................................................................

    private Operation() {}

    //~ Methods .................................................................................................................................

    public static boolean isValid(double amount) {
        return amount < MAX_AMOUNT;
    }

    public static String getFee(Brand brand, double amount) {
        final double fee = brand.getFee();
        if (fee > MAX_FEE || fee < MIN_FEE) return "Fee: " + brand.getFee() + " out of range (0.3% - 5%) for brand " + brand.getName();
        return "El importe total de la operación de $" + amount + " con la marca " + brand.getName() + " es de: $" + (amount + amount * fee / 100);
    }

    //~ Static Fields ...........................................................................................................................

    public static final double MIN_FEE = 0.3;
    public static final double MAX_FEE = 5;
    public static final double MAX_AMOUNT = 1000;
}
