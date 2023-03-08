package com.example.kosmobank;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SavingsItemDetail extends AppCompatActivity {

        String name;
        String i_num;
        String i_name;
        String i_rate;
        String i_type;
        String i_notice;
        String i_date;
        String i_min_date;
        String i_max_date;
        String i_auto_date;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_savings_detail);
                //detail layout에서 출력되는값들을 선언하는곳
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
                txt_num.setText("적금 번호 : " + i_num);

                TextView txt_name = findViewById(R.id.i_name);
                txt_name.setText("적금명 : " + i_name);

                TextView txt_rate = findViewById(R.id.i_rate);
                txt_rate.setText("적금금리 : " + i_rate);

                TextView txt_type = findViewById(R.id.i_type);

                String savingsType = "";
                if(R.id.i_type == 0) {
                        savingsType = "단리";
                } else {
                        savingsType = "복리";
                }
                txt_type.setText("적금 종류 : " + savingsType);

                TextView txt_notice = findViewById(R.id.i_notice);
                txt_notice.setText("상품 내용 : " + i_notice);



        }
}
