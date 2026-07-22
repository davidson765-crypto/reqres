package org.example.entities;


import lombok.Data;

import java.util.List;

@Data
public class UsersResponse {

    public UsersResponse() {}

    private String page;

    private String per_page;

    private String total;

    private String total_pages;

    private List<UserResponse.UserData> data;
}
