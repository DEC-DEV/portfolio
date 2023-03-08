package com.example.kosmobank;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JoinActivity extends Activity {

    private static final String TAG = "태그명";
    EditText id, password, name, zipcode, address, address_detail, phone, email;
    Button btn_send; // 회원가입 버튼
    Button btn_photo; // 신분증인식 버튼


    String mCurrentPhotoPath;
    final static int REQUEST_TAKE_PHOTO = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        id = (EditText) findViewById(R.id.edt_id);
        password = (EditText) findViewById(R.id.edt_password);
        name = (EditText) findViewById(R.id.edt_name);
        zipcode = (EditText) findViewById(R.id.edt_zipCode);
        address = (EditText) findViewById(R.id.edt_address);
        address_detail = (EditText) findViewById(R.id.edt_address_detail);
        phone = (EditText) findViewById(R.id.edt_phone);
        email = (EditText) findViewById(R.id.edt_email);
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_photo = findViewById(R.id.btn_photo);

        btn_send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "가입하기 클릭", Toast.LENGTH_SHORT).show();
                InnerTask task = new InnerTask();

                Map<String, String> map = new HashMap<String, String>();
                map.put("id", id.getText().toString());
                map.put("password", password.getText().toString());
                map.put("name", name.getText().toString());
                map.put("zipcode", zipcode.getText().toString());
                map.put("address", address.getText().toString());
                map.put("address_detail", address_detail.getText().toString());
                map.put("phone", phone.getText().toString());
                map.put("email", email.getText().toString());

                task.execute(map);
            }
        });
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "권한 설정 완료");
            }
            else {
                ActivityCompat.requestPermissions(JoinActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                Log.d(TAG, "권한 설정 요청");
            }
        }

        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });
    }


    // 앱 카메라 권한 요청
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "onRequestPermissionsResult");
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED ) {
            Log.d(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
        }
    }

    // 이미지를 파일로 저장(경로 지정 함수)
    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File image = File.createTempFile(
                imageFileName, // prefix
                ".jpg", // suffix
                storageDir  // directory
        );
        Log.d("이미지에 담긴 값", String.valueOf(image));

        mCurrentPhotoPath = image.getAbsolutePath();
        Log.d("mCurrentPhotoPath:", mCurrentPhotoPath);
        return image;
    }

    // 카메라 인텐트 실행하는 부분
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Log.d("takePictureIntent", String.valueOf(takePictureIntent.resolveActivity(getPackageManager())));
        if(takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null; // 사진 파일 path

            try {
                photoFile = createImageFile(); // photoFile 위에 선언했음
                Log.d("photoFile에 담긴 값", String.valueOf(photoFile));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if(photoFile != null) {
                Log.d("aaaaaaaaa", "aaaaaaaaaa");
                Uri photoURI = FileProvider.getUriForFile(this, "com.example.kosmobank.fileprovider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                Log.d("takePicture에 담긴 값", String.valueOf(takePictureIntent));
                System.out.println("값 : " + String.valueOf(takePictureIntent));
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    // 사진 찍으면 API로 연결
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Log.d("onActivityResult", "onActivityResult탔음");
        try {
            switch (requestCode) {
                case REQUEST_TAKE_PHOTO: {
                    if (resultCode == RESULT_OK) {
                        Log.d("onActi-mcurrentPho", String.valueOf(mCurrentPhotoPath));
                        File photoFile = new File(mCurrentPhotoPath);
                        Bitmap bitmap;
                        if (Build.VERSION.SDK_INT >= 29) {
                            ImageDecoder.Source source = ImageDecoder.createSource(getContentResolver(), Uri.fromFile(photoFile));
                            try {
                                bitmap = ImageDecoder.decodeBitmap(source);
                                if (bitmap != null) { // 성공1
                                    Log.d("bitmap1", String.valueOf(bitmap));
                                    Log.d("file", String.valueOf(photoFile));

                                    // 스프링 연동 시작
                                    String sendingFile = String.valueOf(photoFile);
                                    InnerTask2 task = new InnerTask2(); // 스프링단으로 보내기 위함
                                    Map<String, String> map = new HashMap<>();
                                    map.put("file", sendingFile);
                                    task.execute(map);

                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(photoFile));
                                if (bitmap != null) { // 성공2
                                    Log.d("bitmap2", String.valueOf(bitmap));
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                }
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
    }


    /*

    ① 생성자 만들기
    ② onPreExecute() : 넘겨받은 객체들에 초기화가 필요할때 사용
    ③ doInBackGround  : 대부분의 기능들은 여기다 작성
    ④ onProgressUpdate : 필요하면 씀, 안쓰면 매개 변수의 Integer를 Void로 바꿔준다
    ⑤ onPostExecute() : String도 필요하면 쓰고 안쓰면 String을 Void로 바꿔준다

     */
    public class InnerTask extends AsyncTask<Map, Integer, String> {

        @Override
        protected String doInBackground(Map... maps) {

            HttpClient.Builder http = new HttpClient.Builder("POST", Web.servletURL + "androidJoin"); //스프링 컨트롤러 requestMapping("androidSignIn")            //파라미터 전송
            http.addAllParameters(maps[0]);

            HttpClient post = http.create();
            post.request();

            String body = post.getBody();
            Log.d("body", body);
            return body;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d("JSON_RESULT", s);

            if(s.length() > 0) {
                Gson gson = new Gson();
                ResultDTO vo = gson.fromJson(s, ResultDTO.class);
                Log.d("insertCnt", String.valueOf(vo.getInsertCnt()));
                if(vo.getInsertCnt() != 0) {
                    Toast.makeText(getApplicationContext(), "가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(JoinActivity.this, SignInActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "회원가입 실패", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "회원가입 실패", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class InnerTask2 extends AsyncTask<Map, Integer, String> {

        @Override
        protected String doInBackground(Map... maps) {
            Log.d("doInBackground 탔음", "탔다다다다다다다다ㅏ");
            HttpClient.Builder http = new HttpClient.Builder("POST", Web.servletURL + "androidOcr");
            http.addAllParameters(maps[0]);

            HttpClient post = http.create();
            post.request();

            String body = post.getBody();
            Log.d("body", body);
            return body;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d("JSON_RESULT", s);

            if(s.length() > 0) {
                        Gson gson = new Gson();
                        OcrDTO vo = gson.fromJson(s, OcrDTO.class);
                        Log.d("name", String.valueOf(vo.getName()));
                        Log.d("address1", String.valueOf(vo.getAddress1()));
                        Log.d("address2", String.valueOf(vo.getAddress2()));
                        if(vo.getName() != null) { // 가져온 값이 있으면 이름 세팅
                            name.setText(vo.getName());
                            address.setText(vo.getAddress1());
                            address_detail.setText(vo.getAddress2());
                        } else {
                            Toast.makeText(getApplicationContext(), "이름 값 없다", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "가져온 값 없다", Toast.LENGTH_SHORT).show();
            }
        }
    }



}