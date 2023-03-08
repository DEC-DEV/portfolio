package com.example.kosmobank;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class FundDAO {

    Context context;    // DB를 사용할 화면
    SQLiteDatabase db;  // 경량 데이터베이스

    public FundDAO() {
    }

    public FundDAO(Context context) {
        this.context = context;
    }

    // product 테이블 생성
    public SQLiteDatabase dbConn() {
        SQLiteDatabase db = context.openOrCreateDatabase("fund.db", Context.MODE_PRIVATE, null);
        String sql = "CREATE TABLE IF NOT EXISTS fund "
                + "(f_num  integer PRIMARY KEY AUTOINCREMENT, "
                + "f_title VARCHAR(50) NOT NULL,"
                + "f_start_date VARCHAR(50) NOT NULL, "
                + "f_content VARCHAR(100) NOT NULL)";
        db.execSQL(sql);
        return db;
    }

    // 상품목록 출력
    public List<FundListDTO> FundList() {
        List<FundListDTO> list = new ArrayList<FundListDTO>();
        Cursor cursor = null; // 결과셋 객체(resultSet)

        try {
            db = dbConn();
            String sql = "SELECT f_num, f_title, f_start_date, f_content FROM fund ORDER BY f_num ASC";

            // rawQuery : SELECT 쿼리 실행 => 자바의 executeQuery
            // execSQL : INSERT, UPDATE, DELETE 쿼리 실행 => 자바의 executeUpdate
            cursor = db.rawQuery(sql, null);

            while(cursor.moveToNext()) { // 다음 레코드가 존재하면
                int f_num = cursor.getInt(0);
                String f_title = cursor.getString(1);
                String f_start_date = cursor.getString(2);
                String f_content = cursor.getString(3);

                Log.i("f_num : ", "인덱스0 : " + f_num);
                Log.i("f_title : ", "인덱스1 : " + f_title);
                Log.i("f_start_date : ", "인덱스2 : " + f_start_date);
                Log.i("f_content : ", "인덱스3 : " + f_content);

                list.add(new FundListDTO(f_num, f_title, f_start_date, f_content));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(cursor != null) cursor.close();
            if(db != null) db.close();
        }
        return list;
    }

    // 상품 추가
    public void insert(FundListDTO dto) {
        try {

            db = dbConn();

            // String.format() : 따옴표가 꼬이지 않도록 하기 위함
            String sql = String.format("INSERT INTO fund(f_num, f_title, f_start_date, f_content) VALUES "
                    + "('%d', '%s', '%s', '%s')", dto.getF_num(), dto.getF_title(), dto.getF_start_date(), dto.getF_content());


            Log.i("상품번호 : ", "상품번호 : " + dto.getF_num());
            Log.i("상품명 : ", "상품명 : " + dto.getF_title());
            Log.i("시작일 : ", "시작일 : " +  dto.getF_start_date());
            Log.i("펀드내용 : ", "펀드내용 : " +  dto.getF_content());
            db.execSQL(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(db != null) db.close();
        }
    }
}
    

