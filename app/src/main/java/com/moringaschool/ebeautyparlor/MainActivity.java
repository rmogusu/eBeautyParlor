package com.moringaschool.ebeautyparlor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.findParlorButton) Button mFindParlorButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFindParlorButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if (v == mFindParlorButton) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, ParlorActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
            Toast.makeText(MainActivity.this, location, Toast.LENGTH_LONG).show();
        }
    }
}
