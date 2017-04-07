import controller.mobile.MobileRoutes;
import controller.site.SiteRoutes;
import controller.site.admin.AdministrationRoutes;
import dao.Factory;
import model.TrueCyst;
import model.falseCyst;

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
        for (falseCyst falsec: falseCystList){
            sumA1 += falsec.getA1();
            sumA2 += falsec.getA2();
            sumA3 += falsec.getA3();
            sumA4 += falsec.getA4();
        }
        List<TrueCyst> trueCystList = Factory.getInstance().getGenericRepositoryInterface(TrueCyst.class).getAllObjects();
        double sumA1t = 0;
        double sumA2t = 0;
        double sumA3t = 0;
        double sumA4t = 0;
        for (TrueCyst trueC: trueCystList){
            sumA1 += trueC.getA1();
            sumA2 += trueC.getA2();
            sumA3 += trueC.getA3();
            sumA4 += trueC.getA4();
        }
        int size1=falseCystList.size();
        int size2=trueCystList.size();

        int size = size1+size2;
        double border1 = (sumA1 + sumA1t)/size;
        double border2 = (sumA2 + sumA2t)/size;
        double border3 = (sumA3 + sumA3t)/size;
        double border4 = (sumA4 + sumA4t)/size;
        System.out.println(border4);
        //Полчение работы по таблице с ложными кистами
        ArrayList<Integer> list = new ArrayList<Integer>();
        int countA1if = 0;
        int countA1else = 0;
        int countA2if = 0;
        int countA2else =0;
        int countA3if = 0;
        int countA3else = 0;
        int countA4if = 0;
        int countA4else = 0;
        for (falseCyst workF: falseCystList){
            if(workF.getA1() > border1){
                countA1if++;
            }else{
                countA1else++;
            }
            if (workF.getA2() > border2){
                countA2if++;
            }else{
                countA2else++;
            }
            if (workF.getA3()>border3){
                countA3if++;
            }else{
                countA3else++;
            }
            if (workF.getA4()>border4){
                countA4if++;
            }else{
                countA4else++;
            }
        }

        list.add(0, countA1if);
        list.add(1, countA1else);
        list.add(2, countA2if);
        list.add(3, countA2else);
        list.add(4, countA3if);
        list.add(5, countA3else);
        list.add(6, countA4if);
        list.add(7, countA4else);
        //Получение работы по таблице с истинными кистами
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        int scoreA1if = 0;
        int scoreA1else = 0;
        int scoreA2if = 0;
        int scoreA2else = 0;
        int scoreA3if = 0;
        int scoreA3else = 0;
        int scoreA4if = 0;
        int scoreA4else = 0;
        for (TrueCyst workT: trueCystList){
            if(workT.getA1()>border1){
                scoreA1if++;
            }else{
                scoreA1else++;
            }
            if (workT.getA2()>border2){
                scoreA2if++;
            }else{
                scoreA2else++;
            }
            if (workT.getA3()>border3){
                scoreA3if++;
            }else{
                scoreA3else++;
            }
            if (workT.getA4()>border4){
                scoreA4if++;
            }else{
                scoreA4else++;
            }

        }
        list1.add(0,scoreA1if);
        list1.add(1,scoreA1else);
        list1.add(2,scoreA2if);
        list1.add(3,scoreA2else);
        list1.add(4,scoreA3if);
        list1.add(5,scoreA3else);
        list1.add(6,scoreA4if);
        list1.add(7,scoreA4else);
//        for(Integer f:list){
//            System.out.println(f);
//        }
        float k = 1/5f;
        System.out.println(k);
        new MobileRoutes();
        new SiteRoutes();
        new AdministrationRoutes();
    }
}
