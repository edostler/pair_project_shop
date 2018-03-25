package controllers;

import db.DBHelper;
import models.PreviousPurchase;
import models.Shop;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class PreviousPurchasesController {

    public PreviousPurchasesController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/previous-purchases/:id/edit", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            PreviousPurchase previousPurchase = DBHelper.find(PreviousPurchase.class, id);
            List<Shop> shops = DBHelper.getAll(Shop.class);
            List<User> users = DBHelper.getAll(User.class);
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            model.put("shops", shops);
            model.put("users", users);
            model.put("template", "templates/previousPurchases/edit.vtl");
            model.put("previousPurchase", previousPurchase);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/previous-purchases", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<PreviousPurchase> previousPurchases = DBHelper.getAll(PreviousPurchase.class);
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            model.put("template", "templates/previousPurchases/index.vtl");
            model.put("previousPurchases", previousPurchases);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get ("/previous-purchases/new", (req, res) -> {
            List<User> users = DBHelper.getAll(User.class);
            List<Shop> shops = DBHelper.getAll(Shop.class);
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            model.put("users", users);
            model.put("shops", shops);
            model.put("template", "templates/previousPurchases/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/previous-purchases/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            PreviousPurchase previousPurchase = DBHelper.find(PreviousPurchase.class, id);
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            model.put("previousPurchase", previousPurchase);
            model.put("template", "templates/previousPurchases/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post ("/previous-purchases", (req, res) -> {
            double total = Double.parseDouble(req.queryParams("total"));
            int userId = Integer.parseInt(req.queryParams("user"));
            User user = DBHelper.find(User.class, userId);
            String strOrderDate = req.queryParams("orderDate");
            GregorianCalendar orderDate = DBHelper.formatStringToDate(strOrderDate);
            String strDeliveryDate = req.queryParams("deliveryDate");
            GregorianCalendar deliveryDate = DBHelper.formatStringToDate(strDeliveryDate);
            int shopId = Integer.parseInt(req.queryParams("shop"));
            Shop shop = DBHelper.find(Shop.class, shopId);

            PreviousPurchase previousPurchase = new PreviousPurchase(total, user, orderDate, deliveryDate, shop);
            DBHelper.saveOrUpdate(previousPurchase);

            res.redirect("/previous-purchases");
            return null;
        }, new VelocityTemplateEngine());


        post ("/previous-purchases/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            PreviousPurchase previousPurchase = DBHelper.find(PreviousPurchase.class, id);
            DBHelper.delete(previousPurchase);
            res.redirect("/previous-purchases");
            return null;
        }, new VelocityTemplateEngine());


        post ("/previous-purchases/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            PreviousPurchase previousPurchase = DBHelper.find(PreviousPurchase.class, id);
            double total = Double.parseDouble(req.queryParams("total"));
            int userId = Integer.parseInt(req.queryParams("user"));
            User user = DBHelper.find(User.class, userId);
            String strOrderDate = req.queryParams("orderDate");
            GregorianCalendar orderDate = DBHelper.formatStringToDate(strOrderDate);
            String strDeliveryDate = req.queryParams("deliveryDate");
            GregorianCalendar deliveryDate = DBHelper.formatStringToDate(strDeliveryDate);
            int shopId = Integer.parseInt(req.queryParams("shop"));
            Shop shop = DBHelper.find(Shop.class, shopId);
            previousPurchase.setTotal(total);
            previousPurchase.setUser(user);
            previousPurchase.setOrderDate(orderDate);
            previousPurchase.setDeliveryDate(deliveryDate);
            previousPurchase.setShop(shop);
            DBHelper.saveOrUpdate(previousPurchase);
            res.redirect("/previous-purchases");
            return null;
        }, new VelocityTemplateEngine());
    }

}
