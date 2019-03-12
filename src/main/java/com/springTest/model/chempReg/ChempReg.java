package com.springTest.model.chempReg;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Builder
@Getter
@Setter
@Entity(name = "ChempReg")
public class ChempReg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surName;
    private String phone;
    private String email;

    private int classType;
    private int trainingType;

    private Float sumTotal;

    private String paymentID;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "trainList", joinColumns = @JoinColumn(name = "chempReg_id"))
    @Column(name = "nominationsId")
    private List<String> selectedTrainig = new ArrayList<>();
}
