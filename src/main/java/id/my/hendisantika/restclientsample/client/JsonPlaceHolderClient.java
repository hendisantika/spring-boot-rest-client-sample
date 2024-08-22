package id.my.hendisantika.restclientsample.client;

import id.my.hendisantika.restclientsample.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-client-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/08/24
 * Time: 06.35
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequiredArgsConstructor
public class JsonPlaceHolderClient {
    private final RestClient restClient;

    public List<User> getUsers() {
        return restClient.get()
                .uri("/users")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public User getUserById(int id) {
        return restClient.get()
                .uri((uriBuilder) -> uriBuilder.path("/users/" + id).build())
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public User addUser(User user) {
        return restClient.post()
                .uri("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .body(user)
                .retrieve()
                .body(User.class);
    }
}
