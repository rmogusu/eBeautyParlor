package com.moringaschool.ebeautyparlor.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.ebeautyparlor.Constants;
import com.moringaschool.ebeautyparlor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.findParlorButton) Button mFindParlorButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
    //private SharedPreferences mSharedPreferences;
    //private SharedPreferences.Editor mEditor;
    private ValueEventListener mSearchedLocationReferenceListener;
    private DatabaseReference mSearchedLocationReference;

    @BindView(R.id.savedParlorsButton) Button mSavedParlorsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSearchedLocationReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_LOCATION);
        mSearchedLocationReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot locationSnapshot : dataSnapshot.getChildren()) {
                    String location = locationSnapshot.getValue().toString();
                    Log.d("Locations updated", "location: " + location);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mEditor = mSharedPreferences.edit();
        mFindParlorButton.setOnClickListener(this);
        mSavedParlorsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mFindParlorButton) {
            String location = mLocationEditText.getText().toString();
            saveLocationToFirebase(location);
            Intent intent = new Intent(MainActivity.this, ParlorActivity.class);
            //intent.putExtra("location", location);
            startActivity(intent);
            Toast.makeText(MainActivity.this, location, Toast.LENGTH_LONG).show();
//            if(!(location).equals("")) {
//                addToSharedPreferences(location);
//            }
        }
            if (v == mSavedParlorsButton) {
                Intent intent = new Intent(MainActivity.this, SavedParlorListActivity.class);
                startActivity(intent);
            }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearchedLocationReference.removeEventListener(mSearchedLocationReferenceListener);
    }
    public void saveLocationToFirebase(String location) {
        mSearchedLocationReference.push().setValue(location);
    }
//    private void addToSharedPreferences(String location) {
//        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
//    }
}
