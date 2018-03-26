package controllers;

import db.DBHelper;
import models.CurrentPurchase;
import models.Customer;
import models.Shop;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class CustomersController {

    public CustomersController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        get("/customers/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Customer customer = DBHelper.find(Customer.class, intId);
            List<Shop> shops = DBHelper.getAll(Shop.class);

            Map<String, Object> model = new HashMap<>();
            model.put("shops", shops);
            model.put("customer", customer);
            model.put("template", "templates/customers/edit.vtl");
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/customers", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Customer> customers = DBHelper.getAll(Customer.class);
            model.put("template", "templates/customers/index.vtl");
            model.put("customers", customers);
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/customers/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Shop> shops = DBHelper.getAll(Shop.class);
            model.put("shops", shops);
            model.put("template", "templates/customers/create.vtl");
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/customers/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Customer customer = DBHelper.find(Customer.class, intId);
            Map<String, Object> model = new HashMap<>();
            model.put("customer", customer);
            model.put("template", "templates/customers/show.vtl");
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/customers", (req, res) -> {
            int shopId = Integer.parseInt(req.queryParams("shop"));
            Shop shop = DBHelper.find(Shop.class, shopId);
            String name = req.queryParams("name");
            String username = req.queryParams("username");
            int distance = Integer.parseInt(req.queryParams("distance"));
            Customer customer = new Customer(name, username, distance, shop);
            DBHelper.saveOrUpdate(customer);
            CurrentPurchase currentPurchase = new CurrentPurchase(0.00, customer);
            DBHelper.saveOrUpdate(currentPurchase);
            res.redirect("/customers");
            return null;
        }, new VelocityTemplateEngine());

        post ("/customers/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Customer customerToDelete = DBHelper.find(Customer.class, id);
            DBHelper.delete(customerToDelete);
            res.redirect("/customers");
            return null;
        }, new VelocityTemplateEngine());

        post ("/customers/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Customer customer = DBHelper.find(Customer.class, intId);
            int shopId = Integer.parseInt(req.queryParams("shop"));
            Shop shop = DBHelper.find(Shop.class, shopId);
            String name = req.queryParams("name");
            String username = req.queryParams("username");
            int distance = Integer.parseInt(req.queryParams("distance"));

            customer.setName(name);
            customer.setUsername(username);
            customer.setDistance(distance);
            customer.setShop(shop);
            DBHelper.saveOrUpdate(customer);
            res.redirect("/customers");
            return null;

        }, new VelocityTemplateEngine());
    }

}
