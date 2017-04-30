package utils;

import java.io.FileNotFoundException;

/**
 * Created by Lantiets on 31.03.2017.
 */
public class start {
    //Принятие двумерного массива
    public static double start(Double [][] array) throws FileNotFoundException {
        //Создаем переменную, в которую записываем число соответствующее первой строке второго столбца
        double startGraphic = array[0][1];
        //Создаем переменную и присваиваем значение 0
        int start_index = 0;
        //Создаем цикл прохождения по столбцу массива
        for (int i = 1; i < array.length; i++) {
            //Создаем условие, при котором интервал между числами должен быть меньше 30 и не равен 0
                if (array[i][1]-startGraphic < 30 && array[i][1]-startGraphic != 0 ) {
                    startGraphic = array[i][1];
                }
                else if(array[i][1]-startGraphic != 0) {
                    startGraphic = array[i][1];
                    start_index=i;
            }
        }
        return start_index;
    }
}
