package com.example.sahil.roomorm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.nishant.math.MathView;

import org.json.JSONException;
import org.json.JSONObject;

import static io.github.kexanie.library.MathView.Engine.KATEX;

public class nishant_mathview extends AppCompatActivity {

//    katex.hourglass.in.mathlib.MathView mathView1;
//    katex.hourglass.in.mathlib.MathView mathView2;
//    katex.hourglass.in.mathlib.MathView mathView3;
//    katex.hourglass.in.mathlib.MathView mathView4;
//    katex.hourglass.in.mathlib.MathView mathView5;

    io.github.kexanie.library.MathView mathView1;
    io.github.kexanie.library.MathView mathView2;
    io.github.kexanie.library.MathView mathView3;
    io.github.kexanie.library.MathView mathView4;
    io.github.kexanie.library.MathView mathView5;

    katex.hourglass.in.mathlib.MathView mathView6;
    katex.hourglass.in.mathlib.MathView mathView7;
    katex.hourglass.in.mathlib.MathView mathView8;
    katex.hourglass.in.mathlib.MathView mathView9;
    katex.hourglass.in.mathlib.MathView mathView10;
    katex.hourglass.in.mathlib.MathView mathView11;
    katex.hourglass.in.mathlib.MathView mathView12;
    katex.hourglass.in.mathlib.MathView mathView13;
    katex.hourglass.in.mathlib.MathView mathView14;
    katex.hourglass.in.mathlib.MathView mathView15;

    String question,optionA,optionB,optionC,optionD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nishant_mathview);

      //  AndroidNetworking.initialize(getApplicationContext());

//        mathView1 = findViewById(R.id.mathview1);
//        mathView2 = findViewById(R.id.mathview2);
//        mathView3 = findViewById(R.id.mathview3);
//        mathView4 = findViewById(R.id.mathview4);
//        mathView5 = findViewById(R.id.mathview5);
        mathView6 = findViewById(R.id.mathview6);
        mathView7 = findViewById(R.id.mathview7);
        mathView8 = findViewById(R.id.mathview8);
        mathView9 = findViewById(R.id.mathview9);
        mathView10 = findViewById(R.id.mathview10);
        mathView11 = findViewById(R.id.mathview11);
        mathView12 = findViewById(R.id.mathview12);
        mathView13 = findViewById(R.id.mathview13);
        mathView14 = findViewById(R.id.mathview14);
        mathView15 = findViewById(R.id.mathview15);

//        mathView1.setTextSize(14);
//        mathView2.setTextSize(14);
//        mathView3.setTextSize(14);
//        mathView4.setTextSize(14);
//        mathView5.setTextSize(14);
        mathView6.setTextSize(14);
        mathView7.setTextSize(14);
        mathView8.setTextSize(14);
        mathView9.setTextSize(14);
        mathView10.setTextSize(14);
        mathView11.setTextSize(14);
        mathView12.setTextSize(14);
        mathView13.setTextSize(14);
        mathView14.setTextSize(14);
        mathView15.setTextSize(14);

//
//
//        mathView1.config(
//                "MathJax.Hub.Config({\n"+
//                        "  CommonHTML: { linebreaks: { automatic: true } },\n"+
//                        "  \"HTML-CSS\": { linebreaks: { automatic: true } },\n"+
//                        "         SVG: { linebreaks: { automatic: true } }\n"+
//                        "});");
//
//        mathView2.config(
//                "MathJax.Hub.Config({\n"+
//                        "  CommonHTML: { linebreaks: { automatic: true } },\n"+
//                        "  \"HTML-CSS\": { linebreaks: { automatic: true } },\n"+
//                        "         SVG: { linebreaks: { automatic: true } }\n"+
//                        "});");
//
//        mathView3.config(
//                "MathJax.Hub.Config({\n"+
//                        "  CommonHTML: { linebreaks: { automatic: true } },\n"+
//                        "  \"HTML-CSS\": { linebreaks: { automatic: true } },\n"+
//                        "         SVG: { linebreaks: { automatic: true } }\n"+
//                        "});");
//
//        mathView4.config(
//                "MathJax.Hub.Config({\n"+
//                        "  CommonHTML: { linebreaks: { automatic: true } },\n"+
//                        "  \"HTML-CSS\": { linebreaks: { automatic: true } },\n"+
//                        "         SVG: { linebreaks: { automatic: true } }\n"+
//                        "});");
//
//        mathView5.config(
//                "MathJax.Hub.Config({\n"+
//                        "  CommonHTML: { linebreaks: { automatic: true } },\n"+
//                        "  \"HTML-CSS\": { linebreaks: { automatic: true } },\n"+
//                        "         SVG: { linebreaks: { automatic: true } }\n"+
//                        "});");
     //   setData();


        mathView6.setDisplayText("The differential equation whose solution is a circle centre at $$(h, k)$$ and radius $$a$$ is ($$a$$ is a constant)\n");


        mathView7.setDisplayText("(a)\t$${\\left\\{ {1 + {{\\left( {\\frac{{dy}}{{dx}}} \\right)}^2}} \\right\\}^3} = {a^2}\\frac{{{d^2}y}}{{d{x^2}}}$$\t\n");
        mathView8.setDisplayText("(b)\t$${\\left\\{ {1 + {{\\left( {\\frac{{dy}}{{dx}}} \\right)}^2}} \\right\\}^3} = {a^2}{\\left( {\\frac{{{d^2}y}}{{d{x^2}}}} \\right)^2}$$");
        mathView9.setDisplayText("(c)\t$${\\left\\{ {1 + \\left( {\\frac{{dy}}{{dx}}} \\right)} \\right\\}^3} = {a^2}{\\left( {\\frac{{{d^2}y}}{{d{x^2}}}} \\right)^2}$$\t\n");
        mathView10.setDisplayText("(d)\tnone of these\n");


    }


//        AndroidNetworking.get("http://localhost:3010/sample")
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//
//                        try {
//                            question = response.getString("question");
//                            optionA = response.getString("option_a");
//                            optionB = response.getString("option_b");
//                            optionC = response.getString("option_c");
//                            optionD = response.getString("option_d");
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                        setData();
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//
//
//                        Log.d("conero", anError.getMessage());
//                        Log.d("conero", anError.getLocalizedMessage());
//                        Log.d("conero", anError.getErrorDetail());
//                        Log.d("conero", String.valueOf(anError.getErrorCode()));
//                        Log.d("conero", anError.getErrorBody());
//                        Toast.makeText(nishant_mathview.this, anError.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//d
//        }

    private void setData() {

        mathView1.setText("If \\(A = \\left[ \\begin{matrix}i&0\\0&i\\end{matrix} \\right]\\), then \\(A^n\\) is equal to \\((i = \\sqrt { - 1} )\\)");
        mathView2.setText("(a) \\(A\\( for \\)n = 4\\)");
        mathView3.setText("(b) \\(-A\\( for \\)n = 6\\)");
        mathView4.setText("(c) \\(-I\\( for \\)n = 5\\)");
        mathView5.setText("(d) \\(I\\( for \\)n = 8\\)");
    }


}


//
//        mathView2.setDisplayText("32.\n" +
//                "\n" +
//                "If $$$A = \\left[ \\begin{matrix} 1& 0\\\\ -1& 7\\end{matrix} \\right]$$ and $$A^2 = 8A + kI_2$$ then $$k$$ equals\n" +
//                "\n" +
//                "(a) $$1$$\n" +
//                "\n" +
//                "(b) $$-1$$\n" +
//                "\n" +
//                "(c) $$7$$\n" +
//                "\n" +
//                "(d) $$-7$$");
//
//
//        mathView3.setDisplayText("33.\n" +
//                "\n" +
//                "If $$\\left[ \\begin{matrix} {\\cos^2\\theta}& \\cos \\theta \\sin \\theta\\\\ \\cos \\theta \\sin \\theta& {\\sin^2\\theta}\\end{matrix} \\right]$$ $$\\left[ \\begin{matrix} {\\cos^2\\phi}& \\cos \\phi \\sin \\phi\\\\ \\cos \\phi \\sin \\phi& {\\sin^2\\phi}\\end{matrix} \\right]$$ is zero matrix then $$\\theta$$ and $$\\phi$$ differ by\n" +
//                "\n" +
//                "(a) even multiple of $$\\frac{\\pi }{2}$$\n" +
//                "\n" +
//                "(b) odd multiple of $$\\frac{\\pi }{2}$$\n" +
//                "\n" +
//                "(c) even multiple of $$\\pi$$\n" +
//                "\n" +
//                "(d) none of these");
//
//
//        mathView4.setDisplayText("34.\n" +
//                "\n" +
//                "$$\\left[ \\begin{matrix} 1 \\\\ -2 \\\\ 3\\end{matrix} \\right] \\times \\left[ \\begin{matrix} 4 & 5 & 2\\end{matrix} \\right] \\times \\left[ \\begin{matrix} 2 \\\\ -3 \\\\ 5\\end{matrix} \\right] \\times \\left[ \\begin{matrix} 3 & 2 & 1\\end{matrix} \\right]$$ is a matrix of order:\n" +
//                "\n" +
//                "(a) $$1 \\times 1$$\n" +
//                "\n" +
//                "(b) $$3 \\times 1$$\n" +
//                "\n" +
//                "(c) $$1 \\times 3$$\n" +
//                "\n" +
//                "(d) $$3\\times 3$$");
//
//
//        mathView5.setDisplayText("35.\n" +
//                "\n" +
//                "The value of $$\\left[ \\begin{matrix} 1 \\\\ 2 \\\\ 3\\end{matrix} \\right] \\times \\left[ \\begin{matrix} 3 & 2 & 4\\end{matrix} \\right] \\times \\left[ \\begin{matrix} 4 \\\\ 6 \\\\ 7\\end{matrix} \\right]$$ equals\n" +
//                "\n" +
//                "(a) $$\\left[ \\begin{matrix} 52 \\\\ -104 \\\\ 156\\end{matrix} \\right]$$\n" +
//                "\n" +
//                "(b) $$\\left[ \\begin{matrix} 52 & -104 & 156\\end{matrix} \\right]$$\n" +
//                "\n" +
//                "(c) $$\\left[ \\begin{matrix} 52 \\\\ 104 \\\\ 156\\end{matrix} \\right]$$\n" +
//                "\n" +
//                "(d) does not define");
//
//
//        mathView6.setDisplayText("36.\n" +
//                "\n" +
//                "If $$A = \\left[ \\begin{matrix} 1&3 \\\\ 2&4 \\end{matrix} \\right]$$ and $$B = \\left[ \\begin{matrix} 1&4 \\\\ 2&5 \\end{matrix} \\right]$$, then $$(AB)\\prime$$ equals\n" +
//                "\n" +
//                "(a) $$\\left[ \\begin{matrix} 1&3\\\\ 2&4 \\end{matrix} \\right]\\,\\,\\left[ \\begin{matrix} 1&4\\\\ 2&5 \\end{matrix} \\right]$$\n" +
//                "\n" +
//                "(b) $$\\left[ \\begin{matrix} 1&4\\\\ 2&5 \\end{matrix} \\right]\\,\\,\\left[ \\begin{matrix} 1&3\\\\ 2&4 \\end{matrix} \\right]$$\t\n" +
//                "\n" +
//                "(c) $$\\left[ \\begin{matrix} 1&2\\\\ 3&4 \\end{matrix} \\right]\\,\\,\\left[ \\begin{matrix} 1&2\\\\ 4&5 \\end{matrix} \\right]$$\n" +
//                "\n" +
//                "(d) $$\\left[ \\begin{matrix} 1&2\\\\ 4&5 \\end{matrix} \\right]\\,\\,\\left[ \\begin{matrix} 1&2\\\\ 3&4 \\end{matrix} \\right]$$\n");
//
//
//        mathView7.setDisplayText("37.\n" +
//                "\n" +
//                "If $$A = \\left[ \\begin{matrix}3&{ - 4}\\\\1&{ - 1}\\end{matrix} \\right]\\,,$$ then $$A^n$$ is equal to\n" +
//                "\n" +
//                "(a) $$\\left[ \\begin{matrix}{{3^n}}&{{{( - 4)}^n}}\\\\1&{{{( - 1)}^n}}\\end{matrix} \\right]$$\n" +
//                "\n" +
//                "(b) $$\\left[ \\begin{matrix}{1 + 3n}&{1 - 4n}\\\\{1 + n}&{1 - n}\\end{matrix} \\right]$$\t\n" +
//                "\n" +
//                "(c) $$\\left[ \\begin{matrix}{1 + 2n}&{ - 4n}\\\\{2n - 2}&{1 - 2n}\\end{matrix} \\right]$$\n" +
//                "\n" +
//                "(d) $$\\left[ \\begin{matrix}{1 + 2n}&{ - 4n}\\\\n&{1 - 2n}\\end{matrix} \\right]$$");
//
//
//        mathView8.setDisplayText("38.\n" +
//                "\n" +
//                "If $$A = \\left[ \\begin{matrix}1&{ - 1}\\\\{ - 1}&1\\end{matrix} \\right]\\,,$$ then $$A^5$$ is\n" +
//                "\n" +
//                "(a) $$4A$$\n" +
//                "\n" +
//                "(b) $$5A$$\n" +
//                "\n" +
//                "(c) $$8A$$\n" +
//                "\n" +
//                "(d) $$16A$$");
//
//
//        mathView9.setDisplayText("39.\n" +
//                "\n" +
//                "If $$[1\\,\\times \\,\\,1]\\,\\left[ \\begin{matrix}2&3&2\\\\0&5&1\\\\0&3&2\\end{matrix} \\right]\\,\\,\\left[ \\begin{matrix}1\\\\1\\\\x\\end{matrix} \\right]\\, = 0,$$ then values of $$x$$ are\n" +
//                "\n" +
//                "(a) $$1, 8$$\n" +
//                "\n" +
//                "(b) $$-1, 8$$\n" +
//                "\n" +
//                "(c) $$-1, -8$$\n" +
//                "\n" +
//                "(d) $$1, -8$$");
//
//
//
//        mathView10.setDisplayText("\n" +
//                "40.\n" +
//                "\n" +
//                "If $$F(x) = \\,\\left[ \\begin{matrix}{\\cos x}&{ - \\sin x}&0\\\\{\\sin x}&{\\cos x}&0\\\\0&0&1\\end{matrix} \\right]$$, then $$F(x + y)$$ equals\n" +
//                "\n" +
//                "(a) $$F(x)\\,\\,F(y)$$\n" +
//                "\n" +
//                "(b) $$F(x) + F(y)$$\t\n" +
//                "\n" +
//                "(c) $$F(x) - F(y)$$\n" +
//                "\n" +
//                "(d) $$F(xy)$$");
//
//
//        mathView11.setDisplayText("42.\n" +
//                "\n" +
//                "If order of the matrix $$A$$ is $$3 \\times 5$$, then order the matrix $$A^2$$ is\n" +
//                "\n" +
//                "(a) $$3 \\times 5$$\n" +
//                "\n" +
//                "(b) $$5 \\times 3$$\n" +
//                "\n" +
//                "(c) $$3 \\times 3$$\n" +
//                "\n" +
//                "(d) none of these");
//
//
//        mathView12.setDisplayText("41.\n" +
//                "\n" +
//                "If $$\\left[ \\begin{matrix}2&{ - 1}\\\\1&0\\\\{ - 3}&4\\end{matrix} \\right]\\,\\,A = \\,\\,\\left[ \\begin{matrix}{ - 1}&{ - 8}&{ - 10}\\\\1&{ - 2}&{ - 5}\\\\9&{22}&{15}\\end{matrix} \\right]\\,$$, then matrix $$A$$ is\n" +
//                "\n" +
//                "(a) $$\\left[ \\begin{matrix}1&{ - 2}&{ - 5}\\\\3&4&0\\end{matrix} \\right]$$\n" +
//                "\n" +
//                "(b) $$\\left[ \\begin{matrix}1&3\\\\{ - 2}&4\\\\{ - 5}&0\\end{matrix} \\right]$$\t\n" +
//                "\n" +
//                "(c) $$\\left[ \\begin{matrix}{ - 1}&2&5\\\\3&4&0\\end{matrix} \\right]$$\n" +
//                "\n" +
//                "(d) none of these");
//
//
//        mathView13.setDisplayText("43.\n" +
//                "\n" +
//                "If $$A$$ is a square matrix of $$m \\times m$$, then order of $$A^n$$ is\n" +
//                "\n" +
//                "(a) $$n \\times n$$\n" +
//                "\n" +
//                "(b) $$m \\times m$$\n" +
//                "\n" +
//                "(c) $$m \\times n$$\n" +
//                "\n" +
//                "(d) $$n \\times m$$");
//
//
//        mathView14.setDisplayText("44.\n" +
//                "\n" +
//                "Which of the following is true, if $$A$$ and $$B$$ are square matrices of the same order\n" +
//                "\n" +
//                "(a) $${(A + B)^2} = {A^2} + {B^2} + 2AB$$\n" +
//                "\n" +
//                "(b) $$(A + B)\\,\\,(A - B) = {A^2} - {B^2}$$\t\n" +
//                "\n" +
//                "(c) $${(A + B)^2} + {(A - B)^2} = 2{A^2} + 2{B^2}$$\n" +
//                "\n" +
//                "(d) none of these");
//
//
//        mathView15.setDisplayText("45.\n" +
//                "\n" +
//                "If $$A = \\left[ \\begin{matrix}i&0\\\\0&i\\end{matrix} \\right]$$, then $$A^n$$ is equal to $$(i = \\sqrt { - 1} )$$\n" +
//                "\n" +
//                "(a) $$A$$ for $$n = 4$$\n" +
//                "\n" +
//                "(b) $$-A$$ for $$n = 6$$\n" +
//                "\n" +
//                "(c) $$-I$$ for $$n = 5$$\n" +
//                "\n" +
//                "(d) $$I$$ for $$n = 8$$");


