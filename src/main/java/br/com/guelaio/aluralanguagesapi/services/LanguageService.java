package br.com.guelaio.aluralanguagesapi.services;

import br.com.guelaio.aluralanguagesapi.models.Language;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import java.util.List;

public interface LanguageService {

    Language save(Language language);

    List<Language> findAll();

    List<Language> findAllOrderByRanking();

    Language findById(String id) throws NotFoundException;

    boolean updateRanking(Language language);
}
