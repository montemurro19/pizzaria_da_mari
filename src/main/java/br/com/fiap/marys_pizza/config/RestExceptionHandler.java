package br.com.fiap.marys_pizza.config;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.marys_pizza.models.RestErrors;
import jakarta.validation.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<RestErrors>> constrainViolationExceptionHandler(ConstraintViolationException e){
        log.error("Erro capturado pelo Handler");
        List<RestErrors> erros = new ArrayList<>();

        e.getConstraintViolations().forEach(v -> erros.add(new RestErrors(v.getPropertyPath().toString(), v.getMessage())));

        return ResponseEntity.badRequest().body(erros);
    }
}
