package com.gmail.yudhapratama539.belajarlayout.Tugas2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gmail.yudhapratama539.belajarlayout.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText editTextNama=findViewById(R.id.edittextnama);
        final EditText editTextPassword=findViewById(R.id.edittextpassword);
        final EditText editTextNIM=findViewById(R.id.edittext_nim);

        Button buttonLogin=findViewById(R.id.buttonlogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTextNama.getText().toString().isEmpty() &&
                        !editTextPassword.getText().toString().isEmpty() &&
                        !editTextNIM.getText().toString().isEmpty()){
                    if (editTextPassword.getText().toString().equals("1234") && editTextNIM.getText().toString().equals("155410053")){
                        Intent intent=new Intent(LoginActivity.this, SelamatDatangActivity.class);
                        intent.putExtra("nama", editTextNama.getText().toString());
                        intent.putExtra("nim", editTextNIM.getText().toString());
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Password/NIM Tidak Cocok", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Field Ada Yang Kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
