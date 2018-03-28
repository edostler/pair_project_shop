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

public class ClothingProductsController {

    public ClothingProductsController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        post("/clothing-products/stock", (req, res) -> {
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


        get("/clothing-products/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Clothing clothing = DBHelper.find(Clothing.class, intId);
            List<Shop> shops = DBHelper.getAll(Shop.class);
            List<ClothingCategory> clothingCategories = DBHelper.getAllClothingCategories();
            Map<String, Object> model = new HashMap<>();
            model.put("shops", shops);
            model.put("clothingCategories", clothingCategories);
            model.put("clothing", clothing);
            model.put("template", "templates/clothingProducts/edit.vtl");
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);

            if(loggedInUser.equals("admin")){
                return new ModelAndView(model, "templates/adminLayout.vtl");
            }
            else{
                return new ModelAndView(model, "templates/layout.vtl");
            }
        }, new VelocityTemplateEngine());


        get("/clothing-products", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            Shop stockShop = DBHelper.findShopByName("PPS Groceries");
            List<Clothing> clothingProducts = DBHelper.findProductsByShop(Clothing.class, stockShop);

//            List<Clothing> clothingProducts = DBHelper.getAll(Clothing.class);
            model.put("clothingProducts", clothingProducts);
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            if (loggedInUser.equals("admin")) {
                model.put("template", "templates/clothingProducts/index.vtl");
            }
            else {
                model.put("template", "templates/clothingProducts/customerIndex.vtl");
            }

            if(loggedInUser.equals("admin")){
                return new ModelAndView(model, "templates/adminLayout.vtl");
            }
            else{
                return new ModelAndView(model, "templates/layout.vtl");
            }

        }, new VelocityTemplateEngine());


        get ("/clothing-products/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Shop> shops = DBHelper.getAll(Shop.class);
            List<ClothingCategory> clothingCategories = DBHelper.getAllClothingCategories();
            model.put("shops", shops);
            model.put("clothingCategories", clothingCategories);
            model.put("template", "templates/clothingProducts/create.vtl");
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            if(loggedInUser.equals("admin")){
                return new ModelAndView(model, "templates/adminLayout.vtl");
            }
            else{
                return new ModelAndView(model, "templates/layout.vtl");
            }
        }, new VelocityTemplateEngine());


        get("/clothing-products/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Clothing clothingProduct = DBHelper.find(Clothing.class, intId);
            Map<String, Object> model = new HashMap<>();
            model.put("clothingProduct", clothingProduct);
            model.put("template", "templates/clothingProducts/show.vtl");
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            if(loggedInUser.equals("admin")){
                return new ModelAndView(model, "templates/adminLayout.vtl");
            }
            else{
                return new ModelAndView(model, "templates/layout.vtl");
            }
        }, new VelocityTemplateEngine());


        post ("/clothing-products", (req, res) -> {
            Shop shop = DBHelper.findShopByName("PPS Groceries");
            String name = req.queryParams("name");
            String description = req.queryParams("description");
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            double price = Double.parseDouble(req.queryParams("price"));
            String strStockDate = req.queryParams("stockDate");
            GregorianCalendar stockDate = DBHelper.formatStringToDate(strStockDate);
            String category = req.queryParams("category");
            ClothingCategory clothingCategory = ClothingCategory.valueOf(category);
            Clothing clothing = new Clothing(name, clothingCategory, price, quantity, description, stockDate, shop);
            DBHelper.saveOrUpdate(clothing);
            res.redirect("/clothing-products");
            return null;
        }, new VelocityTemplateEngine());


        post ("/clothing-products/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Clothing productToDelete = DBHelper.find(Clothing.class, id);
            DBHelper.delete(productToDelete);
            res.redirect("/clothing-products");
            return null;
        }, new VelocityTemplateEngine());


        post ("/clothing-products/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Clothing clothing = DBHelper.find(Clothing.class, intId);
            Shop shop = DBHelper.findShopByName("PPS Groceries");
            String name = req.queryParams("name");
            String category = req.queryParams("category");
            ClothingCategory clothingCategory = ClothingCategory.valueOf(category);
            String description = req.queryParams("description");
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            String strStockDate = req.queryParams("stockDate");
            GregorianCalendar stockDate = DBHelper.formatStringToDate(strStockDate);
            double price = Double.parseDouble(req.queryParams("price"));
            clothing.setName(name);
            clothing.setCategory(clothingCategory);
            clothing.setDescription(description);
            clothing.setQuantity(quantity);
            clothing.setStockDate(stockDate);
            clothing.setPrice(price);
            clothing.setShop(shop);
            DBHelper.saveOrUpdate(clothing);
            res.redirect("/clothing-products");
            return null;
        }, new VelocityTemplateEngine());

    }
}
