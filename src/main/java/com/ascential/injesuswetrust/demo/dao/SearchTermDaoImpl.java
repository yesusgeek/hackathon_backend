package com.ascential.injesuswetrust.demo.dao;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class SearchTermDaoImpl implements SearchTermResultDao {

    @Override
    public List<String> getCountryCodes(Integer globalCustomerId, LocalDate reportDate) {
        return null;
    }

}
