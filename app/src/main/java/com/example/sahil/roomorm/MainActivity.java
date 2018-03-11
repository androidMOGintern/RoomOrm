//package com.example.sahil.roomorm;
//
//import android.os.AsyncTask;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//
//    private static AppDatabase db;
//    ArrayList<SessionManager> sessionManagers;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        db = AppDatabase.getAppDatabase(this);
//        sessionManagers = new ArrayList<>();
//
//        SessionManager s = new SessionManager();
//        s.setToken("token-1");
//        s.setId(1);
//        SessionManager s2 = new SessionManager();
//        s2.setToken("token-2");
//        s.setId(2);
//        SessionManager s3 = new SessionManager();
//        s3.setToken("token-3");
//        s.setId(3);
//        sessionManagers.add(s);
//        sessionManagers.add(s2);
//        sessionManagers.add(s3);
//
//     //   loadSessions();
//
//
//
//    }
//
//    private void loadSessions() {
//
//        new DB_GetData().execute(sessionManagers);
//    }
//
//    private static class DB_GetData extends AsyncTask<ArrayList,Void,Void>{
//
//
//        @Override
//        protected Void doInBackground(ArrayList[] arrayLists) {
//            db.sessionDao().insertAll(arrayLists[0]);
//            return null;
//        }
//    }
//}
