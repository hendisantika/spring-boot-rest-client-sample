package id.my.hendisantika.restclientsample.controller;

import id.my.hendisantika.restclientsample.client.JsonPlaceHolderClient;
import id.my.hendisantika.restclientsample.dto.Comment;
import id.my.hendisantika.restclientsample.dto.Post;
import id.my.hendisantika.restclientsample.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-client-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/08/24
 * Time: 06.40
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class JsonPlaceHolderController {
    private final JsonPlaceHolderClient jsonPlaceHolderClient;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        log.info("Get all users");
        return jsonPlaceHolderClient.getUsers();
    }

    @GetMapping("/users/{userId}")
    public User getAllUsers(@PathVariable int userId) {
        log.info("Get user by ID");
        return jsonPlaceHolderClient.getUserById(userId);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        log.info("Add user: {}", user);
        return jsonPlaceHolderClient.addUser(user);
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        log.info("Get all posts");
        return jsonPlaceHolderClient.getPosts();
    }

    @GetMapping("/comments/{postId}")
    public List<Comment> getCommentsByPost(@PathVariable int postId) {
        log.info("Get all comments by post");
        return jsonPlaceHolderClient.getCommentsByPost(postId);
    }
}
