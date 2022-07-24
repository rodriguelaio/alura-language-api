package br.com.guelaio.aluralanguagesapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(path = "/wow", method = RequestMethod.GET)
    public String seila() {

        return "wow";
    }
}
