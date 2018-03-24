package controllers;

import db.DBHelper;
import models.Clothing;
import models.Food;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class ClothingProductsController {

    private void setupEndPoints() {
        get("/clothing-products", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Clothing> clothingProducts = DBHelper.getAll(Clothing.class);
            model.put("clothingProducts", clothingProducts);
            model.put("template", "templates/clothingProducts/index.vtl");
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/clothing-products/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Clothing clothingProducts = DBHelper.find(Clothing.class, intId);

            Map<String, Object> model = new HashMap<>();

            model.put("clothingProducts", clothingProducts);
            model.put("template", "templates/clothingProducts/show.vtl");
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
