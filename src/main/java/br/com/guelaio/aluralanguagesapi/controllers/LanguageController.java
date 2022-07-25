package br.com.guelaio.aluralanguagesapi.controllers;

import br.com.guelaio.aluralanguagesapi.models.Language;
import br.com.guelaio.aluralanguagesapi.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @RequestMapping(path = "language", method = RequestMethod.POST)
    public ResponseEntity<Language> create(@RequestBody Language language) {
        return new ResponseEntity<>(languageService.save(language), HttpStatus.CREATED);
    }

    @RequestMapping(path = "languages", method = RequestMethod.GET)
    public List<Language> findAll() {
        return languageService.findAll();
    }

    @RequestMapping(path = "languages/ordered-by-ranking", method = RequestMethod.GET)
    public List<Language> findAllOrderByRanking() {
        return languageService.findAllOrderByRanking();
    }

    @RequestMapping(path = "language/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(languageService.findById(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "language/update-ranking", method = RequestMethod.PATCH)
    public ResponseEntity<String> updateRanking(@RequestBody Language language) {
        if (languageService.updateRanking(language)) {
            return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
    }

}
