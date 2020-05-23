package com.moringaschool.ebeautyparlor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

public class ParlorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parlor);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String pet = ((TextView)view).getText().toString();
                Log.v(TAG, "In the onItemClickListener!");
                Toast.makeText(PetsActivity.this, pet , Toast.LENGTH_LONG).show();
            }
        });
    }
}
