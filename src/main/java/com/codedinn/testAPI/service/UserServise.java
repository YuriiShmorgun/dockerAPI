package com.codedinn.testAPI.service;

import com.codedinn.testAPI.model.Blog;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.List;

public class UserServise {

    String javaHome = System.getenv("DB_ALIAS");


    //MongoClient client = new MongoClient("localhost", 82);
    //MongoClient client = new MongoClient("172.17.0.2", 27017);
    MongoClient client = new MongoClient(javaHome, 27017);
    Datastore datastore = new Morphia().createDatastore(client, "blog");

    public String addpost (Blog blog){
        datastore.save(blog);
        return javaHome;
    }

    public List<Blog> getAllPost(){
        List<Blog> list = datastore.find(Blog.class).asList();
        if (list != null){
            return list;
        } else {
            return null;
        }
    }


}
