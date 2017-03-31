package utils;

import java.io.FileNotFoundException;

/**
 * Created by Lantiets on 31.03.2017.
 */
public class maximum {
        public static double max(Double [][] array) throws FileNotFoundException {
            double max = array[0][0];
            int max_index = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i][1] > max) {
                    max = array[i][1];
                    max_index = i;
                }

            }
            return max_index;
        }

}
