package com.springTest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity (name = "Part")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String surname;
    private String mName;
    private LocalDate bDay;
    private String salon;
    private String mannequin;
    private int phone;
    private String email;
    private String paymentID;
    //private String nominations;

    private int courseType;

    private Float totalSum;

    private String description;

     // confirmPersonal ?
    private boolean confirmPersonal;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Float totalSum) {
        this.totalSum = totalSum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmPersonal() {
        return confirmPersonal;
    }

    public void setConfirmPersonal(boolean confirmPersonal) {
        this.confirmPersonal = confirmPersonal;
    }

    public int getCourseType() {
        return courseType;
    }

    public void setCourseType(int courseType) {
        this.courseType = courseType;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public LocalDate getbDay() {
        return bDay;
    }

    public void setbDay(LocalDate bDay) {
        this.bDay = bDay;
    }

    public void setbDay(String date) {
        //convert String to LocalDate
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date = date.substring(0, Math.min(date.length(), 10));

            this.bDay = LocalDate.parse(date, formatter);
        } else bDay = LocalDate.now();
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getMannequin() {
        return mannequin;
    }

    public void setMannequin(String mannequin) {
        this.mannequin = mannequin;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    //    public String getNominations() {
//        return nominations;
//    }
//
//    public void setNominations(String nominations) {
//        this.nominations = nominations;
//    }

}
