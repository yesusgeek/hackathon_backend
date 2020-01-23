package com.ascential.injesuswetrust.demo.dao;

import com.ascential.injesuswetrust.demo.model.Countries;
import com.ascential.injesuswetrust.demo.model.SearchTerm;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchTermDao {


    List<SearchTerm> getSearchTermsByCustomerIdAndReportDate(@Param("country") String country);
}
