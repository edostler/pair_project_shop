package controllers;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class HomepageController {

    public HomepageController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        get("/home", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            model.put("user", loggedInUser);
            model.put("template", "templates/homepage/homepage.vtl");
            if(loggedInUser.equals("admin")){
                return new ModelAndView(model, "templates/adminLayout.vtl");
            }
            else{
                return new ModelAndView(model, "templates/layout.vtl");
            }
        }, new VelocityTemplateEngine());


        get ("/welcome", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "templates/homepage/welcome.vtl");
        }, new VelocityTemplateEngine());

    }

}
