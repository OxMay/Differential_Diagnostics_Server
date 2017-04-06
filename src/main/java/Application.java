import controller.mobile.MobileRoutes;
import controller.site.SiteRoutes;
import controller.site.admin.AdministrationRoutes;
import dao.Factory;
import model.TrueCyst;
import model.falseCyst;

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
//        Factory.getInstance().getGenericRepositoryInterface().addObject(new tableWork("Нечаев",9.114,18.54,4.629,10.078));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new falseCyst("Одиноков",1.25,0.727,0.543,3.542));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new falseCyst("Смирнов1",8.864,2.129,0.409,8.427));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new falseCyst("Субботина",3.269,4.56,3.426,4.367));
        //внутрипротоковые
        Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Пивцов",24.05,21.395,7.275,11.519));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Пациент1",10.05,15.395,8.275,7.519));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Пациент2",15.05,16.395,9.275,8.519));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Пациент3",8.05,10.395,7.275,6.519));
        Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst("Смирнов2",4.113,8.34,8.37,4.532));
        //ПОЛУЧЕНИЕ ГРАНИЦ ДЛЯ ВСЕХ А

        List<falseCyst> falseCystList = Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getAllObjects();

        double sumA1 = 0;
        double sumA2 = 0;
        double sumA3 = 0;
        double sumA4 = 0;
        //границы
        for (falseCyst falsec: falseCystList
             ) {

            sumA1 += falsec.getA1();
            sumA2 += falsec.getA2();
        }


        double bdT=0;
        double bdF = 0;
        int [][] mas = new int[2][8];
        for (int i=1;i<=5;i++) {
            falseCyst falseCyst = falseCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(falseCyst.class). getObject("usersId", i));
            bdF = bdF + falseCyst.getA1();
            TrueCyst trueCyst = TrueCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(TrueCyst.class).getObject("usersId", i));
            bdT = bdT + trueCyst.getA1();
        }
        double bdF1=0;
        double bdT1=0;
        for (int i=1;i<=5;i++) {
            falseCyst falseCyst = falseCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getObject("usersId", i));
            bdF1 = bdF1 + falseCyst.getA2();
            TrueCyst trueCyst = TrueCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(TrueCyst.class).getObject("usersId", i));
            bdT1 = bdT1 + trueCyst.getA2();
        }
        double bdF2=0;
        double bdT2 = 0;
        for (int i=1;i<=5;i++) {
            falseCyst falseCyst = falseCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getObject("usersId", i));
            bdF2 = bdF2 + falseCyst.getA3();
            TrueCyst trueCyst = TrueCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(TrueCyst.class).getObject("usersId", i));
            bdT2 = bdT2 + trueCyst.getA3();
        }
        double bdF3=0;
        double bdT3=0;
        for (int i=1;i<=5;i++) {
            falseCyst falseCyst = falseCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getObject("usersId", i));
            bdF3 = bdF3 + falseCyst.getA4();
            TrueCyst trueCyst = TrueCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(TrueCyst.class).getObject("usersId", i));
            bdT3 = bdT3 + trueCyst.getA4();
        }
        double bd1 = (bdF+bdT)/10;
        double bd2 = (bdF1+bdT1)/10;
        double bd3 = (bdF2+bdT2)/10;
        double bd4 = (bdF2+bdT2)/10;
        //ПОЛУЧЕНИЕ А1
        int count1=1;
        int count2=1;
        for (int i=1;i<=5;i++) {
            falseCyst falseCyst = falseCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getObject("usersId", i));
            double A1 = falseCyst.getA1();
            if (A1>bd1){
                mas[0][0] = count1++;
            }else {

                mas[0][1] = count2++;
            }

        }
        // ПОЛУЧЕНИЕ А2
        int count3=1;
        int count4=1;
        for (int i=1;i<=5;i++) {
            falseCyst falseCyst = falseCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getObject("usersId", i));
            double A2 = falseCyst.getA2();
            if (A2>bd2){
                mas[0][2] = count3++;
            }else {

                mas[0][3] = count4++;
            }

        }
        //ПОЛУЧЕНИЕ А3
        int count5=1;
        int count6=1;
        for (int i=1;i<=5;i++) {
            falseCyst falseCyst = falseCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getObject("usersId", i));
            double A3 = falseCyst.getA3();
            if (A3>bd3){
                mas[0][4] = count5++;
            }else {

                mas[0][5] = count6++;
            }

        }
        //ПОЛУЧЕНИЕ А4
        int count7=1;
        int count8=1;
        for (int i=1;i<=5;i++) {
            falseCyst falseCyst = falseCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getObject("usersId", i));
            double A4 = falseCyst.getA4();
            if (A4>bd4){
                mas[0][6] = count7++;
            }else {

                mas[0][7] = count8++;
            }

        }
        //ПОЛУЧЕНИЕ А1
        int count9=1;
        int count10=1;
        for (int i=1;i<=5;i++) {
            TrueCyst trueCyst = TrueCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(TrueCyst.class).getObject("usersId", i));
            double A1 = trueCyst.getA1();
            if (A1>bd1){
                mas[1][0] = count9++;
            }else {

                mas[1][1] = count10++;
            }

        }
        // ПОЛУЧЕНИЕ А2
        int count11=1;
        int count12=1;
        for (int i=1;i<=5;i++) {
            TrueCyst trueCyst = TrueCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(TrueCyst.class).getObject("usersId", i));
            double A2 = trueCyst.getA2();
            if (A2>bd2){
                mas[1][2] = count11++;
            }else {

                mas[1][3] = count12++;
            }

        }
        //ПОЛУЧЕНИЕ А3
        int count13=1;
        int count14=1;
        for (int i=1;i<=5;i++) {
            TrueCyst trueCyst = TrueCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(TrueCyst.class).getObject("usersId", i));
            double A3 = trueCyst.getA3();
            if (A3>bd3){
                mas[1][4] = count13++;
            }else {

                mas[1][5] = count14++;
            }

        }
        //ПОЛУЧЕНИЕ А4
        int count15=1;
        int count16=1;
        for (int i=1;i<=5;i++) {
            TrueCyst trueCyst = TrueCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(TrueCyst.class).getObject("usersId", i));
            double A4 = trueCyst.getA4();
            if (A4>bd4){
                mas[1][6] = count15++;
            }else {

                mas[1][7] = count16++;
            }

        }
        for(int i = 0; i<2;i++){
            for (int j=0;j<8;j++){
                System.out.println(mas[i][j]);
            }

        }
//        Factory.getInstance().getGenericRepositoryInterface(tableWork.class).
        new MobileRoutes();
        new SiteRoutes();
        new AdministrationRoutes();
    }
}
