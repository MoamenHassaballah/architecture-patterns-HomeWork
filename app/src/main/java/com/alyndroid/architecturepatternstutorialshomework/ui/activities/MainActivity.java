package com.alyndroid.architecturepatternstutorialshomework.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.ui.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.ui.NumberPresenter;
import com.alyndroid.architecturepatternstutorialshomework.ui.NumberView;
import com.alyndroid.architecturepatternstutorialshomework.ui.NumberViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        NumberView {

    ActivityMainBinding binding;
    NumberPresenter numberPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.plusButton.setOnClickListener(this);
        binding.divButton.setOnClickListener(this);
        numberPresenter = new NumberPresenter(this);
        binding.setNumberPresenter(numberPresenter);
        binding.setViewModel(ViewModelProviders.of(this).get(NumberViewModel.class));
        binding.setLifecycleOwner(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.plus_button:
                plusFunction();
                break;
        }
    }

    private void plusFunction(){
        int num = new DataBase().getNumbers().getFirstNum() + new DataBase().getNumbers().getSecondNum();
        binding.plusResultTextView.setText(""+num);
    }

    @Override
    public void onDevision(int num) {
        binding.divResultTextView.setText(""+num);
    }
}
