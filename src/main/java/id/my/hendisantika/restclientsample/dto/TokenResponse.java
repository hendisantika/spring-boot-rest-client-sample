package id.my.hendisantika.restclientsample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : mhdc-main
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/08/24
 * Time: 22.33
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TokenResponse {
    private List<String> apiProductListJson = new ArrayList<>();
    private String refreshTokenExpiresIn;
    private String apiProductList;
    private String organizationName;
    @JsonProperty("developer.email")
    private String email;
    private String tokenType;
    private String issuedAt;
    private String clientId;
    private String accessToken;
    private String applicationName;
    private String scope;
    private String expiresIn;
    private String refreshCount;
    private String status;
}
