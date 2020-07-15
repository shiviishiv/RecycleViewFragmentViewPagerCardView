package com.example.testingviewpagerrecycleviewfragmentcardview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import FragmentUses.AppFragment;
import FragmentUses.ImageFragment;
import FragmentUses.PdfFragment;
import FragmentUses.SongFragment;
import FragmentUses.VideoFragment;

public class SecondActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    Toolbar toolbar;
    SecondActivity secondActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //secondActivity = SecondActivity.in
       // ActivityFragmentViewPagerBinding
        inits();
        final String[] titles = new String[]{"Songs", "Images", "Apk","Video","Document"};
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(this);
        myViewPagerAdapter.addFragment(new SongFragment(),"Songs");
        myViewPagerAdapter.addFragment(new ImageFragment(),"Image");
        myViewPagerAdapter.addFragment(new AppFragment(),"App");
        myViewPagerAdapter.addFragment(new VideoFragment(),"Video");
        myViewPagerAdapter.addFragment(new PdfFragment(),"Document");
        viewPager2.setAdapter(myViewPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(titles[position]);
                    }
                }
        ).attach();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Toast.makeText(getApplicationContext(),"not selected saved",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void inits() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager2 = findViewById(R.id.viewPager2);
        tabLayout = findViewById(R.id.tabLayout);

    }
}