package com.enterprise.ems.dtos;

import jakarta.validation.constraints.NotEmpty;
/*import org.apache.poi.ss.formula.functions.T;*/

import java.util.List;

public class BulkDeleteRequest<T> {

    @NotEmpty(message = "Request list cannot be empty")
    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
