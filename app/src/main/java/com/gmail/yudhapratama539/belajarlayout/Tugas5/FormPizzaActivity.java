package com.gmail.yudhapratama539.belajarlayout.Tugas5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.gmail.yudhapratama539.belajarlayout.R;

public class FormPizzaActivity extends AppCompatActivity {
    private Button buttonSubmit;
    private Button buttonMinus;
    private Button buttonPlus;

    private EditText editTextQTY;

    private CheckBox checkBoxVegetable;
    private CheckBox checkBoxMeat;
    private CheckBox checkBoxEgg;

    private RadioButton radioButtonSmall;
    private RadioButton radioButtonMedium;
    private RadioButton radioButtonLarge;

    private int qty=1;
    private String topping="";
    private String size="";
    private int harga=50000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pizza);

        buttonSubmit=findViewById(R.id.btn_submit);
        buttonMinus=findViewById(R.id.btn_minus);
        buttonPlus=findViewById(R.id.btn_plus);

        editTextQTY=findViewById(R.id.et_qty);

        checkBoxVegetable=findViewById(R.id.cb_vegetable);
        checkBoxMeat=findViewById(R.id.cb_meat);
        checkBoxEgg=findViewById(R.id.cb_egg);

        radioButtonSmall=findViewById(R.id.rb_small);
        radioButtonMedium=findViewById(R.id.rb_medium);
        radioButtonLarge=findViewById(R.id.rb_large);

        editTextQTY.setText(""+qty);

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextQTY.getText().toString().equals("1")){
                    Toast.makeText(FormPizzaActivity.this, "Minimal Pembelian Adalah 1", Toast.LENGTH_SHORT).show();
                } else {
                    qty = qty - 1;
                    editTextQTY.setText(""+qty);
                }
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty = qty + 1;
                editTextQTY.setText(""+qty);
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!topping.equals("") && !size.equals("")){
                    Intent intent=new Intent(FormPizzaActivity.this, StructPesanActivity.class);
                    intent.putExtra("Harga", ""+harga*qty);
                    intent.putExtra("qty", ""+qty);
                    intent.putExtra("topping", topping);
                    intent.putExtra("size", size);
                    startActivity(intent);
                } else {
                    Toast.makeText(FormPizzaActivity.this, "Ada yang belum terpilih", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void getTopping(View view){
        if (checkBoxVegetable.isChecked() && !checkBoxMeat.isChecked() && !checkBoxEgg.isChecked()){
            topping="Vegetable";
        } else if (!checkBoxVegetable.isChecked() && checkBoxMeat.isChecked() && !checkBoxEgg.isChecked()){
            topping="Meat";
        } else if (!checkBoxVegetable.isChecked() && !checkBoxMeat.isChecked() && checkBoxEgg.isChecked()){
            topping="Egg";
        } else if (checkBoxVegetable.isChecked() && checkBoxMeat.isChecked() && !checkBoxEgg.isChecked()){
            topping="Vegetable and Meat";
            harga=harga+10000;
        } else if (checkBoxVegetable.isChecked() && !checkBoxMeat.isChecked() && checkBoxEgg.isChecked()){
            topping="Vegetable and Egg";
            harga=harga+10000;
        } else if (!checkBoxVegetable.isChecked() && checkBoxMeat.isChecked() && checkBoxEgg.isChecked()){
            topping="Meat and Egg";
            harga=harga+10000;
        } else if (checkBoxVegetable.isChecked() && checkBoxMeat.isChecked() && checkBoxEgg.isChecked()){
            topping="Vegetable, Meat and Egg";
            harga=harga+15000;
        } else {
            topping="";
        }
    }

    public void getSize(View view){
        if (radioButtonSmall.isChecked()){
            size="Small";
        } else if (radioButtonMedium.isChecked()){
            size="Medium";
            harga=harga+10000;
        } else if (radioButtonLarge.isChecked()){
            size="Large";
            harga=harga+20000;
        }
    }
}
