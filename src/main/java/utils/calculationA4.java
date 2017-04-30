package utils;

import java.io.FileNotFoundException;

/**
 * Created by Lantiets on 01.04.2017.
 */
public class calculationA4 {
    public static double calcA4(Double[][] array) throws FileNotFoundException {
        //Находим максимальный индекс
        int max_index = (int) maximum.max(array);
        //Находим нулевой индекс
        double null_index = array[0][1];
        //производим расчет и умножаем на эмпирический коэффициент
        double A4 = null_index*array[max_index][0]*0.001;
        return A4;
    }
}
