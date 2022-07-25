package br.com.guelaio.aluralanguagesapi.services.implementations;

import br.com.guelaio.aluralanguagesapi.models.Language;
import br.com.guelaio.aluralanguagesapi.repositories.LanguageRepository;
import br.com.guelaio.aluralanguagesapi.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Value("${spring.data.mongodb.uri}")
    private String DB_URI;
    @Autowired
    private LanguageRepository languageRepository;

    public Language save(Language language) {
        return languageRepository.save(language);
    }

    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    public List<Language> findAllOrderByRanking() {
        return languageRepository.findAll(Sort.by(Sort.Direction.ASC, "ranking"));
    }

    public Language findById(String id) throws NotFoundException {
        return languageRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public boolean updateRanking(Language language) {
        return LanguageRepository.updateRanking(language, DB_URI);

    }
}
