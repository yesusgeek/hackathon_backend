package com.ascential.injesuswetrust.demo.service;

import com.ascential.injesuswetrust.demo.model.SearchTerm;
import com.ascential.injesuswetrust.demo.model.SearchTermResult;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface SearchService {

    Map<String, Integer> getCountryCodes(Integer globalCustomerId, LocalDate date);

    List<SearchTermResult> getSearchTermResults(Integer globalCustomerId, LocalDate date, String countryCode);
    List<SearchTerm> getSearchTerm(Integer globalCustomerId, LocalDate date);
    
}
