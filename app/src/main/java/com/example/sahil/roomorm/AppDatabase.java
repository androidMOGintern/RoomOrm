//package com.example.sahil.roomorm;
//
//import android.arch.persistence.room.Database;
//import android.arch.persistence.room.Room;
//import android.arch.persistence.room.RoomDatabase;
//import android.content.Context;
//
///**
// * Created by sahil on 14/1/18.
// */
//
//@Database(entities = {SessionManager.class},version = 1)
//public abstract class AppDatabase  extends RoomDatabase {
//
//    private static AppDatabase INSTANCE;
//
//    public abstract SessionDao sessionDao();
//
//    public static AppDatabase getAppDatabase(Context context){
//
//        if(INSTANCE == null){
//
//            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
//                    AppDatabase.class, "MySampleDB").build();
//        }
//
//        return INSTANCE;
//    }
//
//
//}
