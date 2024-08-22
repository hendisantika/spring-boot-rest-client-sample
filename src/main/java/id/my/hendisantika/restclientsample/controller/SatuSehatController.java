package id.my.hendisantika.restclientsample.controller;

import id.my.hendisantika.restclientsample.client.SatuSehatClient;
import id.my.hendisantika.restclientsample.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-client-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/08/24
 * Time: 08.43
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SatuSehatController {
    private final SatuSehatClient satuSehatClient;

    //    @GetMapping(value = "/token", consumes = "application/x-www-form-urlencoded", produces = "application/json")
    @GetMapping(value = "/token")
    public TokenResponse getToken() {
        return satuSehatClient.getToken();
    }
}
