package com.ascential.injesuswetrust.demo.service;

import com.ascential.injesuswetrust.demo.model.SearchTermResult;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SearchService {

    Map<String, Integer> getCountryCodes(Integer globalCustomerId, Date date);

    List<SearchTermResult> getSearchTermResults(Integer globalCustomerId, Date date, String countryCode);

}
