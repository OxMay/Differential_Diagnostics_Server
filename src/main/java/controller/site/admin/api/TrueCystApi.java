package controller.site.admin.api;

import controller.BaseRoutes;
import dao.Factory;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Lantiets on 12.05.2017.
 */



import model.TrueCyst;


import static spark.Spark.*;

public class TrueCystApi extends BaseRoutes {
    private static Logger log = Logger.getLogger(TrueCystApi.class.getName());

    private final String ROOT = "/admin/api/";

    @Override
    public void routes() {


        post(ROOT + "pacient.delete", (request, response) -> {
            try{
                response.redirect(ROOT.substring(0,7) + "trueCystList");
                return Factory.getInstance().getGenericRepositoryInterface().removeObject(
                        Factory.getInstance().getGenericRepositoryInterface(TrueCyst.class).getObject("pacient",request.queryParams("pacient_name")));
            }catch (Exception e){
                log.log(Level.SEVERE, "Exception: ", e);
                return e;
            }
        });
    }
}