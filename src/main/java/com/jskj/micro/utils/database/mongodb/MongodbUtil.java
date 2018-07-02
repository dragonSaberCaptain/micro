package com.jskj.micro.utils.database.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.utils.Mongodb
 * @description
 * @date 2018-05-17 10:06 星期四
 */
public class MongodbUtil {
    private static final String URL = "mongodb://tshan_jv:javapwd@117.173.135.6:27017/gsis";

    private static final String DATABASE_NAME = "gsis";

    public MongodbUtil(String collectionName) {
        createCollection(collectionName);
    }

    private static MongoDatabase createMongodbDatabase() {
        MongoClientURI connectionString = new MongoClientURI(URL);
        MongoClient    mongoClient      = new MongoClient(connectionString);
        return mongoClient.getDatabase(DATABASE_NAME);
    }

    public static MongoCollection<Document> createCollection(String collectionName) {
        MongoDatabase mongoDatabase = createMongodbDatabase();
        return mongoDatabase.getCollection(collectionName);
    }
}
