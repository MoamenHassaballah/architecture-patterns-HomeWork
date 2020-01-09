package com.alyndroid.architecturepatternstutorialshomework.ui;

public class NumberPresenter {
    NumberView numberView;

    public NumberPresenter(NumberView numberView) {
        this.numberView = numberView;
    }

    private DataBase getNumbersFromDB(){
        return new DataBase();
    }

    public void devideNumbers(){
        int num = getNumbersFromDB().getNumbers().getFirstNum() / getNumbersFromDB().getNumbers().getSecondNum();
        numberView.onDevision(num);
    }
}
