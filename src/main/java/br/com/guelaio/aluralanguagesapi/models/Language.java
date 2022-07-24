package br.com.guelaio.aluralanguagesapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mainLanguages")
public class Language {

    @Id
    private String id;
    private String title;
    private String logoImageUrl;
    private int ranking;

    public Language(String title, String logoImageUrl, int ranking) {
        this.title = title;
        this.logoImageUrl = logoImageUrl;
        this.ranking = ranking;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLogoImageUrl() {
        return logoImageUrl;
    }

    public int getRanking() {
        return ranking;
    }
}
