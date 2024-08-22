package id.my.hendisantika.restclientsample.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClient;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-client-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/08/24
 * Time: 08.01
 * To change this template use File | Settings | File Templates.
 */
@ExtendWith(MockitoExtension.class)
@WireMockTest(httpPort = 3000)
class JsonPlaceHolderClientTest {
    private final RestClient restClient = RestClient.builder().baseUrl("http://localhost:3000").build();

    private final JsonPlaceHolderClient jsonPlaceHolderClient = new JsonPlaceHolderClient(restClient);

    private final ObjectMapper objectMapper = new ObjectMapper();
}
