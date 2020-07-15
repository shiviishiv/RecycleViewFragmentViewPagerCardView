package com.example.testingviewpagerrecycleviewfragmentcardview;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    private List<Fragment>fragmentList = new ArrayList<>();
    private List<String>stringList  = new ArrayList<>();
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    public boolean addFragment(Fragment fragment,String string){
        stringList.add(string);
        return fragmentList.add(fragment);
    }

}
