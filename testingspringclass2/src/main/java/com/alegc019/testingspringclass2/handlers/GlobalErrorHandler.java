package com.alegc019.testingspringclass2.handlers;

import com.alegc019.testingspringclass2.domain.dtos.GeneralResponse;
import com.alegc019.testingspringclass2.utils.ErrorsTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
@Slf4j
public class GlobalErrorHandler {

    private final ErrorsTool errorsTool;

    public GlobalErrorHandler(ErrorsTool errorsTool) {
        this.errorsTool = errorsTool;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GeneralResponse> GeneralHandler(Exception e){
        log.error(e.getMessage());
        return GeneralResponse.getResponse(
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<GeneralResponse> ResourceNotFoundHandler(NoResourceFoundException e){
        return GeneralResponse.getResponse(
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GeneralResponse> BadRequestHandler(MethodArgumentNotValidException ex){
        return GeneralResponse.getResponse(
                HttpStatus.BAD_REQUEST,
                errorsTool.mapErrors(ex.getBindingResult().getFieldErrors())
        );
    }
}