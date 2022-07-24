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
@RequestMapping("api/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @RequestMapping(path = "/languages", method = RequestMethod.GET)
    public List<Language> findAll() {
        return languageService.findAll();
    }

    @RequestMapping(path = "/language/{id}", method = RequestMethod.GET)
    public Language findById(@PathVariable String id) {
        return languageService.findById(id);
    }

    @RequestMapping(path = "language", method = RequestMethod.POST)
    public ResponseEntity<Language> create(@RequestBody Language language) {
        return new ResponseEntity<>(languageService.save(language), HttpStatus.CREATED);
    }
}
