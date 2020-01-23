package com.ascential.injesuswetrust.demo.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController("/api/search")
public class SearchController {

    public ResponseEntity<List<String>> getCountries(@Param("global_customer_id") Integer globalCustomerId,
        @Param("report_date") LocalDate reportDate) {



        return ResponseEnt.ok()

    }

    public ResponseEntity<List<Search>> getSearchTerms(@Param("global_customer_id") Integer globalCustomerId,
                                                     @Param("report_date") LocalDate reportDate) {



        return ResponseEnt.ok()

    }
}
