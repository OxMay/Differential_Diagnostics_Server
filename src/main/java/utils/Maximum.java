package utils;
import java.io.FileNotFoundException;
public class Maximum {
    // Принимает файл двумерного массива
        public static double max(Double [][] array) throws FileNotFoundException {
            //Записываем первый элемент массива в переменную
            double max = array[0][0];
            //Создаем новую переменную и приравниваем ее к нулю
            int max_index = 0;
            //Создаем цикл, который сравнивает каждое числе с предыдущим
            for (int i = 0; i < array.length; i++) {
                if (array[i][1] > max) {
                    //если число больше предыдущего, перезаписываем переменную
                    max = array[i][1];
                    //считываем индекс массива, которому соответствует максимальное число
                    max_index = i;
                }
            }
            //Возвращаем индекс массива, которому соответствует максимальное число
            return max_index;
        }
}

