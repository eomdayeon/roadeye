package com.example.roadeye;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
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
                open_popup(Gravity.CENTER);
                //show();
;
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
    private void open_popup(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup);

        Window window = dialog.getWindow();
        if(window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        dialog.setCancelable(false);
        Button btnno = dialog.findViewById(R.id.btn_no);
        Button btnyes = dialog.findViewById(R.id.btn_yes);

        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //영상 보내기
                Intent intent = new Intent(GalleryActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
        dialog.show();
    }

}
