package controller.site;

import controller.BaseRoutes;
import controller.site.api.UsersApi;
import spark.ModelAndView;
import utils.template.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.logging.Logger;

import static java.lang.String.valueOf;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.post;


public class SiteRoutes extends BaseRoutes {
    private static Logger log = Logger.getLogger(SiteRoutes.class.getName());

    private final String ROOT = "/";

    private void initRoutes(){
        new UsersApi();
    }

    @Override
    public void routes() {
        initRoutes();

//

        get(ROOT+"authorization", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "/public/authorization.html");
        }, new VelocityTemplateEngine());


    }
}
