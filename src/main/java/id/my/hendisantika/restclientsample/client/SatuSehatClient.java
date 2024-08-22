package id.my.hendisantika.restclientsample.client;

import id.my.hendisantika.restclientsample.dto.LoginRequest;
import id.my.hendisantika.restclientsample.dto.TokenResponse;
import id.my.hendisantika.restclientsample.exception.CommentsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

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

    //    @Qualifier("restClientSatuSehat")
    private final RestTemplate restTemplate = new RestTemplate();

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

    public TokenResponse getToken4() {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", "YOUR_CLIENT_ID");
        formData.add("client_secret", "YOUR_CLIENT_SECRET");
        formData.add("organization_id", "YOUR_ORGANIZATION_ID");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return restClientSatuSehat.post()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("api-satusehat-stg.dto.kemkes.go.id")
                        .path("/oauth2/v1/accesstoken")
                        .queryParam("grant_type", "client_credentials")
                        .build())
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .body(formData)
                .retrieve().onStatus(HttpStatusCode::isError, ((request, response) -> {
                    throw new CommentsException("Error Occurred");
                }))
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public TokenResponse getToken2() {
        // Building the login request
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", "YOUR_CLIENT_ID");
        formData.add("client_secret", "YOUR_CLIENT_SECRET");
        formData.add("organization_id", "YOUR_ORGANIZATION_ID");
        formData.add("grant_type", "client_credentials");

        log.info("loginRequest formData ---> {}", formData);

        // Creating HTTP headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Creating the HTTP entity with headers and body
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);

        // Making the POST request
        ResponseEntity<TokenResponse> response = restTemplate.postForEntity(
                "https://api-satusehat-stg.dto.kemkes.go.id/oauth2/v1/accesstoken", // Replace with the actual URL
                requestEntity,
                TokenResponse.class
        );
        log.info("response ---> {}", response);

        if (response.getStatusCode().isError()) {
            log.error("Error occurred while fetching token: {}", response.getStatusCode());
            throw new CommentsException("Error Occurred");
        }

        return response.getBody();
    }

    public TokenResponse getToken3() {
        // URL with request parameters
        String url = "https://api-satusehat-stg.dto.kemkes.go.id/oauth2/v1/accesstoken?grant_type=client_credentials";

        // Form data to be sent in the body
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", "YOUR_CLIENT_ID");
        formData.add("client_secret", "YOUR_CLIENT_SECRET");
        formData.add("organization_id", "YOUR_ORGANIZATION_ID");

        // Setting the headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Creating the HTTP entity
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);

        // Sending the POST request
        ResponseEntity<TokenResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                TokenResponse.class
        );

        // Checking for errors in the response
        if (response.getStatusCode().isError()) {
            log.error("Error occurred while fetching token: {}", response.getStatusCode());
            throw new CommentsException("Error Occurred");
        }

        return response.getBody();
    }
}
