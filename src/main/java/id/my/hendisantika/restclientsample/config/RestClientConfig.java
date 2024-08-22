package id.my.hendisantika.restclientsample.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-client-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/08/24
 * Time: 06.53
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class RestClientConfig {
    @Bean
    public RestClient restClientJsonPlaceHolder(RestTemplateBuilder builder) {
        return RestClient.create(builder
                .rootUri("https://jsonplaceholder.typicode.com")
                .build());
    }

    @Bean
    public RestClient restClientSatuSehat(RestTemplateBuilder builder) {
        return RestClient.create(builder
                .rootUri("https://api-satusehat-stg.dto.kemkes.go.id")
                .build());
    }

}
