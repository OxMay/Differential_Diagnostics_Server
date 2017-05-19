package controller.site.admin.api;

import controller.BaseRoutes;
import dao.Factory;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Lantiets on 12.05.2017.
 */


import controller.BaseRoutes;
import dao.Factory;
import model.TrueCyst;
import model.falseCyst;
import spark.ModelAndView;
import utils.template.VelocityTemplateEngine;


import java.util.logging.Level;
import java.util.logging.Logger;

import static spark.Spark.*;

public class TrueCystApi extends BaseRoutes {
    private static Logger log = Logger.getLogger(TrueCystApi.class.getName());

    private final String ROOT = "/admin/api/";

    @Override
    public void routes() {
        get(ROOT + "getfile", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<falseCyst> falseCystList = Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getAllObjects();

            model.put("get", "Файл загружен");
            return new ModelAndView(model, "/public/admin/trueCystList.html");
        }, new VelocityTemplateEngine());
    }
};