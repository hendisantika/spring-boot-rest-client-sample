package id.my.hendisantika.restclientsample.client;

import id.my.hendisantika.restclientsample.dto.Comment;
import id.my.hendisantika.restclientsample.dto.Post;
import id.my.hendisantika.restclientsample.dto.User;
import id.my.hendisantika.restclientsample.exception.CommentsException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
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
    @Qualifier("restClientJsonPlaceHolder")
    private final RestClient restClientJsonPlaceHolder;

    public List<User> getUsers() {
        return restClientJsonPlaceHolder.get()
                .uri("/users")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public User getUserById(int id) {
        return restClientJsonPlaceHolder.get()
                .uri((uriBuilder) -> uriBuilder.path("/users/" + id).build())
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public User addUser(User user) {
        return restClientJsonPlaceHolder.post()
                .uri("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .body(user)
                .retrieve()
                .body(User.class);
    }

    public List<Post> getPosts() {
        return restClientJsonPlaceHolder.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public Post getPostById(int id) {
        return restClientJsonPlaceHolder.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public List<Comment> getCommentsByPost(int postId) {
        return restClientJsonPlaceHolder.get()
                .uri((uriBuilder -> uriBuilder.path("/comments").queryParam("postId", postId).build()))
                .retrieve().onStatus(HttpStatusCode::isError, ((request, response) -> {
                    throw new CommentsException("Error Occurred");
                }))
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
