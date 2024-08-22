package id.my.hendisantika.restclientsample.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by IntelliJ IDEA.
 * Project : mhdc-main
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/08/24
 * Time: 22.40
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@Builder
@ToString
public class LoginRequest {
    private String clientId;
    private String clientSecret;
    private String organizationId;
}
