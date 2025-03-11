package com.example.demo.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.demo.exceptions.GeneralServiceException;
import com.example.demo.demo.exceptions.NoDataFoundException;
import com.example.demo.demo.exceptions.ValidateServiceException;
import com.example.demo.demo.utils.WrapperResponse;

import org.springframework.web.context.request.WebRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ErrorHandlerConfig extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> all(Exception e, WebRequest request){
        log.error(e.getMessage(),e);
        WrapperResponse<?> response = new WrapperResponse<>(false, /* Error en el servidor */ "Internal Server Error", null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidateServiceException.class)
    public ResponseEntity<?> validateService(Exception e, WebRequest request){
        log.error(e.getMessage(),e);
        WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<?> noData(Exception e, WebRequest request){
        log.error(e.getMessage(),e);
        WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(GeneralServiceException.class)
    public ResponseEntity<?> generalService(Exception e, WebRequest request){
        log.error(e.getMessage(),e);
        WrapperResponse<?> response = new WrapperResponse<>(false, /* Error en el servidor */ "Internal Server Error", null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
