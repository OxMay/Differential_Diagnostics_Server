package utils;

import dao.Factory;
import model.falseCyst;

/**
 * Created by Lantiets on 06.04.2017.
 */
public class modelA1 {
    public static int [][] modelA1(){
        double bdA1=0;
        int [][] mas = new int[2][8];
        for (int i=1;i<=10;i++) {
            falseCyst falseCyst = falseCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getObject("usersId", i));
            bdA1 = bdA1 + falseCyst.getA1();
        }
        double bd1 = bdA1/10;
        int count1=1;
        int count2=1;
        for (int i=1;i<=10;i++) {
            falseCyst falseCyst = falseCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getObject("usersId", i));
            double A1 = falseCyst.getA1();
            if (A1>bd1){
                mas[0][0] = count1++;
            }else {

                mas[0][1] = count2++;
            }

        }
        // получение А2
        double bdA2=0;
        for (int i=1;i<=10;i++) {
            falseCyst falseCyst = falseCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getObject("usersId", i));
            bdA2 = bdA2 + falseCyst.getA2();
        }
        double bd2 = bdA2/10;
//        System.out.println(bd2);
        int count3=1;
        int count4=1;
        for (int i=1;i<=10;i++) {
            falseCyst falseCyst = falseCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getObject("usersId", i));
            double A2 = falseCyst.getA2();
            if (A2>bd2){
                mas[0][2] = count3++;
            }else {

                mas[0][3] = count4++;
            }

        }
        //получени А3
        double bdA3=0;
        for (int i=1;i<=10;i++) {
            falseCyst falseCyst = falseCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getObject("usersId", i));
            bdA3 = bdA3 + falseCyst.getA3();
        }
        double bd3 = bdA3/10;
        int count5=1;
        int count6=1;
        for (int i=1;i<=10;i++) {
            falseCyst falseCyst = falseCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getObject("usersId", i));
            double A3 = falseCyst.getA3();
            if (A3>bd3){
                mas[0][4] = count5++;
            }else {

                mas[0][5] = count6++;
            }

        }
        //получение А4
        double bdA4=0;
        for (int i=1;i<=10;i++) {
            falseCyst falseCyst = falseCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getObject("usersId", i));
            bdA3 = bdA3 + falseCyst.getA3();
        }
        double bd4 = bdA4/10;
        int count7=1;
        int count8=1;
        for (int i=1;i<=10;i++) {
            falseCyst falseCyst = falseCyst.class.cast(Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getObject("usersId", i));
            double A4 = falseCyst.getA4();
            if (A4>bd4){
                mas[0][6] = count7++;
            }else {

                mas[0][7] = count8++;
            }

        }
        for(int i = 0; i<2;i++){
            for (int j=0;j<8;j++){
                System.out.println(mas[i][j]);
            }

        }

        return mas;
    }
}
