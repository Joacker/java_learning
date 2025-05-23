package com.example.demo.demo.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WrapperResponse<T> {
    private boolean ok;
    private String message;
    private T body;

    public ResponseEntity<WrapperResponse<T>> createResponse() {
        return new ResponseEntity<>(this,HttpStatus.OK);
    }

    public ResponseEntity<WrapperResponse<T>> createResponse(HttpStatus status) {
        return new ResponseEntity<>(this,status);
    }
}
