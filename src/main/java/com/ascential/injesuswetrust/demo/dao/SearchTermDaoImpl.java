package com.ascential.injesuswetrust.demo.dao;

import com.ascential.injesuswetrust.demo.model.SearchTerm;
import com.ascential.injesuswetrust.demo.model.SearchTermResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public class SearchTermDaoImpl implements  SearchTermDao{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private String SEARCH_TERMS_CUSTOMER_ID = "select id, country, " +
            "customer_id,search_term,score,report_date " +
            "from search_terms where customer_id = :customer_id";
    
    @Override
    public List<SearchTerm> getSearchTermsByCustomerId(int customerId) {
        List<SearchTerm> searchTerms = jdbcTemplate.queryForList(SEARCH_TERMS_CUSTOMER_ID, SearchTerm.class);
       
        return searchTerms;
    }

    @Override
    public List<SearchTerm> getSearchTermsByCustomerIdAndReportDate(int customerId, String reportDate) {
        List<SearchTerm> searchTerms = jdbcTemplate.queryForList(SEARCH_TERMS_CUSTOMER_ID, SearchTerm.class);

        return searchTerms;
    }
}
