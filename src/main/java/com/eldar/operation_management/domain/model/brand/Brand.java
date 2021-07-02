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

    public String toString() {
        return "Brand{ name='" + name + "\'}";
    }
}
