package com.moringaschool.ebeautyparlor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;

public class ParlorActivity extends AppCompatActivity {
    public static final String TAG = ParlorActivity.class.getSimpleName();
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parlor);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String pet = ((TextView)view).getText().toString();
                Log.v(TAG, "In the onItemClickListener!");
                Toast.makeText(ParlorActivity .this, pet , Toast.LENGTH_LONG).show();
            }
        });
    }
}
