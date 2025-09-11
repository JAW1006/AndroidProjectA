package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // dataBinding 또는 viewBinding 사용
    private ActivityMainBinding binding;

    // Model instance
    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main);
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        model = new Model();    // 모델 객체 생성

        // add button에 이벤트 핸드러 등록
        binding.buttonAdd.setOnClickListener(v -> {

            model.add();
            binding.textViewCount.setText( Integer.toString(model.getCount()) );
            binding.textViewTotalPrice.setText( Integer.toString(model.getTotalPrice()) + "원" );
        });
        // subtract button에 이벤트 핸드러 등록
        binding.buttonSubtract.setOnClickListener(v -> {

            model.subtract();
            binding.textViewCount.setText( Integer.toString(model.getCount()) );
            binding.textViewTotalPrice.setText( Integer.toString(model.getTotalPrice()) + "원" );
        });

    }
}