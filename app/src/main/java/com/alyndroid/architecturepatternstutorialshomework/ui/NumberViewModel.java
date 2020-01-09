package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumberViewModel extends ViewModel {
    public MutableLiveData<String> multiplyNumberMutable = new MutableLiveData<>();

    private DataBase getNumbersFromDB(){
        return new DataBase();
    }

    public void multiplyNumbers(){
        int num = getNumbersFromDB().getNumbers().getFirstNum() * getNumbersFromDB().getNumbers().getSecondNum();
        multiplyNumberMutable.setValue(num+"");
    }
}
