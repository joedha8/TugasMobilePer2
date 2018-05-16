package com.gmail.yudhapratama539.belajarlayout.Tugas8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.gmail.yudhapratama539.belajarlayout.R;

public class ZoomRotateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_rotate);
        final SubsamplingScaleImageView imageView = findViewById(R.id.imageView);
        imageView.setImage(ImageSource.asset("swissroad.jpg"));
        imageView.setOrientation(90);
    }
}
