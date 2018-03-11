package com.example.sahil.roomorm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Results extends AppCompatActivity {

    ArrayList<Sample_Question_Model> question_models;
    ArrayList<String> toShow;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        question_models = new ArrayList<>();

        Intent intent = getIntent();
        question_models = (ArrayList<Sample_Question_Model>) intent.getSerializableExtra("answers");

        listView = findViewById(R.id.listView);

        toShow = new ArrayList<>();

        for (Sample_Question_Model q: question_models) {
            StringBuilder sb = new StringBuilder();
            sb.append(q.getQuestionId());
            sb.append(" QuestionID\n");
            sb.append(q.getTime());
            sb.append(" \n");
            sb.append(q.getType());

            toShow.add(sb.toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1,toShow);

        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent1 = new Intent(Intent.ACTION_MAIN);
        intent1.addCategory(Intent.CATEGORY_HOME);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
    }
}
