package model.site;

import java.util.ArrayList;

public class Query {
    private ArrayList<Double> date;
    private ArrayList<Double> close;

    public Query(ArrayList<Double> date, ArrayList<Double> close) {
        this.date = date;
        this.close = close;
    }

    public ArrayList<Double> getDate() {
        return date;
    }

    public void setDate(ArrayList<Double> date) {
        this.date = date;
    }

    public ArrayList<Double> getClose() {
        return close;
    }

    public void setClose(ArrayList<Double> close) {
        this.close = close;
    }
}
