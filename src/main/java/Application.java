
import controller.site.SiteRoutes;
import controller.site.admin.AdministrationRoutes;
import dao.Factory;
import model.TrueCyst;
import model.Users;
import model.falseCyst;

import java.sql.SQLException;
import java.util.List;


import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

public class Application {
    public static void main(String[] args) throws SQLException {

        staticFileLocation("/public");

        int port;
        port(5555);
//        port = Integer.parseInt(args[0]);
//        port(port);
        try {

            if(Factory.getInstance().getGenericRepositoryInterface(Users.class).getObject("login","admin")==null){
                Factory.getInstance().getUsersDAO().addUser(new Users("admin", "admin", "root"));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new falseCyst("Антипова", 4.68, 5.9, 6.94, 0.29));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new falseCyst("Корезина С.Н.", 3.56, 4.66, 5.45, 1.08));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new falseCyst("Одиноков", 0.83, 0.36, 0.54, 1.77));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new falseCyst("Смирнов С.А.", 2.74, 4.17, 8.37, 2.26));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new falseCyst("Субботина", 2.17, 2.28, 3.42, 2.18));
                //внутрипротоковые
                Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Пивцов", 16.03, 10.69, 4.62, 5.75));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Нечаев", 6.07, 9.27, 4.62, 5.03));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Кисляков С.В.", 6.05, 0.26, 0.066, 3.19));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Добин А.С.", 9.24, 0.35, 0.063, 4.57));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Смирнов1", 5.9, 1.06, 0.4, 4.2));
            }else{


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }






//        for (int i=0;i<2;i++){
//            for (int j=0;j<9;j++){
//                System.out.println(mas[i][j]);
//            }
//        }



        new SiteRoutes();
        new AdministrationRoutes();
    }
}
