package controller.site.admin.api;
import controller.BaseRoutes;
import repository.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FalseCyst;
import static spark.Spark.*;
public class FalseCystApi extends BaseRoutes {
    private static Logger log = Logger.getLogger(TrueCystApi.class.getName());
    private final String ROOT = "/admin/api/";
    @Override
    public void routes() {
        post(ROOT + "pacientfalse.delete", (request, response) -> {
            try{
                response.redirect(ROOT.substring(0,7) + "falseCystList");
                return Factory.getInstance().getGenericRepositoryInterface().removeObject(
                        Factory.getInstance().getGenericRepositoryInterface(FalseCyst.class).getObject("usersId",request.queryParams("users_Id")));
            }catch (Exception e){
                log.log(Level.SEVERE, "Exception: ", e);
                return e;
            }
        });
    }
}

