package com.example.paginationdemo.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "datedUser")
@Data
public class DatedUser {
    private String id;
    private String userName;

    private  Date date;


}
