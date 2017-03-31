package utils;

import java.io.FileNotFoundException;

/**
 * Created by Lantiets on 30.03.2017.
 */
public class parseString {

    public static Double[][] read(String string) throws FileNotFoundException {
        String rep = string.replace(",",".");

        String[] db = rep.split("(   |\n)");

        int len = ((db.length)/3)-1;
        String [] mas= new String [db.length];
        int k=0;
        for(int i=3;i<mas.length;i++) {


            if (db[i].length() < 18) {
                mas[k] = db[i];
                k++;
            }

        }

        Double [][] mas2= new Double[len][2];
        int j=0;
        for(int i=0;i<len;i++){
            for(int l=0;l<2;l++){
                if(mas[i]!=null){
                    mas2[i][l] = Double.parseDouble(mas[j]);
                    j++;
                }

            }




        }



        return mas2;
    };


}
