package httpReqTest;

import com.springTest.model.Payment;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.config.EnableHypermediaSupport;


import java.util.List;


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
        Resource<Payment> posts = feignClient.getPayment(10);
        System.out.println(posts.toString());
//        for (Resource payment : posts) {
//            System.out.println(payment);
//        }

//        final Post postToInsert = Post.builder()
//                .body("bar")
//                .title("foo")
//                .userId(1)
//                .build();
//        Post insertedPost = feignClient.savePost(postToInsert);
//        System.out.println(insertedPost);
    }
}
