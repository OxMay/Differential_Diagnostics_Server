package utils;

import java.io.FileNotFoundException;

/**
 * Created by Lantiets on 31.03.2017.
 */
public class start {
    public static double start(Double [][] array) throws FileNotFoundException {
        double startGraphic = array[0][1];
        int start_index = 0;
        for (int i = 1; i < array.length; i++) {

                if (array[i][1]-startGraphic < 30 && array[i][1]-startGraphic != 0 ) {
                    startGraphic = array[i][1];

                }
                else if(array[i][1]-startGraphic != 0) {
                    startGraphic = array[i][1];
                    start_index=i;
            }

        }
//        double max_time = array[max_index][0];
        return start_index;
    }
}
