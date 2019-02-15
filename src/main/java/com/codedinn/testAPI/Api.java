package com.codedinn.testAPI;

import com.codedinn.testAPI.model.Blog;
import com.codedinn.testAPI.service.UserServise;
import com.google.gson.Gson;

import static spark.Spark.get;
import static spark.Spark.post;


public class Api {

    private static UserServise userService = new UserServise();

    public static void main(String[] args) {
        final Gson gson = new Gson();

        post("/add-post", (req, res)->{
            res.type("application/json");
            Blog blog = gson.fromJson(req.body(), Blog.class);
            return userService.addpost(blog);
        }, gson::toJson);

        get("/", (req, res)->{
            res.type("application/json");
            return userService.getAllPost();
        }, gson::toJson);

    }
}
