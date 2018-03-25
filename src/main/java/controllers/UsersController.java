package controllers;

import db.DBHelper;
import models.Shop;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class UsersController {

    public UsersController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        get("/users/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            User user = DBHelper.find(User.class, intId);
            List<Shop> shops = DBHelper.getAll(Shop.class);

            Map<String, Object> model = new HashMap<>();
            model.put("shops", shops);
            model.put("template", "templates/users/edit.vtl");
            model.put("user", user);
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/users", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<User> users = DBHelper.getAll(User.class);
            model.put("template", "templates/users/index.vtl");
            model.put("users", users);
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/users/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Shop> shops = DBHelper.getAll(Shop.class);
            model.put("shops", shops);
            model.put("template", "templates/users/create.vtl");
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/users/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            User user = DBHelper.find(User.class, intId);
            Map<String, Object> model = new HashMap<>();

            model.put("user", user);
            model.put("template", "templates/users/show.vtl");
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/users", (req, res) -> {
            int shopId = Integer.parseInt(req.queryParams("shop"));
            Shop shop = DBHelper.find(Shop.class, shopId);
            String name = req.queryParams("name");
            String username = req.queryParams("username");
            int distance = Integer.parseInt(req.queryParams("distance"));
            User user = new User(name, username, distance, shop);
            DBHelper.saveOrUpdate(user);
            res.redirect("/users");
            return null;
        }, new VelocityTemplateEngine());

        post ("/engineers/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            User userToDelete = DBHelper.find(User.class, id);
            DBHelper.delete(userToDelete);
            res.redirect("/users");
            return null;
        }, new VelocityTemplateEngine());

        post ("/users/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            User user = DBHelper.find(User.class, intId);
            int shopId = Integer.parseInt(req.queryParams("shop"));
            Shop shop = DBHelper.find(Shop.class, shopId);
            String name = req.queryParams("name");
            String username = req.queryParams("username");
            int distance = Integer.parseInt(req.queryParams("distance"));

            user.setName(name);
            user.setUsername(username);
            user.setDistance(distance);
            user.setShop(shop);
            DBHelper.saveOrUpdate(user);
            res.redirect("/users");
            return null;

        }, new VelocityTemplateEngine());
    }

}
