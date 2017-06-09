package utils;
import java.io.FileNotFoundException;
public class CalculationA1 {
    public static double calcA1(Double[][] array) throws FileNotFoundException {
        //Нахождение максимального индекса
        int max_index = (int) Maximum.max(array);
        //Нахождение начала графика
        int start_index = (int) Start.start(array);
        //Вычисление площади треугольника
        double one = ((array[max_index][1])-array[start_index][1]);
        double two = (array[max_index][0]-array[start_index][0]);
        double A1 = (one*two*0.01)/2;
        return A1;
    }
}


