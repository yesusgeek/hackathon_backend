package com.ascential.injesuswetrust.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SearchTerm {
    
    @Id
    private int id;
    
    private String country;
    private int customerId;
    private String searchTerm;
    private int score;
    private String reportDate;
}
