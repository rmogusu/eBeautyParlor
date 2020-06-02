package com.moringaschool.ebeautyparlor.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.ebeautyparlor.models.BeautyParlor;

import com.moringaschool.ebeautyparlor.ui.ParlorDetailFragment;

import java.util.List;

public class ParlorPagerAdapter extends FragmentPagerAdapter  {
    private List<BeautyParlor> mParlor;

    public ParlorPagerAdapter(FragmentManager fm, int behavior, List<BeautyParlor > parlors) {
        super(fm, behavior);
        mParlor  = parlors;
    }

    @Override
    public Fragment getItem(int position) {
        return ParlorDetailFragment.newInstance(mParlor.get(position));
    }

    @Override
    public int getCount() {
        return mParlor.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mParlor .get(position).getName();

    }

}
