package org.codejudge.sb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExceptionResponse {

    private String status;
    private String reason;


    public ExceptionResponse(String status, String reason) {
        this.status = status;
        this.reason = reason;
    }
}