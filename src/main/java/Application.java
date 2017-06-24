
import controller.site.SiteRoutes;
import controller.site.admin.AdministrationRoutes;
import model.FalseCyst;
import repository.Factory;
import model.TrueCyst;
import model.Users;

import java.sql.SQLException;


import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

public class Application {
    public static void main(String[] args) throws SQLException {

        staticFileLocation("/public");

        int port;
//        port(5555);
        port = Integer.parseInt(args[0]);
        port(port);
        try {

            if(Factory.getInstance().getGenericRepositoryInterface(Users.class).getObject("login","admin")==null){
                Factory.getInstance().getUsersDAO().addUser(new Users("admin", "admin", "root"));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new FalseCyst( "Антипова", 4.68, 5.92, 6.9, 0.29));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new FalseCyst("Корезина", 3.56, 4.66, 5.4, 1.08));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new FalseCyst("Одиноков", 0.83, 2.98, 4.47, 0.52));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new FalseCyst("Смирнов", 2.74, 4.17, 8.37, 2.26));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new FalseCyst("Субботина", 2.17, 2.28, 3.42, 2.18));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new FalseCyst("Волков", 2.63, 4.86, 5.95, 1.46));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new FalseCyst("Малышев", 2.07, 4.45, 6.78, 1.75));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new FalseCyst("Барашкин", 1.93, 5.16, 6.15, 1.14));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new FalseCyst("Крылов", 2.98, 3.92, 5.11, 0.81));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new FalseCyst("Викторов", 3.21, 3.44, 7.91, 1.23));
                //внутрипротоковые
                Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Пивцов", 6.44, 0.68, 0.24, 5.75));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Нечаев", 6.07, 0.56, 0.21, 5.03));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Кисляков", 6.05, 0.26, 0.18, 3.19));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Добин", 6.32, 0.35, 0.083, 4.57));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Смирнов", 5.9, 1.06, 0.07, 4.2));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Логина", 6.02, 0.44, 0.09, 4.26));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Калугин", 6.11, 0.82, 0.13, 4.78));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Морозова", 6.22, 0.77, 0.13, 5.18));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Кузнецов", 6.01, 0.39, 0.17, 5.27));
                Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Борисов", 5.94, 0.71, 0.15, 4.91));
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
