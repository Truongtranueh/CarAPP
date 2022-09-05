package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemChangeListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.carapp.R;
import com.example.carapp.databinding.ActivityIntroduceBinding;

import java.util.ArrayList;
import java.util.List;

public class IntroduceActivity extends AppCompatActivity {

    private ActivityIntroduceBinding binding;
    List<SlideModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroduceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        list = new ArrayList<>();
        list.add(new SlideModel(R.drawable.slide1, ScaleTypes.FIT));
        list.add(new SlideModel(R.drawable.slide2, ScaleTypes.FIT));
        list.add(new SlideModel(R.drawable.slide3, ScaleTypes.FIT));
        list.add(new SlideModel(R.drawable.slide4, ScaleTypes.FIT));
        binding.imgslider.setImageList(list);
        binding.imgslider.startSliding(2000);
        binding.imgslider.setItemChangeListener(new ItemChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onItemChanged(int i) {
                switch (i){
                    case 0:
                        binding.tvtitle.setText("CAR SHARING");
                        binding.tvtitle.setTextColor(getResources().getColor(R.color.yellow));
                        binding.tvslider.setText("One");
                        binding.btnslider.setBackgroundColor(getResources().getColor(R.color.yellow));
                        break;
                    case 1:
                        binding.tvtitle.setText("FIND CARS");
                        binding.tvtitle.setTextColor(getResources().getColor(R.color.red));
                        binding.tvslider.setText("Two");
                        binding.btnslider.setBackgroundColor(getResources().getColor(R.color.red));
                        break;
                    case 2:
                        binding.tvtitle.setText("DRIVE NOW");
                        binding.tvtitle.setTextColor(getResources().getColor(R.color.green));
                        binding.tvslider.setText("Three");
                        binding.btnslider.setBackgroundColor(getResources().getColor(R.color.green));
                        break;
                    case 3:
                        binding.tvtitle.setText("TAXI SERVICE");
                        binding.tvtitle.setTextColor(getResources().getColor(R.color.blue));
                        binding.tvslider.setText("Four");
                        binding.btnslider.setBackgroundColor(getResources().getColor(R.color.blue));
                        break;

                }
            }
        });
        binding.btnslider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IntroduceActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}