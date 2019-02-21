package com.springTest.service;

import com.springTest.dao.PartDAO;
import com.springTest.feignService.ApiClient;
import com.springTest.model.*;

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
//        final Payment postToInsert = Payment.builder()
//                .amount(Amount.builder().currency("RUB").value(50F).build())
//                .status("bar")
//                .description("foo")
//                .payment_method(PaymentMethod.builder().type("bank_card").build())
//                .paid(false)
//                .build();
        //String insertedPost = feignService.savePost(postToInsert);
        //System.out.println(insertedPost);
        //feignService.getPaymentInfo(postToInsert);
//        feignService.savePayment(postToInsert);
        return dao.list();
    }

    @Override
    public String save(Part part) {
        long localId = dao.save(part);

        Payment paymentToSend = Payment.builder()
                .amount(Amount.builder().currency("RUB").value(part.getTotalSum()).build())
                .payment_method(PaymentMethod.builder().type("bank_card").build())
                .confirmation(Confirmation.builder().type("redirect").return_url("http://alliancebeauty.ru/chemp_reg/?pay=success").build())
                .capture(true)
                .description(part.getDescription())
                .build();

        //Payment confirmedPayment = feignService.savePayment(paymentToSend);
        System.out.println(paymentToSend);

        //toDO Update record in part with confirmedPayment.payment_method.getId()

        return "http://somesite.com/";//confirmedPayment.getConfirmation().getConfirmation_url();
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


