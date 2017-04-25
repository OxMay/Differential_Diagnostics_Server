package utils;

import java.io.FileNotFoundException;

/**
 * Created by Lantiets on 31.03.2017.
 */
public class calculationA1 {
    public static double calcA1(Double[][] array) throws FileNotFoundException {
        int max_index = (int) maximum.max(array);
        int start_index = (int) start.start(array);
        double one = (((3*array[max_index][1])-3*array[start_index][1])/2);
        double two = (array[max_index][0]-array[start_index][0]);
        double A1 = Math.ceil((one*two*0.01)/2);
        return A1;
    }


}
