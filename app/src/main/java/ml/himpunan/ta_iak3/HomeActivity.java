package ml.himpunan.ta_iak3;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    ImageButton button1;
    ImageButton button2;
    ImageButton button3;
    ImageButton button4;
    ImageButton button5;
    ImageButton button6;
    ViewPager viewPager;
    TextView keterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = (ViewPager) findViewById(R.id.ViewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);
        keterangan = (TextView) findViewById(R.id.keteranganText);

        button1 = (ImageButton) findViewById(R.id.button1);
        button1.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                keterangan.setText("Birthday Card");
                Intent intent = new Intent (HomeActivity.this, BirthdayCard.class);
                startActivity(intent);
            }
        });

        button2 = (ImageButton) findViewById(R.id.button2);
        button2.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                keterangan.setText("Order Coffee");
                Intent intent = new Intent (HomeActivity.this, JustJava.class);
                startActivity(intent);
            }
        });

        button3 = (ImageButton) findViewById(R.id.button3);
        button3.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                keterangan.setText("Basketball Score Counter");
                Intent intent = new Intent (HomeActivity.this, BasketCounter.class);
                startActivity(intent);
            }
        });

        button4 = (ImageButton) findViewById(R.id.button4);
        button4.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                keterangan.setText("Notes");
                Intent intent = new Intent (HomeActivity.this, Notes.class);
                startActivity(intent);
            }
        });

        button5 = (ImageButton) findViewById(R.id.button5);
        button5.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                keterangan.setText("Share");
                Intent intent = new Intent (HomeActivity.this, Share.class);
                startActivity(intent);
            }
        });

        button6 = (ImageButton) findViewById(R.id.button6);
        button6.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                keterangan.setText("Help");
                Intent intent = new Intent (HomeActivity.this, Help.class);
                startActivity(intent);
            }
        });
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    }
                    else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    }
                    else if (viewPager.getCurrentItem() == 2) {
                        viewPager.setCurrentItem(3);
                    }
                    else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
