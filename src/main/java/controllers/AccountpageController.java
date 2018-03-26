package controllers;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class AccountpageController {

    public AccountpageController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        get("/account", (req, res) ->{

            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            model.put("template", "templates/accountPage/customer_account.vtl");

            if (loggedInUser.equals("admin")) {
                model.put("template","templates/accountpage/admin_account.vtl");
            }
            else {
                model.put("template","templates/accountpage/customer_account.vtl");
            }
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());
    }
}
