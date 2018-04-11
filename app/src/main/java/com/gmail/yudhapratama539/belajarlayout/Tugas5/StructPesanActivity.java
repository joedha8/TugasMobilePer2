package com.gmail.yudhapratama539.belajarlayout.Tugas5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gmail.yudhapratama539.belajarlayout.R;

public class StructPesanActivity extends AppCompatActivity {
    private TextView textViewTotal;
    private TextView textViewQTY;
    private TextView textViewHarga;
    private TextView textViewTopping;
    private TextView textViewSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_struct_pesan);

        textViewTotal=findViewById(R.id.tv_total);
        textViewQTY=findViewById(R.id.tv_qty);
        textViewHarga=findViewById(R.id.tv_harga_pizza);
        textViewTopping=findViewById(R.id.tv_topping);
        textViewSize=findViewById(R.id.tv_size);

        textViewTotal.setText("Rp. "+getIntent().getStringExtra("Harga"));
        textViewQTY.setText("x "+getIntent().getStringExtra("qty"));
        textViewHarga.setText("Rp. "+getIntent().getStringExtra("Harga"));
        textViewTopping.setText(getIntent().getStringExtra("topping"));
        textViewSize.setText(getIntent().getStringExtra("size"));
    }
}
