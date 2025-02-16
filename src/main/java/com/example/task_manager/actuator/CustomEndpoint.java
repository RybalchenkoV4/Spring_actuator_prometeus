package com.example.task_manager.actuator;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

@Endpoint(id = "CustomEndpoint")
public class CustomEndpoint {

    @ReadOperation
    public CustomResponse customMethod() {
        return new CustomResponse("Everything is awesome!", 42);
    }

    @AllArgsConstructor
    @Data
    public static class CustomResponse {
        private String message;
        private int number;
    }
}
