package com.sanket.funplay.ui.puzzle.puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sanket.funplay.Java_FIles.LocaleHelper;
import com.sanket.funplay.R;
import com.sanket.funplay.Splash;


public class Puzzle extends AppCompatActivity {

    String input;
    ImageView image;
    TextView text,sol,viewsol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        input = getIntent().getExtras().getString("puname");
        image = findViewById(R.id.image1);
        text = findViewById(R.id.la1);
        viewsol = findViewById(R.id.solution1);
        sol = findViewById(R.id.solution2);

        hideall();

        if (input.equals(getString(R.string.puz1)))
            pu1();
        else if (input.equals(getString(R.string.puz2)))
            pu2();
        else if (input.equals(getString(R.string.puz3)))
            pu3();
        else if (input.equals(getString(R.string.puz4)))
            pu4();
        else if (input.equals(getString(R.string.puz5)))
            pu5();
        else if (input.equals(getString(R.string.puz6)))
            pu6();
        else if (input.equals(getString(R.string.puz7)))
            pu7();
        else if (input.equals(getString(R.string.puz8)))
            pu8();
        else if (input.equals(getString(R.string.puz9)))
            pu9();
        else if (input.equals(getString(R.string.puz10)))
            pu10();

        viewsol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sol.setVisibility(View.VISIBLE);
                if (input.equals("Puzzle 6"))
                    image.setVisibility(View.VISIBLE);
            }
        });
    }

    private void pu1() {
        hideall();
        text.setText(getString(R.string.p1));
        sol.setText(getString(R.string.s1));
        compvis();

    }

    private void pu2() {
        hideall();
        text.setText(getString(R.string.p2));
        sol.setText(getString(R.string.s2));
        compvis();
    }

    private void pu3() {
        hideall();
        text.setText(getString(R.string.p3));
        sol.setText(getString(R.string.s3));
        compvis();
    }

    private void pu4() {
        hideall();
        text.setText(getString(R.string.p4));
        sol.setText(getString(R.string.s4));
        compvis();
    }

    private void pu5() {
        hideall();
        text.setText(getString(R.string.p5));
        sol.setText(getString(R.string.s5));
        compvis();
    }

    private void pu6() {
        hideall();
        text.setText(getString(R.string.p6));
        sol.setText(getString(R.string.s6));
        image.setBackgroundResource(R.drawable.sol_chess);
        compvis();
    }

    private void pu7() {
        hideall();
        text.setText(getString(R.string.p7));
        sol.setText(getString(R.string.s7));
        compvis();
    }

    private void pu8() {
        hideall();
        text.setText(getString(R.string.p8));
        sol.setText(getString(R.string.s8));
        compvis();
    }

    private void pu9() {
        hideall();
        text.setText(getString(R.string.p9));
        sol.setText(getString(R.string.s9));
        compvis();
    }

    private void pu10() {
        hideall();
        text.setText(getString(R.string.p10));
        sol.setText(getString(R.string.s10));
        compvis();
    }

    private void compvis() {
        text.setVisibility(View.VISIBLE);
        viewsol.setVisibility(View.VISIBLE);
    }

    private void hideall() {
        image.setVisibility(View.INVISIBLE);
        text.setVisibility(View.INVISIBLE);
        sol.setVisibility(View.INVISIBLE);
        viewsol.setVisibility(View.INVISIBLE);
    }

}
