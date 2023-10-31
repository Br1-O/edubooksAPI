package com.br1.edubooks.model.domain;

import com.br1.edubooks.model.dto.request.dtoAddress;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable
public class Address {

    private String street;
    private String district;
    private String city;
    private String numeration;
    private String complement;

    public Address(dtoAddress dtoAddress) {
        this.street=dtoAddress.street();
        this.district=dtoAddress.district();
        this.city=dtoAddress.city();
        this.numeration=dtoAddress.numeration();
        this.complement=dtoAddress.complement();
    }

}
