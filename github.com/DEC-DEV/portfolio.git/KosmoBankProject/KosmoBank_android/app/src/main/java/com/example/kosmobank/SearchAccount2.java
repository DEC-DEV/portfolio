package com.example.kosmobank;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchAccount2 extends AppCompatActivity {

    /*InnerTask task = null;*/
    String c_id;
    String name;
    ListView listView;
    List<AccountDTO> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchaccount2);

        Intent intent = getIntent(); //전달할 데이터를 받을 Intent
        //text 키값으로 데이터를 받는다. String을 받아야 하므로 getStringExtra()를 사용함
        name = intent.getStringExtra("customer_name");
        c_id = intent.getStringExtra("customer_ID");

        TextView text_tv = findViewById(R.id.tv_name);
        text_tv.setText(name + "님");

        InnerTask task = new InnerTask();

        Log.d("task.execute ", "전1");
        task.execute(c_id);
        Log.d("task.execute ", "후6");


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume ", "들어옴7");
        // 4. 커스텀 아답터 생성
        // new ProductAdapter(context 정보, 리소스, data)



/*        for(int i = 0; i<list.size(); i++) {
            Log.d("onResume에서 list 확인 ", String.valueOf(list.get(i)));
        }*/
    }

    // 3. 커스텀 아답터 : 개발자가 화면에 아답터를 만들어서 리스트뷰 출력
    // 아답터 : 화면과 데이터를 연결
    class AccountAdapter extends ArrayAdapter<AccountDTO> {

        // 3-1.
        // 우클릭 > Generate > Constructor > 아래에서 두번째 선택
        // 아래 생성자를 선택하기 전에는 오류 발생
        public AccountAdapter(@NonNull Context context, int resource, @NonNull List<AccountDTO> objects) {
            super(context, resource, objects);
        }

        // 3-2. activity_product_detail.xml 생성
        // 3-3.. 자식뷰 생성(xml -> View Type으로 객체화)
        // 우클릭 > Generate > Override Methods > getView 선택
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            // convertView는 자식뷰로 activity_product_detail.xml 생성 (productDTO)
            if(convertView == null) { // null 일때 처음 한번만 xml을 이용해서 View 생성
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.activity_searchaccount_list2, null);
            }

            // 리소스 연결
            TextView txtAccount_num = convertView.findViewById(R.id.txtAccount_num); // 제품명

            // select해서 data가져오기
            AccountDTO dto  = list.get(position);

            // 리소스에 데이터를 설정
            txtAccount_num.setText(dto.getAccount_num());

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
            Log.d("searchAccount doInBg : ", "들어옴2");

            //HTTP 요청 준비
            HttpClient.Builder http = new HttpClient.Builder("POST", Web.servletURL + "androidAccountList"); //스프링 컨트롤러 requestMapping("androidSignIn")            //파라미터 전송
            http.addOrReplace("id", (String) objects[0]);  //get방식처럼

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
            Log.d("AccountList 응답4 ", (String) o);
            Gson gson = new Gson();

            list = gson.fromJson((String) o, new TypeToken<List<AccountDTO>>(){}.getType());

            for(int i = 0; i<list.size(); i++) {
                Log.d("list for문 확인(post)5 ", String.valueOf(list.get(i)));
            }

            listView = findViewById(R.id.listView);
            AccountAdapter adapter = new AccountAdapter(getBaseContext(), R.layout.activity_searchaccount_list2, list);
            listView.setAdapter(adapter);

            //??????????리스트 계좌번호를 눌렀을때??????????
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplicationContext(), transferDetail.class);
                    /* putExtra의 첫 값은 식별 태그, 뒤에는 다음 화면에 넘길 값 */
                    intent.putExtra("id", c_id);
                    intent.putExtra("name", name);
                    intent.putExtra("balance", Integer.toString(list.get(position).getBalance()));
                    intent.putExtra("account_num", list.get(position).getAccount_num());
                    startActivity(intent);
                }
            });

        }
    }
}
