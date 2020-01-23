package com.ascential.injesuswetrust.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Countries {
    
    @Id
    private int id;
    
    private String country;
    private int total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
