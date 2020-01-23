package com.ascential.injesuswetrust.demo.service;

import com.ascential.injesuswetrust.demo.dao.SearchTermDao;
import com.ascential.injesuswetrust.demo.model.SearchTermResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchTermDao searchTermResultDao;

    @Override
    public List<String> getCountryCodes(Integer globalCustomerId, LocalDate date) {
        return searchTermResultDao.getCountryCodes(globalCustomerId, date);
    }

    @Override
    public List<SearchTermResult> getSearchTermResults(Integer globalCustomerId, LocalDate date, String countryCode) {
        return null;
    }
}
