package com.springTest.service;

import com.springTest.model.Part;

import java.util.List;

public interface PartService {

    long save(Part part);

    String register(Part part);

    Part get(long id);

    List<Part> list();

    void update(long id, Part part);

    void delete(long id);

    void getNewStatus(Part part);
}
