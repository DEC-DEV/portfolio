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


public class LoansItem extends AppCompatActivity {

        String s_id;
        String name;
        ListView listView;
        List<LoansItemDTO> list;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //표출하고싶은 레이아웃을 선언
            setContentView(R.layout.activity_loans);

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

        class LoansListAdapter extends ArrayAdapter<LoansItemDTO> {


            public LoansListAdapter(@NonNull Context context, int resource, @NonNull List<LoansItemDTO> objects) {
                super(context, resource, objects);
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                if (convertView == null) {
                    LayoutInflater inflater = getLayoutInflater();
                    convertView = inflater.inflate(R.layout.activity_loans_list, null);

                }
                //리소스 연결
                //TextView textF_num = convertView.findViewById(R.id.txtF_num);
                TextView txt_name = convertView.findViewById(R.id.txt_name);    //네임
                TextView txt_MaxMoney = convertView.findViewById(R.id.txt_MaxMoney); //최대 대출 금액
                TextView txt_rate = convertView.findViewById(R.id.txt_rate);    // 대출 금리
                TextView txt_repay = convertView.findViewById(R.id.txt_repay);  // 상환방식
                TextView txt_notice = convertView.findViewById(R.id.txt_explanation);

                LoansItemDTO dto = list.get(position);

                txt_name.setText(dto.getD_name());
                txt_MaxMoney.setText(String.valueOf(dto.getD_max_price()));
                txt_rate.setText(String.valueOf(dto.getD_interest_rate()));
                txt_repay.setText(dto.getD_repay());
                txt_notice.setText(dto.getD_explanation1());

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
                Log.d("Loans doInBg : ", "들어옴2");

                //http 요청 준비
                HttpClient.Builder http = new HttpClient.Builder("POST", Web.servletURL + "loansList");
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

                list = gson.fromJson((String) o, new TypeToken<List<LoansItemDTO>>() {
                }.getType());

                for(int i=0; i < list.size(); i++) {
                    Log.d("list for문 확인(post)5 ", String.valueOf(list.get(i)));
                }

                listView = findViewById(R.id.loans_listView);
                LoansListAdapter adapter = new LoansListAdapter(getBaseContext(), R.layout.activity_loans, list);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView parent, View view, int i, long id) {
                        Intent intent = new Intent(getApplicationContext(), LoansItemDetail.class);
                        // putExtra의 첫 값은 식별태그, 뒤에는 다음 화면에 넘길 값
                        intent.putExtra("name", name);

                        intent.putExtra("d_name",list.get(i).getD_name());
                        intent.putExtra("d_interest_rate", Double.toString(list.get(i).getD_interest_rate()));
                        intent.putExtra("d_max_price", Long.toString(list.get(i).getD_max_price()));
                        intent.putExtra("d_prepayment_fee", Integer.toString(list.get(i).getD_prepayment_fee()));
                        intent.putExtra("d_explanation1",list.get(i).getD_explanation1());
                        intent.putExtra("d_repay",list.get(i).getD_repay());

                        startActivity(intent);
                    }
                });
            }
        }


    }

