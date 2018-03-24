package controllers;

import db.DBHelper;
import models.Food;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class FoodProductsController {

    public FoodProductsController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {
        get("/food-products", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Food> foods = DBHelper.getAll(Food.class);
            model.put("foods", foods);
            model.put("template", "templates/foodProducts/index.vtl");
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
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
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
