package id.my.hendisantika.restclientsample.controller;

import id.my.hendisantika.restclientsample.client.JsonPlaceHolderClient;
import id.my.hendisantika.restclientsample.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class JsonPlaceHolderController {
    private final JsonPlaceHolderClient jsonPlaceHolderClient;

    @GetMapping
    public List<User> getAllUsers() {
        return jsonPlaceHolderClient.getUsers();
    }
}
