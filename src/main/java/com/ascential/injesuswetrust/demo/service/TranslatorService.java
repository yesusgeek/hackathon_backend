package com.ascential.injesuswetrust.demo.service;

import com.ascential.injesuswetrust.demo.model.SearchTerm;
import com.ascential.injesuswetrust.demo.model.SearchTermResult;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TranslatorService {

    public List<SearchTermResult> getTranslations(List<SearchTerm> searchTerms, String targetLanguage) {

        TranslateOptions translateOptions = TranslateOptions.newBuilder().setProjectId("asc-hackathon202-1579103020171").setTargetLanguage(targetLanguage).build();
        Translate translate = translateOptions.getService();

        final List<String> listTerms = searchTerms.stream().map(SearchTerm::getSearchTerm).collect(Collectors.toList());
        List<String> tmpTermList = new ArrayList<>();
        List<Translation> translations = new ArrayList<>();
        for(int i=0; i<listTerms.size();i++) {
            System.out.println("adding term = " + listTerms.get(i));
            tmpTermList.add(listTerms.get(i));
            System.out.println("adding term = " + listTerms.get(i) + " added");
            if (i%10 == 0) {
                System.out.println("translating " + i +" items");
                translations.addAll(translate.translate(tmpTermList, Translate.TranslateOption.targetLanguage(targetLanguage)));
                tmpTermList.clear();
            }
        }
        System.out.println("Translation completed");
        System.out.println("Translation lsit size " + translations.size());
        System.out.println("Search term lsit size " + searchTerms.size());

        List<SearchTermResult> searchTermsTranslated = new ArrayList<>();
        int i = 0;

        for (SearchTerm searchTerm : searchTerms) {
            if (i<translations.size()) {
                final SearchTermResult searchTermResult = new SearchTermResult();
                searchTermResult.setSource(searchTerm.getSearchTerm());
                searchTermResult.setTarget(translations.get(i).getTranslatedText());
                searchTermResult.setScore(searchTerm.getScore());
                searchTermsTranslated.add(searchTermResult);
            }
            i++;
        }

        return searchTermsTranslated;

    }
}
