package id.my.hendisantika.restclientsample.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.common.JsonException;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import id.my.hendisantika.restclientsample.dto.Address;
import id.my.hendisantika.restclientsample.dto.Company;
import id.my.hendisantika.restclientsample.dto.Geo;
import id.my.hendisantika.restclientsample.dto.Post;
import id.my.hendisantika.restclientsample.dto.User;
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

    @Test
    void shouldReturnTheListOfUsersOnSuccess() throws JsonException, JsonProcessingException {
        Geo geo = new Geo("-37.3159", "81.1496");
        Address address = new Address("Tokyo", "Tokyo", "Tokyo", "12390", geo);
        Company company = new Company("Jujustru", "Jujutsu", "JUJUTSU");
        User user = new User(1, "Itadori Yuji", "yuji", "yuji@yopmail.com", address,
                "+6281321411511", "jujustsu.com", company);

        List<User> userList = List.of(user);

        stubFor(get("/users").willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(objectMapper.writeValueAsString(userList))
        ));

        List<User> actualResponse = jsonPlaceHolderClient.getUsers();
        Assertions.assertEquals(userList, actualResponse);
    }

//    void getTokenTest(){
//        HttpClient client = HttpClientBuilder.create().build();
//        Http request = new Http("https://api-satusehat-stg.dto.kemkes.go.id/oauth2/v1/accesstoken?grant_type=client_credentials");
//        HttpResponse response = client.execute(request);
//        int statusCode = response.getStatusLine().getStatusCode();
//        String responseBody = EntityUtils.toString(response.getEntity());
//        System.out.println("Status Code: " + statusCode);
//        System.out.println("Response Body: " + responseBody);
//    }
}
