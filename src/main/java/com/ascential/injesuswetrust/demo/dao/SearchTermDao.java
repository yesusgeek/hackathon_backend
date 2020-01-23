package com.ascential.injesuswetrust.demo.dao;

import com.ascential.injesuswetrust.demo.model.SearchTerm;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SearchTermDao {

    List<String> getCountryCodes(Integer globalCustomerId, LocalDate reportDate);

    @Query("select id, country, customer_id,search_term,score,report_date from search_terms where customer_id = :customer_id")
    List<SearchTerm> getSearchTermsByCustomerId(@Param("customer_id") int customerId);

    @Query("select id, country, customer_id,search_term,score,report_date from search_terms where customer_id = :customer_id and report_date = report_date")
    List<SearchTerm> getSearchTermsByCustomerIdAndReportDate(@Param("customer_id") int customerId, @Param("report_date") String reportDate);

}
