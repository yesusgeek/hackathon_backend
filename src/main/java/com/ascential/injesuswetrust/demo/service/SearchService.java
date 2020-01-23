package com.ascential.injesuswetrust.demo.service;

import com.ascential.injesuswetrust.demo.model.SearchTermResult;

import java.time.LocalDate;
import java.util.List;

public interface SearchService {

    List<String> getCountryCodes(Integer globalCustomerId, LocalDate date);

    List<SearchTermResult> getSearchTermResults(Integer globalCustomerId, LocalDate date, String countryCode);
}
