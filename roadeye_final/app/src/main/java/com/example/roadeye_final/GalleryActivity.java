package com.example.roadeye_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class GalleryActivity extends AppCompatActivity {

    private VideoView videoView; //비디오를 실행할 수 있게 도와주는 뷰
    Button button;
    Button btn_give;
    private  static final  int REQUEST_CODE = 0;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        button = findViewById(R.id.button);
        btn_give = findViewById(R.id.btn_give);
        videoView = findViewById(R.id.videoView); //비디오 뷰 아이디 연결

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("video/*");
                //Intent intent = new Intent();
                //intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        btn_give.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GalleryActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode==RESULT_OK){
                try{
                    Uri uri = data.getData();
                    //Glide.with(getApplicationContext()).load(uri).into(imageView);
                    mediaController=new MediaController(this);
                    mediaController.setAnchorView(videoView);
                    videoView.setMediaController(mediaController);
                    videoView.setVideoURI(uri); //비디오 뷰의 주소를 설정
                    videoView.start(); //비디오 실행

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(resultCode == RESULT_CANCELED){
            }
        }
    }
}