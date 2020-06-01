package com.moringaschool.ebeautyparlor.ui;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.ebeautyparlor.BeautyParlorArrayAdapter;
import com.moringaschool.ebeautyparlor.R;
import com.moringaschool.ebeautyparlor.adapters.ParlorListAdapter;
import com.moringaschool.ebeautyparlor.models.BeautyParlor;
import com.moringaschool.ebeautyparlor.models.Parlor;
import com.moringaschool.ebeautyparlor.network.SalonApi;
import com.moringaschool.ebeautyparlor.network.SalonClient;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class ParlorActivity extends AppCompatActivity {
    public static final String TAG = ParlorActivity.class.getSimpleName();
    //@BindView(R.id.locationTextView) TextView mLocationTextView;
    //@BindView(R.id.listView) ListView mListView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    private ParlorListAdapter mAdapter;

    public List<BeautyParlor> parlors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parlor);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String parlor = ((TextView) view).getText().toString();
//                Toast.makeText(ParlorActivity.this, parlor, Toast.LENGTH_LONG).show();
//            }
//        });
//        Intent intent = getIntent();
//        String location = intent.getStringExtra("location");
        //mLocationTextView.setText("Here are all the Beauty Parlor near: " + location);

        SalonApi client = SalonClient.getClient();
        Call<List<BeautyParlor>> call = client.getBeautyParlor(location, "parlors");
        call.enqueue(new Callback<List<BeautyParlor>>() {
            @Override
            public void onResponse(Call<List<BeautyParlor>> call, Response<List<BeautyParlor>> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    //List<BeautyParlor > parlorsList = response.body();
                    parlors = response .body();
                    mAdapter = new ParlorListAdapter(ParlorActivity.this,parlors);
                    mRecyclerView .setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(ParlorActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                    //String[] parlors = new String[parlorsList.size()];
                    //String[] categories = new String[parlorsList.size()];

                    showParlors();
                } else {
                    showUnsuccessfulMessage();
                }
            }
//                    for (int i = 0; i < parlors.length; i++) {
//                        parlors[i] = parlorsList.get(i).getName();
//                    }
//                    ArrayAdapter adapter
//                            = new BeautyParlorArrayAdapter(ParlorActivity.this, android.R.layout.simple_list_item_1, parlors, categories);
//                    mListView.setAdapter(adapter);
//
//                    showRestaurants();
//                } else {
//                    showUnsuccessfulMessage();
//                }
//            }

        @Override
            public void onFailure(Call<List<BeautyParlor>> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }

        });
    }

//    private void showFailureMessage() {
//        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
//        mErrorTextView.setVisibility(View.VISIBLE);
//    }
//
//    private void showUnsuccessfulMessage() {
//        mErrorTextView.setText("Something went wrong. Please try again later");
//        mErrorTextView.setVisibility(View.VISIBLE);
//    }
//
//    private void showRestaurants() {
//        mListView.setVisibility(View.VISIBLE);
//        mLocationTextView.setVisibility(View.VISIBLE);
//    }

//    private void hideProgressBar() {
//        mProgressBar.setVisibility(View.GONE);
//    }
    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showParlors() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}