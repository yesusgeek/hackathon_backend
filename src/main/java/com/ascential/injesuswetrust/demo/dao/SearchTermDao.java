package com.ascential.injesuswetrust.demo.dao;

import com.ascential.injesuswetrust.demo.model.SearchTerm;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchTermDao {


    List<SearchTerm> getSearchTermsByCustomerIdAndReportDate(@Param("customer_id") int customerId, @Param("report_date") String reportDate);

}
