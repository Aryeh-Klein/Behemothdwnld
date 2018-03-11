package org.kinneret.behemoth;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SeferPage extends AppCompatActivity {

    private TextView mTextMessage;

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
        setContentView(R.layout.activity_sefer_page);

        View view = getWindow().getDecorView();
        int orientation = getResources().getConfiguration().orientation;
        if (Configuration.ORIENTATION_LANDSCAPE == orientation) {
            view.setBackgroundResource (R.drawable.behmothmobile);
        } else {
            view.setBackgroundResource (R.drawable.behmoth);
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final Button buttonBereshit = (Button) findViewById(R.id.Bereshit);
        buttonBereshit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                buttonBereshit.setBackgroundColor(Color.GREEN);
                OpenSefer(v, "Bereishit");

            }
        });

        final Button buttonShmot = (Button) findViewById(R.id.Shmot);
        buttonShmot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                buttonShmot.setBackgroundColor(Color.GREEN);
                OpenSefer(v, "Shmot");

            }
        });

        final Button buttonVayikrah = (Button) findViewById(R.id.Vayikrah);
        buttonVayikrah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                buttonVayikrah.setBackgroundColor(Color.GREEN);
                OpenSefer(v, "Vayikrah");

            }
        });

        final Button buttonBamidbar = (Button) findViewById(R.id.Bamidbar);
        buttonBamidbar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                buttonBamidbar.setBackgroundColor(Color.GREEN);
                OpenSefer(v, "Bamidbar");

            }
        });

        final Button buttonDivarim = (Button) findViewById(R.id.Divarim);
        buttonDivarim.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                buttonDivarim.setBackgroundColor(Color.GREEN);
                OpenSefer(v, "Divarim");

            }
        });

    }


    private void OpenSefer(View view, String sefer){

        Intent intent = new Intent(this, SeferPerakim.class);
        intent.putExtra("Sefer",sefer);
        startActivity(intent);

    }

    @Override
    protected void onResume(){
        super.onResume();

        final Button button1 = (Button) findViewById(R.id.Bereshit);
        button1.setBackgroundColor(Color.TRANSPARENT);

        final Button button2 = (Button) findViewById(R.id.Shmot);
        button2.setBackgroundColor(Color.TRANSPARENT);

        final Button button3 = (Button) findViewById(R.id.Vayikrah);
        button3.setBackgroundColor(Color.TRANSPARENT);

        final Button button4 = (Button) findViewById(R.id.Bamidbar);
        button4.setBackgroundColor(Color.TRANSPARENT);

        final Button button5 = (Button) findViewById(R.id.Divarim);
        button5.setBackgroundColor(Color.TRANSPARENT);

    }


}
