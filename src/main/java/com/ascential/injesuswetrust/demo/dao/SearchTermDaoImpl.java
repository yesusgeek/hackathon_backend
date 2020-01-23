package com.ascential.injesuswetrust.demo.dao;

import com.ascential.injesuswetrust.demo.model.SearchTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SearchTermDaoImpl implements SearchTermDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_COUNTRY_LIST =
            "SELECT country, COUNT(*) search_terms_count FROM search_terms " +
                    "GROUP BY country HAVING COUNT(*) > 0";

    private String SEARCH_TERMS_CUSTOMER_ID = "select id, country, " +
            "customer_id,search_term,score,report_date " +
            "from search_terms where customer_id = :customer_id";

    @Override
    public List<SearchTerm> getSearchTermsByCustomerId(int customerId) {
        return jdbcTemplate.queryForList(SEARCH_TERMS_CUSTOMER_ID, SearchTerm.class);
    }

    @Override
    public List<SearchTerm> getSearchTermsByCustomerIdAndReportDate(int customerId, String reportDate) {
        return jdbcTemplate.queryForList(SEARCH_TERMS_CUSTOMER_ID, SearchTerm.class);
    }
}
