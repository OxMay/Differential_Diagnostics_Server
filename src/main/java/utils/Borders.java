package utils;

import dao.Factory;
import model.TrueCyst;
import model.falseCyst;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lantiets on 10.04.2017.
 */
public class Borders {
    public static ArrayList<Double> borders(){
        //Изъятие всех объектов из таблицы falseCyst и запись их в массив
        List<falseCyst> falseCystList = Factory.getInstance().getGenericRepositoryInterface(falseCyst.class).getAllObjects();
        //инициализация новых переменных
        double sumA1 = 0;
        double sumA2 = 0;
        double sumA3 = 0;
        double sumA4 = 0;
        //Цикл, производящий суммацию всех показателей работ для  таблицы
        for (falseCyst falsec: falseCystList){
            sumA1 += falsec.getA1();
            sumA2 += falsec.getA2();
            sumA3 += falsec.getA3();
            sumA4 += falsec.getA4();
        }
        //Изъятие всех объектов из таблицы TrueCyst и запись их в массив
        List<TrueCyst> trueCystList = Factory.getInstance().getGenericRepositoryInterface(TrueCyst.class).getAllObjects();
        //инициализация новых переменных
        double sumA1t = 0;
        double sumA2t = 0;
        double sumA3t = 0;
        double sumA4t = 0;
        //Цикл, производящий суммацию всех показателей работ для  таблицы
        for (TrueCyst trueC: trueCystList){
            sumA1 += trueC.getA1();
            sumA2 += trueC.getA2();
            sumA3 += trueC.getA3();
            sumA4 += trueC.getA4();
        }
        //Расчет количества пациентов в двух таблицах базы данных
        int size1=falseCystList.size();
        int size2=trueCystList.size();
        int size = size1+size2;
        //Нахождение границ путем суммации всех показателей по каждой работе и делением на общее количество
        double border1 = (sumA1 + sumA1t)/size;
        double border2 = (sumA2 + sumA2t)/size;
        double border3 = (sumA3 + sumA3t)/size;
        double border4 = (sumA4 + sumA4t)/size;
        //Запись всех границ в новый массив
        ArrayList<Double> border = new ArrayList<>();
        border.add(border1);
        border.add(border2);
        border.add(border3);
        border.add(border4);
        return border;
    }
}
