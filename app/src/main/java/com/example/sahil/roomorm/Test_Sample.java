package com.example.sahil.roomorm;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.util.TimeUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;
import com.orm.SugarRecord;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.github.kexanie.library.MathView;

public class Test_Sample extends AppCompatActivity {


    boolean hasLifeLine = true;
    boolean isEliminated = false,isInViewMode,isEligible;
    boolean isLifeLineUsed = false,isQuizStarted;


    String LIVE_GAME_STATUS = "QUESTION_SHOW",USER_GAME_STATUS;

    MyApplication application;
    Socket mSocket;

    // #1 Questions Layout
    Chronometer chronometer;
    Question question;
    katex.hourglass.in.mathlib.MathView question_MathView;
    katex.hourglass.in.mathlib.MathView optionA_MathView;
    katex.hourglass.in.mathlib.MathView optionB_MathView;
    katex.hourglass.in.mathlib.MathView optionC_MathView;
    katex.hourglass.in.mathlib.MathView optionD_MathView;
    LottieAnimationView lottieAnimationView;

    CardView question_CardView;
    CardView optionA_CardView;
    CardView optionB_CardView;
    CardView optionC_CardView;
    CardView optionD_CardView;
    RelativeLayout relativeLayout;
//    private Sample_Test_Fragment.onQuestionAnswered onQuestionAnswered;

    long startTime;
    MediaPlayer mediaPlayer;
    Sample_Question_Model sampleQuestionModel;
    CountDownTimer timer;
    ProgressBar progressBar;
    boolean responseSent;
    LinearLayout bottomLinearLayout;
    TextView bottomMessageTextView;
    TextView timeToNext;


    ////////////////////////////////////////////////////////////////////////////////////////////////

    // #2 Correct + Incorrect too
    LottieAnimationView lottieAnimationView_Correct;
    LottieAnimationView lottieAnimationView_Incorrect;
    RelativeLayout correctORIncorrect_relativeLayout;
    boolean isCorrectResponseChosen;
    TextView sampleTextViewCorIC;

    ////////////////////////////////////////////////////////////////////////////////////////////////

    // #3 Response Layout
    ProgressBar optionA_pb,optionB_pb,optionC_pb,optionD_pb;
    RelativeLayout responseRelativeLayout;
    CountDownTimer timerResponseLayout;
    TextView responseMessage,timeTONxttvResponse;
    TextView optionA_Response,optionB_Response,optionC_Response,optionD_Response;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        setContentView(R.layout.activity_test__sample);

        application = (MyApplication) getApplication();

        mSocket = application.getSocket();

        // #1 QuestionsLayout

        relativeLayout = findViewById(R.id.questionRelativeLayout);

        question_MathView = findViewById(R.id.question_MathView);
        optionA_MathView = findViewById(R.id.question_optionA_MathView);
        optionB_MathView = findViewById(R.id.question_optionB_MathView);
        optionC_MathView = findViewById(R.id.question_optionC_MathView);
        optionD_MathView = findViewById(R.id.question_optionD_MathView);

        question_CardView = findViewById(R.id.cardView_question);
        optionA_CardView = findViewById(R.id.cardView_optionA);
        optionB_CardView = findViewById(R.id.cardView_optionB);
        optionC_CardView = findViewById(R.id.cardView_optionC);
        optionD_CardView = findViewById(R.id.cardView_optionD);

        question_CardView.setEnabled(true);
        optionA_CardView.setEnabled(true);
        optionB_CardView.setEnabled(true);
        optionC_CardView.setEnabled(true);
        optionD_CardView.setEnabled(true);

//        progressBar = findViewById(R.id.questionTimerProgressBar);
//        progressBar.setRotation(180);
//        progressBar.setIndeterminate(false);
//        progressBar.setMax(100);


        bottomLinearLayout = findViewById(R.id.bottomMessage);
        bottomMessageTextView = findViewById(R.id.textView_bottomMessage);
        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("%s");
        timeToNext = findViewById(R.id.questionTimerProgressBar);

        // #2 Correct/Incorrect Layout

        lottieAnimationView_Correct = findViewById(R.id.lottie_Correct);
        lottieAnimationView_Incorrect = findViewById(R.id.lottie_inCorrect);
        correctORIncorrect_relativeLayout = findViewById(R.id.correctORincorrectLayout);
        sampleTextViewCorIC = findViewById(R.id.sampleCorrectOrincorrectTV);

       // #3 Response Layout
//        optionA_pb = findViewById(R.id.optionA_responseProgressbar);
//        optionB_pb = findViewById(R.id.optionB_responseProgressbar);
//        optionC_pb = findViewById(R.id.optionC_responseProgressbar);
//        optionD_pb = findViewById(R.id.optionD_responseProgressbar);
//        optionA_pb.setScaleY(11f);
//        optionB_pb.setScaleY(11f);
//        optionC_pb.setScaleY(11f);
//        optionD_pb.setScaleY(11f);

        optionA_Response = findViewById(R.id.optionA_ResponseTextView);
        optionB_Response = findViewById(R.id.optionB_ResponseTextView);
        optionC_Response = findViewById(R.id.optionC_ResponseTextView);
        optionD_Response = findViewById(R.id.optionD_ResponseTextView);
        timeTONxttvResponse = findViewById(R.id.timeToNextTVResponse);

        responseMessage = findViewById(R.id.textView_responseHeaderCardView);
        responseRelativeLayout = findViewById(R.id.responseRelativeLayout);


        optionA_MathView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                optionA_CardView.setCardBackgroundColor(Color.BLUE);
                getAnswer("A");
            }
        });

        optionA_CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                optionA_CardView.setCardBackgroundColor(Color.BLUE);
                getAnswer("A");

            }
        });


        optionB_MathView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                optionB_CardView.setCardBackgroundColor(Color.BLUE);
                getAnswer("B");

            }
        });


        optionB_CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                optionB_CardView.setCardBackgroundColor(Color.BLUE);
                getAnswer("B");

            }
        });


        optionC_MathView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                optionC_CardView.setCardBackgroundColor(Color.BLUE);
                getAnswer("C");

            }
        });



        optionC_CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                optionC_CardView.setCardBackgroundColor(Color.BLUE);
                getAnswer("C");

            }
        });


        optionD_MathView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                optionD_CardView.setCardBackgroundColor(Color.BLUE);
                getAnswer("D");
            }
        });



        optionD_CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                optionD_CardView.setCardBackgroundColor(Color.BLUE);
                getAnswer("D");

            }
        });
    ////////////////////////////////////////////////////////////////////////////////////////////////




        mSocket.on("time_left", new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                Test_Sample.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        JSONObject response = (JSONObject) args[0];
                        Log.d("checkrea",Arrays.toString(args));

                        String timeNextQuestionIn,timeleft;
                        try {
                            timeleft = response.getString("timeleft");
                            timeNextQuestionIn = response.getString("nextQuestionIn");


                            if(LIVE_GAME_STATUS.contentEquals("QUESTION_SHOW")){

                                timeToNext.setText("Time left - " + timeleft);
                                if(timeleft.contentEquals("1")){
                                    showResponseLayout();

                                    relativeLayout.setVisibility(View.GONE);
                                }



                            }
                            if(LIVE_GAME_STATUS.contentEquals("RESPONSE_SCREEN")){

                                timeTONxttvResponse.setText("Time to next - " + timeNextQuestionIn);

                                if(timeNextQuestionIn.contentEquals("1")){
                                    responseRelativeLayout.setVisibility(View.GONE);

                                    if(isEliminated){

                                        Toast.makeText(Test_Sample.this, "Eliminated", Toast.LENGTH_SHORT).show();

                                    }else if(isLifeLineUsed){

                                        Toast.makeText(Test_Sample.this, "LifeLine used", Toast.LENGTH_SHORT).show();


                                    }

                                }

                                //

                            }

                        } catch (JSONException e) {

                        }


                    }
                });
            }
        });


        mSocket.on("session_over", new Emitter.Listener() {
            @Override
            public void call(final Object... args) {

                Test_Sample.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("checkrea",Arrays.toString(args));

                        Toast.makeText(Test_Sample.this, "Session_OVer", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        mSocket.on("common_error", new Emitter.Listener() {
            @Override
            public void call(final Object... args) {

                Test_Sample.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("checkrea",Arrays.toString(args));

                        Toast.makeText(Test_Sample.this, "common_error" + args[0].toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        mSocket.on("get_question", new Emitter.Listener() {
            @Override
            public void call(final Object... args) {

                LIVE_GAME_STATUS = "QUESTION_SHOW";

                Test_Sample.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject response = (JSONObject) args[0];
                        Log.d("checkrea",Arrays.toString(args));

                        try {

                            USER_GAME_STATUS = response.getString("game_status");
                            String questionStr = response.getString("questionText");
                            String id = response.getString("_id");
                            JSONArray options = response.getJSONArray("options");


                            JSONObject optionAObj = (JSONObject) options.get(0);
                            String optionA = optionAObj.getString("value");

                            JSONObject optionBObj = (JSONObject) options.get(1);
                            String optionB = optionBObj.getString("value");

                            JSONObject optionCObj = (JSONObject) options.get(2);
                            String optionC = optionCObj.getString("value");

//                            JSONObject optionDObj = (JSONObject) options.get(0);
                            String optionD = optionAObj.getString("value");

                            question = new Question(questionStr,optionA,optionB,optionC,optionD,id);
                            question_MathView.setDisplayText(question.getQuestion());
                            optionA_MathView.setDisplayText(question.getOptionA());
                            optionB_MathView.setDisplayText(question.getOptionB());
                            optionC_MathView.setDisplayText(question.getOptionC());
                            optionD_MathView.setDisplayText(question.getOptionD());
                            showQuestionLayout();


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("checkrea","get_question - " + e.getMessage());
                            Log.d("checkrea","get_question - " + e.toString());
                            Toast.makeText(Test_Sample.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }


                    }
                });
            }
        });

        mSocket.on("questionDetails", new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                Test_Sample.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject response = (JSONObject) args[0];
                        Log.d("checkrea", Arrays.toString(args));

                        try {
                            USER_GAME_STATUS = response.getString("state");
                            String questionId = response.getString("question_id");
                            String option1_Count = response.getString("option1_count");
                            String option2_Count = response.getString("option2_count");
                            String option3_Count = response.getString("option3_count");
                            String option4_Count = response.getString("option1_count");

                            String correct_option = response.getString("correct_option");

//                            String time_taken = response.getString("time_taken");
                            String lease_time_Taken = response.getString("least_time_taken");

                            String message;

                            if(USER_GAME_STATUS.contentEquals("active1")){

                                message = "Correct";
                                Toast.makeText(Test_Sample.this, "Correct ans active1", Toast.LENGTH_SHORT).show();
                            }
                            else if(USER_GAME_STATUS.contentEquals("active2")){

                                message = "Incorrect with Lifeline";
                                isLifeLineUsed = true;
                                Toast.makeText(Test_Sample.this, "LifeLine used active2", Toast.LENGTH_SHORT).show();


                            }else if(USER_GAME_STATUS.contentEquals("inactive1")){

                                message = "Incorrect without lifeline";
                                isEliminated = true;
                                Toast.makeText(Test_Sample.this, "Incorrect without lifeline inactive1", Toast.LENGTH_SHORT).show();


                            }else{

                                message = "No response";
                                isEliminated = true;
                                Toast.makeText(Test_Sample.this, "NO response inactive2", Toast.LENGTH_SHORT).show();
                            }


                            responseMessage.setText(message + "\n" + USER_GAME_STATUS +"\n"+ "correct_option -" + correct_option + "\n" + "least time - " + lease_time_Taken);
                            // TODO Check message and set the responseTextView accordingly
                            // TODO set the progress of the option progress barsl
                            optionA_Response.setText("Option 1 count  - " + option1_Count);
                            optionB_Response.setText("Option 2 count  - " + option2_Count);
                            optionC_Response.setText("Option 3 count  - " + option3_Count);
                            optionD_Response.setText("Option 4 count  - " + option4_Count);

                        } catch (JSONException e) {
                            e.printStackTrace();

                            e.printStackTrace();
                            Log.d("checkrea","questionDetails - " + e.getMessage());
                            Log.d("checkrea","questionDetails - " + e.toString());
                            Toast.makeText(Test_Sample.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    ////////////////////////////////////////////////////////////////////////////////////////////////
//        Intent intent = getIntent();
//        isQuizStarted = intent.getBooleanExtra("QUIZ_STARTED",true);
//        isEligible = intent.getBooleanExtra("ELIGIBLE",true);
//
//        if(isQuizStarted && isEligible){
//
//            isInViewMode = false;
//        }else{
//
        
//            isInViewMode = true;
//        }
        // TODO fetch from the socket if the quiz start then call showQuestionLayout()
        // TODO if the user is late then check which event is going on and take him there and setthe linear layout visible with the message

    }

    // #1 Questions Layout
    private void getAnswer(String option) {

        chronometer.stop();
        disableAllCards();
        long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
        String timeInSeconds = String.valueOf(elapsedMillis/1000);
        Log.d("chrono",timeInSeconds);
        Toast.makeText(this, timeInSeconds, Toast.LENGTH_SHORT).show();

       sendResponse(option,timeInSeconds);
    }

    private void sendResponse(String option,String timeTaken) {


        // TODO send response to server
        JSONObject toSend = new JSONObject();

        String answer;

        if(option.contentEquals("A")){

            answer = question.getOptionA();
        }
        else if(option.contentEquals("B")){

            answer = question.getOptionB();
        }
        else if(option.contentEquals("C")){

            answer = question.getOptionC();
        }
        else {

            answer = question.getOptionD();
        }

        int time = Integer.parseInt(timeTaken);

        if(time == 0){

            time = 1;
        }

        try {

            toSend.put("Answer",answer);

            toSend.put("timeTaken",time);

            toSend.put("_id",question.getId());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("checkrea",e.toString());
            Log.d("checkrea",e.getMessage());

        }

        mSocket.emit("answer_question",toSend);
        Log.d("checkrea","answer sent - " + toSend.toString());

    }

    public void showQuestionLayout(){

        relativeLayout.setVisibility(View.VISIBLE);
        enableAllCards();
        chronometer.start();
        chronometer.setBase(SystemClock.elapsedRealtime());
        optionA_CardView.setCardBackgroundColor(Color.WHITE);
        optionB_CardView.setCardBackgroundColor(Color.WHITE);
        optionC_CardView.setCardBackgroundColor(Color.WHITE);
        optionD_CardView.setCardBackgroundColor(Color.WHITE);




        if(isEliminated) {
            chronometer.stop();
            bottomLinearLayout.setVisibility(View.VISIBLE);
            bottomMessageTextView.setText("Eliminated");
            disableAllCards();
        }

        if(isInViewMode){
            chronometer.stop();
            bottomLinearLayout.setVisibility(View.VISIBLE);
            bottomMessageTextView.setText("View Mode");
            disableAllCards();
        }


    }

    public void enableAllCards(){
        optionA_CardView.setEnabled(true);
        optionB_CardView.setEnabled(true);
        optionC_CardView.setEnabled(true);
        optionD_CardView.setEnabled(true);

        optionA_MathView.setClickable(true);
        optionB_MathView.setClickable(true);
        optionC_MathView.setClickable(true);
        optionD_MathView.setClickable(true);

    }

    public void startTimer(){

//        timer = new CountDownTimer(15000,1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//
////                progressBar.setProgress((int) (millisUntilFinished / 60000) * 100);
////
//                timeToNext.setText("Time to next question - " + String.valueOf(millisUntilFinished/1000));
//
//            }
//
//            @Override
//            public void onFinish() {
//
//                timer.cancel();
//
//                showCorrectorIncorrectLayout();
//
//                if(!responseSent){
//
//                    sendResponse("E");
//                }
//                // TODO take the user to #2 screen
//
//
//            }
//        }.start();

    }



    private void fetchAndSetData() {

        // TODO Get questions and options from socket and then show them.



    }



    public void disableAllCards(){

        if(!isEliminated) {
            Snackbar snackbar = Snackbar.make(relativeLayout, "Answer Locked", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        optionA_CardView.setEnabled(false);
        optionB_CardView.setEnabled(false);
        optionC_CardView.setEnabled(false);
        optionD_CardView.setEnabled(false);

        optionA_MathView.setClickable(false);
        optionB_MathView.setClickable(false);
        optionC_MathView.setClickable(false);
        optionD_MathView.setClickable(false);
    }




    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // #2 Correct or Incorrect Layout

    public void showCorrectorIncorrectLayout(String option){

        long timeToNext;

        LIVE_GAME_STATUS = "CORRECT_OR_INCORRECT";

        correctORIncorrect_relativeLayout.setVisibility(View.VISIBLE);

        if(isCorrectResponseChosen){

//            correctORIncorrect_relativeLayout.setBackgroundColor(Color.GREEN);
            lottieAnimationView_Correct.setVisibility(View.VISIBLE);
            sampleTextViewCorIC.setText("correct ans");
            timeToNext = lottieAnimationView_Correct.getDuration();

        }else{

//            correctORIncorrect_relativeLayout.setBackgroundColor(Color.RED);
            sampleTextViewCorIC.setText("incorrect ans");

            lottieAnimationView_Incorrect.setVisibility(View.VISIBLE);

            timeToNext = lottieAnimationView_Incorrect.getDuration();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                correctORIncorrect_relativeLayout.setVisibility(View.GONE);
              //  showResponseLayout();

            }
        },timeToNext + 500);

    }

////////////////////////////////////////////////////////////////////////////////////////////////////

    // #3 Response Layout

    public void showResponseLayout(){

        responseRelativeLayout.setVisibility(View.VISIBLE);
        LIVE_GAME_STATUS = "RESPONSE_SCREEN";
    }

    private void setResponseData(String message,String optionA_markedNumber,String optionB_markedNumber,String optionC_markedNumber,String optionD_markedNumber,String time_taken,String leastTime,String totalMarked) {

    //    setResponseTimer();


    }




    public void setResponseTimer(){

        timerResponseLayout = new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                timeTONxttvResponse.setText("Time to next question - " + String.valueOf((int)millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {

                timer.cancel();

                if(!isEliminated) {

                    if (!isCorrectResponseChosen) {

                        if (hasLifeLine && !isLifeLineUsed) {

                            isLifeLineUsed = true;
                            // TODO send message to server that lifeline used


                        } else {

                            isEliminated = true;


                            // TODO show alert dialog message that you are eliminated and set eliminated conditions;
                        }

                        // TODO take the user to respective stage either withlifeline or eliminate.

                    }
                }




            }
        }.start();
    }












//
//
//    public void endTest(){
//
//        Intent intent = new Intent(this,Results.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.putExtra("answers",question_models);
//        startActivity(intent);
//    }
//
//    public void loadNextQuestion(){
//        ++currQuestion;
//
//        if(currQuestion < toShowQuestions.size()){
//
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            Fragment fragment = new Sample_Test_Fragment();
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("question",toShowQuestions.get(currQuestion));
//            fragment.setArguments(bundle);
//            fragmentTransaction.replace(R.id.sample_test_container,fragment);
//            startTime = System.currentTimeMillis();
//            fragmentTransaction.addToBackStack(null).commit();
//        }else{
//
//            endTest();
//        }
//    }
//
//
//
//
//    public static void saveTime(Sample_Question_Model question_model){
//
//        if(!question_models.contains(question_model)) {
//
//            Log.d("checkTime", String.valueOf(question_model.getQuestionId()));
//            Log.d("checkTime", question_model.getTime());
//            SugarRecord.save(question_model);
//            question_models.add(question_model);
//
//        }
//    }
//
//
//    @Override
//    public void onQuestionAnswered() {
//        loadNextQuestion();
//    }
//



}
