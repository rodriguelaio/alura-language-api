package br.com.guelaio.aluralanguagesapi.services.implementations;

import br.com.guelaio.aluralanguagesapi.models.Language;
import br.com.guelaio.aluralanguagesapi.repositories.LanguageRepository;
import br.com.guelaio.aluralanguagesapi.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public List<Language> findAll() {
        return languageRepository.findAll();
    }
}
