package ru.billing.stocklist;

public class WorkArray <T extends Number> {
    T[] arrNums;

    public WorkArray(T[] arrNums) {
        this.arrNums = arrNums;
    }

    public double sum(){
        double doubleWork = 0.0;
        for (T number :
                arrNums) {
            doubleWork += number.doubleValue();
        }
        return doubleWork;
    }
}
