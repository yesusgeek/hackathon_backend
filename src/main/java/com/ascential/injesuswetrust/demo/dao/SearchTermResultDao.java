package com.ascential.injesuswetrust.demo.dao;

import com.ascential.injesuswetrust.demo.model.SearchTermResult;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface SearchTermResultDao {

    Map<String, Integer> getCountryCodes(Integer globalCustomerId, LocalDate reportDate);

    List<SearchTermResult> getSearchTermResults(Integer globalCustomerId, LocalDate date, String countryCode);
}
