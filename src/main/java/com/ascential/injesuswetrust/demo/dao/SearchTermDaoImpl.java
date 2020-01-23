package com.ascential.injesuswetrust.demo.dao;

import com.ascential.injesuswetrust.demo.model.SearchTerm;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class SearchTermDaoImpl implements SearchTermDao {

    @Override
    public List<String> getCountryCodes(Integer globalCustomerId, LocalDate reportDate) {
        return null;
    }

    @Override
    public List<SearchTerm> getSearchTermsByCustomerId(int customerId) {
        return null;
    }

    @Override
    public List<SearchTerm> getSearchTermsByCustomerIdAndReportDate(int customerId, String reportDate) {
        return null;
    }

}
