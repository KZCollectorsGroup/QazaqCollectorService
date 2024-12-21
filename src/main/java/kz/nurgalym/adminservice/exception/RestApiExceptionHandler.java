package kz.nurgalym.adminservice.exception;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class RestApiExceptionHandler {
    private static final String NOT_NULL = "NotNull";
    private static final String NOT_BLANK = "NotBlank";
    private static final String EMAIL = "Email";
    private static final String SIZE = "Size";

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeError(RuntimeException e) {
        log.error("", e);
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", getLocalDateTime());
        map.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(map);
    }

    @ExceptionHandler({SQLException.class})
    public ResponseEntity<Object> handleSqlException(SQLException e) {
        log.error("", e);
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", getLocalDateTime());
        map.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(map);
    }


    @ExceptionHandler({CustomException.class})
    public ResponseEntity<Object> handleRuntimeError(CustomException e) {
        log.error("", e);
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", getLocalDateTime());
        map.put("message", e.getMessage());
        map.put("status", e.getStatus());
        map.put("code", e.getCode());
        return ResponseEntity.status(e.getStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(map);
    }

    @NotNull
    private static String getLocalDateTime() {
        return String.valueOf(LocalDate.now(ZoneId.of("UTC")));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        Map<String, String> errors = new HashMap<>();
        for (FieldError error : fieldErrors) {
            if (NOT_NULL.equals(error.getCode())) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            if (NOT_BLANK.equals(error.getCode())) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            if (EMAIL.equals(error.getCode())) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            if (SIZE.equals(error.getCode())) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
        }
        return new ResponseEntity<>(errors, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
