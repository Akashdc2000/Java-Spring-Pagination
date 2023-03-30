package com.example.paginationdemo.entities;

import lombok.Data;

import java.util.List;

@Data
public class PaginationResponse {

    private long totalUsers;
    private long totalPages;
    private long currentPageNumber;
    private long usersPerPage;
    private List<DatedUser> userList;
}
