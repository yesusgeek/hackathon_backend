package com.ascential.injesuswetrust.demo.service;

import com.ascential.injesuswetrust.demo.dao.SearchTermDao;
import com.ascential.injesuswetrust.demo.model.SearchTerm;
import com.ascential.injesuswetrust.demo.model.SearchTermResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchTermDao searchTermResultDao;

    @Autowired
    private TranslatorService translatorService;

    public Map<String, Integer> getCountryCodes(Integer globalCustomerId, Date date) {

        return null;
    }

    @Override
    public List<SearchTermResult> getSearchTermResults(Integer globalCustomerId, Date date, String countryCode) {
        List<SearchTerm> searchTerms = searchTermResultDao.getSearchTermsByCustomerIdAndReportDate(countryCode);

        List<SearchTermResult> results =  translatorService.getTranslations(searchTerms, "ES");

        return results;
    }
}
