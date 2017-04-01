package utils;

import java.io.FileNotFoundException;

/**
 * Created by Lantiets on 01.04.2017.
 */
public class calculationA3 {
    public static double calcA3(Double[][] array) throws FileNotFoundException {
        int start_index = (int) start.start(array);
        double null_index = array[0][1];
        double one = ((array[start_index][1] - null_index)*array[start_index][0])/2;
        double A3 = one*0.01;
        return A3;
    }
}
