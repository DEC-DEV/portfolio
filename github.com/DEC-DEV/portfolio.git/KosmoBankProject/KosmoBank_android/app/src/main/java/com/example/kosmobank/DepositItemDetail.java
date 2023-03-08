package com.example.kosmobank;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DepositItemDetail extends AppCompatActivity {

        String name;
        String i_num;
        String i_name;
        String i_rate;
        String i_type;
        String i_notice;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_deposits_detail);

                Intent intent = getIntent();
                name = intent.getStringExtra("name");
                i_num = intent.getStringExtra("i_num");
                i_name = intent.getStringExtra("i_name");
                i_rate = intent.getStringExtra("i_rate");
                i_type = intent.getStringExtra("i_type");
                i_notice = intent.getStringExtra("i_notice");

                TextView txt_tv = findViewById(R.id.tv_name);
                txt_tv.setText(name + "님");

                TextView txt_num = findViewById(R.id.i_num);
                txt_num.setText("예금 번호 : " + i_num);

                TextView txt_name = findViewById(R.id.i_name);
                txt_name.setText("예금명 : " + i_name);

                TextView txt_rate = findViewById(R.id.i_rate);
                txt_rate.setText("예금금리 : " + i_rate);

                TextView txt_type = findViewById(R.id.i_type);

                String depositType = "";
                if(R.id.i_type == 0) {
                        depositType = "단리";
                } else {
                        depositType = "복리";
                }
                txt_type.setText("예금 종류 : " + depositType);

                TextView txt_notice = findViewById(R.id.i_notice);
                txt_notice.setText("상품 내용 : " + i_notice);

        }
}
