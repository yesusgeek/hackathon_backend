package com.ascential.injesuswetrust.demo.service;

import com.ascential.injesuswetrust.demo.dao.SearchTermResultDao;
import com.ascential.injesuswetrust.demo.model.SearchTerm;
import com.ascential.injesuswetrust.demo.model.SearchTermResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchTermResultDao searchTermResultDao;

    @Override
    public Map<String, Integer> getCountryCodes(Integer globalCustomerId, LocalDate date) {
        return searchTermResultDao.getCountryCodes(globalCustomerId, date);
    }

    public List<SearchTerm> getSearchTerm(Integer globalCustomerId, LocalDate date) {
        return searchTermResultDao.getSearchTermsByCustomerIdAndReportDate(globalCustomerId, date.toString());
    }

    @Override
    public List<SearchTermResult> getSearchTermResults(Integer globalCustomerId, LocalDate date, String countryCode) {
        return searchTermResultDao.getSearchTermResults(globalCustomerId, date, countryCode);
    }
}
