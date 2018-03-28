package controllers;

import db.Seeds;
import spark.ModelAndView;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) {

//        port(getHerokuAssignedPort());

        Seeds.seedData();

        staticFileLocation("/public");

        LoginController loginController = new LoginController();
        HomepageController homepageController = new HomepageController();
        AccountpageController accountpageController = new AccountpageController();
        BasketController basketController = new BasketController();
        CustomersController customersController = new CustomersController();
        PreviousPurchasesController previousPurchasesController = new PreviousPurchasesController();
        ProductsController productsController = new ProductsController();
        FoodProductsController foodProductsController = new FoodProductsController();
        ClothingProductsController clothingProductsController = new ClothingProductsController();
        HealthProductsController healthProductsController = new HealthProductsController();

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            model.put("template","templates/main.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        Spark.exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });
    }

//    static int getHerokuAssignedPort() {
//        ProcessBuilder processBuilder = new ProcessBuilder();
//        if (processBuilder.environment().get("PORT") != null) {
//            return Integer.parseInt(processBuilder.environment().get("PORT"));
//        }
//        return 4567;
//    }

}
