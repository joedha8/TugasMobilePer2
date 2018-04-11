package com.gmail.yudhapratama539.belajarlayout.Pertemuan5;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.gmail.yudhapratama539.belajarlayout.R;

public class Pertemuan5Activity extends AppCompatActivity {
    TextView textViewNama;
    CheckBox checkBoxBold;
    CheckBox checkBoxItalic;
    RadioButton radioButtonBlue;
    RadioButton radioButtonRed;
    RadioButton radioButtonGreen;
    RadioButton radioButtonYellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertemuan5);

        textViewNama=findViewById(R.id.tv_nama);
        checkBoxBold=findViewById(R.id.cb_bold);
        checkBoxItalic=findViewById(R.id.cb_italic);
        radioButtonBlue=findViewById(R.id.rb_blue);
        radioButtonRed=findViewById(R.id.rb_red);
        radioButtonGreen=findViewById(R.id.rb_green);
        radioButtonYellow=findViewById(R.id.rb_yellow);
    }

    public void saatCheckBoxDiklik(View view){
        boolean jikaDicentang = checkBoxBold.isChecked();
        boolean jikaItalic = checkBoxItalic.isChecked();
        if (jikaDicentang){
            textViewNama.setTypeface(Typeface.DEFAULT_BOLD);
            Log.d("Bold", "Bold gan");
        } else if (jikaItalic){
            textViewNama.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
            Log.d("Italic", "Italic gan");
        } else {
            textViewNama.setTypeface(Typeface.DEFAULT);
            Log.d("Normal", "Normal gan");
        }

        if (jikaDicentang && jikaItalic){
            textViewNama.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
            Log.d("BoldItalic", "Bold dan Italic gan");
        }
    }

    public void changeBackground(View view){
        if (radioButtonBlue.isChecked()){
            textViewNama.setBackgroundColor(Color.BLUE);
        } else if (radioButtonRed.isChecked()){
            textViewNama.setBackgroundColor(Color.RED);
        } else if (radioButtonGreen.isChecked()){
            textViewNama.setBackgroundColor(Color.GREEN);
        } else if (radioButtonYellow.isChecked()){
            textViewNama.setBackgroundColor(Color.YELLOW);
        }
    }
}
