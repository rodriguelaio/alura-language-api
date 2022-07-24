package br.com.guelaio.aluralanguagesapi.services;

import br.com.guelaio.aluralanguagesapi.models.Language;

import java.util.List;

public interface LanguageService {

    List<Language> findAll();

    Language findById(String id);

    Language save(Language language);
}
