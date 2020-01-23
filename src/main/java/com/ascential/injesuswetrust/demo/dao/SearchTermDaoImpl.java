package com.ascential.injesuswetrust.demo.dao;

import com.ascential.injesuswetrust.demo.model.SearchTerm;
import com.ascential.injesuswetrust.demo.model.SearchTermResult;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public class SearchTermDaoImpl implements SearchTermResultDao {

    @Override
    public Map<String, Integer> getCountryCodes(Integer globalCustomerId, LocalDate reportDate) {
        return null;
    }

    @Override
    public List<SearchTermResult> getSearchTermResults(Integer globalCustomerId, LocalDate date, String countryCode) {
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
