package com.example.sahil.roomorm;

import android.app.Application;
import android.util.Log;

import com.github.nkzawa.socketio.client.IO;
import com.orm.SugarContext;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.Socket;
import java.net.URISyntaxException;

/**
 * Created by sahil on 4/3/18.
 */

public class MyApplication extends Application {

    private com.github.nkzawa.socketio.client.Socket socket;

    IO.Options options = new IO.Options();

    public com.github.nkzawa.socketio.client.Socket getSocket(){

        if(socket == null){


            {
                try {

                    options.query = "id=5a9fc952ef128734e48cd4fe" ;

                    socket = IO.socket("http://ec2-13-126-208-145.ap-south-1.compute.amazonaws.com:3000/",options );

                    socket.connect();

                    return socket;
                } catch (URISyntaxException e) {

                    Log.d("Errcon",e.getMessage());
                }
            }

        }

        return socket;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
