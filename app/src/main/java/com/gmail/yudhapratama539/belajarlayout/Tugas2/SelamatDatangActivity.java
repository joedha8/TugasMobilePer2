package com.gmail.yudhapratama539.belajarlayout.Tugas2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.gmail.yudhapratama539.belajarlayout.R;

import java.util.Random;

public class SelamatDatangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selamat_datang);

        TextView textViewNama=findViewById(R.id.tv_nama);
        TextView textViewNumber=findViewById(R.id.tv_number);

        Random random=new Random();
        int nim=Integer.parseInt(getIntent().getStringExtra("nim"));
        int hasil=random.nextInt(nim)+1;

        textViewNama.setText(getIntent().getStringExtra("nama"));
        textViewNumber.setText(hasil+"");
    }
}
