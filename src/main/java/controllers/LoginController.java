package controllers;

import db.DBHelper;
import models.Shop;
import models.User;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class LoginController {

    public LoginController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get ("/login", (req, res) -> {
            List<Shop> shops = DBHelper.getAll(Shop.class);
            Map<String, Object> model = new HashMap<>();
            model.put("shops", shops);
            return new ModelAndView(model, "templates/login.vtl");
        }, new VelocityTemplateEngine());


        post("/login", (req, res) -> {
            String username = req.queryParams("username");
            req.session().attribute("username", username);
            String test = req.queryParams("username").toString().toLowerCase();
            if (test == "admin") {
                res.redirect("/");
            }
            else {
                res.redirect("/home");
            }
            return null;
        }, new VelocityTemplateEngine());


        post("/login-new", (req, res) -> {

            String name = req.queryParams("name");
            String username = req.queryParams("username");
            int distance = Integer.parseInt(req.queryParams("distance"));
            int shopId = Integer.parseInt(req.queryParams("shop"));
            Shop shop = DBHelper.find(Shop.class, shopId);

            User user = new User(name, username, distance, shop);
            DBHelper.saveOrUpdate(user);

//            int userId = user.getId();

//            req.session().attribute("userId", userId);
            req.session().attribute("username", username);

            res.redirect("/welcome");
            return null;
        }, new VelocityTemplateEngine());


        get ("/logout", (req, res) -> {
            req.session().removeAttribute("username");
            res.redirect("/");
            return null;
        }, new VelocityTemplateEngine());
    }

    public static String getLoggedInUserName(Request req, Response res) {
        String username = req.session().attribute("username");
        if (username == null || username.isEmpty()) {
            res.redirect("/login");
        }
        return username;
    }

}
