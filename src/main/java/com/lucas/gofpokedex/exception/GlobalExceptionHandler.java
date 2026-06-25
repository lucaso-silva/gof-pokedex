package com.lucas.gofpokedex.exception;

import ch.qos.logback.core.boolex.EvaluationException;
import feign.FeignException;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    protected ResponseEntity<ProblemDetail> handleBusinessException(BusinessException ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatusCode.valueOf(ex.getHttpStatus()), ex.getMessage()
        );
        problemDetail.setTitle(ex.getCode());
        problemDetail.setInstance(URI.create(request.getDescription(false).replace("uri=", "")));
        problemDetail.setProperty("code", ex.getCode());
        problemDetail.setProperty("timestamp", Instant.now().toString());

        return ResponseEntity.status(ex.getHttpStatus()).body(problemDetail);
    }

    @ExceptionHandler(value = FeignException.class)
    protected ResponseEntity<ProblemDetail> handleFeignException(FeignException ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatusCode.valueOf(ex.status()), ex.getMessage()
        );
        problemDetail.setTitle("api error");
        problemDetail.setInstance(URI.create(request.getDescription(false).replace("uri=", "")));
        problemDetail.setProperty("code", ex.getMessage());
        problemDetail.setProperty("timestamp", Instant.now().toString());

        return ResponseEntity.status(ex.status()).body(problemDetail);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        List<Map<String, String>> invalidParams = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> {
                    Map<String, String> param = new HashMap<>();
                    param.put("name", e.getField());
                    param.put("reason", e.getDefaultMessage());

                    return  param;
                })
                .collect(Collectors.toUnmodifiableList());

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST, "validation failed"
        );
        problemDetail.setTitle("validation failed");
        problemDetail.setInstance(URI.create(request.getDescription(false).replace("uri=", "")));
        problemDetail.setProperty("invalid-params", invalidParams);
        problemDetail.setProperty("timestamp", Instant.now().toString());

        return new ResponseEntity<>(problemDetail, HttpStatus.BAD_REQUEST);
    }
}
