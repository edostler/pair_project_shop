package controllers;

import db.DBHelper;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class ProductsController {

    public ProductsController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        get("/products/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Product product = DBHelper.find(Product.class, intId);
            List<Shop> shops = DBHelper.getAll(Shop.class);
            Map<String, Object> model = new HashMap<>();
            model.put("shops", shops);
            model.put("product", product);
            model.put("template", "templates/products/edit.vtl");
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/products", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Shop stockShop = DBHelper.findShopByName("PPS Groceries");
            List<Product> products = DBHelper.findProductsByShop(Product.class, stockShop);
            model.put("products", products);
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            if (loggedInUser.equals("admin")) {
                model.put("template", "templates/products/index.vtl");
                }
            else {
                model.put("template", "templates/products/customerIndex.vtl");
            }
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/products/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Product product = DBHelper.find(Product.class, intId);
            Map<String, Object> model = new HashMap<>();
            model.put("product", product);
            model.put("template", "templates/products/show.vtl");
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post ("/products/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Product productToDelete = DBHelper.find(Product.class, id);
            DBHelper.delete(productToDelete);
            res.redirect("/products");
            return null;
        }, new VelocityTemplateEngine());


        post ("/products/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Product product = DBHelper.find(Product.class, intId);
            int shopId = Integer.parseInt(req.queryParams("shop"));
            Shop shop = DBHelper.find(Shop.class, shopId);
            String name = req.queryParams("name");
            String description = req.queryParams("description");
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            String strStockDate = req.queryParams("stockDate");
            GregorianCalendar stockDate = DBHelper.formatStringToDate(strStockDate);
            double price = Double.parseDouble(req.queryParams("price"));
            product.setName(name);
            product.setDescription(description);
            product.setQuantity(quantity);
            product.setStockDate(stockDate);
            product.setPrice(price);
            product.setShop(shop);
            DBHelper.saveOrUpdate(product);
            res.redirect("/products");
            return null;
        }, new VelocityTemplateEngine());
    }
}