import controller.mobile.MobileRoutes;
import controller.site.SiteRoutes;
import controller.site.admin.AdministrationRoutes;
import controller.mobile.api.users.UsersRoutes;
import dao.Factory;
import model.Users;
import model.tableWork;

import java.sql.SQLException;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

public class Application {
    public static void main(String[] args){

        staticFileLocation("/public");

        int port;
        port(5555);
//        port = Integer.parseInt(args[0]);
//        port(port);
            Factory.getInstance().getGenericRepositoryInterface().addObject(new tableWork("Антипова",7.025,11.845,6.942,0.589));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new tableWork("Корезина",5.342,9.327,5.457,2.165));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new tableWork("Нечаев",9.114,18.54,4.629,10.078));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new tableWork("Одиноков",1.25,0.727,0.543,3.542));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new tableWork("Смирнов1",8.864,2.129,0.409,8.427));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new tableWork("Смирнов2",4.113,8.34,8.37,4.532));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new tableWork("Субботина",3.269,4.56,3.426,4.367));
        //внутрипротоковые
        Factory.getInstance().getGenericRepositoryInterface().addObject(new tableWork("Пивцов",24.05,21.395,7.275,11.519));
        new MobileRoutes();
        new SiteRoutes();
        new AdministrationRoutes();
    }
}
