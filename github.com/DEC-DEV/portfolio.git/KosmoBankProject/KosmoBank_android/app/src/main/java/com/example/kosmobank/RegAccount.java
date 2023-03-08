package com.example.kosmobank;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class RegAccount extends AppCompatActivity {

    /*InnerTask task = null;*/
    EditText edtPwd;
    String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regaccount);

        Intent intent = getIntent(); //전달할 데이터를 받을 Intent
        //text 키값으로 데이터를 받는다. String을 받아야 하므로 getStringExtra()를 사용함
        String name = intent.getStringExtra("customer_name");
        id = intent.getStringExtra("customer_id");

        TextView text_tv = findViewById(R.id.tv_name);
        text_tv.setText("이름 : " + name + "님");

        TextView master_name = findViewById(R.id.master_name);
        master_name.setText("이름 : " + name);
        TextView bank_name = findViewById(R.id.bank_name);
        bank_name.setText("은행명 : KOS뱅크");
        Button confirm_btn = (Button) findViewById(R.id.btn_confirm);
        edtPwd = (EditText) findViewById(R.id.account_password);

        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "확인버튼 클릭함", Toast.LENGTH_SHORT).show();
                if(edtPwd.getText().toString().length() == 4) {
                    Map<String, String> map = new HashMap<>();
                    map.put("customerID", id);
                    map.put("account_name", name);
                    map.put("account_password", edtPwd.getText().toString());
                    map.put("bank_name", "미정");
    
                    InnerTask task = new InnerTask();
                    task.execute(map);
                } else {
                    Toast.makeText(getApplicationContext(), "비밀번호 4자리를 입력하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //각 Activity 마다 Task 작성
    public class InnerTask extends AsyncTask<Map, Integer, String> {

        //doInBackground 실행되기 이전에 동작
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        //작업을 쓰레드로 처리
        @Override
        protected String doInBackground(Map... maps) {
            Log.d("doInBackground : ", "들어옴");

            //HTTP 요청 준비
            HttpClient.Builder http = new HttpClient.Builder("POST", Web.servletURL + "androidRegAccount"); //스프링 컨트롤러 requestMapping("androidSignIn")            //파라미터 전송
            http.addAllParameters(maps[0]);  // 입력한 데이터

            //HTTP 요청 전송
            HttpClient post = http.create();
            post.request();

            // 안드로이드에서 응답받음
            String body = post.getBody(); //Web의 Controller에서 리턴한 값
            Log.d("androidRegAccount 응답 : ", body);
            return body;
        }

        //doInBackground 종료되면 동작
        /**
         * @param s : doInBackground에서 리턴한 body. JSON 데이터
         */
        @Override
        protected void onPostExecute(String s) {
            Log.d("JSON_RESULT", s);

            if(s.length() > 0) {
                Toast.makeText(getApplicationContext(), "등록 성공.", Toast.LENGTH_SHORT).show();
                Log.d("onPostExecute : ", "등록 성공");
                Intent intent = new Intent(RegAccount.this, MyPageMainActivity.class);
                Intent intent2 = getIntent();
                id = intent2.getStringExtra("customer_id");
                Log.d("id값 확인 : ", id);
                intent.putExtra("id", id);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "등록 실패", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
