package id.my.hendisantika.restclientsample.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.common.JsonException;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import id.my.hendisantika.restclientsample.dto.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClient;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

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

    @Test
    void shouldReturnTheListOfPostOnSuccess() throws JsonException, JsonProcessingException {
        Post post = new Post(1, 1, "Title", "Description");

        List<Post> posts = List.of(post);

        stubFor(get("/posts").willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(objectMapper.writeValueAsString(posts))
        ));

        List<Post> actualResponse = jsonPlaceHolderClient.getPosts();
        Assertions.assertEquals(posts, actualResponse);
    }
}
