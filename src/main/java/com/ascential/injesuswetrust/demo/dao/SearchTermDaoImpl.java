package com.ascential.injesuswetrust.demo.dao;

import com.ascential.injesuswetrust.demo.model.Countries;
import com.ascential.injesuswetrust.demo.model.SearchTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SearchTermDaoImpl implements SearchTermDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_COUNTRY_LIST =
            "SELECT country, COUNT(*) as total search_terms_count FROM search_terms " +
                    "GROUP BY country HAVING COUNT(*) > 0";

    private String SEARCH_TERMS_CUSTOMER_ID = "select id, country, " +
            "customer_id,search_term,score,report_date " +
            "from search_terms where country = :country LIMIT 100";

    @Override
    public List<SearchTerm> getSearchTermsByCustomerIdAndReportDate(String country) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("country", country);

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        List<SearchTerm> terms = new ArrayList<SearchTerm>();
        
        List <Map<String,Object>>  results =  namedParameterJdbcTemplate.query(SEARCH_TERMS_CUSTOMER_ID,params ,new ColumnMapRowMapper());

        for (Map<String,Object> termResults : results){
            
            SearchTerm term = new SearchTerm();
            term.setCountry(termResults.get("country").toString());
            term.setReportDate(termResults.get("report_date").toString());
            term.setCustomerId(1);
            term.setScore(Integer.parseInt(termResults.get("score").toString()));
            term.setSearchTerm(termResults.get("search_term").toString());
            terms.add(term);
        }
        
        return terms;
    }

}
