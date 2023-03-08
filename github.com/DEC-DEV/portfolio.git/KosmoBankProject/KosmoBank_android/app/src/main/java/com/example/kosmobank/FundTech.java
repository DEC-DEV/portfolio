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
import android.widget.ListAdapter;
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

public class FundTech extends AppCompatActivity {

    String f_id;
    String name;
    ListView listView;
    List<FundListDTO> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech);

        Intent intent = getIntent(); //전달할 데이터를 받을 Intent

        name = intent.getStringExtra("customer_name");
        f_id = intent.getStringExtra("customer_id");

        TextView text_tv = findViewById(R.id.tv_name);
        text_tv.setText(name + "님");

        InnerTask task = new InnerTask();

        Log.d("task.execute ", "전1");
        task.execute(f_id);
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
    class FundListAdapter extends ArrayAdapter<FundListDTO> {

        public FundListAdapter(@NonNull Context context, int resource, @NonNull List<FundListDTO> objects) {
            super(context, resource, objects);
        }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView는 자식뷰로 activity_product_detail.xml 생성 (productDTO)
        if (convertView == null) { // null 일때 처음 한번만 xml을 이용해서 View 생성
            LayoutInflater inflater = getLayoutInflater();
            convertView = inflater.inflate(R.layout.activity_fund_list, null);
        }

        // 리소스 연결
        // TextView txtF_num = convertView.findViewById(R.id.txtF_num); // 펀드번호
        TextView txtF_title = convertView.findViewById(R.id.txtF_title); // 펀드명
        TextView txtF_date = convertView.findViewById(R.id.txtF_date); // 펀드시작일
        TextView txtF_content = convertView.findViewById(R.id.txtF_content); // 펀드내용


        // select해서 data가져오기
        FundListDTO dto = list.get(position);

        // 리소스에 데이터를 설정
        // txtF_num.setText(Integer.toString(dto.getF_num()));
        txtF_title.setText(dto.getF_title());
        txtF_date.setText(dto.getF_start_date());
        txtF_content.setText(dto.getF_content());

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
            Log.d("fundtech doInBg : ", "들어옴2");

            //HTTP 요청 준비
            HttpClient.Builder http = new HttpClient.Builder("POST", Web.servletURL + "androidFundList"); //스프링 컨트롤러 requestMapping("androidSignIn")            //파라미터 전송
            http.addOrReplace("id", (String) objects[0]);

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

            list = gson.fromJson((String) o, new TypeToken<List<FundListDTO>>() {
            }.getType());

            for (int i = 0; i < list.size(); i++) {
                Log.d("list for문 확인(post)5 ", String.valueOf(list.get(i)));
            }

            listView = findViewById(R.id.fundlistView);
            FundListAdapter adapter = new FundListAdapter(getBaseContext(), R.layout.activity_tech, list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplicationContext(), FundTechDetail.class);
                    /* putExtra의 첫 값은 식별 태그, 뒤에는 다음 화면에 넘길 값 */
                    intent.putExtra("id", f_id);
                    intent.putExtra("name", name);
                    intent.putExtra("f_num", Integer.toString(list.get(position).getF_num()));
                    intent.putExtra("f_title", list.get(position).getF_title());
                    intent.putExtra("f_start_date", list.get(position).getF_start_date());
                    intent.putExtra("f_content", list.get(position).getF_content());
                    startActivity(intent);
                }
            });

        }
    }
}

