package com.springTest.model;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AccessLevel;
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
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private PaymentMethod payment_method;

    private String description;

    public String toString() {
        //
        return String.format("\n id: %s \n Status: %s \n Value: %f %s \n Paid: %s \n Description: %s \n S/N: %s \n",
                id, status, amount.getValue(), amount.getCurrency(), paid, description, payment_method.getId());
    }

    @JsonGetter("payment_method_data")
    public PaymentMethod getpayment_method_data() {
        return payment_method;
    }

    @JsonSetter("payment_method")
    public void setPayment_method(PaymentMethod payment_method) {
        this.payment_method = payment_method;
    }

    // -------------------------------------------

}





