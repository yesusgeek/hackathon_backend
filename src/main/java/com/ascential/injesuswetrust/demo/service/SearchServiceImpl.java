package com.ascential.injesuswetrust.demo.service;

import com.ascential.injesuswetrust.demo.dao.SearchTermDao;
import com.ascential.injesuswetrust.demo.model.SearchTerm;
import com.ascential.injesuswetrust.demo.model.SearchTermResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchTermDao searchTermResultDao;

    public Map<String, Integer> getCountryCodes(Integer globalCustomerId, LocalDate date) {

        return null;
    }

    @Override
    public List<SearchTermResult> getSearchTermResults(Integer globalCustomerId, LocalDate date, String countryCode) {
        List<SearchTerm> searchTerms = searchTermResultDao.getSearchTermsByCustomerIdAndReportDate(globalCustomerId);
       
        //TODO: translate terms
        List<SearchTermResult> results =  new ArrayList<>();
        
        for(SearchTerm search : searchTerms){
            SearchTermResult result = new SearchTermResult();
            result.setScore(search.getScore());
            result.setSource(search.getSearchTerm());
            result.setReportDate(search.getReportDate());
            
            results.add(result);
        }
        
        return results;
    }
}
