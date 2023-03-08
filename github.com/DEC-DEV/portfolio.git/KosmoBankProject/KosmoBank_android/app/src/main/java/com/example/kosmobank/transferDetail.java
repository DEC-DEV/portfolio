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

public class transferDetail extends AppCompatActivity {

    /*InnerTask task = null;*/
    EditText money, account2;  // input받는
    String id, account1;    // 화면이동시받는
    Button confirm_btn;
    int balance;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);  // jsp 화면

        Intent intent = getIntent(); // 화면이동하면서 보내준값 받을때
        id = intent.getStringExtra("id"); //
        account1 = intent.getStringExtra("account_num"); //출금계좌
        Log.d("activity_transfer : ",account1);
        balance = Integer.parseInt(intent.getStringExtra("balance"));
        Log.d("activity_transfer : ",Integer.toString(balance));
        // 받은값 셋팅해줘야함ㅅ
        TextView account_num = findViewById(R.id.d_account_num);
        account_num.setText("계좌번호 : " +account1 );

       TextView balance_x = findViewById(R.id.d_balance);
        balance_x.setText("잔액 : " +Integer.toString(balance) );

        // input받는값들
        money = (EditText) findViewById(R.id.account_money);
        account2 = (EditText) findViewById(R.id.account_num2); //입금계좌번호
        confirm_btn = (Button) findViewById(R.id.btn_confirm);


        // confirm_btn 클릭하면
        confirm_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "이체전송", Toast.LENGTH_SHORT).show();
                InnerTask task = new InnerTask();
                Map<String, String> map = new HashMap<>();

                // 안드화면에서 받는값
                map.put("money", money.getText().toString());
                map.put("account_num", account2.getText().toString());//출금
                // 전 페이지에서 넘어온 값
                map.put("account_num2", account1); //입금
                map.put("customer_id", id);
                map.put("balance", Integer.toString(balance));
                // 콘솔
                Log.d("금액 ------", money.getText().toString());
                Log.d("계좌번호 ------", account1);
                task.execute(map);   // doInBackground() 실행 //map을 들고가라
            }

        });
    }

    //각 Activity 마다 Task 작성
    // DB갈때 마다 이거 해야함
    // 컨트롤러 타는곳
    public class InnerTask extends AsyncTask<Map, Integer, String> {

        //doInBackground 실행되기 이전에 동작
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        //작업을 쓰레드로 처리
        @Override
        protected String doInBackground(Map... maps) {
            //HTTP 요청 준비
            // 스프링 컨트롤러 연결
            //스프링 컨트롤러 requestMapping("androidSignIn")
            Log.d("빌더", "전");
            HttpClient.Builder http = new HttpClient.Builder("POST", Web.servletURL + "androidTransfer");            //파라미터 전송
            http.addAllParameters(maps[0]);  // map에 담은거 가지고 컨트롤러타라
            Log.d("빌더", "후");

            //HTTP 요청 전송
            HttpClient post = http.create();
            post.request();

            Log.d("http", "전송");
            // 안드로이드에서 응답받음
            String body = post.getBody(); //Web의 Controller에서 리턴한 값
            Log.d("body------", body);
            return body;
        }
        //doInBackground 종료되면 동작

        /**
         * @param s : doInBackground에서 리턴한 body. JSON 데이터
         */
        @Override
        protected void onPostExecute(String s) {
            Log.d("JSON_RESULT", s);

            //JSON으로 받은 데이터를 VO Obejct로 바꿔준다.
            if (s.length() > 10) {
                Intent intent = new Intent(transferDetail.this, MyPageMainActivity.class);
                Intent intent2 = getIntent();
                // id = intent2.getStringExtra("customer_id");
                // Log.d("id값 확인 : ", id);
                // intent.putExtra("id", id);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "이체 실패", Toast.LENGTH_SHORT).show();
            }
        }

    }
}