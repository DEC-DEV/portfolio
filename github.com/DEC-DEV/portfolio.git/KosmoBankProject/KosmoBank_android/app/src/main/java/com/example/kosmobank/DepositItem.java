package com.example.kosmobank;

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
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;

import java.sql.Timestamp;
import java.util.List;


public class DepositItem extends AppCompatActivity {

    String s_id;
    String name;
    ListView listView;
    List<DepositItemDTO> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //표출하고싶은 레이아웃을 선언
        setContentView(R.layout.activity_deposits);

        Intent intent = getIntent();

        name = intent.getStringExtra("customer_name");
        s_id = intent.getStringExtra("customer_id");

        TextView text = findViewById(R.id.tv_name);
        text.setText(name + "님");

        InnerTask task = new InnerTask();
        Log.d("task.execute", "전1");
        task.execute(s_id);
        Log.d("task.execute", "후6");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume", "들어옴");
    }

    class DepositListAdapter extends ArrayAdapter<DepositItemDTO> {


        public DepositListAdapter(@NonNull Context context, int resource, @NonNull List<DepositItemDTO> objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.activity_deposits_list, null);

            }
            //리소스 연결
            //TextView textF_num = convertView.findViewById(R.id.txtF_num);
            TextView txt_name = convertView.findViewById(R.id.txt_name);    //네임
            TextView txt_rate = convertView.findViewById(R.id.txt_rate);    //금리
            TextView txt_type = convertView.findViewById(R.id.txt_type);    //종류
            TextView txt_summary = convertView.findViewById(R.id.txt_summary);  //요약
            TextView txt_notice = convertView.findViewById(R.id.txt_notice);


            DepositItemDTO dto = list.get(position);

            txt_name.setText(dto.getY_name());
            txt_rate.setText(String.valueOf(dto.getY_interest_rate()));

            String typeName ="";
            if(dto.getY_type() == 0) {
                typeName = "정기예금";
            } else {
                typeName = "비정기예금";
            }
            txt_type.setText(typeName);
            txt_summary.setText(dto.getY_summary());
            txt_notice.setText(dto.getY_notice());

            return convertView;
        }
    }

    public class InnerTask extends AsyncTask {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            Log.d("savings doInBg : ", "들어옴2");

            //http 요청 준비
            HttpClient.Builder http = new HttpClient.Builder("POST", Web.servletURL + "depositList");
            http.addOrReplace("id", (String) objects[0]);

            HttpClient post = http.create();
            post.request();

            String body = post.getBody();
            Log.d("AccountList 응답 3", body);

            return body;
        }

        @Override
        protected void onPostExecute(Object o) {
            Log.d("AccountList 응답4 ", (String) o);
            Gson gson = new GsonBuilder().registerTypeAdapter(Timestamp.class, (JsonDeserializer) (json, typeOfT, context) -> {
                return new Timestamp(json.getAsLong());
            }).create();

            list = gson.fromJson((String) o, new TypeToken<List<DepositItemDTO>>() {
            }.getType());

            for(int i=0; i < list.size(); i++) {
                Log.d("list for문 확인(post)5 ", String.valueOf(list.get(i)));
            }

            listView = findViewById(R.id.deposits_listView);
            DepositListAdapter adapter = new DepositListAdapter(getBaseContext(), R.layout.activity_deposits, list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View view, int i, long id) {
                    Intent intent = new Intent(getApplicationContext(), DepositItemDetail.class);
                    // putExtra의 첫 값은 식별태그, 뒤에는 다음 화면에 넘길 값
                    intent.putExtra("name", name);
                    intent.putExtra("i_num", Integer.toString(list.get(i).getY_no()));
                    intent.putExtra("i_name", list.get(i).getY_name());
                    intent.putExtra("i_rate", Double.toString(list.get(i).getY_interest_rate()));
                    intent.putExtra("i_type", Integer.toString(list.get(i).getY_type()));
                    intent.putExtra("i_notice", list.get(i).getY_notice());
                    startActivity(intent);
                }
            });
        }
    }
}
