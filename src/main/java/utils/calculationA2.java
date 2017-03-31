package utils;

import java.io.FileNotFoundException;

/**
 * Created by Lantiets on 31.03.2017.
 */
public class calculationA2 {
    public static double calcA2(Double[][] array) throws FileNotFoundException {
        int max_index = (int) maximum.max(array);
        int start_index = (int) start.start(array);
        double null_index = array[0][1];
        double one = (array[start_index][1]-null_index)*(array[max_index][0]-array[start_index][0]);
        double A2 = one*0.001*2;
        return A2;
    }
}
