//package com.example.sahil.roomorm;
//
//import android.app.Fragment;
//import android.graphics.Color;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.os.CountDownTimer;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.widget.CardView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.webkit.WebSettings;
//
//import com.airbnb.lottie.LottieAnimationView;
//
//import java.util.Locale;
//import java.util.concurrent.TimeUnit;
//
//import io.github.kexanie.library.MathView;
//
///**
// * Created by sahil on 19/1/18.
// */
//public class Sample_Test_Fragment extends android.support.v4.app.Fragment {
//
//
//    View view;
//
//
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        view = inflater.inflate(R.layout.sample_test_fragment_layout,container,false);
//
//        question_MathView = view.findViewById(R.id.question_MathView);
//        optionA_MathView = view.findViewById(R.id.question_optionA_MathView);
//        optionB_MathView = view.findViewById(R.id.question_optionB_MathView);
//        optionC_MathView = view.findViewById(R.id.question_optionC_MathView);
//        optionD_MathView = view.findViewById(R.id.question_optionD_MathView);
//
////        lottieAnimationView = view.findViewById(R.id.lottieView);
//        question_CardView = view.findViewById(R.id.cardView_question);
//        optionA_CardView = view.findViewById(R.id.cardView_optionA);
//        optionB_CardView = view.findViewById(R.id.cardView_optionB);
//        optionC_CardView = view.findViewById(R.id.cardView_optionC);
//        optionD_CardView = view.findViewById(R.id.cardView_optionD);
//
//
//
//        question_CardView.setEnabled(true);
//        optionA_CardView.setEnabled(true);
//        optionB_CardView.setEnabled(true);
//        optionC_CardView.setEnabled(true);
//        optionD_CardView.setEnabled(true);
//
//        mediaPlayer = new MediaPlayer();
//
//        this.onQuestionAnswered = (Sample_Test_Fragment.onQuestionAnswered) getActivity();
//
//        return view;
//    }
//
//
//
//
//    public void setListener(onQuestionAnswered listener){
//
//        this.onQuestionAnswered = listener;
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//
//        Bundle bundle = this.getArguments();
//
//        sampleQuestionModel = (Sample_Question_Model) bundle.getSerializable("question");
//
//        question_MathView.setTextSize(14);
//        optionA_MathView.setTextSize(14);
//        optionB_MathView.setTextSize(14);
//        optionC_MathView.setTextSize(14);
//        optionD_MathView.setTextSize(14);
//
//
//        if(sampleQuestionModel != null) {
//
//            question_MathView.setDisplayText(sampleQuestionModel.getQuestion());
//            optionA_MathView.setDisplayText(sampleQuestionModel.getOptionA());
//            optionB_MathView.setDisplayText(sampleQuestionModel.getOptionB());
//            optionC_MathView.setDisplayText(sampleQuestionModel.getOptionC());
//            optionD_MathView.setDisplayText(sampleQuestionModel.getOptionD());
//
//            startTime = System.currentTimeMillis();
//        }
//
//
//
//
//
//
//
//
//    }
//
//    public void setCorrectAns(){
//
//        String correctAns = sampleQuestionModel.getCorrectAns();
//
//        if(correctAns.contentEquals("A")){
//
//            optionA_CardView.setCardBackgroundColor(Color.GREEN);
//        }
//        else if(correctAns.contentEquals("B")){
//
//            optionB_CardView.setCardBackgroundColor(Color.GREEN);
//
//        }
//        else if(correctAns.contentEquals("C")){
//
//            optionC_CardView.setCardBackgroundColor(Color.GREEN);
//
//        }
//        else if(correctAns.contentEquals("D")){
//
//            optionD_CardView.setCardBackgroundColor(Color.GREEN);
//
//        }
//    }
//
//    public void saveQuestionTime(long eTime){
//
//        long timeToFormat = eTime - startTime;
//
//        sampleQuestionModel.setType("A");
//        String time = String.format("%02d min, %02d sec", TimeUnit.MILLISECONDS.toMinutes(timeToFormat),TimeUnit.MILLISECONDS.toSeconds(timeToFormat) - TimeUnit.MILLISECONDS.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeToFormat)));
//
//        StringBuilder sb = new StringBuilder();
//        int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(timeToFormat);
//        int min = (int) TimeUnit.MILLISECONDS.toMinutes(timeToFormat);
//
//        sb.append(min);
//        sb.append(" min ");
//        sb.append(seconds);
//        sb.append(" sec");
//        sampleQuestionModel.setTime(time);
//
//        Test_Sample.saveTime(sampleQuestionModel);
//    }
//
//    public interface onQuestionAnswered{
//
//        public void onQuestionAnswered();
//    }
//
//
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        killMediaPlayer();
//    }
//
//    private void killMediaPlayer(){
//
//        if(mediaPlayer != null){
//
//            try{
//
//                mediaPlayer.release();
//
//            }catch (Exception e){
//
//                e.printStackTrace();
//            }
//        }
//    }
//}