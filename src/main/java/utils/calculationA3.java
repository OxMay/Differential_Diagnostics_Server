package utils;

import java.io.FileNotFoundException;

/**
 * Created by Lantiets on 01.04.2017.
 */
public class CalculationA3 {
    public static double calcA3(Double[][] array) throws FileNotFoundException {
        //Нахождение точки начала графика
        int start_index = (int) Start.start(array);
        //Нахождение нулевого индекса массива
        double null_index = array[0][1];
        //Расчет работы А3
        double one = (array[start_index][1] - null_index) *array[start_index][0]/2;
        //Умножение на эмпирический коэффициент
        double A3 = one*0.01;
        return A3;
    }
}
