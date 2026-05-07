package cl.duoc.agenda.controller.handler;

import cl.duoc.agenda.dto.ExceptionDto;
import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionDto>> handlerValidation(MethodArgumentNotValidException ex) {
        List<ExceptionDto> errors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = error.getObjectName();
            String errorMessage = error.getDefaultMessage();
            log.error(errorMessage, error);
            errors.add(new ExceptionDto(fieldName, errorMessage));
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(RetryableException.class)
    public ResponseEntity<ExceptionDto> handlerRetryable(RetryableException ex) {
        ExceptionDto error = new ExceptionDto("Error de comunicación con el servicio externo", ex.getMessage());
        log.error("Error de comunicación con el servicio externo: {}", ex.getMessage(), ex);
        return ResponseEntity.internalServerError().body(error);
    }

    public ResponseEntity<List<ExceptionDto>> handlerGeneral(Exception ex) {
        List<ExceptionDto> errors = new ArrayList<>();
        errors.add(new ExceptionDto(ex.getMessage(), ex.getCause().toString()));
        log.error(ex.getMessage(), ex);
        return ResponseEntity.internalServerError().body(errors);
    }

}
