package com.example.paginationdemo.service;

import com.example.paginationdemo.entities.DatedUser;
import com.example.paginationdemo.entities.PaginationResponse;
import com.example.paginationdemo.repository.DatedUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class DatedUserService {

    private final DatedUserRepository datedUserRepository;

    public DatedUserService(DatedUserRepository datedUserRepository) {
        this.datedUserRepository = datedUserRepository;
    }

    public <T> T getAllUsers(int pageNumber, int pageSize){

        pageNumber--;
        if(pageNumber<0)
            return (T) "Page Number not less than 1";

        Pageable pageable =PageRequest.of(pageNumber,pageSize, Sort.by("userName"));
        Page<DatedUser> page=datedUserRepository.findAll(pageable);

        PaginationResponse paginationResponse=new PaginationResponse();

        paginationResponse.setTotalUsers(page.getTotalElements());
        paginationResponse.setTotalPages(page.getTotalPages());
        long currentPage=page.getPageable().getPageNumber();
        paginationResponse.setCurrentPageNumber(currentPage+1);
        paginationResponse.setUsersPerPage(page.getPageable().getPageSize());
        paginationResponse.setUserList(page.getContent());

        return (T) paginationResponse;
    }

    public DatedUser addUser(DatedUser datedUser){
        datedUser.setDate(new Date());
        return datedUserRepository.save(datedUser);
    }
}
