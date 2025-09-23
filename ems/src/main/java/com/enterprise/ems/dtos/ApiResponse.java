package com.enterprise.ems.dtos;


public class ApiResponse<T> {
    private boolean success;
    private int code;
    private String message;
    private T data;
    private PaginationResponse pagination;

    // No-args constructor
    public ApiResponse() {}

    // All-args constructor
    public ApiResponse(boolean success, int code, String message, T data, PaginationResponse pagination) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.pagination = pagination;
    }

    // Getters & setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public PaginationResponse getPagination() { return pagination; }
    public void setPagination(PaginationResponse pagination) { this.pagination = pagination; }
}
