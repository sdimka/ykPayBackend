package com.springTest.feignService;

import com.springTest.model.Payment;
import org.springframework.hateoas.Resource;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiClientImpl implements ApiClient {

    RestTemplate rt = new RestTemplate();


    public void putInfo(Payment payment) {

        Map<String, String> vars = new HashMap<String, String>();
        vars.put("id", "JS01");

            rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            rt.getMessageConverters().add(new StringHttpMessageConverter());
        String uri = "https://postman-echo.com/post/";

        String returns = rt.postForObject(uri, payment, String.class, vars);
        System.out.println(returns + " \n --------- ");
}
    @Override
    public Resource<Payment> getPayment(int postLimit, String paymentID) {
        
        return null;
    }

    @Override
    public String savePost(Payment payment) {
        return null;
    }
}
