package com.ascential.injesuswetrust.demo.dao;

import java.time.LocalDate;
import java.util.List;

public interface SearchTermResultDao {

    List<String> getCountryCodes(Integer globalCustomerId, LocalDate reportDate);
}
