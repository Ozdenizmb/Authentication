package com.auth.user.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.io.Serializable;

import static com.auth.user.exception.ErrorMessages.DEFAULT_ERROR_MESSAGE;

@Getter
@Setter
public class UserException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String detail;
    @NotNull
    private final HttpStatus status;

    protected UserException(HttpStatus status, Throwable throwable) {
        super(status.name(), throwable);
        this.status = status;
        this.message = throwable.getMessage();
        this.detail = !StringUtils.hasText(throwable.getMessage()) ? throwable.getMessage() : DEFAULT_ERROR_MESSAGE;
    }

    protected UserException(HttpStatus status, String message) {
        super(status.name());
        this.status = status;
        this.message = message;
        this.detail = null;
    }

    protected UserException(HttpStatus status, String message, String errorDetail) {
        super(status.name());
        this.status = status;
        this.message = message;
        this.detail = errorDetail;
    }

    public static UserException withStatusAndThrowable(HttpStatus status, Throwable throwable){
        return new UserException(status, throwable);
    }

    public static UserException withStatusAndMessage(HttpStatus status, String message){
        return new UserException(status, message);
    }

    public static UserException withStatusAndDetails(HttpStatus status, String message, String errorDetail){
        return new UserException(status, message, errorDetail);
    }

}
