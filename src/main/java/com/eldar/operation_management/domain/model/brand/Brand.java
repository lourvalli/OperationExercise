package com.eldar.operation_management.domain.model.brand;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public abstract class Brand {

    //~ Instance Fields .........................................................................................................................

    @Id
    private String name;

    //~ Methods .................................................................................................................................

    public abstract double getFee();

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        final Brand brand = (Brand) object;
        return name.equals(brand.name);
    }

    public String toString() {
        return "Brand{ name='" + name + "\'}";
    }
}
