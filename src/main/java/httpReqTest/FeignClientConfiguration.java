package httpReqTest;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("548831", "test_BXC19NGsNOMn38f1e1t1JBFH4yuieszpj-P0UAb9BLQ");
    }
}
