package utils;

import java.util.ArrayList;

/**
 * Created by Lantiets on 11.04.2017.
 */
public class CalculationMethodBaies {
    public static ArrayList <Double> procent(ArrayList<Double> border, double as1,double as2,double as3, double as4,Double [][] mas){
        double t =0;
        double t1 = 0;
        ArrayList<Double> comparisonOfVariables = new ArrayList<>();
        if(as1>border.get(0)){
            t=mas[1][0];
            t1=mas[0][0];
        }else{
            t=mas[1][1];
            t1=mas[0][1];

        }

        if (as2>border.get(1)){
            t=t*mas[1][2];
            t1=t1*mas[0][2];
        }else {
            t=t*mas[1][3];
            t1=t1*mas[0][3];
        }
        if (as3>border.get(2)){
            t=t*mas[1][4];
            t1=t1*mas[0][4];
        }else {
            t=t*mas[1][5];
            t1=t1*mas[0][5];
        }
        if (as4>border.get(3)){
            t=t*mas[1][6];
            t1=t1*mas[0][6];
        }else {
            t=t*mas[1][7];
            t1=t1*mas[0][7];
        }
        comparisonOfVariables.add(0,t);
        comparisonOfVariables.add(1,t1);
        return comparisonOfVariables;

    }
}
