package com.springTest.service.chempRegService;

import com.springTest.dao.chempRegDAO.ChempRegDAO;
import com.springTest.feignService.ApiClient;
import com.springTest.model.Amount;
import com.springTest.model.Confirmation;
import com.springTest.model.Payment;
import com.springTest.model.PaymentMethod;
import com.springTest.model.chempReg.ChempReg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChempRegServiseImpl {
    @Autowired
    private ChempRegDAO dao;

    @Autowired
    private ApiClient feignService ;


    public ChempReg get(long id) {
        return dao.get(id);

    }

    public List<ChempReg> list() {
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

    public long save(ChempReg chempReg) {
        return dao.save(chempReg);

    }

    public String register(ChempReg chempReg) {

        if (chempReg.getSumTotal() > 0 ) {
            Payment paymentToSend = Payment.builder()
                    .amount(Amount.builder().currency("RUB").value(chempReg.getSumTotal()).build())
                    .payment_method(PaymentMethod.builder().type("bank_card").id("New-Id-To-Insert").build()) // remove ID
                    .confirmation(Confirmation.builder().type("redirect").return_url("http://alliancebeauty.ru/chemp_reg/?pay=success").build())
                    .capture(true)
                    .description("Оплата тренеровок для чемпионата")
                    .build();

            Payment confirmedPayment = feignService.savePayment(paymentToSend); // WORK!!!
            //System.out.println(paymentToSend);

            dao.updatePaymentId(chempReg.getId(), confirmedPayment.getpayment_method_data().getId()); // WORK!!!
//        dao.updatePaymentId(chempReg.getId(), paymentToSend.getpayment_method_data().getId()); // DEMO

            return confirmedPayment.getConfirmation().getConfirmation_url(); //  WORK!!!
//        return "http://somesite.com/";  // DEMO
        } else return "https://ssl.alliancebeauty.ru/train_reg/index.html#/complete";

    }
}
