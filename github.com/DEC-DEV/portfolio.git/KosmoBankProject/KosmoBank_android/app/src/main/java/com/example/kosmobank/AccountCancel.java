package com.example.kosmobank;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountCancel extends AppCompatActivity {
    String id;
    String name;
    Button btnCancel;

    EditText account_num;
    EditText pwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountcancel);
        Intent intent = getIntent();

        id = intent.getStringExtra("id");
        name = intent.getStringExtra("customer_name");
        account_num = (EditText) findViewById(R.id.account_num);
        pwd = (EditText) findViewById(R.id.account_password);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
        TextView text_tv = findViewById(R.id.tv_name);
        text_tv.setText(name + "님");

        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "해지 클릭", Toast.LENGTH_SHORT).show();
                InnerTask task = new InnerTask();
                Map<String, String> map = new HashMap<>();
                map.put("id",id);
                map.put("account_num", account_num.getText().toString());
                map.put("account_password", pwd.getText().toString());

                task.execute(map);   // doInBackground() 실행
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
            //HTTP 요청 준비
            HttpClient.Builder http = new HttpClient.Builder("POST", Web.servletURL + "accountCancel"); //스프링 컨트롤러 requestMapping("androidSignIn")            //파라미터 전송
            http.addAllParameters(maps[0]);  // 입력한 데이터(id, 패스워드)

            //HTTP 요청 전송
            HttpClient post = http.create();
            post.request();

            // 안드로이드에서 응답받음
            String body = post.getBody(); //Web의 Controller에서 리턴한 값
            Log.d("accountCancel------", body);
            return body;
        }

        //doInBackground 종료되면 동작
        /**
         * @param s : doInBackground에서 리턴한 body. JSON 데이터
         */
        @Override
        protected void onPostExecute(String s) {
            Log.d("AccountCancel", s);
            if(s.length() > 0){
                Gson gson = new Gson();
                Map<String,Object> map  =  gson.fromJson(s,new TypeToken<Map<String, Object>>(){}.getType());
                if( map.get("insertCnt").toString().equals("1.0")){
                    Intent intent = new Intent(AccountCancel.this, AccountDetail.class);
                    Log.d( "account: ",(String)map.get("account_num"));
                    intent.putExtra("account_num", (String)map.get("account_num"));
                    intent.putExtra("state",(String)map.get("state"));
                    intent.putExtra("name",name);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "해지 실패", Toast.LENGTH_SHORT).show();
                }
            }
            //JSON으로 받은 데이터를 VO Obejct로 바꿔준다.
        }
    }
}
