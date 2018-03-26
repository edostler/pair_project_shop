package controllers;

import db.DBHelper;
import models.Food;
import models.FoodCategory;
import models.Product;
import models.Shop;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class FoodProductsController {

    public FoodProductsController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {




        get("/food-products/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Food food = DBHelper.find(Food.class, intId);
            List<Shop> shops = DBHelper.getAll(Shop.class);
            List<FoodCategory> foodCategories = DBHelper.getAllFoodCategories();
//            String category = req.queryParams("category");
//            FoodCategory foodCategory = FoodCategory.valueOf(category);
            Map<String, Object> model = new HashMap<>();
            model.put("shops", shops);
            model.put("categories", foodCategories);
            model.put("food", food);
            model.put("template", "templates/foodProducts/edit.vtl");
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/food-products", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Food> foods = DBHelper.getAll(Food.class);
            model.put("foods", foods);
            model.put("template", "templates/foodProducts/index.vtl");
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/food-products/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Shop> shops = DBHelper.getAll(Shop.class);
            List<FoodCategory> foodCategories = DBHelper.getAllFoodCategories();
            model.put("shops", shops);
            model.put("foodCategories", foodCategories);
            model.put("template", "templates/foodProducts/create.vtl");
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/food-products/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Food food = DBHelper.find(Food.class, intId);

            Map<String, Object> model = new HashMap<>();

            model.put("food", food);
            model.put("template", "templates/foodProducts/show.vtl");
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());




        post ("/food-products", (req, res) -> {
            int shopId = Integer.parseInt(req.queryParams("shop"));
            Shop shop = DBHelper.find(Shop.class, shopId);
            String name = req.queryParams("name");
            String description = req.queryParams("description");
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            double price = Double.parseDouble(req.queryParams("price"));
            String strStockDate = req.queryParams("stockDate");
            GregorianCalendar stockDate = DBHelper.formatStringToDate(strStockDate);
            String category = req.queryParams("category");
            FoodCategory foodCategory = FoodCategory.valueOf(category);
            Food food = new Food(name, foodCategory, price, quantity, description, stockDate, shop);
            DBHelper.saveOrUpdate(food);
            res.redirect("/food-products");
            return null;
        }, new VelocityTemplateEngine());

        post ("/food-products/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Food productToDelete = DBHelper.find(Food.class, id);
            DBHelper.delete(productToDelete);
            res.redirect("/food-products");
            return null;
        }, new VelocityTemplateEngine());

//        post ("/products/:id", (req, res) -> {
//            String strId = req.params(":id");
//            Integer intId = Integer.parseInt(strId);
//            Product product = DBHelper.find(Product.class, intId);
//            int shopId = Integer.parseInt(req.queryParams("shop"));
//            Shop shop = DBHelper.find(Shop.class, shopId);
//            String name = req.queryParams("name");
//            String username = req.queryParams("username");
//            int distance = Integer.parseInt(req.queryParams("distance"));
//
//            customer.setName(name);
//            customer.setUsername(username);
//            customer.setDistance(distance);
//            customer.setShop(shop);
//            DBHelper.saveOrUpdate(customer);
//            res.redirect("/customers");
//            return null;
//
//        }, new VelocityTemplateEngine());
    }

}
