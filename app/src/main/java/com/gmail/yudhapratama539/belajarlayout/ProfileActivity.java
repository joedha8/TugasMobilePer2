package com.gmail.yudhapratama539.belajarlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button buttonBio=findViewById(R.id.btn_bio);
        Button buttonSekolah=findViewById(R.id.btn_sekolah);
        Button buttonOrganisasi=findViewById(R.id.btn_organisasi);

        buttonBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProfileActivity.this, BioActivity.class);
                startActivity(intent);
            }
        });

        buttonSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProfileActivity.this, SekolahActivity.class);
                startActivity(intent);
            }
        });

        buttonOrganisasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProfileActivity.this, OrganisasiActivity.class);
                startActivity(intent);
            }
        });
    }
}
