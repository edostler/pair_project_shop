package controllers;

import db.DBHelper;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class HealthProductsController {

    public HealthProductsController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        post("/health-products/stock", (req, res) -> {
            int productId = Integer.parseInt(req.queryParams("id"));
            Product product = DBHelper.find(Product.class, productId);
            int shopQuantity = product.getQuantity();
            int addedQuantity = Integer.parseInt(req.queryParams("quantity"));
            int newShopQuantity = shopQuantity + addedQuantity;
            product.setQuantity(newShopQuantity);
            DBHelper.saveOrUpdate(product);
            String url = req.headers("referer");
            res.redirect(url);
            return null;
        }, new VelocityTemplateEngine());


        get("/health-products/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Health health = DBHelper.find(Health.class, intId);
            List<Shop> shops = DBHelper.getAll(Shop.class);
            List<HealthCategory> healthCategories = DBHelper.getAllHealthCategories();
            Map<String, Object> model = new HashMap<>();
            model.put("shops", shops);
            model.put("healthCategories", healthCategories);
            model.put("health", health);
            model.put("template", "templates/healthProducts/edit.vtl");
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            if(loggedInUser.equals("admin")){
                return new ModelAndView(model, "templates/adminLayout.vtl");
            }
            else{
                return new ModelAndView(model, "templates/layout.vtl");
            }
        }, new VelocityTemplateEngine());


        get("/health-products", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Shop stockShop = DBHelper.findShopByName("PPS Groceries");
            List<Health> healthProducts = DBHelper.findProductsByShop(Health.class, stockShop);

//            List<Health> healthProducts = DBHelper.getAll(Health.class);
            model.put("healthProducts", healthProducts);
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            if (loggedInUser.equals("admin")) {
                model.put("template", "templates/healthProducts/index.vtl");
            }
            else {
                model.put("template", "templates/healthProducts/customerIndex.vtl");
            }
            if(loggedInUser.equals("admin")){
                return new ModelAndView(model, "templates/adminLayout.vtl");
            }
            else{
                return new ModelAndView(model, "templates/layout.vtl");
            }
        }, new VelocityTemplateEngine());


        get ("/health-products/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Shop> shops = DBHelper.getAll(Shop.class);
            List<HealthCategory> healthCategories = DBHelper.getAllHealthCategories();
            model.put("shops", shops);
            model.put("healthCategories", healthCategories);
            model.put("template", "templates/healthProducts/create.vtl");
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            if(loggedInUser.equals("admin")){
                return new ModelAndView(model, "templates/adminLayout.vtl");
            }
            else{
                return new ModelAndView(model, "templates/layout.vtl");
            }
        }, new VelocityTemplateEngine());


        get("/health-products/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Health healthProduct = DBHelper.find(Health.class, intId);
            Map<String, Object> model = new HashMap<>();
            model.put("healthProduct", healthProduct);
            model.put("template", "templates/healthProducts/show.vtl");
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            if(loggedInUser.equals("admin")){
                return new ModelAndView(model, "templates/adminLayout.vtl");
            }
            else{
                return new ModelAndView(model, "templates/layout.vtl");
            }
        }, new VelocityTemplateEngine());


        post ("/health-products", (req, res) -> {
            Shop shop = DBHelper.findShopByName("PPS Groceries");
            String name = req.queryParams("name");
            String description = req.queryParams("description");
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            double price = Double.parseDouble(req.queryParams("price"));
            String strStockDate = req.queryParams("stockDate");
            GregorianCalendar stockDate = DBHelper.formatStringToDate(strStockDate);
            String category = req.queryParams("category");
            HealthCategory healthCategory = HealthCategory.valueOf(category);
            Health health = new Health(name, healthCategory, price, quantity, description, stockDate, shop);
            DBHelper.saveOrUpdate(health);
            res.redirect("/health-products");
            return null;
        }, new VelocityTemplateEngine());


        post ("/health-products/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Health productToDelete = DBHelper.find(Health.class, id);
            DBHelper.delete(productToDelete);
            res.redirect("/health-products");
            return null;
        }, new VelocityTemplateEngine());


        post ("/health-products/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Health health = DBHelper.find(Health.class, intId);
            Shop shop = DBHelper.findShopByName("PPS Groceries");
            String name = req.queryParams("name");
            String category = req.queryParams("category");
            HealthCategory healthCategory = HealthCategory.valueOf(category);
            String description = req.queryParams("description");
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            String strStockDate = req.queryParams("stockDate");
            GregorianCalendar stockDate = DBHelper.formatStringToDate(strStockDate);
            double price = Double.parseDouble(req.queryParams("price"));
            health.setName(name);
            health.setCategory(healthCategory);
            health.setDescription(description);
            health.setQuantity(quantity);
            health.setStockDate(stockDate);
            health.setPrice(price);
            health.setShop(shop);
            DBHelper.saveOrUpdate(health);
            res.redirect("/health-products");
            return null;
        }, new VelocityTemplateEngine());

    }
}
