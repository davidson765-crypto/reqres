package org.example.entities;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersResponse {

    public UsersResponse() {}

    private String page;

    private String per_page;

    private String total;

    private String total_pages;

    private List<UserResponse.UserData> data;

    public String getPage() {
        return page;
    }

    public String getPerPage() {
        return per_page;
    }

    public String getTotal() {
        return total;
    }

    public String getTotalPages() {
        return total_pages;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setPer_page(String per_page) {
        this.per_page = per_page;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public void setData(List<UserResponse.UserData> data) {
        this.data = data;
    }

    public List<UserResponse.UserData> getData() {
        return data;
    }
}
