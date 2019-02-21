package com.springTest.controller;


import com.springTest.model.Payment;
import com.springTest.feignService.FeignClientConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

// @FeignClient(name = "jsonplaceholder", url = "https://payment.yandex.net/api/v3", path = "/payments",

@FeignClient(name = "jsonplaceholder", url = "https://postman-echo.com/post", path = "/",
        configuration = FeignClientConfiguration.class)
public interface ApiClient {

    @RequestMapping(method = GET, path="/{paymentID}",
            consumes = APPLICATION_JSON_VALUE)
    Resource<Payment> getPayment(@RequestParam("_limit") final int postLimit,
                                 @PathVariable("paymentID") String paymentID);

    //Resource<Payment> getPayment(@RequestParam("_limit") final int postLimit);

    @RequestMapping(method = POST, value = "/",
            consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    //Payment savePost(@RequestBody Payment payment);
    String savePost(@RequestBody Payment payment);
}