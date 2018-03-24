package controllers;

import db.DBHelper;
import models.Clothing;
import models.Health;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class HealthProductsController {

    public HealthProductsController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {
        get("/health-products", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Health> healthProducts = DBHelper.getAll(Health.class);
            model.put("healthProducts", healthProducts);
            model.put("template", "templates/healthProducts/index.vtl");
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/health-products/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Clothing healthProduct = DBHelper.find(Health.class, intId);

            Map<String, Object> model = new HashMap<>();

            model.put("healthProduct", healthProduct);
            model.put("template", "templates/healthProducts/show.vtl");
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }

}
