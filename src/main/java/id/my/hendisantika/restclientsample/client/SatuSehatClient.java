package id.my.hendisantika.restclientsample.client;

import id.my.hendisantika.restclientsample.dto.LoginRequest;
import id.my.hendisantika.restclientsample.dto.TokenResponse;
import id.my.hendisantika.restclientsample.exception.CommentsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-client-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/08/24
 * Time: 08.40
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SatuSehatClient {
    @Qualifier("restClientSatuSehat")
    private final RestClient restClientSatuSehat;

    public TokenResponse getToken() {
        LoginRequest loginRequest = LoginRequest.builder()
                .clientId("YOUR_CLIENT_ID")
                .clientSecret("YOUR_CLIENT_SECRET")
                .organizationId("YOUR_ORGANIZATION_ID")
                .build();
        log.info("loginRequest ---> {}", loginRequest.toString());
        return restClientSatuSehat.post()
                .uri((uriBuilder -> uriBuilder.path("/oauth2/v1/accesstoken")
                        .queryParam("grant_type", "client_credentials")
                        .build()))
                .header("Content-Type", "application/x-www-form-urlencoded ")
                .body(loginRequest)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .retrieve().onStatus(HttpStatusCode::isError, ((request, response) -> {
                    throw new CommentsException("Error Occurred");
                }))
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
