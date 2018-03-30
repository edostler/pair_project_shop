package controllers;

import db.DBHelper;
import models.Customer;
import models.PreviousPurchase;
import models.Shop;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class AccountpageController {

    public AccountpageController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {
//
        get("/account/edit", (req, res) -> {
//            TEST
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            Customer customer = DBHelper.findCustomerByUsername(loggedInUser);
            List<Shop> shops = DBHelper.getAll(Shop.class);
//            Shop shop = customer.getShop();
            model.put("customer", customer);
            model.put("user", loggedInUser);
            model.put("shops", shops);
            model.put("template", "templates/accountpage/customer_edit.vtl");

            if (loggedInUser.equals("admin")) {
                model.put("template","templates/accountpage/admin_edit.vtl");
            }
            else {
                model.put("template","templates/accountpage/customer_edit.vtl");
            }
            if(loggedInUser.equals("admin")){
                return new ModelAndView(model, "templates/adminLayout.vtl");
            }
            else{
                return new ModelAndView(model, "templates/layout.vtl");
            }
        }, new VelocityTemplateEngine());


        get("/account/previous-purchases", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            Customer customer = DBHelper.findCustomerByUsername(loggedInUser);
            List<Shop> shops = DBHelper.getAll(Shop.class);
            List<PreviousPurchase> previousPurchases = DBHelper.getAll(PreviousPurchase.class);
            List<PreviousPurchase> customerPreviousPurchases = DBHelper.getAllPreviousPurchasesForCustomer(customer);

            model.put("customer", customer);
            model.put("user", loggedInUser);
            model.put("shops", shops);
            model.put("previousPurchases", previousPurchases);
            model.put("customerPreviousPurchases", customerPreviousPurchases);

            if (loggedInUser.equals("admin")) {
                model.put("template","templates/previousPurchases/index.vtl");
            }
            else {
                model.put("template","templates/accountpage/customer_previousOrders.vtl");
            }
            if(loggedInUser.equals("admin")){
                return new ModelAndView(model, "templates/adminLayout.vtl");
            }
            else{
                return new ModelAndView(model, "templates/layout.vtl");
            }
        }, new VelocityTemplateEngine());



        get("/account", (req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            Customer customer = DBHelper.findCustomerByUsername(loggedInUser);
            model.put("user", loggedInUser);
            model.put("customer", customer);
            model.put("template", "templates/accountPage/customer_account.vtl");

            if (loggedInUser.equals("admin")) {
                model.put("template","templates/accountpage/admin_account.vtl");
            }
            else {
                model.put("template","templates/accountpage/customer_account.vtl");
            }
            if(loggedInUser.equals("admin")){
                return new ModelAndView(model, "templates/adminLayout.vtl");
            }
            else{
                return new ModelAndView(model, "templates/layout.vtl");
            }

        }, new VelocityTemplateEngine());

        post("/account", (req, res) ->{
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            Customer customer = DBHelper.findCustomerByUsername(loggedInUser);
            String name = req.queryParams("name");
            String username = loggedInUser;
            Shop shop = DBHelper.findShopByName("PPS Groceries");

            int distance = Integer.parseInt(req.queryParams("distance"));

            customer.setName(name);
            customer.setDistance(distance);
            customer.setShop(shop);
            DBHelper.saveOrUpdate(customer);
            res.redirect("/account");
            return null;
        }, new VelocityTemplateEngine());

    }
}
