package com.springTest.feignService;


import com.springTest.model.Payment;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class ApiClientImpl implements ApiClient {



    @Override
    public Payment getPaymentInfo(Payment payment) {

        RestTemplate rt = new RestTemplate();

        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());
        rt.getInterceptors().add(
                new BasicAuthorizationInterceptor("548831", "test_BXC19NGsNOMn38f1e1t1JBFH4yuieszpj-P0UAb9BLQ"));

        String uri = "https://payment.yandex.net/api/v3/payments/" + "23f9056a-000f-5000-9000-1d9bb9d0f339";


        Payment returnPayment = rt.getForObject(uri, Payment.class);
        System.out.println(" ----------------------------------------------------------------------------------");
        System.out.println(returnPayment.getAmount() + " " + returnPayment.getDescription() + " " + returnPayment.getId());
        System.out.println(" ----------------------------------------------------------------------------------");

        return returnPayment;
        //System.out.println(returns + " \n --------- ");
    }

    @Override
    public Payment savePayment(Payment payment){
        RestTemplate rt = new RestTemplate();
        UUID uuid = UUID.randomUUID();

        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(new RestTemplateHeaderModifierInterceptor("Idempotence-Key", uuid.toString()));

        rt.setInterceptors(interceptors);

        rt.getInterceptors().add(
                new BasicAuthorizationInterceptor("548831", "test_BXC19NGsNOMn38f1e1t1JBFH4yuieszpj-P0UAb9BLQ"));


        String uri = "https://payment.yandex.net/api/v3/payments/";
        //String uri = "https://postman-echo.com/post/";

//        Payment returnPayment = Payment.builder()
//                .amount(Amount.builder().currency("RUB").value(50F).build())
//                .payment_method(PaymentMethod.builder().type("bank_card").build())
//                .confirmation(Confirmation.builder().type("redirect").return_url("http://alliancebeauty.ru/chemp_reg/?pay=success").build())
//                .capture(true)
//                .description("Тестовый заказ")
//                .build();

//        String res = rt.postForObject(uri, payment, String.class);
        Payment resultPayment = rt.postForObject(uri, payment, Payment.class);

        System.out.println(" ----------------------------------------------------------------------------------");
        System.out.println(resultPayment);
        System.out.println(" ----------------------------------------------------------------------------------");

        return resultPayment;
    }

//    @Override
//    public Resource<Payment> getPayment(int postLimit, String paymentID) {
//
//        return null;
//    }
//
//    @Override
//    public String savePost(Payment payment) {
//        return null;
//    }
}
