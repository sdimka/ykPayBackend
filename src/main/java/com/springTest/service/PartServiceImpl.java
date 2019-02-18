package com.springTest.service;

import com.springTest.dao.PartDAO;
import com.springTest.model.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService{

    @Autowired
    private PartDAO dao;

    @Override
    public Part get(long id) {
        return dao.get(id);
    }

    @Override
    public List<Part> list() {
        return dao.list();
    }

    @Override
    public long save(Part part) {
        return dao.save(part);
    }

    @Override
    public void update(long id, Part part) {
        dao.update(id, part);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }
}


