package kz.nurgalym.adminservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {

    private final HttpStatus status;
    private final String code;

    public CustomException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.code = null;
    }

    public CustomException(String message, HttpStatus status, String code) {
        super(message);
        this.status = status;
        this.code = code;
    }

    public CustomException(Throwable cause, String message, HttpStatus status, String code) {
        super(message, cause);
        this.status = status;
        this.code = code;
    }
}
