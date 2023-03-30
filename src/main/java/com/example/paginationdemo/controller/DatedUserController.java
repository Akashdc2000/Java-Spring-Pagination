package com.example.paginationdemo.controller;

import com.example.paginationdemo.entities.DatedUser;

import com.example.paginationdemo.service.DatedUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class DatedUserController {

    private final DatedUserService datedUserService;

    public DatedUserController(DatedUserService datedUserService) {
        this.datedUserService = datedUserService;
    }


    @GetMapping
    public <T> T getAllUsers(
            @RequestParam(value = "pageNumber",defaultValue = "1",required = false) Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "1",required = false) Integer pageSize
    ){
        return datedUserService.getAllUsers(pageNumber,pageSize);
    }


    @PostMapping
    public DatedUser addUser(@RequestBody DatedUser datedUser){
        return datedUserService.addUser(datedUser);
    }
}
