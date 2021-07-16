package com.example.akhmadarip.zakat;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.akhmadarip.zakat.Adapter.ActivityAdapter;
import com.example.akhmadarip.zakat.Adapter.SlidingImageAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BerandaActivity extends AppCompatActivity {

    Button btnhh;
    private List<Activity> activitys=new ArrayList<>();
    private static final Integer[] IMAGES= {R.drawable.programsatu,R.drawable.programyatim,R.drawable.programzakat};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    RecyclerView lstActivity;
    LinearLayoutManager linear;

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        lstActivity=(RecyclerView)findViewById(R.id.lstAct);
        linear=new LinearLayoutManager(this);
        lstActivity.setLayoutManager(linear);

            activitys.add(new Activity());
            btnhh=(Button)findViewById(R.id.btnhh);
            btnhh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ActivityAdapter adapter = new ActivityAdapter();
                    lstActivity.setAdapter(adapter);

                    init();
                }

                private void init() {
                    for (int i = 0; i < IMAGES.length; i++)
                        ImagesArray.add(IMAGES[i]);

                    mPager = (ViewPager) findViewById(R.id.pager);


                    mPager.setAdapter(new SlidingImageAdapter(BerandaActivity.this, ImagesArray));


                    NUM_PAGES = IMAGES.length;

                    // Auto start of viewpager
                    final Handler handler = new Handler();
                    final Runnable Update = new Runnable() {
                        public void run() {
                            if (currentPage == NUM_PAGES) {
                                currentPage = 0;
                            }
                            mPager.setCurrentItem(currentPage++, true);
                        }
                    };
                    Timer swipeTimer = new Timer();
                    swipeTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            handler.post(Update);
                        }
                    }, 3000, 3000);

                }
            });
    }
}