package utils;
import repository.Factory;
import model.TrueCyst;
import model.falseCyst;

import java.util.ArrayList;
import java.util.List;
public class ModelA1 {
    public static Double[][] modelA1( ArrayList<Double> arrayList){
        //ПОЛУЧЕНИЕ ГРАНИЦ ДЛЯ ВСЕХ А
        List<falseCyst> falseCystList = Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getAllObjects();
        List<TrueCyst> trueCystList = Factory.getInstance().getGenericRepositoryInterface(TrueCyst.class).getAllObjects();
        //Получение количества пациентов
        int size1=falseCystList.size();
        int size2=trueCystList.size();
        int size = size1+size2;
        //Полчение работы по таблице с ложными кистами
        ArrayList<Double> list = new ArrayList<Double>();
        //инициализируем переменные
        int countA1if = 0;
        int countA1else = 0;
        int countA2if = 0;
        int countA2else =0;
        int countA3if = 0;
        int countA3else = 0;
        int countA4if = 0;
        int countA4else = 0;
        //Производим расчет количества пациентов для каждого признака
        for (falseCyst workF: falseCystList){
            if(workF.getA1() > arrayList.get(0)){
                countA1if++;
            }else{
                countA1else++;
            }
            if (workF.getA2() > arrayList.get(1)){
                countA2if++;
            }else{
                countA2else++;
            }
            if (workF.getA3()>arrayList.get(2)){
                countA3if++;
            }else{
                countA3else++;
            }
            if (workF.getA4()>arrayList.get(3)){
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
            if(workT.getA1()>arrayList.get(0)){
                scoreA1if++;
            }else{
                scoreA1else++;
            }
            if (workT.getA2()>arrayList.get(1)){
                scoreA2if++;
            }else{
                scoreA2else++;
            }
            if (workT.getA3()>arrayList.get(2)){
                scoreA3if++;
            }else{
                scoreA3else++;
            }
            if (workT.getA4()>arrayList.get(3)){
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
        //Создаем новый массив
        Double [][] aposterior = new Double[2][9];
        //Создаем цикл, которые идет по двум массивам
        for (int i =0; i < 8; i++){
            //Рассчитываем вероятности по первой строке
            aposterior [0][i] = (list.get(i)*list.get(8))/(list.get(i)*list.get(8)+list1.get(i)*list1.get(8));
            //Рассчитываем вероятности по второй строке
            aposterior[1][i] = (list1.get(i)*list1.get(8))/(list1.get(i)*list1.get(8)+list.get(i)*list.get(8));
        }
        //Записываем вероятности проявления заболевания в новый массив
        aposterior[0][8] = list.get(8);
        aposterior[1][8] = list1.get(8);

        return aposterior;
    }
}
