package id.my.hendisantika.restclientsample.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-client-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/08/24
 * Time: 07.56
 * To change this template use File | Settings | File Templates.
 */
public class CommentsException extends RuntimeException {
    public CommentsException(String errorOccurred) {
        super(errorOccurred);
    }
}
