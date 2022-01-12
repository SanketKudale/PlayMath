package com.sanket.funplay.ui.mathstricks.tricks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sanket.funplay.Java_FIles.LocaleHelper;
import com.sanket.funplay.R;
import com.sanket.funplay.Splash;

public class Tricks extends AppCompatActivity {

    String input;
    TextView line1,line2,line3,line4,line5,line6,line7,line8,line9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tricks);

        input = getIntent().getExtras().getString("pname");

        line1 = findViewById(R.id.l1);
        line2 = findViewById(R.id.l2);
        line3 = findViewById(R.id.l3);
        line4 = findViewById(R.id.l4);
        line5 = findViewById(R.id.l5);
        line6 = findViewById(R.id.l6);
        line7 = findViewById(R.id.l7);
        line8 = findViewById(R.id.l8);
        line9 = findViewById(R.id.l9);

        hideall();

        if (input.equals(getString(R.string.trick1)))
            trick1();
        else if (input.equals(getString(R.string.trick2)))
            trick2();
        else if (input.equals(getString(R.string.trick3)))
            trick3();
        else if (input.equals(getString(R.string.trick4)))
            trick4();
        else if (input.equals(getString(R.string.trick5)))
            trick5();
        else if (input.equals(getString(R.string.trick6)))
            trick6();
        else if (input.equals(getString(R.string.trick7)))
            trick7();
        else if (input.equals(getString(R.string.trick8)))
            trick8();
        else if (input.equals(getString(R.string.trick9)))
            trick9();
        else if (input.equals(getString(R.string.trick10)))
            trick10();

    }

    private void trick1() {
        line1.setText(getString(R.string.t1_1));
        line2.setText(getString(R.string.t1_2));
        line3.setText(getString(R.string.t1_3));
        line4.setText(getString(R.string.t1_4));
        line5.setText(getString(R.string.t1_5));
        line6.setText(getString(R.string.t1_6));
        hideall();
        vis(line1);
        vis(line2);
        vis(line3);
        vis(line4);
        vis(line5);
        vis(line6);
    }

    private void trick2() {
        line1.setText(getString(R.string.t2_1));
        line2.setText(getString(R.string.t2_2));
        line3.setText(getString(R.string.t2_3));
        line4.setText(getString(R.string.t2_4));
        hideall();
        vis(line1);
        vis(line2);
        vis(line3);
        vis(line4);
    }

    private void trick3() {
        line1.setText(getString(R.string.t3_1));
        line2.setText(getString(R.string.t3_2));
        line3.setText(getString(R.string.t3_3));
        line4.setText(getString(R.string.t3_4));
        line5.setText(getString(R.string.t3_5));
        line6.setText(getString(R.string.t3_6));
        hideall();
        vis(line1);
        vis(line2);
        vis(line3);
        vis(line4);
        vis(line5);
        vis(line6);
    }

    private void trick4() {
        line1.setText(getString(R.string.t4_1));
        line2.setText(getString(R.string.t4_2));
        line3.setText(getString(R.string.t4_3));
        line4.setText(getString(R.string.t4_4));
        line5.setText(getString(R.string.t4_5));
        hideall();
        vis(line1);
        vis(line2);
        vis(line3);
        vis(line4);
        vis(line5);
    }

    private void trick5() {
        line1.setText(getString(R.string.t5_1));
        line2.setText(getString(R.string.t5_2));
        line3.setText(getString(R.string.t5_3));
        line4.setText(getString(R.string.t5_4));
        line5.setText(getString(R.string.t5_5));
        hideall();
        vis(line1);
        vis(line2);
        vis(line3);
        vis(line4);
        vis(line5);
    }

    private void trick6() {
        line1.setText(getString(R.string.t6_1));
        line2.setText(getString(R.string.t6_2));
        line3.setText(getString(R.string.t6_3));
        line4.setText(getString(R.string.t6_4));
        line5.setText(getString(R.string.t6_5));
        hideall();
        vis(line1);
        vis(line2);
        vis(line3);
        vis(line4);
        vis(line5);
    }

    private void trick7() {
        line1.setText(getString(R.string.t7_1));
        line2.setText(getString(R.string.t7_2));
        line3.setText(getString(R.string.t7_3));
        line4.setText(getString(R.string.t7_4));
        line5.setText(getString(R.string.t7_5));
        hideall();
        vis(line1);
        vis(line2);
        vis(line3);
        vis(line4);
        vis(line5);
    }

    private void trick8() {
        line1.setText(getString(R.string.t8_1));
        line2.setText(getString(R.string.t8_2));
        line3.setText(getString(R.string.t8_3));
        line4.setText(getString(R.string.t8_4));
        hideall();
        vis(line1);
        vis(line2);
        vis(line3);
        vis(line4);
    }

    private void trick9() {
        line1.setText(getString(R.string.t9_1));
        line2.setText(getString(R.string.t9_2));
        line3.setText(getString(R.string.t9_3));
        line4.setText(getString(R.string.t9_4));
        line5.setText(getString(R.string.t9_5));
        line6.setText(getString(R.string.t9_6));
        line7.setText(getString(R.string.t9_7));
        line8.setText(getString(R.string.t9_8));
        line9.setText(getString(R.string.t9_9));
        hideall();
        vis(line1);
        vis(line2);
        vis(line3);
        vis(line4);
        vis(line5);
        vis(line6);
        vis(line7);
        vis(line8);
        vis(line9);
    }

    private void trick10() {
        line1.setText(getString(R.string.t10_1));
        line2.setText(getString(R.string.t10_2));
        line3.setText(getString(R.string.t10_3));
        line4.setText(getString(R.string.t10_4));
        line5.setText(getString(R.string.t10_5));
        line6.setText(getString(R.string.t10_6));
        hideall();
        vis(line1);
        vis(line2);
        vis(line3);
        vis(line4);
        vis(line5);
        vis(line6);
    }

    private void hideall() {
        invis(line1);
        invis(line2);
        invis(line3);
        invis(line4);
        invis(line5);
        invis(line6);
        invis(line7);
        invis(line8);
        invis(line9);
    }

    private void invis(TextView textView) {
        textView.setVisibility(View.INVISIBLE);
    }

    private void vis(TextView textView) {
        textView.setVisibility(View.VISIBLE);
    }
}
