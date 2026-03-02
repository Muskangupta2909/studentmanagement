package com.Project.studentmanagement.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
public class ApiResponse<T>{
    private String status;
    private int statusCode;
    private String message;
    private T data;
    private LocalDateTime timestamp;
}
