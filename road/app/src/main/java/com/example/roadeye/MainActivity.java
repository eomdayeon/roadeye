package com.example.roadeye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;



public class MainActivity extends AppCompatActivity {
    private Button btn_register;
    private Button btn_login;
//    private Button sendBtn;
//    private Socket socket;
//    {
//        try {
//            socket = IO.socket("http://192.168.0.10:5000");
//            Log.d("SOCKET", "Connection success : " + socket.id());
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_register=findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });

        btn_login=findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

//
//        socket.on("connection", onMessage);
//        socket.connect();
//
//        sendBtn=findViewById(R.id.btn_findid);
//        sendBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                socket.emit("location", "hi");
//                Log.e("send", "data");
//            }
//        });



    }


//    private Emitter.Listener onMessage = new Emitter.Listener() {
//        @Override
//        public void call(Object... args) {
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    String data = (String) args[0];
//                    Log.e(
//                            "get", data);
//                }
//            });
//        }
//    };
}