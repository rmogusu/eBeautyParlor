package com.moringaschool.ebeautyparlor;


import android.content.Context;
import android.widget.ArrayAdapter;

public class BeautyParlorArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mParlor;
    private String[] mServices;


    public BeautyParlorArrayAdapter(Context mContext, int resource, String[] mParlor, String[] mServices) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mParlor  = mParlor;
        this.mServices  = mServices;

    }
    @Override
    public Object getItem(int position) {
        String parlor= mParlor[position];
        String service = mServices[position];
        return String.format("%s \n serves great: %s", parlor , service);
    }

    @Override
    public int getCount() {
        return mParlor.length;
    }
}

