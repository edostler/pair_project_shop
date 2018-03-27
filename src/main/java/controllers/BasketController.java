package controllers;

import db.DBHelper;
import models.*;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

import spark.ModelAndView;

public class BasketController {

    public BasketController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        get("/basket", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            Customer customer = DBHelper.findCustomerByUsername(loggedInUser);
            CurrentPurchase basket = DBHelper.findBasketForCustomer(customer);
            List<Product> contents = DBHelper.findContentsForBasket(basket);
            model.put("user", loggedInUser);
            model.put("basket", basket);
            model.put("contents", contents);
            model.put("template", "templates/basket/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post("/basket", (req, res) -> {
            int productId = Integer.parseInt(req.queryParams("id"));
            Product product = DBHelper.find(Product.class, productId);

            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            Customer customer = DBHelper.findCustomerByUsername(loggedInUser);
            CurrentPurchase basket = DBHelper.findBasketForCustomer(customer);
            List<Product> contents = DBHelper.findContentsForBasket(basket);
            basket.setContents(contents);

            int shopQuantity = product.getQuantity();

            String name = product.getName();
            double price = product.getPrice();
            int purchaseQuantity = Integer.parseInt(req.queryParams("quantity"));
            String description = product.getDescription();
            GregorianCalendar stockDate = product.getStockDate();
            Shop shop = new Shop("SOLD");
            DBHelper.saveOrUpdate(shop);

            if (shopQuantity < purchaseQuantity) {
                purchaseQuantity = shopQuantity;
//                NEED TO FLAG THE USER IF NOT ENOUGH AVAILABLE
            }

            if (product.getClass() == Food.class) {
                Food stockFood = (Food) product;
                FoodCategory foodCategory = stockFood.getCategory();
                Food food = new Food(name, foodCategory, price, purchaseQuantity, description, stockDate, shop);
                DBHelper.saveOrUpdate(food);
                DBHelper.addProductToPurchase(food, basket);
            }
            else if (product.getClass() == Clothing.class) {
                Clothing stockClothing = (Clothing) product;
                ClothingCategory clothingCategory = stockClothing.getCategory();
                Clothing clothing = new Clothing(name, clothingCategory, price, purchaseQuantity, description, stockDate, shop);
                DBHelper.saveOrUpdate(clothing);
                DBHelper.addProductToPurchase(clothing, basket);
            }
            else {
                Health stockHealth = (Health) product;
                HealthCategory healthCategory = stockHealth.getCategory();
                Health health = new Health(name, healthCategory, price, purchaseQuantity, description, stockDate, shop);
                DBHelper.saveOrUpdate(health);
                DBHelper.addProductToPurchase(health, basket);
                }

            int newShopQuantity = shopQuantity - purchaseQuantity;
            product.setQuantity(newShopQuantity);
            boolean availability = product.checkAvailability();
            product.setAvailability(availability);
            DBHelper.saveOrUpdate(product);

            String url = req.headers("referer");
            res.redirect(url);
            return null;
        }, new VelocityTemplateEngine());

        post("/basket/:id/remove", (req, res) ->{
            int productId = Integer.parseInt(req.params("id"));
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            Customer customer = DBHelper.findCustomerByUsername(loggedInUser);
            CurrentPurchase basket = DBHelper.findBasketForCustomer(customer);
            List<Product> contents = DBHelper.findContentsForBasket(basket);
            for(Product content: contents){
                if(content.getId() == productId){
                    basket.reduceTotalInBasket(content);
                    DBHelper.saveOrUpdate(basket);
                    DBHelper.delete(content);

                }
            }

            String url = req.headers("referer");
            res.redirect(url);
            return null;
        }, new VelocityTemplateEngine());

    }

}
