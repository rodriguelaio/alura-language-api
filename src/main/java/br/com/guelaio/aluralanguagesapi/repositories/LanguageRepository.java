package br.com.guelaio.aluralanguagesapi.repositories;

import br.com.guelaio.aluralanguagesapi.models.Language;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LanguageRepository extends MongoRepository<Language, String> {

    //
    static boolean updateRanking(Language language, String dbUri) {
        try {
            MongoClient mongoClient = MongoClients.create(dbUri);
            MongoDatabase database = mongoClient.getDatabase("languagesDb");
            MongoCollection<Document> collection = database.getCollection("mainLanguages");
            UpdateResult updateResult = collection.updateOne(Filters.eq("title", language.getTitle()),
                Updates.set("ranking", language.getRanking()));
            return updateResult.getModifiedCount() > 0;
        } catch (Exception e) {
            System.out.println("updateRanking Exception: ".concat(e.getMessage()));
            return false;
        }
    }
}
