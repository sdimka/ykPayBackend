package com.springTest.dao;

import com.springTest.model.Part;

import java.util.List;

public interface PartDAO {

    long save(Part part);

    Part get(long id);

    List<Part> list();

    void update(long id, Part part);

    void delete(long id);
}
