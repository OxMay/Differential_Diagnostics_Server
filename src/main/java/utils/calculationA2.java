package utils;
import java.io.FileNotFoundException;
public class CalculationA2 {
    public static double calcA2(Double[][] array) throws FileNotFoundException {
        //Находим максимальную точку
        int max_index = (int) Maximum.max(array);
        //Находим точку начала графика
        int start_index = (int) Start.start(array);
        //Находим точку массива, соответствующую нулевому времени
        double null_index = array[0][1];
        //Производим расчет работы
        double one = (array[start_index][1]-null_index)*(array[max_index][0]-array[start_index][0]);
        //умножаем на эмпирический коэффициент
        double A2 = one*0.001;
        return A2;
    }
}


