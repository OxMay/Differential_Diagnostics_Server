package utils;

import dao.Factory;
import model.TrueCyst;
import model.falseCyst;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lantiets on 06.04.2017.
 */
public class modelA1 {
    public static Double[][] modelA1(){
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
        //Полчение работы по таблице с ложными кистами
        ArrayList<Double> list = new ArrayList<Double>();
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

        list.add(0, (double) countA1if/size1);
        list.add(1, (double) countA1else/size1);
        list.add(2, (double) countA2if/size1);
        list.add(3, (double) countA2else/size1);
        list.add(4, (double) countA3if/size1);
        list.add(5, (double) countA3else/size1);
        list.add(6, (double) countA4if/size1);
        list.add(7, (double) countA4else/size1);
        list.add(8, (double) size1/size);
        //Получение работы по таблице с истинными кистами
        ArrayList<Double> list1 = new ArrayList<Double>();
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
        list1.add(0, (double) scoreA1if/size2);
        list1.add(1, (double) scoreA1else/size2);
        list1.add(2, (double) scoreA2if/size2);
        list1.add(3, (double) scoreA2else/size2);
        list1.add(4, (double) scoreA3if/size2);
        list1.add(5, (double) scoreA3else/size2);
        list1.add(6, (double) scoreA4if/size2);
        list1.add(7, (double) scoreA4else/size2);
        list1.add(8,(double) size2/size);
        //Расчет апостериорных вероятностей
        Double [][] aposterior = new Double[2][9];
        for (int i =0; i < 8; i++){
            aposterior [0][i] = (list.get(i)*list.get(8))/(list.get(i)*list.get(8)+list1.get(i)*list1.get(8));
            aposterior[1][i] = (list1.get(i)*list1.get(8))/(list1.get(i)*list1.get(8)+list.get(i)*list.get(8));
        }
        aposterior[0][8] = list.get(8);
        aposterior[1][8] = list1.get(8);

        return aposterior;
    }
}
