package httpReqTest;

import com.springTest.model.Payment;
import com.springTest.model.Amount;
import com.springTest.model.PaymentMethod;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.hateoas.config.EnableHypermediaSupport;


@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@SpringBootApplication
@EnableFeignClients
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
public class Runner {

    public static void main(final String args[]) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        ApiClient feignClient = context.getBean(ApiClient.class);
//        Resource<Payment> posts = feignClient.getPayment(10, "23f9056a-000f-5000-9000-1d9bb9d0f339");
               // "23ecf75e-000f-5000-8000-149fe17e1ffa");


//        System.out.println(posts.toString());
//        for (Resource payment : posts) {
//            System.out.println(payment);
//        }

        final Payment postToInsert = Payment.builder()
                .amount(Amount.builder().currency("RUB").value(50F).build())
                .status("bar")
                .description("foo")
                .payment_method(PaymentMethod.builder().type("bank_card").build())
                .paid(false)
                .build();

        //Payment insertedPost = feignClient.savePost(postToInsert);
        String insertedPost = feignClient.savePost(postToInsert);
        System.out.println(insertedPost);
    }
}
