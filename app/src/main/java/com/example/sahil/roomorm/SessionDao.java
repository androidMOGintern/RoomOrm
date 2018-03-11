//package com.example.sahil.roomorm;
//
//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Insert;
//import android.arch.persistence.room.OnConflictStrategy;
//import android.arch.persistence.room.Query;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by sahil on 12/1/18.
// */
//@Dao
//public interface SessionDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insertAll(ArrayList<SessionManager> sessionManagers);
//
////    @Insert
////    void insertSession(String token);
//
//    @Query("SELECT token FROM sessionmanager WHERE session_id = 1")
//    String getSession();
//
//    @Query("SELECT * FROM sessionmanager")
//    List<SessionManager> getAll();
//
//}
