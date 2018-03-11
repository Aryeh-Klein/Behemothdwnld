package org.kinneret.behemoth;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView mInstructions;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = getWindow().getDecorView();
        int orientation = getResources().getConfiguration().orientation;
        if (Configuration.ORIENTATION_LANDSCAPE == orientation) {
            view.setBackgroundResource (R.drawable.behmothmobile);
        } else {
            view.setBackgroundResource (R.drawable.behmoth);
        }

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mInstructions = (TextView) findViewById(R.id.Instructions);
        runBlink();
        final Button button = (Button) findViewById(R.id.Tanach);

        /*button.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(MainActivity.this,"Pressed",Toast.LENGTH_SHORT).show();
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Toast.makeText(MainActivity.this,"Rleased",Toast.LENGTH_SHORT).show();
                }

                return true;
            }


        });*/

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                button.setBackgroundColor(Color.GREEN);
                OpenSeferScreen(v);

            }
        });
    }



    private void OpenSeferScreen(View view){
        Intent intent = new Intent(this, SeferPage.class);
        startActivity(intent);

    }

    private void runBlink(){
        ObjectAnimator anim = ObjectAnimator.ofInt(mInstructions,"textColor", Color.TRANSPARENT, Color.RED, Color.TRANSPARENT);
        anim.setDuration(3500);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.setRepeatCount(5);
        anim.start();
    }

    @Override
    protected void onResume(){
        super.onResume();
        final Button button = (Button) findViewById(R.id.Tanach);
        button.setBackgroundColor(Color.TRANSPARENT);

    }

}
