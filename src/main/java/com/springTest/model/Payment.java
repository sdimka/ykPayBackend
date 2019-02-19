package com.springTest.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {
    private String id;
    private String status;
    private boolean paid;
    private Amount amount;
    private PaymentMethod payment_method;

    private String description;

    public String toString() {
        //
        return String.format("\n id: %s \n Status: %s \n Value: %f %s \n Paid: %s \n Description: %s \n S/N: %s \n",
                id, status, amount.getValue(), amount.getCurrency(), paid, description, payment_method.getId());
    }

    // -------------------------------------------

}





