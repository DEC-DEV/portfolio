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
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import java.sql.Timestamp;




public class SavingsItem extends AppCompatActivity {

    String s_id;
    String name;
    ListView listView;
    List<SavingsItemDTO> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //표출하고싶은 레이아웃을 선언
        setContentView(R.layout.activity_savings);

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

    class SavingsListAdapter extends ArrayAdapter<SavingsItemDTO> {


        public SavingsListAdapter(@NonNull Context context, int resource, @NonNull List<SavingsItemDTO> objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.activity_savings_list, null);

            }
            //리소스 연결
            //TextView textF_num = convertView.findViewById(R.id.txtF_num);
            TextView txt_name = convertView.findViewById(R.id.txt_name);    //네임
            TextView txt_rate = convertView.findViewById(R.id.txt_rate);    //금리
            TextView txt_type = convertView.findViewById(R.id.txt_type);    //종류
            TextView txt_summary = convertView.findViewById(R.id.txt_summary);  //요약
            TextView txt_notice = convertView.findViewById(R.id.txt_notice); //설명

            SavingsItemDTO dto = list.get(position);

            txt_name.setText(dto.getI_name());
            txt_rate.setText(String.valueOf(dto.getI_rate()));

            String typeName = "";
            if(dto.getI_type() == 0) {
                typeName = "단리";
            } else {
                typeName = "복리";
            }
            txt_type.setText(typeName);
            txt_summary.setText(dto.getI_summary());
            txt_notice.setText(dto.getI_notice());
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
            HttpClient.Builder http = new HttpClient.Builder("POST", Web.servletURL + "savingsList");
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

            list = gson.fromJson((String) o, new TypeToken<List<SavingsItemDTO>>() {
            }.getType());

            for(int i=0; i < list.size(); i++) {
                Log.d("list for문 확인(post)5 ", String.valueOf(list.get(i)));
            }

            listView = findViewById(R.id.savings_listView);
            SavingsListAdapter adapter = new SavingsListAdapter(getBaseContext(), R.layout.activity_savings, list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View view, int i, long id) {
                    Intent intent = new Intent(getApplicationContext(), SavingsItemDetail.class);
                    // putExtra의 첫 값은 식별태그, 뒤에는 다음 화면에 넘길 값
                    intent.putExtra("name", name);
                    intent.putExtra("i_num", Integer.toString(list.get(i).getI_no()));
                    intent.putExtra("i_name", list.get(i).getI_name());
                    intent.putExtra("i_rate", Double.toString(list.get(i).getI_rate()));
                    intent.putExtra("i_type", Integer.toString(list.get(i).getI_type()));
                    intent.putExtra("i_notice", list.get(i).getI_notice());
                    intent.putExtra("i_date", list.get(i).getI_date());
                    intent.putExtra("i_auto_date", list.get(i).getI_auto_date());
                    intent.putExtra("i_man_date", list.get(i).getI_min_date());
                    intent.putExtra("i_max_date", list.get(i).getI_max_date());

                    startActivity(intent);
                }
            });
        }
    }


}
