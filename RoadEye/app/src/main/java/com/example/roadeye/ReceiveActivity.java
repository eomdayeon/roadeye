package com.example.roadeye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class ReceiveActivity extends AppCompatActivity {

    private VideoView videoView; //비디오를 실행할 수 있게 도와주는 뷰
    private MediaController mediaController; //재생이나 정지와 같은 미디어 제어 버튼부를 담당
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        videoView = findViewById(R.id.videoView); //비디오 뷰 아이디 연결
        mediaController=new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/raw/project_video");
        videoView.setMediaController(mediaController); //미디어 제어 버튼부 세팅
        videoView.setVideoURI(uri); //비디오 뷰의 주소를 설정
        videoView.start(); //비디오 실행

        btn_back=findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReceiveActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }
}