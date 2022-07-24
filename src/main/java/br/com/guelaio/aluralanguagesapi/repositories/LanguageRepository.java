package br.com.guelaio.aluralanguagesapi.repositories;

import br.com.guelaio.aluralanguagesapi.models.Language;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LanguageRepository extends MongoRepository<Language, String> {

}
