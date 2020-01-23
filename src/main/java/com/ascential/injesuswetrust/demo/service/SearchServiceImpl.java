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

    public List<SearchTerm> getSearchTerm(Integer globalCustomerId, LocalDate date) {
        return searchTermResultDao.getSearchTermsByCustomerIdAndReportDate(globalCustomerId, date.toString());
    }

    public List<SearchTerm> getSearchTermByCustomerId(Integer globalCustomerId) {
        return searchTermResultDao.getSearchTermsByCustomerId(globalCustomerId);
    }

    public Map<String, Integer> getCountryCodes(Integer globalCustomerId, LocalDate date) {
        return null;
    }

    @Override
    public List<SearchTermResult> getSearchTermResults(Integer globalCustomerId, LocalDate date, String countryCode) {
        return new ArrayList<SearchTermResult>();
    }
}
