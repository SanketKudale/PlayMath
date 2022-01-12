package com.sanket.funplay;

import android.Manifest;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sanket.funplay.Java_FIles.LocaleHelper;
import com.sanket.funplay.music.MusicService;
import com.sanket.funplay.ui.mathstricks.MathsTricksFragment;
import com.sanket.funplay.ui.home.HomeFragment;
import com.sanket.funplay.ui.puzzle.PuzzleFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    TextView hidden1;
    BottomNavigationView navView;
    ImageView lang_card;
    boolean mIsBound = false;
    final MusicService[] mServ = new MusicService[1];
    Boolean flag1;
    ServiceConnection Scon = new ServiceConnection() {

        public void onServiceConnected(ComponentName name, IBinder binder) {
            mServ[0] = ((MusicService.ServiceBinder) binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ[0] = null;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hidden1 = findViewById(R.id.hidden1);
        navView = findViewById(R.id.nav_view);
        lang_card = findViewById(R.id.lang_im);
        doBindService();
        Intent music = new Intent();
        music.setClass(this,MusicService.class);
        startService(music);


        //LanguageChooser();


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_maths_tricks, R.id.navigation_puzzle)
                .build();
        navView.setOnNavigationItemSelectedListener(this);

        lang_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageChooser();

            }
        });

        loadFragment(new HomeFragment());
    }

        public void doBindService(){
            bindService(new Intent(this,MusicService.class),
                    Scon,Context.BIND_AUTO_CREATE);
            mIsBound = true;
        }

        public void doUnbindService()
        {
            if(mIsBound)
            {
                unbindService(Scon);
                mIsBound = false;
            }
        }

    private void LanguageChooser() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.langchoose_custom);

        final TextView edit1 = dialog.findViewById(R.id.lock_edit1);
        ListView list1 = dialog.findViewById(R.id.lang_options);
        final List<String> lang_list = Arrays.asList(getResources().getStringArray(R.array.languages));

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                edit1.setText(lang_list.get(position));
                LocaleHelper localeHelper = new LocaleHelper(MainActivity.this);
                localeHelper.functionchange(lang_list.get(position));

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        startActivity(getIntent());
                        dialog.dismiss();
                    }
                },1820);

            }
        });

        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.show();
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }
        return  false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){

        Fragment fragment = null;
        switch (item.getItemId()){

            case R.id.navigation_home:
                lang_card.setVisibility(View.VISIBLE);
                fragment = new HomeFragment();
                hidden1.setText("home");
                break;

            case R.id.navigation_maths_tricks:
                lang_card.setVisibility(View.GONE);
                fragment = new MathsTricksFragment();
                hidden1.setText("tricks");
                break;

            case R.id.navigation_puzzle:
                lang_card.setVisibility(View.GONE);
                fragment = new PuzzleFragment();
                hidden1.setText("puzzles");
                break;

            case R.id.navigation_contact:
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.fragment_contact);
                dialog.show();
                break;

        }
        return loadFragment(fragment);
    }
    @Override
    public void onBackPressed() {

        if (hidden1.getText().toString().equals("home")) {
            doUnbindService();
            Intent music = new Intent();
            music.setClass(this,MusicService.class);
            stopService(music);
            startActivity(new Intent(MainActivity.this,ExitPage.class));
        }
        else {
            navView.setSelectedItemId(R.id.navigation_home);
        }
    }
}
