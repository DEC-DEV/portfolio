package com.example.kosmobank;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoansItemDetail extends AppCompatActivity {

    String name;

    String d_name;
    String d_interest_rate;
    String d_max_price;
    String d_prepayment_fee;
    String d_explanation1;
    String d_repay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loans_detail);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        d_name = intent.getStringExtra("d_name");
        d_interest_rate = intent.getStringExtra("d_interest_rate");
        d_max_price = intent.getStringExtra("d_max_price");
        d_prepayment_fee = intent.getStringExtra("d_prepayment_fee");
        d_explanation1 = intent.getStringExtra("d_explanation1");
        d_repay = intent.getStringExtra("d_repay");

        TextView txt_tv = findViewById(R.id.tv_name);
        txt_tv.setText(name + "님");

        TextView txt_name = findViewById(R.id.d_name);
        txt_name.setText("대출 상품명 : " + d_name);

        TextView txt_rate = findViewById(R.id.d_interest_rate);
        txt_rate.setText("대출금리 : " + d_interest_rate);

        TextView txt_max = findViewById(R.id.d_max_price);
        txt_max.setText("최대대출금액 : " + d_max_price);

        TextView txt_prepayment = findViewById(R.id.d_prepayment_fee);
        txt_prepayment.setText("중도상환수수료율 : " + d_prepayment_fee);

        TextView txt_exp = findViewById(R.id.d_explanation1);
        txt_exp.setText("대출상품설명 : " + d_explanation1);

        TextView txt_reapy = findViewById(R.id.d_repay);
        txt_reapy.setText("상환방식 : " + d_repay);


    }
}
