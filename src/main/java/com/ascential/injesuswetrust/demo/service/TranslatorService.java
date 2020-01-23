package com.ascential.injesuswetrust.demo.service;

import com.ascential.injesuswetrust.demo.model.SearchTermResult;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TranslatorService {

    public List<SearchTermResult> getTranslations(List<String> searchTerms, String targetLanguage, List<Integer> scores) {

        TranslateOptions translateOptions = TranslateOptions.newBuilder().setProjectId("asc-hackathon202-1579103020171").setTargetLanguage(targetLanguage).build();
        Translate translate = translateOptions.getService();

        List<Translation> translations = translate.translate(searchTerms, Translate.TranslateOption.targetLanguage(targetLanguage));

        List<SearchTermResult> searchTermsTranslated = new ArrayList<>();
        int i = 0;

        for (String searchTerm : searchTerms) {

            final SearchTermResult searchTermResult = new SearchTermResult();
            searchTermResult.setSource(searchTerm);
            searchTermResult.setTarget(translations.get(i).getTranslatedText());
            searchTermResult.setScore(scores.get(i));
            searchTermsTranslated.add(searchTermResult);
            i++;
        }

        return searchTermsTranslated;

    }
}
