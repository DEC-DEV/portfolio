package com.example.kosmobank;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDetail extends AppCompatActivity {

    /*InnerTask task = null;*/
    String id;
    String name;
    String account_num;

    // 거래내역 리스트
    // 계좌 정보
    TransferDTO s = null;
    // 상태 정보
    String state;
    List<TransferDTO> list;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountdetail);

        Intent intent = getIntent(); //전달할 데이터를 받을 Intent
        //text 키값으로 데이터를 받는다. String을 받아야 하므로 getStringExtra()를 사용함
        list = new ArrayList<TransferDTO>();
        state = intent.getStringExtra("state");
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        account_num = intent.getStringExtra("account_num");

        TextView text_tv = findViewById(R.id.tv_name);
        text_tv.setText(name + "님");

        TextView d_account_num = findViewById(R.id.d_account_num);
        d_account_num.setText("계좌번호 : " + account_num);

        TextView d_account_type = findViewById(R.id.d_account_type);
        d_account_type.setText("계좌 상태 : " + state);

        Log.d("task.execute ", "전1");

        AccountDetail.InnerTask task = new AccountDetail.InnerTask();
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("account_num", account_num);
        task.execute(map);

    }
    class TransferHistoryAdapter extends ArrayAdapter<TransferDTO> {
        public TextView money;
        public TextView in_out, in_out_date;

        //어댑터에 데이터를 받기위해 생성자 만든다. // 컨텍스트와 리스트는 받아오지만 인플레이터는 안받아온다.
        Context context;
        LayoutInflater inflater;

        public TransferHistoryAdapter(@NonNull Context context, int resource, @NonNull List objects) {
            super(context, resource, objects);
            System.out.println( "TransferHistoryAdapter:"+"진입");
        }

        //리스트의 항목을 삭제할 메서드 작성


        //getCount() : 리스트에서 항목을 몇개나 가져와서 몇개의 화면을 만들 것인지 정하는 메서드

        //getItem() : 리스트에서 해당하는 인덱스의 데이터(사진, 이름, 전번)를 모두 가져오는 메서드
        //Object를 알아서 캐스팅해서 사용하라는 의미로 반환 타입이 Object

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            //화면 구성
            if (convertView == null) {
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.activity_accounthistory, null);
                in_out = convertView.findViewById(R.id.in_out);
                in_out.setText("이체 내역이 존재하지 않습니다");
            }
            in_out = convertView.findViewById(R.id.in_out);
            in_out_date = convertView.findViewById(R.id.in_out_date);
            money = convertView.findViewById(R.id.money);
            //DTO에서 데이터를 찾음
            if( list.get(position) == null){
                in_out.setText("이체 내역이 존재하지 않습니다");
            }else{
                TransferDTO dto  = list.get(position);
                in_out.setText(dto.getIn_out());
                in_out_date.setText(dto.getIn_out_date());
                money.setText(String.valueOf(dto.getMoney() ));
            }




            //XML의 화면에 찾은 데이터 표시
            //이미지만 클릭했을때 번호, 이름만 표시되게 기능 추가

            //따로 새 자바 파일을 만들지 않고 XML의 내용을 볼 수 있게끔 만든 클래스
            return convertView;
        }
    }
    //각 Activity 마다 Task 작성
    public class InnerTask extends AsyncTask {

        //doInBackground 실행되기 이전에 동작
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        //작업을 쓰레드로 처리
        @Override
        protected Object doInBackground(Object[] objects) {

            //HTTP 요청 준비
            HttpClient.Builder http = new HttpClient.Builder("POST", Web.servletURL + "androidDetail"); //스프링 컨트롤러 requestMapping("androidSignIn")            //파라미터 전송
            http.addOrReplace("account_num", account_num);

            //HTTP 요청 전송
            HttpClient post = http.create();
            post.request();

            // 안드로이드에서 응답받음
            String body = post.getBody(); //Web의 Controller에서 리턴한 값
            Log.d("AccountList 응답 3", body);
            return body;
        }

        //doInBackground 종료되면 동작
        @Override
        protected void onPostExecute(Object o) {

            Gson gson = new Gson();
            list = gson.fromJson((String) o, new TypeToken<List<TransferDTO>>() {
            }.getType());
        try {
            listView = findViewById(R.id.listView);
            TransferHistoryAdapter adapter = new TransferHistoryAdapter(getBaseContext(), R.layout.activity_accounthistory, list);
            listView.setAdapter(adapter);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        }
    }


}