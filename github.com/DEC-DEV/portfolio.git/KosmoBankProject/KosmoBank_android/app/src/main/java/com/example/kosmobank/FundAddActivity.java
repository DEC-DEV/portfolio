package com.example.kosmobank;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



// 상품추가
public class FundAddActivity extends AppCompatActivity {
    EditText editFundNum, editFundName, editFundStart, editFundContent;
    Button btnSave;
    FundDAO dao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_product_add.xml을 현재 레이아웃으로 사용
        setContentView(R.layout.activity_fund_add);

        // 리소스 연결
        editFundNum = findViewById(R.id.editFundNum);
        editFundName = findViewById(R.id.editFundName);
        editFundStart = findViewById(R.id.editFundStart);
        editFundContent = findViewById(R.id.editFundContent);
        btnSave = findViewById(R.id.btnSave);

        dao = new FundDAO(this);

        // 저장 버튼 클릭시 이벤트 처리
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int f_num = Integer.parseInt(editFundNum.getText().toString());
                String f_title = editFundName.getText().toString();
                String f_start_date = editFundStart.getText().toString();
                String f_content = editFundContent.getText().toString();

                dao.insert(new FundListDTO(f_num, f_title, f_start_date, f_content));

                finish(); // 현재 엑티비티를 종료함, 이전화면 ProductListActivity의 onResume() 호출
            }
        });
    }
}
