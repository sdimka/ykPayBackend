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
    public long save(Part part) {
        return dao.save(part);

    }

    @Override
    public String register(Part part) {

        Payment paymentToSend = Payment.builder()
                .amount(Amount.builder().currency("RUB").value(part.getTotalSum()).build())
                .payment_method(PaymentMethod.builder().type("bank_card").id("New-Id-To-Insert").build()) // remove ID
                .confirmation(Confirmation.builder().type("redirect").return_url("http://alliancebeauty.ru/chemp_reg/?pay=success").build())
                .capture(true)
                .description(part.getDescription())
                .build();

//        Payment confirmedPayment = feignService.savePayment(paymentToSend); // WORK!!!
        //System.out.println(paymentToSend);

//        dao.updatePaymentId(part.getId(), confirmedPayment.getpayment_method_data().getId()); // WORK!!!
        dao.updatePaymentId(part.getId(), paymentToSend.getpayment_method_data().getId()); // DEMO

//        return confirmedPayment.getConfirmation().getConfirmation_url(); //  WORK!!!
        return "http://somesite.com/";  // DEMO

    }

    @Override
    public void update(long id, Part part) {
        dao.update(id, part);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }

    @Override
    public void getNewStatus(Part part) {

    }
}


