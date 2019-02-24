package com.springTest.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Nomination {
    private int id;
    private String name;
    private boolean selected;

    public Nomination() {
    }

    public Nomination(int id, String name, boolean selected) {
        this.id = id;
        this.name = name;
        this.selected = selected;
    }

}
