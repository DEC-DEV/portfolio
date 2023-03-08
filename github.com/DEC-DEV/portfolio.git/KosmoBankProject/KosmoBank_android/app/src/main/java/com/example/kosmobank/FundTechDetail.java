package com.example.kosmobank;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FundTechDetail extends AppCompatActivity {

    /*InnerTask task = null;*/
    String id;
    String name;
    String f_num;
    String f_title;
    String f_start_date;
    String f_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_detail);

        Intent intent = getIntent(); //전달할 데이터를 받을 Intent
        //text 키값으로 데이터를 받는다. String을 받아야 하므로 getStringExtra()를 사용함
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        f_title = intent.getStringExtra("f_title");
        f_num = intent.getStringExtra("f_num");
        f_start_date = intent.getStringExtra("f_start_date");
        f_content = intent.getStringExtra("f_content");
        

        TextView text_tv = findViewById(R.id.tv_name);
        text_tv.setText(name + "님");

        TextView fund_num = findViewById(R.id.fund_num);
        fund_num.setText("펀드번호 : " + f_num);

        TextView fund_title = findViewById(R.id.fund_title);
        fund_title.setText("상품명 : " + f_title);

        TextView fund_start_date = findViewById(R.id.fund_start_date);
        fund_start_date.setText("시작일 : " + f_start_date);

        TextView fund_content = findViewById(R.id.fund_content);
        fund_content.setText("상품내용 : " + f_content);


    }
}
