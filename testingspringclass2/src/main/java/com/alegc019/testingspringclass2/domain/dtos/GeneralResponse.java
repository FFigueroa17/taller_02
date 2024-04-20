package com.alegc019.testingspringclass2.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponse {
    private String message;
    private Object data;

    public static ResponseEntity<GeneralResponse> getResponse(HttpStatus status, String message, Object data){
        return new ResponseEntity<>(
                new GeneralResponse(message, data),
                status
        );
    }

    public static ResponseEntity<GeneralResponse> getResponse(HttpStatus status, String message){
        return new ResponseEntity<>(
                new GeneralResponse(message, null),
                status
        );
    }

    public static ResponseEntity<GeneralResponse> getResponse(HttpStatus status, Object data){
        return new ResponseEntity<>(
                new GeneralResponse(status.getReasonPhrase(), data),
                status
        );
    }

    public static ResponseEntity<GeneralResponse> getResponse(String message, Object data){
        return new ResponseEntity<>(
                new GeneralResponse(message, data),
                HttpStatus.OK
        );
    }

    public static ResponseEntity<GeneralResponse> getResponse(String message){
        return new ResponseEntity<>(
                new GeneralResponse(message, HttpStatus.OK.getReasonPhrase()),
                HttpStatus.OK
        );
    }

    public static ResponseEntity<GeneralResponse> getResponse(HttpStatus status){
        return new ResponseEntity<>(
                new GeneralResponse(status.getReasonPhrase(), null),
                status
        );
    }
}

