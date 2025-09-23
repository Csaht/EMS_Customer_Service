package com.enterprise.ems.dtos;


public class PaginationResponse {
    private int page;
    private int pageSize;
    private long totalRecords;
    private int totalPages;

    // ✅ No-args constructor
    public PaginationResponse() {}

    // ✅ All-args constructor
    public PaginationResponse(int page, int pageSize, long totalRecords, int totalPages) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalRecords = totalRecords;
        this.totalPages = totalPages;
    }

    // ✅ Getters & setters
    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }

    public int getPageSize() { return pageSize; }
    public void setPageSize(int pageSize) { this.pageSize = pageSize; }

    public long getTotalRecords() { return totalRecords; }
    public void setTotalRecords(long totalRecords) { this.totalRecords = totalRecords; }

    public int getTotalPages() { return totalPages; }
    public void setTotalPages(int totalPages) { this.totalPages = totalPages; }
}
