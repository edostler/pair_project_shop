package controllers;

import db.DBHelper;
import models.Shop;
import models.Customer;
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
            return new ModelAndView(model, "templates/login/login.vtl");
        }, new VelocityTemplateEngine());


        post("/login", (req, res) -> {
            List<Customer> customers = DBHelper.getAll(Customer.class);
            String username = req.queryParams("username");
            if (username.equals("admin")) {
                req.session().attribute("username", username);
                res.redirect("/login/password");
            }
            else {
                for (Customer customer : customers) {
                    if (username.equals(customer.getUsername())) {
                        req.session().attribute("username", username);
                        res.redirect("/home");
                    }
                }
                res.redirect("/login/no-account");
            }
            return null;
        }, new VelocityTemplateEngine());


        get("login/no-account", (req, res) -> {
            List<Shop> shops = DBHelper.getAll(Shop.class);
            Map<String, Object> model = new HashMap<>();
            model.put("shops", shops);
            return new ModelAndView(model, "templates/login/noAccount.vtl");
        }, new VelocityTemplateEngine());


        get("/login/password", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            return new ModelAndView(model, "templates/login/adminPassword.vtl");
        }, new VelocityTemplateEngine());


        post("/login/password", (req, res) -> {
            String password = req.queryParams("password");
            if (password.equals("admin1234")) {
                res.redirect("/");
            }
            else {
                res.redirect("/logout");
            }
            return null;
        }, new VelocityTemplateEngine());


        post("/login-new", (req, res) -> {
            String name = req.queryParams("name");
            String username = req.queryParams("username");
            int distance = Integer.parseInt(req.queryParams("distance"));
            int shopId = Integer.parseInt(req.queryParams("shop"));
            Shop shop = DBHelper.find(Shop.class, shopId);
            Customer customer = new Customer(name, username, distance, shop);
            DBHelper.saveOrUpdate(customer);
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

    public static String getLoggedInUsername(Request req, Response res) {
        String username = req.session().attribute("username");
        if (username == null || username.isEmpty()) {
            res.redirect("/login");
        }
        return username;
    }

}
