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


    private String description;

    public String toString() {
        //
        return String.format("\n id: %s \n Status: %s \n Paid: %s \n Description: %s \n", id, status, paid, description);
    }

}
