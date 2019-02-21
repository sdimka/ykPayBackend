package com.springTest.feignService;

import com.springTest.model.Payment;

public interface ApiClient {

    public Payment getPaymentInfo(Payment payment);

    public Payment savePayment(Payment payment);

}
