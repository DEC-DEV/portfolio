package com.example.kosmobank;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

/**
 * Created by psn on 2018-02-07.
 */

public class MyPageMainActivity extends AppCompatActivity {

    InnerTask task = null;
    String id;
    String customer_name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        Intent intent = getIntent();
        id = intent.getStringExtra("id"); //  intent.getStringExtra("putExtra의 key")

        task = new InnerTask();
        task.execute(id);

        actionBar();  // extends AppCompatActivity 시 사용가능

        ImageButton center_imgBtn = (ImageButton) findViewById(R.id.ra_center);
        LinearLayout sub_layout_center = (LinearLayout) findViewById(R.id.sub_layout_center);
        ImageButton transfer_imgBtn = (ImageButton) findViewById(R.id.ra_transfer);
        LinearLayout sub_layout_transfer = (LinearLayout) findViewById(R.id.sub_layout_transfer);
        ImageButton fund_imgBtn = (ImageButton) findViewById(R.id.ra_fund);
        LinearLayout sub_layout_fund = (LinearLayout) findViewById(R.id.sub_layout_fund);

        // 조회/이체 서브메뉴들
        // 계좌등록
        TextView sub_reg_account_btn =  (TextView) findViewById(R.id.sub_reg_account);
        // 계좌해지
        TextView sub_cancel_account_btn =  (TextView) findViewById(R.id.sub_cancel_account);
        // 이체
        TextView sub_transfer_btn =  (TextView) findViewById(R.id.sub_transfer);
        // 계좌조회
        TextView sub_search_account_btn =  (TextView) findViewById(R.id.sub_search_account);

        //펀드 서브메뉴
        // 의류
        TextView sub_fund_cloth_btn = (TextView) findViewById(R.id.sub_fund1);
        // 건강
        TextView sub_fund_health_btn = (TextView) findViewById(R.id.sub_fund2);
        // 테크/가전
        TextView sub_fund_tech_btn = (TextView) findViewById(R.id.sub_fund3);
        // 홈-리빙
        TextView sub_fund_home_btn = (TextView) findViewById(R.id.sub_fund4);
        // 푸드
        TextView sub_fund_food_btn = (TextView) findViewById(R.id.sub_fund5);


        // 금융센터 서브메뉴들
        // 예금 상품
        TextView sub_deposit_btn = (TextView) findViewById(R.id.sub_deposit);
        // 적금 상품
        TextView sub_savings_btn = (TextView) findViewById(R.id.sub_savings);
        // 대출 상품
        TextView sub_loan_btn = (TextView) findViewById(R.id.sub_loan);

        // 펀드 서브메뉴들
        // 펀드1,2,3
        TextView sub_fund1_btn = (TextView) findViewById(R.id.sub_fund1);
        TextView sub_fund2_btn = (TextView) findViewById(R.id.sub_fund2);
        TextView sub_fund3_btn = (TextView) findViewById(R.id.sub_fund3);

        // 조회/이체 버튼 클릭시 서브메뉴 보이기
        transfer_imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "조회/이체클릭함", Toast.LENGTH_SHORT).show();
                sub_layout_center.setVisibility(View.GONE);
                sub_layout_fund.setVisibility(View.GONE);
                // new Intent(현재페이지, 이동할 페이지)
                /*
                Intent intent = new Intent(MyPageMainActivity.this, TransferActivity.class);
                startActivity(intent);
                */
                if(sub_layout_transfer.getVisibility() == View.VISIBLE) {
                    sub_layout_transfer.setVisibility(View.GONE);
                } else {
                    sub_layout_transfer.setVisibility(View.VISIBLE);
                }
            }
        });

        // 금융센터 버튼 클릭시 서브메뉴 보이기
        center_imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "금융센터클릭함", Toast.LENGTH_SHORT).show();
                sub_layout_transfer.setVisibility(View.GONE);
                sub_layout_fund.setVisibility(View.GONE);
                // new Intent(현재페이지, 이동할 페이지)
                /*
                Intent intent = new Intent(MyPageMainActivity.this, TransferActivity.class);
                startActivity(intent);
                */
                if(sub_layout_center.getVisibility() == View.VISIBLE) {
                    sub_layout_center.setVisibility(View.GONE);
                } else {
                    sub_layout_center.setVisibility(View.VISIBLE);
                }
            }
        });

        // 펀드 버튼 클릭시 서브메뉴 보이기
        fund_imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "펀드클릭함", Toast.LENGTH_SHORT).show();
                sub_layout_transfer.setVisibility(View.GONE);
                sub_layout_center.setVisibility(View.GONE);
                // new Intent(현재페이지, 이동할 페이지)
                /*
                Intent intent = new Intent(MyPageMainActivity.this, TransferActivity.class);
                startActivity(intent);
                */
                if (sub_layout_fund.getVisibility() == View.VISIBLE) {
                    sub_layout_fund.setVisibility(View.GONE);
                } else {
                    sub_layout_fund.setVisibility(View.VISIBLE);
                }
            }
        });

        // 조회/이체 - 계좌등록 클릭시
        sub_reg_account_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "sub-계좌등록 클릭", Toast.LENGTH_SHORT).show();

                Log.d("customer_name", customer_name);
                // new Intent(현재페이지, 이동할 페이지)
                Intent intent = new Intent(MyPageMainActivity.this, RegAccount.class);
                intent.putExtra("customer_name", customer_name);
                intent.putExtra("customer_id", id);

                startActivity(intent);
            }
        });

        // 조회/이체 - 계좌해지 클릭시
        sub_cancel_account_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "sub-계좌해지 클릭", Toast.LENGTH_SHORT).show();

                Log.d("customer_name", customer_name);
                // new Intent(현재페이지, 이동할 페이지)
                Intent intent = new Intent(MyPageMainActivity.this, AccountCancel.class);
                intent.putExtra("customer_name", customer_name);

                startActivity(intent);
            }
        });

        //조회/이체 - 계좌 이체 클릭시
        sub_transfer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "sub-계좌이체 클릭", Toast.LENGTH_SHORT).show();

                Log.d("customer_name", customer_name);
                Log.d("customer_ID", id);
                // new Intent(현재페이지, 이동할 페이지)
                Intent intent = new Intent(MyPageMainActivity.this, SearchAccount2.class);
                intent.putExtra("customer_name", customer_name);
                intent.putExtra("customer_ID", id);

                startActivity(intent);
            }
        });

        // 조회/이체 - 계좌조회 클릭시
        sub_search_account_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "sub-계좌조회 클릭", Toast.LENGTH_SHORT).show();

                Log.d("customer_name", customer_name);
                // new Intent(현재페이지, 이동할 페이지)
                Intent intent = new Intent(MyPageMainActivity.this, SearchAccount.class);
                intent.putExtra("customer_name", customer_name);
                intent.putExtra("customer_id", id);

                startActivity(intent);
            }
        });

        // 금융센터 - 예금상품 클릭시
        sub_deposit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "sub-계좌조회 클릭", Toast.LENGTH_SHORT).show();

                Log.d("customer_name", customer_name);
                // new Intent(현재페이지, 이동할 페이지)
                Intent intent = new Intent(MyPageMainActivity.this, DepositItem.class);
                intent.putExtra("customer_name", customer_name);

                startActivity(intent);
            }
        });

        // 금융센터 - 적금상품 클릭시
        sub_savings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "sub-계좌조회 클릭", Toast.LENGTH_SHORT).show();
                Log.d("customer_name", customer_name);
                // new Intent(현재페이지, 이동할 페이지)
                Intent intent = new Intent(MyPageMainActivity.this, SavingsItem.class);
                intent.putExtra("customer_name", customer_name);
                startActivity(intent);
            }
        });

        // 금융센터 - 대출상품 클릭시
        sub_loan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "sub-계좌조회 클릭", Toast.LENGTH_SHORT).show();

                Log.d("customer_name", customer_name);
                // new Intent(현재페이지, 이동할 페이지)
                Intent intent = new Intent(MyPageMainActivity.this, LoansItem.class);
                intent.putExtra("customer_name", customer_name);

                startActivity(intent);
            }
        });

        //펀드 -의류 클릭시
        sub_fund_cloth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "sub-펀드의류 클릭", Toast.LENGTH_SHORT).show();

                Log.d("customer_name", customer_name);

                // new Intent(현재페이지, 이동할 페이지)....
                Intent intent = new Intent(MyPageMainActivity.this, FundCloth.class);
                intent.putExtra("customer_name", customer_name);
                intent.putExtra("customer_id", id);

                startActivity(intent);
            }
        });

        //펀드 - 카테고리-건강 클릭시
        sub_fund_health_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "sub-펀드건강 클릭", Toast.LENGTH_SHORT).show();

                Log.d("customer_name", customer_name);
                // new Intent(현재페이지, 이동할 페이지)
                Intent intent = new Intent(MyPageMainActivity.this, FundHealth.class);
                intent.putExtra("customer_name", customer_name);
                intent.putExtra("customer_id", id);

                startActivity(intent);
            }
        });

        //펀드 - 카테고리-테크/가전 클릭시
        sub_fund_tech_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "sub-펀드테크/가전 클릭", Toast.LENGTH_SHORT).show();

                Log.d("customer_name", customer_name);
                // new Intent(현재페이지, 이동할 페이지)
                Intent intent = new Intent(MyPageMainActivity.this, FundTech.class);
                intent.putExtra("customer_name", customer_name);
                intent.putExtra("customer_id", id);

                startActivity(intent);
            }
        });

        //펀드 - 카테고리-홈-리빙 클릭시
        sub_fund_home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "sub-펀드홈-리빙 클릭", Toast.LENGTH_SHORT).show();

                Log.d("customer_name", customer_name);
                // new Intent(현재페이지, 이동할 페이지)
                Intent intent = new Intent(MyPageMainActivity.this, FundCloth.class);
                intent.putExtra("customer_name", customer_name);

                startActivity(intent);
            }
        });

        //펀드 - 카테고리-푸드 클릭시
        sub_fund_food_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "sub-펀드푸드 클릭", Toast.LENGTH_SHORT).show();

                Log.d("customer_name", customer_name);
                // new Intent(현재페이지, 이동할 페이지)
                Intent intent = new Intent(MyPageMainActivity.this, FundCloth.class);
                intent.putExtra("customer_name", customer_name);

                startActivity(intent);
            }
        });


    }


    private void actionBar() {
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.custom_bar, null);
        TextView tv_bar = v.findViewById(R.id.tv_bar);
        tv_bar.setText("MyProject");

        ActionBar bar = getSupportActionBar();
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        bar.setCustomView(v);
    }

    private class InnerTask extends AsyncTask {

        //MypageRecyAdapter adapter;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            HttpClient.Builder http = new HttpClient.Builder("POST", com.example.kosmobank.Web.servletURL + "androidMyPageMain"); //@RequestMapping url
            http.addOrReplace("id", (String) objects[0]);

            HttpClient post = http.create();
            post.request();

            // 안드로이드에서 응답받음
            String body = post.getBody();
            return body;
        }

        @Override
        protected void onPostExecute(Object o) {
            Log.d("JSON_RESULT", (String) o);
            Gson gson = new Gson();
            com.example.kosmobank.Data data = gson.fromJson((String) o, com.example.kosmobank.Data.class);

            try {
                TextView name = (TextView) findViewById(R.id.tv_name);
                name.setText(data.getData1() + "님");
                customer_name = data.getData1();
                Log.d("JSON_RESULT", "이름 = " + data.getMember().get("member_name"));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}