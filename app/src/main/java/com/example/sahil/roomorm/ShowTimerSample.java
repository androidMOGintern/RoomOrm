package com.example.sahil.roomorm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;
import com.github.nkzawa.socketio.client.SocketIOException;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class ShowTimerSample extends AppCompatActivity {

    Socket mSocket;
    TextView timerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_timer_sample);

        MyApplication application = (MyApplication) getApplication();

        timerTextView = findViewById(R.id.timerTextView);
        gameStart();

//        mSocket = application.getSocket();
//
//        mSocket.on("time_left", new Emitter.Listener() {
//            @Override
//            public void call(final Object... args) {
//                ShowTimerSample.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        JSONObject response = (JSONObject) args[0];
//
//
//                        String time;
//
//                        try {
//                            time = response.getString("timeleft");
//                            timerTextView.setText(time);
//
//                            if(time.contentEquals("0")){
//
//                                gameStart();
//                            }
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//
//
//                        // TODO take user to Test_Sample for the quiz
//                    }
//                });
//            }
//        });
//
//    }

    }

    public void gameStart(){

        Intent intent = new Intent(this,Test_Sample.class);
        startActivity(intent);
    }
}
