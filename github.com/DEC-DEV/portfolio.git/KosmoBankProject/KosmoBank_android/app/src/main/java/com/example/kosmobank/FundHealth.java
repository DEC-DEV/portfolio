package com.example.kosmobank;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;


public class FundHealth extends AppCompatActivity  {

    String id;
    String title;
    String date;
    String content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        Intent intent = getIntent(); //전달할 데이터를 받을 Intent
        //text 키값으로 데이터를 받는다. String을 받아야 하므로 getStringExtra()를 사용함
        String name = intent.getStringExtra("customer_name");
        id = intent.getStringExtra("customer_id");


        TextView text_tv = findViewById(R.id.tv_name);
        text_tv.setText(name + "님");
    }

    // 이미지 클릭 > 상세페이지
    public void health_image_onClick(View view) {
        Intent intent = new Intent(this, FundHealthDetail.class);


        startActivity(intent);
    }

//    private class InnerTask extends AsyncTask {
//
//        //MypageRecyAdapter adapter;
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected Object doInBackground(Object[] objects) {
//            HttpClient.Builder http = new HttpClient.Builder("POST", com.example.kosmobank.Web.servletURL + "androidFundhealth"); //@RequestMapping url
//            http.addOrReplace("f_num", (String) objects[0]);
//            http.addOrReplace("f_title", (String) objects[1]);
//            http.addOrReplace("f_start_date", (String) objects[2]);
//            http.addOrReplace("f_content", (String) objects[3]);
//
//            HttpClient post = http.create();
//            post.request();
//
//            // 안드로이드에서 응답받음
//            String body = post.getBody();
//            return body;
//        }
//
//        @Override
//        protected void onPostExecute(Object o) {
//            Log.d("JSON_RESULT", (String) o);
//            Gson gson = new Gson();
//            com.example.kosmobank.Data data = gson.fromJson((String) o, com.example.kosmobank.Data.class);
//
//            try {
//                TextView f_title = (TextView) findViewById(R.id.fund_title);
//                TextView f_start_date = (TextView) findViewById(R.id.fund_start_date);
//                TextView f_content = (TextView) findViewById(R.id.fund_content);
//
//                f_title.setText(data.getData1());
//                f_start_date.setText(data.getData2());
//                f_content.setText(data.getData3());
//
//                title = data.getData1();
//                date = data.getData2();
//                content = data.getData3();
//
//                // Log.d("JSON_RESULT", "이름 = " + data.getMember().get("member_name"));
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
