package com.ascential.injesuswetrust.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Countries {
    
    @Id
    private int id;
    
    private String country;
    private int customerId;
}
