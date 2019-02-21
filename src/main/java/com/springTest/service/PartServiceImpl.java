package com.springTest.service;

import com.springTest.dao.PartDAO;
import com.springTest.feignService.ApiClient;
import com.springTest.model.Amount;
import com.springTest.model.Part;

import com.springTest.model.Payment;
import com.springTest.model.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService{

    @Autowired
    private PartDAO dao;

    @Autowired
    private ApiClient feignService ;

    @Override
    public Part get(long id) {
        return dao.get(id);
    }

    @Override
    public List<Part> list() {
        final Payment postToInsert = Payment.builder()
                .amount(Amount.builder().currency("RUB").value(50F).build())
                .status("bar")
                .description("foo")
                .payment_method(PaymentMethod.builder().type("bank_card").build())
                .paid(false)
                .build();
        //String insertedPost = feignService.savePost(postToInsert);
        //System.out.println(insertedPost);
        feignService.putInfo(postToInsert);
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


