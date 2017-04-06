package utils;

import dao.Factory;
import model.tableWork;

/**
 * Created by Lantiets on 06.04.2017.
 */
public class modelA1 {
    public static int [][] modelA1(){
        double bdA1=0;
        int [][] mas = new int[2][8];
        for (int i=1;i<=10;i++) {
            tableWork tableWork = tableWork.class.cast(Factory.getInstance().getGenericRepositoryInterface(tableWork.class).getObject("usersId", i));
            bdA1 = bdA1 + tableWork.getA4();
        }
        double bd1 = bdA1/10;
        int count1=0;
        int count2=0;
        for (int i=1;i<=10;i++) {
            tableWork tableWork = tableWork.class.cast(Factory.getInstance().getGenericRepositoryInterface(tableWork.class).getObject("usersId", i));
            double A1 = tableWork.getA1();
            if (A1>bd1){
                mas[0][0] = count1++;
            }else {

                mas[1][1] = count2++;
            }

        }
        // получение А2
        double bdA2=0;
        for (int i=1;i<=10;i++) {
            tableWork tableWork = tableWork.class.cast(Factory.getInstance().getGenericRepositoryInterface(tableWork.class).getObject("usersId", i));
            bdA2 = bdA2 + tableWork.getA4();
        }
        double bd2 = bdA2/10;
        int count3=0;
        int count4=0;
        for (int i=1;i<=10;i++) {
            tableWork tableWork = tableWork.class.cast(Factory.getInstance().getGenericRepositoryInterface(tableWork.class).getObject("usersId", i));
            double A2 = tableWork.getA2();
            if (A2>bd2){
                mas[0][2] = count3++;
            }else {

                mas[1][3] = count4++;
            }

        }
        //получени А3
        double bdA3=0;
        for (int i=1;i<=10;i++) {
            tableWork tableWork = tableWork.class.cast(Factory.getInstance().getGenericRepositoryInterface(tableWork.class).getObject("usersId", i));
            bdA3 = bdA3 + tableWork.getA4();
        }
        double bd3 = bdA3/10;
        int count5=0;
        int count6=0;
        for (int i=1;i<=10;i++) {
            tableWork tableWork = tableWork.class.cast(Factory.getInstance().getGenericRepositoryInterface(tableWork.class).getObject("usersId", i));
            double A3 = tableWork.getA3();
            if (A3>bd3){
                mas[0][4] = count5++;
            }else {

                mas[1][5] = count6++;
            }

        }
        //получение А4
        double bdA4=0;
        for (int i=1;i<=10;i++) {
            tableWork tableWork = tableWork.class.cast(Factory.getInstance().getGenericRepositoryInterface(tableWork.class).getObject("usersId", i));
            bdA4 = bdA4 + tableWork.getA4();
        }
        double bd4 = bdA4/10;
        int count7=0;
        int count8=0;
        for (int i=1;i<=10;i++) {
            tableWork tableWork = tableWork.class.cast(Factory.getInstance().getGenericRepositoryInterface(tableWork.class).getObject("usersId", i));
            double A4 = tableWork.getA4();
            if (A4>bd4){
                mas[0][6] = count7++;
            }else {

                mas[1][7] = count8++;
            }

        }

        return mas;
    }
}
