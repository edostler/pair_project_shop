package controllers;

import db.DBHelper;
import models.CurrentPurchase;
import models.Customer;
import models.PreviousPurchase;
import models.Product;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static spark.Spark.get;
import static spark.Spark.post;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

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
//            Set<Product> contents = basket.getContents();
            model.put("user", loggedInUser);
            model.put("basket", basket);
//            model.put("contents", contents);
            model.put("template", "templates/basket/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }

}
