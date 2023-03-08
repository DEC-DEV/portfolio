package com.example.kosmobank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class FundCloth extends AppCompatActivity {

    String id;
    List<FundListDTO> list;
    ListView listView;
    FundDAO dao;
    ImageButton fund_image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth);

        Intent intent = getIntent(); //전달할 데이터를 받을 Intent
        //text 키값으로 데이터를 받는다. String을 받아야 하므로 getStringExtra()를 사용함
        String name = intent.getStringExtra("customer_name");
        id = intent.getStringExtra("customer_id");

//        listView = findViewById(R.id.cloth_listView);
//        Button btnAdd = findViewById(R.id.btnAdd);
//        ImageButton fund_image = (ImageButton) findViewById(R.id.fund_image);
//
//        dao = new FundDAO(this);

        TextView text_tv = findViewById(R.id.tv_name);
        text_tv.setText(name + "님");
    }

    // 2.
    // 우클릭 > Generate > Override Methods > OnResume 검색
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        // 2-1. 상품목록 조회
//        list = dao.FundList();
////
//        Log.i("text", "상품목록 ==> " + list);
//
//        // 4. 커스텀 아답터 생성
//        ClothAdapter adapter = new ClothAdapter(this, R.layout.activity_cloth_list, list);
//        listView.setAdapter(adapter);
//    }
//
//    // 5. 상품추가 버튼 클릭 .. 상품추가 화면(FundAddActivity)으로 이동
//    public void btnAdd_onClick(View view) {
//        Intent intent = new Intent(this, FundAddActivity.class);
//        startActivity(intent);
//    }

    // 이미지 클릭 > 상세페이지
    public void fund_image_onClick(View view) {
        Intent intent = new Intent(this, FundClothDetail.class);
        startActivity(intent);
    }

//    class ClothAdapter extends ArrayAdapter<FundListDTO> {
//
//        public ClothAdapter(@NonNull Context context, int resource, @NonNull List<FundListDTO> objects) {
//            super(context, resource, objects);
//        }
//
//        @NonNull
//        @Override
//        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//            // convertView는 자식뷰로 activity_product_detail.xml 생성(ProductDTO 정보)
//            if(convertView == null) {   // 처음 한번만 xml을 이용해서 View 생성
//                LayoutInflater inflater = getLayoutInflater();
//                convertView = inflater.inflate(R.layout.activity_cloth_list, null); // 3-3. 자식뷰 생성(xml -> View Type으로 객체화)
//
//            }
//
//            // 리소스 연결
//            TextView txtFundNum = convertView.findViewById(R.id.txtFundNum);  // 펀드번호
//            TextView txtFundTitle = convertView.findViewById(R.id.txtFundTitle);  // 펀드명
//            TextView txtFundStart = convertView.findViewById(R.id.txtFundStart); // 펀드시작일
//            TextView txtFundContent = convertView.findViewById(R.id.txtFundContent); // 펀드내용
//
//            // select해서 data 가져오기
//            FundListDTO dto = list.get(position);
//
//            // 리소스에 데이터를 설정
//            txtFundTitle.setText(dto.getF_title());
//            txtFundStart.setText("시작일 : " + dto.getF_start_date());  // String 변환(문자열 + int)
//            txtFundContent.setText("내용 : " + dto.getF_content());
//
//            return convertView;
//        }
//
//        private class InnerTask extends AsyncTask {
//
//            //MypageRecyAdapter adapter;
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//            }
//
//            @Override
//            protected Object doInBackground(Object[] objects) {
//                HttpClient.Builder http = new HttpClient.Builder("POST", com.example.kosmobank.Web.servletURL + "androidFundCloth"); //@RequestMapping url
//                http.addOrReplace("id", (String) objects[0]);
//
//                HttpClient post = http.create();
//                post.request();
//
//                // 안드로이드에서 응답받음
//                String body = post.getBody();
//                return body;
//            }
//
//            @Override
//            protected void onPostExecute(Object o) {
//                Log.d("JSON_RESULT", (String) o);
//                Gson gson = new Gson();
//                com.example.kosmobank.Data data = gson.fromJson((String) o, com.example.kosmobank.Data.class);
//
//                try {
//                    TextView txtFundNum = (TextView) findViewById(R.id.txtFundNum);  // 펀드명
//                    TextView txtFundTitle = (TextView) findViewById(R.id.txtFundTitle);  // 펀드명
//                    TextView txtFundStart = (TextView) findViewById(R.id.txtFundStart); // 펀드시작일
//                    TextView txtFundContent = (TextView) findViewById(R.id.txtFundContent); // 펀드내용
//
//                    txtFundNum.setText(data.getData1());
//                    txtFundTitle.setText(data.getData2());
//                    txtFundStart.setText(data.getData3());
//                    txtFundContent.setText(data.getData4());
//
//                    // Log.d("JSON_RESULT", "펀드명 = " + data.getMember().get("member_name"));
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//

    }

