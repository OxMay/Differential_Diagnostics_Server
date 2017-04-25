
import controller.site.SiteRoutes;
import controller.site.admin.AdministrationRoutes;
import dao.Factory;
import model.TrueCyst;
import model.falseCyst;
import spark.Request;
import utils.modelA1;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

public class Application {
    public static void main(String[] args){

        staticFileLocation("/public");

        int port;
        port(5555);
//        port = Integer.parseInt(args[0]);
//        port(port);
        Factory.getInstance().getGenericRepositoryInterface().addObject(new falseCyst("Антипова",7.025,11.845,6.942,0.589));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new falseCyst("Корезина",5.342,9.327,5.457,2.165));
//
        Factory.getInstance().getGenericRepositoryInterface().addObject(new falseCyst("Одиноков",1.25,0.727,0.543,3.542));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new falseCyst("Смирнов2",4.113,8.34,8.37,4.532));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new falseCyst("Субботина",3.269,4.56,3.426,4.367));
        //внутрипротоковые
        Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Пивцов",24.05,21.395,7.275,11.519));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Нечаев",9.114,18.54,4.629,10.078));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Пациент2",15.05,16.395,9.275,8.519));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Пациент3",8.05,10.395,7.275,6.519));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Смирнов1",8.864,2.129,0.409,8.427));
//        Double [][] mas = modelA1.modelA1();
//        for (int i=0;i<2;i++){
//            for (int j=0;j<9;j++){
//                System.out.println(mas[i][j]);
//            }
//        }



        new SiteRoutes();
        new AdministrationRoutes();
    }
}
