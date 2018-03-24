package controllers;

import db.DBHelper;
import models.PreviousPurchase;
import models.Shop;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

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

//            List<Shop> shops = DBHelper.getAll(Shop.class);

            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);

//            model.put("shops", shops);

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
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            List<Shop> shops = DBHelper.getAll(Shop.class);
            model.put("shops", shops);
            model.put("template", "templates/previousPurchase/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/previous-purchases/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            PreviousPurchase previousPurchase = DBHelper.find(PreviousPurchase.class, id);

//            Manager manager = DBHelper.findManagerForDept(engineer.getDepartment());

            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            model.put("previousPurchase", previousPurchase);

//            model.put("manager", manager);

            model.put("template", "templates/previousPurchase/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post ("/previous-purchases", (req, res) -> {
            int shopId = Integer.parseInt(req.queryParams("shop"));
            Shop shop = DBHelper.find(Shop.class, shopId);

//            String firstName = req.queryParams("firstName");
//            String lastName = req.queryParams("lastName");
//            int salary = Integer.parseInt(req.queryParams("salary"));
//            PreviousPurchase previousPurchase = new PreviousPurchase(firstName, lastName, salary, shop);
//            DBHelper.saveOrUpdate(previousPurchase);

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

//            String firstName = req.queryParams("firstName");
//            String lastName = req.queryParams("lastName");
//            int salary = Integer.parseInt(req.queryParams("salary"));
//            engineer.setFirstName(firstName);
//            engineer.setLastName(lastName);
//            engineer.setSalary(salary);

            DBHelper.saveOrUpdate(previousPurchase);
            res.redirect("/previous-purchases");
            return null;
        }, new VelocityTemplateEngine());
    }

}
