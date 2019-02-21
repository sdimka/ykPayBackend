package com.springTest.model;


import com.fasterxml.jackson.annotation.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payment {
    private String id;
    private String status;
    private boolean paid;
    private Amount amount;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private PaymentMethod payment_method;

    private Confirmation confirmation;

    private boolean capture;

    private String description;

    public String toString() {
        //
        return String.format("\n id: %s \n Status: %s \n Value: %f %s \n Paid: %s \n Description: %s \n " +
                        "S/N: %s \n URL: %s \n",
                id, status, amount.getValue(), amount.getCurrency(),
                paid, description, payment_method.getId(), confirmation.getConfirmation_url());
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





