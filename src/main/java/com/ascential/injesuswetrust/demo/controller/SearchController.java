package com.ascential.injesuswetrust.demo.controller;

import com.ascential.injesuswetrust.demo.model.SearchTermResult;
import com.ascential.injesuswetrust.demo.service.SearchService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @ApiOperation(value = "List countries with search terms data", nickname = "getSearchTermCountryList")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Map.class),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure"),
            @ApiResponse(code = 400, message = "Bad Request")})
    @GetMapping("country/list")
    public ResponseEntity<Map<String, Integer>> getCountries(@Param("global_customer_id") Integer globalCustomerId,
                                                             @Param("report_date") LocalDate reportDate) {
        Map<String, Integer> result = searchService.getCountryCodes(globalCustomerId, reportDate);
        return ResponseEntity.ok(result);
    }

    @ApiOperation(value = "Get a list of original and translated search terms with their related score", nickname = "getTranslatedSearchTerms")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure"),
            @ApiResponse(code = 400, message = "Bad Request")})
    @GetMapping("translator")
    public ResponseEntity<List<SearchTermResult>> getSearchTerms(@Param("global_customer_id") Integer globalCustomerId,
                                                                 @Param("report_date") LocalDate reportDate, @Param("country_code") String countryCode) {
        List<SearchTermResult> result = searchService.getSearchTermResults(globalCustomerId, reportDate, countryCode);
        return ResponseEntity.ok(result);
    }
}
