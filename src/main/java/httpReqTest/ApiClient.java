package httpReqTest;


import com.springTest.model.Payment;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient(name = "jsonplaceholder", url = "https://payment.yandex.net/api/v3", path = "/payments",
        configuration = FeignClientConfiguration.class)
public interface ApiClient {

    @RequestMapping(method = GET, value = "/23ecf75e-000f-5000-8000-149fe17e1ffa",
            consumes = APPLICATION_JSON_VALUE)
    Resource<Payment> getPayment(@RequestParam("_limit") final int postLimit);
    //Resource<Payment> getPayment(@RequestParam("_limit") final int postLimit);

//    @RequestMapping(method = POST, value = "/23ecf75e-000f-5000-8000-149fe17e1ffa",
//            consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
//    Post savePost(@RequestBody Post post);
}