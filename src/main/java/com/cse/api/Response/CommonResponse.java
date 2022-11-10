package com.cse.api.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse {
    private String status;
    private String message;
    private Long count;
    private Object data;

    public CommonResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }



    public CommonResponse setData(Object o) {
        this.data = o;
        return this;
    }

    public CommonResponse setCount(Long i) {
        this.count = i;
        return this;
    }
}
