package com.ascential.injesuswetrust.demo.controller;

import com.ascential.injesuswetrust.demo.model.SearchTermResult;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController("/api/search")
public class SearchController {

    @GetMapping("country/list")
    public ResponseEntity<List<String>> getCountries(@Param("global_customer_id") Integer globalCustomerId,
        @Param("report_date") LocalDate reportDate) {



        return ResponseEntity.ok(null);

    }
    @GetMapping("translator")

    public ResponseEntity<List<SearchTermResult>> getSearchTerms(@Param("global_customer_id") Integer globalCustomerId,
                                                                 @Param("report_date") LocalDate reportDate, @Param("country_code") String countryCode) {



        return ResponseEntity.ok(null);

    }
}
