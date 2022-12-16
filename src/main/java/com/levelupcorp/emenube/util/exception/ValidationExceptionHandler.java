package com.levelupcorp.emenube.util.exception;

import com.levelupcorp.emenube.domain.response.ValidationResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<ValidationResponse> processUnmergeException(final MethodArgumentNotValidException ex) {

       List<String> list = ex.getBindingResult().getAllErrors().stream()
               .map(DefaultMessageSourceResolvable::getDefaultMessage)
               .collect(Collectors.toList());

        return new ResponseEntity<>(new ValidationResponse(list), HttpStatus.BAD_REQUEST);
    }

}